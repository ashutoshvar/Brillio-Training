package com.jdbc.menu;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		try{
			menu();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Done...");
			sc.close();
		}
		
		
	}
	static void menu() throws Exception{
		System.out.println("Choose one option:");
		System.out.println("1. To add an Employee.");
		System.out.println("2. To update Employee's Name");
		System.out.println("3. To delete an Employee.");
		System.out.println("4. To get an Employee by employee ID.");
		System.out.println("5. To get all Employee data.");
		int c;
		c= sc.nextInt();
		switch(c) {
		case 1: save(); break;
		case 2: update(); break;
		case 3: delete(); break;
		case 4: getEmpByID(); break;
		case 5: getAllEmp(); break;
		default: System.out.println("Invalid choice");
		}
		
		menu();
	}
	
	private static void save() throws SQLException, ParseException {

		Emp e1 = new Emp();
		System.out.println("Emp ID: ");
		e1.setEid(sc.nextInt());
		System.out.println("Emp Name: ");
		e1.setEname(sc.next());
		System.out.println("Emp Age:");
		e1.setAge(sc.nextInt());
		System.out.println("Emp DOB: ");
		e1.setDob(new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()).getTime()));
		System.out.println("Emp Salary: ");
		e1.setSal(sc.nextInt());
		Functions.saveEmp(e1);

	}
	private static void getAllEmp() throws SQLException {
		Functions.getAllEmp();
	}

	private static void update() throws SQLException, ParseException {

		Emp e1 = new Emp();
		System.out.println("Emp ID: ");
		e1.setEid(sc.nextInt());
		System.out.println("Emp Name: ");
		e1.setEname(sc.next());
		Functions.updateEmp(e1);
	}
	private static void delete() throws SQLException {
		System.out.println("Enter Employee ID to delete");
		int eid =sc.nextInt();
		Functions.deleteEmp(eid);
		
	}
	private static void getEmpByID() throws SQLException{
		System.out.println("Enter employee ID");
		int eid = sc.nextInt();
		Functions.getByID(eid);
		}
}


	


