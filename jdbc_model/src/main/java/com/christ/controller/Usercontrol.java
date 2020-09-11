package com.christ.controller;

import com.christ.dao.UserDao;
import com.christ.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Usercontrol {
    public static void menu()
    {
        System.out.println("=====欢迎使用用户管理系统=====");
        System.out.println("1.增加用户");
        System.out.println("2.根据id查询用户");
        System.out.println("3.查询用户");
        System.out.println("4.修改信息");
        System.out.println("5.删除信息");
        System.out.println("6.查询年龄段日期");
        System.out.println("7.分页查询");
        System.out.println("0.退出系统");
        System.out.print("请选择操作项：");
    }
    public static void chooseopt(int code) throws Exception
    {
            switch (code){
                case 1:
                    add();
                    System.out.println("=====欢迎使用用户管理系统=====");
                    System.out.println("1.增加用户");
                    break;
                case 2:
                    queryId();
                    System.out.println("=====欢迎使用用户管理系统=====");
                    System.out.println("1.根据id查询用户");
                    break;
                case 3:
                    queryAll();

                    break;
                case 4:
                    updateInfo();

                    break;
                case 5:
                    deleteUser();
                    break;
            }
    }

    private static void queryId() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入要查询的id：");
        int id=scanner.nextInt();
        UserDao userDao=new UserDao();
        User user=userDao.queryId(id);
        if (user==null){
            System.out.println("你要查找的用户不存在");
        }else{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("姓名："+user.getName());
            System.out.println("年龄："+user.getAge());
            System.out.println("年龄："+sdf.format(user.getBirthday()));
        }

    }

    private static void deleteUser() {
    }

    private static void updateInfo() {
    }

    private static void queryAll() {
    }

    private static  void add() throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name=scanner.next();
        System.out.print("请输入年龄：");
        String age=scanner.next();
        System.out.print("请输入生日（YY-MM-dd）：");
        String birthday=scanner.next();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(birthday);
        UserDao userDao=new UserDao();
        User user=new User(0,name,Integer.valueOf(age),date);
        userDao.save(user);
        getcho();
    }
    public static int inputcho(){
        Scanner scanner=new Scanner(System.in);
        int code;
        while(true) {
            code = scanner.nextInt();
            if(code==1||code==2||code==3||code==4||code==5||code==0){
                break;
            }
            System.err.println("输入不合法，重新输入：");
        }
        return  code;
    }
    public static void getcho() throws Exception {
        menu();;
        while(true){
            int code=inputcho();
            switch (code){
                case 1:
                    chooseopt(1);
                    break;
                case 2:
                    chooseopt(2);
                    break;
                case 3:
                    chooseopt(3);
                    break;
                case 4:
                    chooseopt(4);
                    break;
                case 5:
                    chooseopt(4);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("无效输入，请重新输入！");
                    inputcho();
            }
        }
    }
    public static void main(String[] args) throws  Exception{
        getcho();
    }
}
