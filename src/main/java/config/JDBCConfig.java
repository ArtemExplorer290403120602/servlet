package config;

import model.Translation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConfig {
    private Connection connection = null;
    private final static String ADD_TRANSLATE = "INSERT INTO word (word, \"translate \") VALUES (?, ?)";
    private final static String TRANSLATE_WORD = "SELECT \"translate \" FROM word WHERE word = ?";
    private final static String REVERSE_TRANSLATE = "SELECT word FROM word WHERE \"translate \" = ?";
    private final static String GET_HISTORY = "SELECT word, \"translate \" FROM word";

    public JDBCConfig() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/translation", "postgres", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Метод для добавления нового перевода
    public void addTranslation(Translation translation) {
        try (PreparedStatement pstmt = connection.prepareStatement(ADD_TRANSLATE)) {
            pstmt.setString(1, translation.getWord());
            pstmt.setString(2, translation.getTranslate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения перевода по слову
    public Translation translateWord(String word) {
        Translation translation = null;
        try (PreparedStatement pstmt = connection.prepareStatement(TRANSLATE_WORD)) {
            pstmt.setString(1, word);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    translation = new Translation();
                    translation.setWord(word);
                    translation.setTranslate(rs.getString("translate "));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return translation;
    }

    // Метод для получения слова по его переводу
    public Translation reverseTranslate(String translate) {
        Translation translation = null;

        try (PreparedStatement pstmt = connection.prepareStatement(REVERSE_TRANSLATE)) {
            pstmt.setString(1, translate);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    translation = new Translation();
                    translation.setWord(rs.getString("word"));
                    translation.setTranslate(translate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return translation;
    }

    public List<Translation> getTranslationHistory() {
        List<Translation> history = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(GET_HISTORY);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Translation translation = new Translation();
                translation.setWord(rs.getString("word"));
                translation.setTranslate(rs.getString("translate ")); // Обратите внимание на пробел
                history.add(translation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return history;
    }
}