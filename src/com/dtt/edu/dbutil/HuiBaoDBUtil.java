package com.dtt.edu.dbutil;

import com.dtt.edu.entity.HuiBao;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuiBaoDBUtil {

    /*public static void main(String[] args) {
        HuiBao hb=new HuiBao();
        hb.setTy(1);
        hb.setRq("11111");
        hb.setZyys(23);
        hb.setBm_name("dtt");
        hb.setM_name("dtt");
        hb.setCsren("dtt");
        hb.setUser_id(5);
        hb.setSt(1);
        System.out.println(getHuiBaoId(hb));
    }*/
    /*查询*/
    public static HuiBao findHuibaoById(int id){
        HuiBao hb= new HuiBao();
        String sql="select * from hb where id=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hb;
    }

    public static List<HuiBao> findHuiBaoByUserIdAndTY(int user_id,int ty){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where user_id=? and ty=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;

    }
    public static List<HuiBao> findHuiBaoByUserIdAndST(int user_id,int st){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where user_id=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }

    public static List<HuiBao> findHuiBaoByUserIdAndORST(int user_id,int st,int st1){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where user_id=? and st=? or st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,st);
            pre.setInt(3,st1);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }

    public static HuiBao findHuiBaoByUserIdAndTYAndZyys(int user_id,int ty,int zyys){
        HuiBao hb = new HuiBao();
        String sql="select * from hb where user_id=? and ty=? and zyys=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            pre.setInt(3,zyys);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hb;
    }

    public static boolean findHuiBaoByIdAndTYAndZyys(int user_id,int ty,int zyys){
        HuiBao hb=new HuiBao();
        String sql="select * from hb where user_id=? and ty=? and zyys=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            pre.setInt(3,zyys);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return false;
    }

    public static HuiBao findHuiBaoByIdAndTYAndST(int user_id,int ty,int st){
        HuiBao hb=new HuiBao();
        String sql="select * from hb where user_id=? and ty=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){

                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hb;
    }

    public static HuiBao findHuiBaoByIdAndZyysAndSTAndTy(int user_id,int zyys,int st,int ty){
        HuiBao hb=new HuiBao();
        String sql="select * from hb where user_id=? and zyys=? and st=? and ty=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,zyys);
            pre.setInt(3,st);
            pre.setInt(4,ty);

            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hb;
    }

    public static HuiBao findHuiBaoByCsrenAndzyyAndST(String csren,int zyy,int st){
        HuiBao hb=new HuiBao();
        String sql="select * from hb where csren=? and zyys=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,csren);
            pre.setInt(2,zyy);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){

                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hb;
    }


    public static List<HuiBao> findHuiBaoByUserIdAndTYAndORST(int user_id,int ty,int st,int st1){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where user_id=? and ty=? and st=? or st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            pre.setInt(3,st);
            pre.setInt(4,st1);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }
    public static List<HuiBao> findHuiBaoByUserIdAndTYAndST(int user_id,int ty,int st){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where user_id=? and ty=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.setInt(2,ty);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }

    public static List<HuiBao> findHuiBaoByMnameAndTYAndST(String m_name,int ty,int st){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where m_name=? and ty=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,m_name);
            pre.setInt(2,ty);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }

    /*
    * 根据汇报类型、汇报类型、汇报周期，查找未发汇报
    * 每周期未发汇报在超级管理员用户登陆时自动更新
    *
    * */
    public static List<HuiBao> FindWFHB(int ty,int zyys,int st){
        List<HuiBao> hbs=new ArrayList<HuiBao>();
        String sql="select * from hb where ty=? and zyys=? and st=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,ty);
            pre.setInt(2,zyys);
            pre.setInt(3,st);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                HuiBao hb=new HuiBao();
                hb.setId(rs.getInt("id"));
                hb.setTy(rs.getInt("ty"));
                hb.setRq(rs.getString("rq"));
                hb.setZyys(rs.getInt("zyys"));
                hb.setBm_name(rs.getString("bm_name"));
                hb.setM_name(rs.getString("m_name"));
                hb.setCsren(rs.getString("csren"));
                hb.setUser_id(rs.getInt("user_id"));
                hb.setSt(rs.getInt("st"));
                hbs.add(hb);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return hbs;
    }


    /*增加*/
    public static void insertHuiBao(HuiBao hb){
        boolean flag=findHuiBaoByIdAndTYAndZyys(hb.getUser_id(),hb.getTy(),hb.getZyys());
        if(flag){
            return;
        }
        String sql="insert into hb(ty,rq,zyys,bm_name,m_name,csren,user_id,st) values(?,?,?,?,?,?,?,?)";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb.getTy());
            pre.setString(2,hb.getRq());
            pre.setInt(3,hb.getZyys());
            pre.setString(4,hb.getBm_name());
            pre.setString(5,hb.getM_name());
            pre.setString(6,hb.getCsren());
            pre.setInt(7,hb.getUser_id());
            pre.setInt(8,hb.getSt());
            pre.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
    }

    /*增加*/
    public static int getHuiBaoId(HuiBao hb){
        String sql="insert into hb(ty,rq,zyys,bm_name,m_name,csren,user_id,st) values(?,?,?,?,?,?,?,?);";
        Connection conn=ConnectionUtil.getCurrentConnection();
        int hbid=-1;
        try {
            PreparedStatement pre = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pre.setInt(1,hb.getTy());
            pre.setString(2,hb.getRq());
            pre.setInt(3,hb.getZyys());
            pre.setString(4,hb.getBm_name());
            pre.setString(5,hb.getM_name());
            pre.setString(6,hb.getCsren());
            pre.setInt(7,hb.getUser_id());
            pre.setInt(8,hb.getSt());
            pre.executeUpdate();//执行
            ResultSet rs = pre.getGeneratedKeys();
            if(rs.next()){
                hbid=rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
        return hbid;
    }

    /*删除*/
    public static void deleteHuiBaoById(int id){
        String sql="delete form hb where id = ?";
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
    /*删除*/
    public static void deleteHuiBaoByRqAndZyy(String rq,int zyy){
        String sql="delete form hb where zyy = ? and rq= ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,zyy);
            pre.setString(1,rq);
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }

    }
    public static void deleteHuiBaoByUserId(int user_id){
        String sql="delete form hb where user_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }

    /*更新*/
    public static void updateHuiBaoByIdSetST(int id,int st){
        String sql="update hb set st = ? where id=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,st);
            pre.setInt(2,id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }

    /*更新*/
    public static void updateHuiBaoByRqAndZyyAndCsrenSetST(String rq,int zyy,int st,String csren){
        String sql="update hb set st = ? where zyys=? and csren=? st =2";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,st);
            pre.setInt(2,zyy);
            pre.setString(3,csren);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }


}
