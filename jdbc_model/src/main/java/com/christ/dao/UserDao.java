package com.christ.dao;

import com.christ.entity.User;
import com.christ.util.JdbcUtil2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public void save(User user) {
        Connection connection=null;
        PreparedStatement prep = null;
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="insert users(name,age,birthday) values(?,?,?)";
            prep=connection.prepareStatement(sql);
            prep.setString(1,user.getName());
            prep.setInt(2,user.getAge());
            prep.setDate(3, new Date(user.getBirthday().getTime()));
            prep.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                prep.close();
                if(prep!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public User queryId(int id) {
        Connection connection=null;
        PreparedStatement prep = null;
        ResultSet rs=null;
        User user = null;
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="select * from users where id=?";
            prep=connection.prepareStatement(sql);
            prep.setInt(1,id);
            rs=prep.executeQuery();
            if (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return user;
    }

    public List<User> queryAll() {
        Connection connection=null;
        PreparedStatement prep = null;
        ResultSet rs=null;
        User user = null;
        List<User> userList=new ArrayList<User>();
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="select * from users";
            prep=connection.prepareStatement(sql);
            rs=prep.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return userList;
    }
    public void updateInfo(int id,String name,int age ,java.util.Date birthday) {
        Connection connection=null;
        PreparedStatement prep = null;
        User user = null;
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="update users set name=?,age=?,birthday=? where id=?";
            prep=connection.prepareStatement(sql);
            prep.setString(1,name);
            prep.setInt(2,age);
            prep.setDate(3, new Date(birthday.getTime()));
            prep.setInt(4,id);
            prep.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void deleUser(int id) {
        Connection connection=null;
        PreparedStatement prep = null;
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="delete from users where id=?";
            prep=connection.prepareStatement(sql);
            prep.setInt(1,id);
            prep.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> queryBybirthday(java.util.Date date1,java.util.Date date2) {
        Connection connection=null;
        PreparedStatement prep = null;
        ResultSet rs=null;
        User user = null;
        List<User> userList=new ArrayList<User>();
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="select * from users where birthday>? and birthday<?";
            prep=connection.prepareStatement(sql);
            prep.setDate(1,new Date(date1.getTime()));
            prep.setDate(2,new Date(date2.getTime()));
            rs=prep.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return userList;
    }

    public List<User> queryByPage(int page,int num) {
        Connection connection=null;
        PreparedStatement prep = null;
        ResultSet rs=null;
        User user = null;
        List<User> userList=new ArrayList<User>();
        try{
            connection=JdbcUtil2.getDBConnection();
            String sql="select * from users limit ?,?";
            prep=connection.prepareStatement(sql);
            prep.setInt(1,(page-1)*num);
            prep.setInt(2,num);
            rs=prep.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }finally {

            try {
                if (connection!=null)
                    prep.close();
                if(prep!=null)
                    connection.close();
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return userList;
    }
}
