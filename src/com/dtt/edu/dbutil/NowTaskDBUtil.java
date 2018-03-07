package com.dtt.edu.dbutil;

import com.dtt.edu.entity.NowTask;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NowTaskDBUtil {
    public static void insertNowTask(NowTask nt){
        String sql="insert into nowtask(cdtask,xdrq,wcrq,hb_id) values(?,?,?,?)";
        Connection conn= ConnectionUtil.getCurrentConnection();

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,nt.getCdtask());
            pre.setString(2,nt.getXdrq());
            pre.setString(3,nt.getWcrq());
            pre.setInt(4,nt.getHb_id());
            pre.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
    }

    /*删除*/
    public static void deleteNowTaskByHbId(int hb_id){
        String sql="delete form nowtask where hb_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb_id);
            pre.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }

    }

    /*查询*/
    public static List<NowTask> findNowTaskByHbId(int hb_id){
        List <NowTask>  nts= new ArrayList<NowTask>();
        String sql="select * from  nowtask where hb_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                NowTask nt=new NowTask();
                nt.setId(rs.getInt("id"));
                nt.setCdtask(rs.getString("cdtask"));
                nt.setXdrq(rs.getString("xdrq"));
                nt.setWcrq(rs.getString("wcrq"));
                nt.setHb_id(rs.getInt("hb_id"));
                nts.add(nt);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return nts;
    }
    /*删除*/
    public static void deleteNowTaskById(int id){
        String sql="delete form nowtask where id = ?";
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
    public static void updateNowTask(NowTask nt,int id){
        String sql="update nowtask set cdtask=?,xdrq =?,wcrq=? where id=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,nt.getCdtask());
            pre.setString(2,nt.getXdrq());
            pre.setString(3,nt.getWcrq());
            pre.setInt(4,id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }

}
