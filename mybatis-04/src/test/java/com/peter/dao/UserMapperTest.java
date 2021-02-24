package com.peter.dao;

import com.peter.pojo.User;
import com.peter.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserList_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info: enter log4j method");
        logger.info("debug: enter log4j method");
        logger.error("error: enter testlog4j method");
    }
}
