package com.dtt.edu.dbutil;

import com.dtt.edu.entity.PiWen;
import com.dtt.edu.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PiWenDBUtil {
    public static void insertNextTask(PiWen pw){
        String sql="insert into piwen(m_bm,m_name,des,hb_id,sj) values(?,?,?,?,?)";
        Connection conn= ConnectionUtil.getCurrentConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,pw.getM_bm());
            pre.setString(2,pw.getM_name());
            pre.setString(3,pw.getDes());
            pre.setInt(4,pw.getHb_id());
            pre.setString(5,pw.getSj());
            pre.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(conn);
        }
    }


    /*插入*/
    public static PiWen findPiWenByHbId(int hb_id){
        PiWen  pw= new PiWen();
        String sql="select * from  piwen where hb_id = ?";
        Connection conn=ConnectionUtil.getCurrentConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,hb_id);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                
                pw.setId(rs.getInt("id"));
                pw.setM_bm(rs.getString("m_bm"));
                pw.setM_name(rs.getString("m_name"));
                pw.setDes(rs.getString("des"));
                pw.setHb_id(rs.getInt("hb_id"));
                pw.setSj(rs.getString("sj"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(conn);
        }
        return pw;
    }
}
