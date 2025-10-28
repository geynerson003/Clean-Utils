package com.lealcode.cleanutils.utils.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/** */

public class DateUtils {

    public static LocalDate convertTextToDate (String dateText, String format ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateText,formatter);
    }

    public static String convertDateToText (LocalDate date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String getMonthName (LocalDate date, Locale locale){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);
        return date.format(formatter);
    }

    public static int calculateAge (LocalDate birthDate){
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static LocalDate addDays (LocalDate date, int days){
        return date.plusDays(days);
    }

    public static LocalDate subtractMonths (LocalDate date, int months){
        return date.minusMonths(months);
    }

    public static boolean dateIsValid (String date, String format){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate.parse(date, formatter);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }

    public static boolean isAfterToday(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    public static long daysBetween (LocalDate date1, LocalDate date2){
        return ChronoUnit.DAYS.between(date1, date2);
    }
}

