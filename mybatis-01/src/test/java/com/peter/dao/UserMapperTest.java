package com.peter.dao;

import com.peter.pojo.User;
import com.peter.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void getUserList_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for(User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserLikeList_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserLikeList("%ba%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User test_1 = userMapper.getUserById(1);
        System.out.println(test_1);
        sqlSession.close();
    }

    @Test
    public void getUserByIdMap_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("helloId", 1);
        User test_1 = userMapper.getUserById2(map);
        System.out.println(test_1);
        sqlSession.close();
    }

    @Test
    public void addUser_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(5,"cloud", "123"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserMap_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 8);
        map.put("userName", "Baster");
        map.put("passWord", "2222333");
        userMapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(1,"baxter", "900"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser_test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }
}
