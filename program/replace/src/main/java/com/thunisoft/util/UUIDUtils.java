package com.thunisoft.util;

import java.util.UUID;

/**
 * @author qiaozhe
 */
public class UUIDUtils {
    public synchronized static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
