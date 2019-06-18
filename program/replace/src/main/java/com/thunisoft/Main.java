package com.thunisoft;

import com.thunisoft.task.ExcelTask;
import com.thunisoft.util.DataUtils;
import com.thunisoft.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author qiaozhe
 */
public class Main {

    public static void main(String[] args) {
        initYwlxRelation();
        doexcute();
    }

    private static void doexcute() {
        try(FileInputStream inputStream = new FileInputStream(new File(Constant.PATH))) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(3);
            ExcelTask excelTask = new ExcelTask(sheet);
            excelTask.doTask();
            workbook.write(new File(Constant.PATH));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initYwlxRelation() {
        HSSFSheet sheet = ExcelUtils.readExcel(2, "H://案件业务类型表V1.0.xls");
        int totle = sheet.getPhysicalNumberOfRows();
        for(int i = 1; i < totle; i++) {
            double newValue = sheet.getRow(i).getCell(Constant.newYwlxColumn).getNumericCellValue();
            if(newValue == 0.0) {
                continue;
            }
            try {
                String originalValue = sheet.getRow(i).getCell(Constant.originalYwlxColumn).getStringCellValue();
                Constant.YWLXMAP.put(originalValue, DataUtils.double2String(newValue));
            } catch (Exception e) {
                double originalValue = sheet.getRow(i).getCell(Constant.originalYwlxColumn).getNumericCellValue();
                Constant.YWLXMAP.put(DataUtils.double2String(originalValue), DataUtils.double2String(newValue));
            }
        }
        Constant.YWLXMAP.remove("");
    }

}
