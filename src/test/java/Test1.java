import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = null;
        System.out.println(date.toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        String dateStr = format.format(date);
        System.out.println(dateStr);
        Date now = new Date();
        String bizTime = Optional.ofNullable(date1)
                .map(d -> format.format(d))
                .orElse(format.format(now));
        System.out.println(bizTime);
    }
}
