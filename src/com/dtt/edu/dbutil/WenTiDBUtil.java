package com.dtt.edu.dbutil;

import com.dtt.edu.entity.WenTi;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WenTiDBUtil {
    public static void insertWenti(WenTi wt){
        String sql="insert into wenti(cdtask,zywt,dcjjy,hb_id) values(?,?,?,?)";
        Connection conn= ConnectionUtil.getCurrentConnection();

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,wt.getCdtask());
            pre.setString(2,wt.getZywt());
            pre.setString(3,wt.getDcjjy());
            pre.setInt(4,wt.getHb_id());
            pre.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
    }

    /*删除*/
    public static void deleteWenTiByHbId(int hb_id){
        String sql="delete form wenti where hb_id = ?";
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
    public static List<WenTi> findNextTaskByHbId(int hb_id){
        List <WenTi>  wts= new ArrayList<WenTi>();
        String sql="select * from  wenti where hb_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                WenTi wt=new WenTi();
                wt.setId(rs.getInt("id"));
                wt.setCdtask(rs.getString("cdtask"));
                wt.setZywt(rs.getString("zywt"));
                wt.setDcjjy(rs.getString("dcjjy"));
                wt.setHb_id(rs.getInt("hb_id"));
                wts.add(wt);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return wts;
    }

    /*删除*/
    public static void deleteWenTiById(int id){
        String sql="delete form wenti where id = ?";
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
    public static void updateWenTi(WenTi wt,int id){
        String sql="update wenti set cdtask=?,zywt =?,dcjjy=? where id=?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,wt.getCdtask());
            pre.setString(2,wt.getZywt());
            pre.setString(3,wt.getDcjjy());
            pre.setInt(4,id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
    }
}
