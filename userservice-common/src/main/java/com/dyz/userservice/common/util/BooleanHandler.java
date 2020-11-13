package com.dyz.userservice.common.util;

import com.dyz.userservice.common.constant.ServiceConstant;

import java.util.Objects;

public class BooleanHandler {

    public static String convertToString(Boolean b) {
        if(Objects.isNull(b)) {
            return null;
        }
        if(b) {
            return ServiceConstant.BOOLEAN_TRUE;
        }
        return ServiceConstant.BOOLEAN_FALSE;
    }

    public static Boolean convertToBoolean(String s) {
        if(Objects.isNull(s)) {
            return null;
        }
        return ServiceConstant.BOOLEAN_TRUE.equals(s);
    }
}
