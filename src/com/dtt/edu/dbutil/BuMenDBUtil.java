package com.dtt.edu.dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dtt.edu.entity.BuMen;
import com.dtt.edu.util.ConnectionUtil;

public class BuMenDBUtil {
	public static void main(String[] args) {
		BuMen bms = new BuMen();
		bms = findByID(3);
		System.out.println(bms.name);
		/*System.out.println(bms.size());
		for(int i=0;i<bms.size();i++) {
			System.out.println(bms.get(i).getName());
		}*/
	}

	public static BuMen findByID(int id){
		BuMen bm = new  BuMen();
		String sql="select * from bumen where id=?";
		Connection con = ConnectionUtil.getCurrentConnection();
		/**
		 * 根据部门id,返回部门信息
		 *
		 */
		try {
			PreparedStatement pre= con.prepareStatement(sql);
			pre.setInt(1,id );
			ResultSet rs;
			rs = pre.executeQuery();
			while(rs.next()){
				bm.setId(rs.getInt("id"));
				bm.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bm;
	}

	/*查询——所有部门信息*/
	public static List<BuMen> findAllBuMen(){
		List<BuMen> bms=new ArrayList<BuMen>();
		String sql= "select * from bumen";
		Connection conn=ConnectionUtil.getCurrentConnection();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				BuMen bm=new BuMen();
				bm.setId(rs.getInt("id"));
				bm.setName(rs.getString("name"));
				bms.add(bm);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(conn);
		}
		return bms;
	}


	/*增加*/
	public static void insertBuMen(BuMen bm){
		String sql= "insert into bumen values(?)";
		Connection conn=ConnectionUtil.getCurrentConnection();
		try{
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,bm.getName());
			pre.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(conn);
		}

	}

	/*删除——根据ID*/
	public static void deleteByID(int id){
		String sql= "delete * from bumen where id=?";
		Connection conn=ConnectionUtil.getCurrentConnection();
		try{
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1,id);
			pre.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(conn);
		}
	}

	/*更新——根据ID更新name*/
	public static void updateNameByID(int id,String name){
		String sql= "update bumen set name = ? where id=?";
		Connection conn=ConnectionUtil.getCurrentConnection();
		try{
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,name);
			pre.setInt(2,id);
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(conn);
		}
	}
}
