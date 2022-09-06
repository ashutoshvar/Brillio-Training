package com.jdbc.ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws SQLException {

		try {
			 save();
			//update();
			getAllEmp();
			//update();
			//delete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("```````````````````````````");
			System.out.println("Connection Closed");
			Utility.closeConnection();
		}
	}

	private static void save() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Emp e1 = new Emp();
		System.out.println("Emp ID: ");
		e1.setEid(scanner.nextInt());
		System.out.println("Emp Name: ");
		e1.seteName(scanner.next());
		System.out.println("Emp Salary: ");
		e1.setSal(scanner.nextInt());
		scanner.close();
		Queries.saveEmp(e1);

	}

	private static void getAllEmp() throws SQLException {
		Queries.getAllEmp();
	}

	private static void update() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Emp e1 = new Emp();
		System.out.println("Emp ID: ");
		e1.setEid(scanner.nextInt());
		System.out.println("Emp Name: ");
		e1.seteName(scanner.next());
		System.out.println("Emp Salary: ");
		e1.setSal(scanner.nextInt());
		scanner.close();
		Queries.updateEmp(e1);
	}
	private static void delete() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		int eid =scanner.nextInt();
		scanner.close();
		Queries.deleteEmp(eid);
		
	}
}
