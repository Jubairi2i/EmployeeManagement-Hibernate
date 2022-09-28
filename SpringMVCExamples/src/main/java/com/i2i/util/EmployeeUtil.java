package com.i2i.util;

import java.time.LocalDate;

/**
 * <p>
 * EmployeeUtil class is used to create non business methods
 * as static
 * </p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
public class EmployeeUtil {

    private static int suffixIdCount;
    private static final String ID_PREFIX = "I";

    /*
     * This method is used to create Id for an Employee
     *
     * @return {@link String}
     */
    public static String getGeneratedId() {
        String employeeId = null;
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        suffixIdCount++;
        employeeId = (ID_PREFIX+currentYear%100+suffixIdCount);
        return employeeId;
    }
}
