package com.dtt.edu.dbutil;

import com.dtt.edu.entity.NextTask;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NextTaskDBUtil {
    public static void insertNextTask(NextTask nxt){
        String sql="insert into nexttask(cdtask,rq,zr,xtbm,bz,hb_id) values(?,?,?,?,?,?)";
        Connection conn= ConnectionUtil.getCurrentConnection();

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,nxt.getCdtask());
            pre.setString(2,nxt.getRq());
            pre.setString(3,nxt.getZr());
            pre.setString(4,nxt.getXtbm());
            pre.setString(5,nxt.getBz());
            pre.setInt(6,nxt.getHb_id());
            pre.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
    }

    /*删除*/
    public static void deleteNextTaskByHbId(int hb_id){
        String sql="delete form nexttask where hb_id = ?";
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


    /*插入*/
    public static List<NextTask> findNextTaskByHbId(int hb_id){
        List <NextTask>  nxts= new ArrayList<NextTask>();
        String sql="select * from  nexttask where hb_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                NextTask nxt=new NextTask();
                nxt.setId(rs.getInt("id"));
                nxt.setCdtask(rs.getString("cdtask"));
                nxt.setRq(rs.getString("rq"));
                nxt.setZr(rs.getString("zr"));
                nxt.setXtbm(rs.getString("xtbm"));
                nxt.setBz(rs.getString("bz"));
                nxt.setHb_id(rs.getInt("hb_id"));
                nxts.add(nxt);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return nxts;
    }


    /*删除*/
    public static void deleteNextTaskById(int id){
        String sql="delete form nexttask where id = ?";
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
    public static void updateNextTask(NextTask nxt,int id){
        String sql="update nexttask set cdtask=?,rq =?,zr=?,xtbm=?,bz=? where id=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,nxt.getCdtask());
            pre.setString(2,nxt.getRq());
            pre.setString(3,nxt.getZr());
            pre.setString(4,nxt.getXtbm());
            pre.setString(5,nxt.getBz());
            pre.setInt(6,id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }
}
