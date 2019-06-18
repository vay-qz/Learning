package com.thunisoft;

import com.thunisoft.util.DataUtils;
import com.thunisoft.util.UUIDUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author qiaozhe
 */
public class Main2 {

    private static String Path = "H://电子卷宗.业务公用.业务类型.数据.xls";

    public static void main(String[] args) {
        Main.initYwlxRelation();
        try(FileInputStream inputStream = new FileInputStream(new File(Path))) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(2);
            int sumNum = sheet.getPhysicalNumberOfRows();
            for(int i = 217; i < sumNum - 1; i++) {
                HSSFRow row = sheet.getRow(i);
                row.getCell(0).setCellValue(UUIDUtils.getUuid());
                try{
                    double originalYwlx = row.getCell(1).getNumericCellValue();
                    String nowywlx = Constant.YWLXMAP.get(DataUtils.double2String(originalYwlx));
                    if(nowywlx==null || nowywlx.length()==0) {
                        continue;
                    }else {
                        row.getCell(1).setCellValue(nowywlx);
                    }
                }catch (Exception e){
                    String originalYwlx = row.getCell(1).getStringCellValue();
                    String nowywlx = Constant.YWLXMAP.get(originalYwlx);
                    if(nowywlx==null || nowywlx.length()==0) {
                        continue;
                    }else {
                        row.getCell(1).setCellValue(nowywlx);
                    }
                }
            }
            workbook.write(new File(Path));
        } catch (IOException e) {

        }
    }
}
