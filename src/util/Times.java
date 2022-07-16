package util;

// 时间类型转换

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Times {
    /**
     * 返回10位时间戳
     *
     * @return
     */
    public static String getDay() {
        Date time = new Date();
        long timeStr = time.getTime();
        String day = Long.toString(timeStr / 1000);
        return day;
    }

    /**
     * 返回格式化后时间戳
     *
     * @return
     */
    public static String time() {
        String format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return format0;
    }

    /**
     * 时间转为时间戳
     *
     * @return
     * @throws ParseException
     */
    public static String formatTime(String param) throws ParseException {
        SimpleDateFormat timeformate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date t = timeformate.parse(param);
        return String.valueOf(t.getTime());
    }
}
