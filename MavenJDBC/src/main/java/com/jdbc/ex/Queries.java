package com.jdbc.ex;

import java.sql.Statement;

import com.siva.MavenTrail.Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	static Connection conn = null;
	
	static void saveEmp(Emp e1) throws SQLException{
		int count;
		conn = Utility.createConnection();
		Statement stmt  = conn.createStatement();
		count = stmt
				.executeUpdate("insert into emp values(" + e1.getEid() + ",'" + e1.geteName() + "'," + e1.getSal()+ ")");
		System.out.println("employee added" + count);
	}
	
	static void getAllEmp() throws SQLException{
		ResultSet rs = null;
		conn = Utility.createConnection();
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery("Select * from emp");
		while(rs.next()) {
			System.out.println(
					"Emp ID:" + rs.getInt("eid") + " Emp Name:" + rs.getString("eName") + " Emp Salary:" + rs.getInt("sal"));
		}
	}
	static void updateEmp(Emp e1) throws SQLException {
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate(
				"Update emp set eName='" + e1.geteName() + "' where eId =" + e1.getEid());
	}
	
	static void deleteEmp(int eid) throws SQLException {
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate("Delete from emp where eid =" + eid);
	}
}

