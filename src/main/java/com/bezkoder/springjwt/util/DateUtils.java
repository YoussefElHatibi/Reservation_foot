package com.bezkoder.springjwt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date stringDateToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }
    
    public static String dateToString(Date date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
