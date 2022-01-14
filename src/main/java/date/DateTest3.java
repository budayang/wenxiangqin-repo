package date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Author wenxiangqin.wxq
 * @Date 2021/8/31 7:31 下午
 * @Version 1.0
 */
public class DateTest3 {
    public static void main(String[] args) {
        Date date = new Date(2021, 8, 31);
        Date date1 = new Date(2021, 8, 31);
        System.out.println(date.equals(date1));
        DateTime dateTime = new DateTime(2021, 8, 31, 23, 59, 59);
        Date date2 = dateTime.toDate();
        System.out.println(date2);
    }
}
