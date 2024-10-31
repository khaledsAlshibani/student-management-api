package com.kss.studentmanagementapi.util;

import java.util.List;

public class ValidationUtil {

    private ValidationUtil() {}

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}