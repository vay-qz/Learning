package com.thunisoft.task;

import com.thunisoft.Constant;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qiaozhe
 */
public class ExcelTask {

    private HSSFSheet sheet;

    private ThreadPoolExecutor executor;

    public ExcelTask(HSSFSheet sheet) {
        this.sheet = sheet;
        executor = new ThreadPoolExecutor(8,
                8, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public void doTask() {
        int totalNum = sheet.getPhysicalNumberOfRows();
        for(int begin = 3,end = begin + 1; end < totalNum; end++) {
            if(sheet.getRow(end).getCell(Constant.orderColumn).getNumericCellValue() == 0.0) {
                executor.execute(new UnitTask(begin, end, sheet));
                begin = end;
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
