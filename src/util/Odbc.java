package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ben.User;

public class Odbc {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.214.19:3306/bbs";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    // static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // static final String DB_URL =
    // "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "admin";

    public static List<Object> testSql() {
        Connection conn = null;
        Statement stmt = null;
        List<Object> list = new ArrayList<>();
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT member_id,nickname,username,phone,password FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while (rs.next()) {
                // 映射进实体类
                User user = convertResultToEntity(rs, User.class);
                list.add(user);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // 什么都不做
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return list;
    }

    public static <T> T convertResultToEntity(ResultSet resultSet, Class<T> tClass) throws Exception {

        T t = tClass.newInstance();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {

            String columnName = metaData.getColumnName(i + 1);

            PropertyDescriptor descriptor = new PropertyDescriptor(columnName, tClass);
            if (descriptor != null) {

                // 获得应该用于写入属性值的方法
                Method method = descriptor.getWriteMethod();
                method.invoke(t, resultSet.getObject(columnName));
            }
        }
        return t;
    }
}
