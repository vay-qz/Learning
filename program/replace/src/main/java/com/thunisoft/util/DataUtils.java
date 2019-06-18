package com.thunisoft.util;

import java.text.DecimalFormat;

/**
 * @author qiaozhe
 */
public class DataUtils {

    public static String double2String(double newValue) {
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return String.valueOf(decimalFormat.format(newValue).length() == 3? "0" + decimalFormat.format(newValue) : decimalFormat.format(newValue));
    }

}
