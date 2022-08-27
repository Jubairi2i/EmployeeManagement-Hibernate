package com.i2i.util;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeUtil {

    private static int suffixIdCount;
    private static final String ID_PREFIX = "I";

    public static String getGeneratedId() {
        String employeeId = null;
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        suffixIdCount++;
        employeeId = (ID_PREFIX+currentYear%100+suffixIdCount);
        return employeeId;
    }
}