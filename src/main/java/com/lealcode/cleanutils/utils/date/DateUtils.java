package com.lealcode.cleanutils.utils.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * <b>Clase utilitaria para el manejo y transformación de fechas.</b>
 * <p>
 * La clase {@code DateUtils} proporciona un conjunto de métodos estáticos
 * para realizar operaciones comunes con objetos {@link LocalDate}, como:
 * <ul>
 *     <li>Conversión entre texto y fecha</li>
 *     <li>Obtención del nombre del mes</li>
 *     <li>Cálculo de edad</li>
 *     <li>Sumar o restar unidades de tiempo</li>
 *     <li>Validación de formato de fechas</li>
 *     <li>Cálculo de diferencia en días</li>
 * </ul>
 * </p>
 *
 * <p>Esta clase no puede ser instanciada, ya que todos sus métodos son estáticos.</p>
 *
 * @author LealCodeSoftware - Geynerson Leal Guzman
 * @version 1.0
 */
public class DateUtils {

    /**
     * Convierte una fecha en formato texto a un objeto {@link LocalDate}.
     *
     * @param dateText cadena de texto que representa la fecha (por ejemplo, "2025-10-28").
     * @param format formato de la fecha, siguiendo el patrón de {@link DateTimeFormatter}
     *               (por ejemplo, "yyyy-MM-dd" o "dd/MM/yyyy").
     * @return la fecha convertida como {@link LocalDate}.
     */
    public static LocalDate convertTextToDate (String dateText, String format ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateText,formatter);
    }

    /**
     * Convierte un objeto {@link LocalDate} a una cadena de texto con el formato indicado.
     *
     * @param date objeto {@link LocalDate} a convertir.
     * @param format formato de salida deseado (por ejemplo, "dd/MM/yyyy").
     * @return la fecha formateada como cadena de texto.
     */

    public static String convertDateToText (LocalDate date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    /**
     * Obtiene el nombre del mes correspondiente a una fecha dada.
     *
     * @param date fecha de la cual se desea obtener el nombre del mes.
     * @param locale configuración regional para obtener el nombre en el idioma correspondiente
     *               (por ejemplo, {@link Locale#SPANISH} o {@link Locale#ENGLISH}).
     * @return nombre completo del mes según la configuración regional.
     */

    public static String getMonthName (LocalDate date, Locale locale){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", locale);
        return date.format(formatter);
    }

    /**
     * Calcula la edad actual a partir de una fecha de nacimiento.
     *
     * @param birthDate fecha de nacimiento como {@link LocalDate}.
     * @return la edad actual en años.
     * @throws IllegalArgumentException si la fecha de nacimiento es nula.
     */

    public static int calculateAge (LocalDate birthDate){
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /**
     * Suma una cantidad de días a una fecha dada.
     *
     * @param date fecha base.
     * @param days cantidad de días a sumar (puede ser negativa para restar).
     * @return nueva fecha resultante.
     */

    public static LocalDate addDays (LocalDate date, int days){
        return date.plusDays(days);
    }

    /**
     * Resta una cantidad de meses a una fecha dada.
     *
     * @param date fecha base.
     * @param months cantidad de meses a restar.
     * @return nueva fecha resultante.
     */

    public static LocalDate subtractMonths (LocalDate date, int months){
        return date.minusMonths(months);
    }

    /**
     * Verifica si una cadena de texto representa una fecha válida según el formato especificado.
     *
     * @param date cadena de texto que representa la fecha.
     * @param format formato esperado (por ejemplo, "yyyy-MM-dd").
     * @return {@code true} si la fecha es válida; {@code false} en caso contrario.
     */

    public static boolean dateIsValid (String date, String format){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate.parse(date, formatter);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }

    /**
     * Determina si una fecha ocurre después del día actual.
     *
     * @param date fecha a evaluar.
     * @return {@code true} si la fecha es posterior a hoy; {@code false} en caso contrario.
     */

    public static boolean isAfterToday(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    /**
     * Calcula la cantidad de días entre dos fechas dadas.
     *
     * @param date1 fecha inicial.
     * @param date2 fecha final.
     * @return número de días entre {@code date1} y {@code date2}.
     */

    public static long daysBetween (LocalDate date1, LocalDate date2){
        return ChronoUnit.DAYS.between(date1, date2);
    }
}

