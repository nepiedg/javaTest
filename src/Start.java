import util.ArrayTest;
import util.FileTest;
import util.MyBase;
import util.Odbc;
import util.Times;

import java.util.Date;
import java.util.List;

// 类型转换
import util.TypeConvert;
import ben.User;

import com.alibaba.fastjson.JSON;

// https://blog.csdn.net/gfd54gd5f46/article/details/54918168
public class Start {
    public static void main(String[] args) {
        mybase();
    }

    public static void mybase() {
        MyBase.getUser();
    }

    public static void toJson() {
        List<Object> userData = Odbc.testSql();
        List<User> ls = (List<User>) (Object) userData;
        System.out.println(ls);
        System.out.println(userData);
        String userStr = JSON.toJSONString(userData);
        String json = JSON.toJSONString(ls);
        System.out.println(userStr);
        System.out.println(json);
    }
}