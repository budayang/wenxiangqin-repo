/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package str;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author wenxiangqin
 * @version $Id: StringFormat.java, v 0.1 2022-02-25 2:30 下午 wenxiangqin Exp $$
 */
public class StringFormat {

    public static void main(String[] args) {
        String format = String.format("%s===%s", "10", "10001456");
        System.out.println(format);
        String keyIndex = String.format("%s==%s==%s==%s==%s",
                "11",
                "11011101",
                "922922",
                "TMGJZ",
                "2021-01-01 20:20:20");
        System.out.println(keyIndex);

        Date currentDay = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        System.out.println(currentDay);
    }
}