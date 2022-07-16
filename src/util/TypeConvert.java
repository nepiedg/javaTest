package util;

// 类型转换
public class TypeConvert {
    /**
     * 字符串转int类型
     *
     * @param name
     * @return
     */
    public static int StringToInt(String name) {
        return Integer.parseInt(name);
    }

    /**
     * 字符转long类型
     *
     * @param param
     * @return
     */
    public static long StringToLong(String param) {
        return Long.parseLong(param);
    }

    /**
     * int 转string
     *
     * @param param
     * @return
     */
    public static String IntToString(int param) {
        return String.valueOf(param);
    }

    /**
     * int 转 string
     *
     * @param param
     * @return
     */
    public static String IntToString2(int param) {
        return Integer.toString(param);
    }

    /**
     * 获取数据类型
     *
     * @param o
     * @return
     */
    public static String getType(Object o) {
        return o.getClass().toString();
    }
}

