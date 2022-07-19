package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ben.User;
import mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class MyBase {
    // https://jishuin.proginn.com/p/763bfbd6c72c
    public static void getUser() {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            // 读取配置文件
            inputStream = Resources.getResourceAsStream("mapper/base.xml");
            // 创建SqlSession工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 创建sql操作会话
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 获取数据并解析成User对象
            User user = userMapper.selectUserById(1);
            // 输出
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭相关资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.close();
        }
    }
}
