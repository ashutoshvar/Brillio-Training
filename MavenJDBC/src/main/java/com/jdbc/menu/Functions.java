package com.jdbc.menu;


import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Functions {
	static Connection conn = null;
	
	static void saveEmp(Emp e1) throws SQLException{
		String sql1 = "insert into emp values(?,?,?,?,?)";
		conn = Utility.createConnection();
		PreparedStatement ps  = conn.prepareStatement(sql1);
		ps.setInt(1, e1.getEid());
		ps.setString(2, e1.getEname());
		ps.setInt(3, e1.getAge());
		ps.setDate(4, e1.getDob());
		ps.setInt(5, e1.getSal());
		ps.executeUpdate();
		
	}
	
	static void getAllEmp() throws SQLException{
		ResultSet rs = null;
		conn = Utility.createConnection();
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery("Select * from emp");
		while(rs.next()) {
			System.out.println(
					"Emp ID:" + rs.getInt("eid") + " Emp Name:" + rs.getString("eName") + " Emp Age:" + rs.getInt("Age") + " Emp DOB:" + rs.getDate("DOB") + " Emp Salary:" + rs.getInt("sal"));
		}
		System.out.println("Data added");
	}
	static void updateEmp(Emp e1) throws SQLException {
		String sql2 = "Update emp Set eName=? where eid=?";
		conn = Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(sql2);
		
		ps.setString(1, e1.getEname());
		ps.setInt(2, e1.getEid());
		ps.executeUpdate();
		System.out.println("Data updated");
		
	}
	
	static void deleteEmp(int eid) throws SQLException {
		String sql3= "delete from emp where eid=?";
		conn = Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(sql3);
		ps.setInt(1, eid);
		ps.executeUpdate();
		System.out.println("Data deleted");
	}
	
	static void getByID(int eid) throws SQLException {
		String sql4 = "select * from emp where eid=?";
		conn = Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(sql4);
		ps.setInt(1, eid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(
					"Emp ID:" + rs.getInt("eid") + " Emp Name:" + rs.getString("eName") + " Emp Age:" + rs.getInt("Age") + " Emp DOB:" + rs.getDate("DOB") + " Emp Salary:" + rs.getInt("sal"));
		}
		
		
		System.out.println("Data fetched");
	}
		
		
}


