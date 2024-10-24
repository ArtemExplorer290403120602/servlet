import client.ClientConnectionServlet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/downloadExcel")
public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Создание новой книги Excel
        logClientAccess(req);
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Создание заголовка
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Column 1");
        headerRow.createCell(1).setCellValue("Column 2");

        // Добавление данных
        for (int i = 1; i <= 10; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue("Data " + i);
            row.createCell(1).setCellValue("More Data " + i);
        }

        // Настройка ответа HTTP
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        resp.setHeader("Content-Disposition", "attachment; filename=\"data.xlsx\"");

        // Запись файла в ответ
        try (OutputStream out = resp.getOutputStream()) {
            workbook.write(out);
        }

        // Закрытие книги
        workbook.close();
    }
    private void logClientAccess(HttpServletRequest req) {
        String clientIpAddress = req.getRemoteAddr();
        int clientPort = req.getRemotePort();
        String requestUrl = req.getRequestURI();
        ClientConnectionServlet.logClientVisit(clientIpAddress, clientPort, requestUrl);
    }
}