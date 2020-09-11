package com.christ.dao;

import com.christ.entity.User;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestUserdao {
    public TestUserdao() throws ParseException {
    }

    @Test
    public void saveTest() throws ParseException, SQLException {
        UserDao userDao=new UserDao();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        User user=new User(0,"李四",24, sdf.parse("1998-8-8"));
        userDao.save(user);
    }
    @Test
    public void queryIdTest(){
        UserDao userDao=new UserDao();
        User user=userDao.queryId(5);
        if(user!=null){
            System.out.println(user.toString());
        }else {
            System.out.println("未找到啊匹配结果");
        }
    }
    @Test
    public void queryAllTest() {
        UserDao userDao = new UserDao();
        List<User> list = userDao.queryAll();
    }
    @Test
    public void updateInfoTest() throws ParseException {
        UserDao userDao = new UserDao();
        String name="Green";
        int age=15;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        userDao.updateInfo(2,name,age,sdf.parse("2001-01-21"));
    }
    @Test
    public void deleUserTest() {
        UserDao userDao = new UserDao();
        int id=15;
        userDao.deleUser(id);
    }
    @Test
    public void queryBybirthdayTest() throws ParseException {
        UserDao userDao = new UserDao();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<User> list = userDao.queryBybirthday(sdf.parse("2019-1-1"),sdf.parse("2019-12-1"));
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void queryByPageTest() {
        UserDao userDao = new UserDao();
        int page=2;
        int nums=3;
        List<User> list = userDao.queryByPage(page,nums);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
