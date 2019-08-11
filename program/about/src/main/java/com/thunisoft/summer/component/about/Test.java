package com.thunisoft.summer.component.about;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AboutContext actx = AboutUtils.getContext();
        InputStream is = AboutUtils.getReportInputStream(actx);
        try {
            IOUtils.copy(is, new FileOutputStream(new File("d:\\test.htm")));
          //  IOUtils.copy(input, output)
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
