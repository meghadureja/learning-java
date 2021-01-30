package edu.practice.java.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Java 8 introduced new APIs for Date and Time to address the shortcomings of the older java.util.Date and java.util.Calendar
 * and most commonly used classes are LocalDate, LocalTime, LocalDateTime, ZonedDateTime
 *
 */
public class DateTimeTest {

  private static final String PATTERN = "yyyy-MM-dd";
  private static String dateString = "2020-01-15";

  public static void main(String[] args) throws ParseException {
    Date aDate = new SimpleDateFormat(PATTERN).parse(dateString);
    Calendar aCalendar = Calendar.getInstance();
    aCalendar.setTime(aDate);
    //In java.util.Calendar, January is defined as month 0, not month 1
    // 0 - 11
    System.out.print(aCalendar.get(Calendar.DAY_OF_MONTH) + "," + aCalendar.get(Calendar.MONTH));

    //LocalDate represents a date in ISO format (yyyy-MM-dd) without time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    LocalDate bDate = LocalDate.parse(dateString, formatter);
    System.out.print(" " + bDate.getDayOfMonth() + "," + bDate.getMonthValue());
    System.out.println("");

    System.out.println(LocalDate.now());
    System.out.println(LocalDate.of(2015, 02, 20));
    System.out.println(LocalDate.parse("2015-02-20"));

    //LocalDateTime is used to represent a combination of date and time.
    System.out.println(LocalDateTime.now());

    // time zone specific date and time. The ZoneId is an identifier used to represent different zones.
    // There are about 40 different time zones
    ZoneId zoneId = ZoneId.of("America/Chicago");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
    System.out.println(zonedDateTime);
  }
}
