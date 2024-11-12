package com.qapitol.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcell {

    String path = "";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadExcell() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheetAt(0);
        Object[][] data = null;

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount - 1; i++) {

        }

    }
}
