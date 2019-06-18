package com.thunisoft.task;

import com.thunisoft.Constant;
import com.thunisoft.util.DataUtils;
import com.thunisoft.util.UUIDUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * @author qiaozhe
 */
public class UnitTask implements Runnable {

    private int beginRow;

    private int endRow;

    private HSSFSheet sheet;

    public UnitTask(int beginRow, int endRow, HSSFSheet sheet) {
        this.beginRow = beginRow;
        this.endRow = endRow;
        this.sheet = sheet;
    }

    @Override
    public void run() {
        for(int i = beginRow; i < endRow; i++) {
            HSSFRow fRow = sheet.getRow(i);
            String originalValue = fRow.getCell(Constant.bhColumn).getStringCellValue();
            String newValue = UUIDUtils.getUuid();
            fRow.getCell(Constant.bhColumn).setCellValue(newValue);
            for(int j = i + 1; j < endRow; j++){
                HSSFCell cell = sheet.getRow(j).getCell(Constant.fbhColumn);
                if(StringUtils.equals(originalValue, cell.getStringCellValue())){
                    cell.setCellValue(newValue);
                }
            }
            double originalYwlx = fRow.getCell(Constant.ywlxColumn).getNumericCellValue();
            String nowywlx = Constant.YWLXMAP.get(DataUtils.double2String(originalYwlx));
            if(nowywlx==null || nowywlx.length()==0) {
                continue;
            }else {
                fRow.getCell(Constant.ywlxColumn).setCellValue(nowywlx);
            }
        }
    }
}
