import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createExcel")
public class CreateExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Инициализация COM-потока
        com.jacob.com.ComThread.InitSTA();

        ActiveXComponent excel = new ActiveXComponent("Excel.Application");

        try {
            // Создание новой книги
            Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
            Dispatch workbook = Dispatch.call(workbooks, "Add").toDispatch();
            Dispatch sheet = Dispatch.get(workbook, "ActiveSheet").toDispatch();

            // Заполнение ячеек
            Dispatch cellA1 = Dispatch.invoke(sheet, "Range", Dispatch.Get, new Object[]{"A1"}, new int[1]).toDispatch();
            Dispatch.put(cellA1, "Value", "Hello, World!");

            Dispatch cellA2 = Dispatch.invoke(sheet, "Range", Dispatch.Get, new Object[]{"A2"}, new int[1]).toDispatch();
            Dispatch.put(cellA2, "Value", "This is a test.");

            // Сохранение файла
            String filePath = "D:\\Java\\excel\\output.xlsx"; // Укажите путь для сохранения файла
            Dispatch.call(workbook, "SaveAs", filePath);

            // Открытие Excel
            excel.setProperty("Visible", new Variant(true));

            // Открытие созданного файла
            Dispatch.call(workbooks, "Open", filePath);

            // Не закрываем книгу и Excel, чтобы оставить его открытым
            // Dispatch.call(workbook, "Close", new Variant(false));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закомментируйте вызов Quit, чтобы Excel не закрывался
            // excel.invoke("Quit", new Variant[]{});
            com.jacob.com.ComThread.Release();
        }
    }
}