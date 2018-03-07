package com.dtt.edu.dbutil;

import com.dtt.edu.entity.User;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
    public static void main(String[] args) {
        List<User> us=new ArrayList<User>();
        us = findUserByBm_ID(3);
        System.out.println(us.size());
        for(int i=0;i<us.size();i++){
            System.out.println(us.get(i).getUsername());
        }

    }
    //建议对数据库的操作都是用静态方法，
    //好处是可以直接调用
    public static User findUserByName(String username){
        User user = new User();
        String sql="select * from user where name = ?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,username);
            ResultSet rs = pre.executeQuery();
            //rs对应的是返回的虚表
            //系统存在BUG,如果用户名相同则只返回最后一个用户信息
            /*
            * 解决方案
            * 1.更改页面为工号登录（合理）。
            * 2.注册是规定相同用户名不能注册（不太合理）。
            * */
            while(rs.next()){

                //System.out.println("findUserByName:"+username);
                user.setId(rs.getInt("id"));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //关闭当前与数据库的连接通道
            ConnectionUtil.close(con);

        }

        return user;
    }
    /**
     * 同时根据用户名或工号进行查询
     * */
    public static User findUserByNameORGH(String str){
        User user = new User();
        String sql="select * from user where name = ? or gh = ?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,str);
            pre.setString(2,str);
            ResultSet rs = pre.executeQuery();
            //rs对应的是返回的虚表
            //系统存在BUG,如果用户名相同则只返回最后一个用户信息
            /*
            * 解决方案
            * 1.更改页面为工号登录（合理）。
            * 2.注册是规定相同用户名不能注册（不太合理）。
            * */
            while(rs.next()){

                //System.out.println("findUserByName:"+username);
                user.setId(rs.getInt("id"));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //关闭当前与数据库的连接通道
            ConnectionUtil.close(con);

        }

        return user;
    }
    /**
     * 得到数据库中所有的用户
     */
    public static List<User> findAllUsers(){
        ArrayList<User> users=new ArrayList<User>();
        String sql="select * from user";
        Connection con = ConnectionUtil.getCurrentConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(con);
        }
        return users;

    }

    public static List<User> findUserByBm_ID(int bm_id){
        ArrayList<User> users=new ArrayList<User>();
        String sql="select * from user where bm_id=?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,bm_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(con);
        }
        return users;

    }

    public static List<User> findWFHB(int ty,int zyys,int st){
        ArrayList<User> users=new ArrayList<User>();
        String sql="select * from user where gh in(select user_id from hb where ty=? and zyys=? and st=?)";
        Connection con = ConnectionUtil.getCurrentConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,ty);
            pre.setInt(2,zyys);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(con);
        }
        return users;

    }
    public static User findById(int id){
        User user = new User();
        String sql="select * from user where id = ?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            //rs对应的是返回的虚表
            //系统存在BUG,如果用户名相同则只返回最后一个用户信息
            /*
            * 解决方案
            * 1.更改页面为工号登录（合理）。
            * 2.注册是规定相同用户名不能注册（不太合理）。
            * */
            while(rs.next()){
                //System.out.println("findUserByName:"+username);
                user.setId(rs.getInt("id"));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //关闭当前与数据库的连接通道
            ConnectionUtil.close(con);

        }

        return user;
    }

    public static List<User> findByM_id(int mid){
        ArrayList<User> users=new ArrayList<User>();
        String sql="select * from user where manager_id = ?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,mid);
            ResultSet rs=pre.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));
                users.add(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //关闭当前与数据库的连接通道
            ConnectionUtil.close(con);

        }
        return users;
    }


    public static User findByGH(String gh){
        User user = new User();
        String sql="select * from user where gh = ?";
        Connection con = ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,gh);
            ResultSet rs = pre.executeQuery();
            //rs对应的是返回的虚表
            //系统存在BUG,如果用户名相同则只返回最后一个用户信息
            /*
            * 解决方案
            * 1.更改页面为工号登录（合理）。
            * 2.注册是规定相同用户名不能注册（不太合理）。
            * */
            while(rs.next()){
                //System.out.println("findUserByName:"+username);
                user.setId(rs.getInt("id"));
                user.setGh(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setPhone(rs.getString(5));
                user.setPow(rs.getInt(6));
                user.setManager_id(rs.getInt(7));
                user.setBm_id(rs.getInt(8));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //关闭当前与数据库的连接通道
            ConnectionUtil.close(con);

        }

        return user;
    }

    /*增加*/
    public static void insertUser(User user){
        String sql="insert into user(gh,name,pwd,phone,pow,manager_id,bm_id) values(?,?,?,?,?,?,?)";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,user.getGh());
            pre.setString(2,user.getUsername());
            pre.setString(3,user.getPwd());
            pre.setString(4,user.getPhone());
            pre.setInt(5,user.getPow());
            pre.setInt(6,user.getManager_id());
            pre.setInt(7,user.getBm_id());
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }

    }

    /*删除——根据ID 或者是GH*/
    public static void deleteID(int id){
        String sql="delete form user where id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }


    }

    public static void deleteGH(String gh){
        String sql="delete form user where gh = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,gh);
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }


    /*更新——根据GH更新name或者pwd或者phone*/
    public static void updatePwdByGH(String gh,String pwd){
        String sql="update user set pwd = ? where gh=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,pwd);
            pre.setString(2,gh);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }

    public static void updatePhoneByGH(String gh,String phone){
        String sql="update user set phone = ? where gh=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,phone);
            pre.setString(2,gh);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }
}
