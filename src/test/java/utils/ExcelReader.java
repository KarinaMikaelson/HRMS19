package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader  {

    public static List<Map<String, String>> read(String path, String sheetName) throws IOException {
        List<Map<String, String>> excelData = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(path);
             XSSFWorkbook excelFile = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = excelFile.getSheet(sheetName);
            if (sheet == null) {
                throw new IOException(sheetName + " does not exist in the Excel file.");
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IOException(sheetName + " is empty.");
            }

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                    String key = headerRow.getCell(j).toString();
                    String value = row.getCell(j) != null ? row.getCell(j).toString() : "";
                    rowMap.put(key, value);
                }
                excelData.add(rowMap);
            }

        }
        System.out.println(excelData.size());
        return excelData;
    }

    public static List<Map<String, String>> read(String sheetName) throws IOException {
        return read(Constants.EXCEL_FILE_PATH, sheetName);
    }

    public static List<Map<String, String>> read() throws IOException {
        return read(Constants.EXCEL_FILE_PATH, "Sheet1");
    }

}