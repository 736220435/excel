package com.springboot.test;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class polTest {
    public static String path = "E:\\car.xlsx";

    public static void main(String[] args) {
        try {
            // 创建都Excel工作簿文件的引用
            XSSFWorkbook sheets = new XSSFWorkbook(new FileInputStream(path));
            // 获取Excel工作表总数
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = sheets.getSheetAt(i);
                for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
                    for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        System.out.println("第" + (j + 1) + "行第" + (k + 1) + "列的单元格是" + stringCellValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
