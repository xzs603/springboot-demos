package com.mttsui.security.util;

import java.util.UUID;

public class CommonUtil {

    public static String genUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
