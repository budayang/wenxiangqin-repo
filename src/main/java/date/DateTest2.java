package date;

import org.joda.time.DateTime;

import java.util.Date;

public class DateTest2 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        DateTime dateTime = new DateTime(date);
        System.out.println(dateTime);
        dateTime = dateTime.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
        System.out.println(dateTime);
        DateTime dateTime1 = dateTime.plusDays(1);
        System.out.println(dateTime1);
        System.out.println(dateTime1.toDate());

    }
}
