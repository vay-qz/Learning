package com.thunisoft.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author qiaozhe
 */
public class ExcelUtils {
    private final static String PATH = "H://test.xls";

    public static void writeExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("test");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("123");
        try {
            workbook.write(new File(PATH));
        }catch (IOException e) {

        }
    }

    public static HSSFSheet readExcel(int sheetNum, String path) {
        try(FileInputStream inputStream = new FileInputStream(new File(path))) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            return workbook.getSheetAt(sheetNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
