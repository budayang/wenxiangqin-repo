package date;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        int dayDuration = Days.daysBetween(new DateTime(2021, 4, 1, 0, 0, 0), new DateTime(2021, 5, 1, 0, 0, 0)).getDays();
        System.out.println(dayDuration);
        int monthDuration = Months.monthsBetween(new DateTime(2021, 4, 1, 0, 0, 0), new DateTime(2022, 3, 31, 23, 59, 59)).getMonths();
        System.out.println(monthDuration);
        DateTime dateTime = new DateTime(2021, 4, 1, 0, 0, 0);
        Date scheduleDate = dateTime.plusMonths(1).dayOfMonth().withMinimumValue().withMillisOfDay(0).toDate();
        System.out.println(scheduleDate);
        DateTime endDate = new DateTime(scheduleDate).minusMonths(1).dayOfMonth().withMaximumValue();
        DateTime startDate = new DateTime(scheduleDate).minusMonths(1).dayOfMonth().withMinimumValue();
        //计提 30
        Date endTime = DateUtils.addSeconds(new Date(2021, 4, 30, 23, 59, 59), 1);
        int preDayDuration = Days.daysBetween(new DateTime(2021, 4, 1, 0, 0, 0), new DateTime(2021, 5, 1, 0, 0, 0)).getDays();
        System.out.println(preDayDuration);

//        Date date = new Date("2021-08-25");
//        System.out.println(date);

        String dateStr = "2021-08-26 18:18:18";
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date parse = new Date();
        try {
            parse = fmt.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);

        DateTime dateTime1 = new DateTime(dateStr);
        Date date = dateTime1.plusDays(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate();
        System.out.println(date);
    }
}
