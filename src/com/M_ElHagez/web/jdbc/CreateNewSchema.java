package com.M_ElHagez.web.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;


public class CreateNewSchema {
	
//	@Resource(name="jdbc/web_student_tracker")
//	private  DataSource dataSource ;
	private static void  createNewScema() throws SQLException, IOException{
		// Registering the Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Getting the connection
		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
		System.out.println("Connection established......");
		// Initialize the script runner
		ScriptRunner sr = new ScriptRunner(connection);
		// Creating a reader object
		Reader UserReader = new BufferedReader(new FileReader("E:\\PersonalProjects\\Student-University-App\\src\\SQL-Scripts\\01-create-user.sql"));
		System.out.println("New User Created ......");
		Reader scriptReader = new BufferedReader(new FileReader("E:\\PersonalProjects\\Student-University-App\\src\\SQL-Scripts\\02-student-tracker.sql"));
		System.out.println("Data Added to the DB ......");
		// Running the script
		sr.runScript(UserReader);
		sr.runScript(scriptReader);
		UserReader.close();
		scriptReader.close();
	}
	public static void testConnectionWithDB() {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
		System.out.println("connecting1");
		} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
		}
		catch (SQLException ex) {
		ex.printStackTrace();
		}
	}
	public static void tryGetData() throws SQLException {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker", "webstudent", "webstudent");;
		Statement myStmt = null;
		ResultSet myRs = null;
		System.out.println("connection created.....");
		
		//s3   create a sql statement
		String sql = " select * from student";
//		String sql2 ="USE web_student_tracker";
		myStmt = myConn.createStatement();
		//s4  execute sql query
//		myRs = myStmt.executeQuery(sql2);
		myRs = myStmt.executeQuery(sql);
		//s5  process the result set
		while (myRs.next()) {
			String email = myRs.getString("email");
			System.out.println(email);
		}
	}
	
	
	
	public static void main(String args[]) throws Exception {
		
//		CreateNewSchema.createNewScema();
	}
}
