package com.hegazy.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.ibatis.jdbc.ScriptRunner;

public class Schema {

	public static void createNewSchema() throws SQLException, IOException {
		// Registering the Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Getting the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
		System.out.println("Connection established......");
		// Initialize the script runner
		ScriptRunner sr = new ScriptRunner(connection);
		// Creating a reader object
		Reader UserReader = new BufferedReader(
				new FileReader("E:\\PersonalProjects\\Student-University-App\\src\\SQL-Scripts\\01-create-user.sql"));
		System.out.println("New User Created ......");
		Reader scriptReader = new BufferedReader(new FileReader(
				"E:\\PersonalProjects\\Student-University-App\\src\\SQL-Scripts\\02-student-tracker.sql"));
		System.out.println("Data Added to the DB ......");
		// Running the script
		sr.runScript(UserReader);
		sr.runScript(scriptReader);
		UserReader.close();
		scriptReader.close();
	}

	public static void dropTheSchema() throws SQLException {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker", "webstudent",
				"webstudent");
		;
		Statement myStmt = null;
		System.out.println("connection created.....");
		String sql = "drop database web_student_tracker";
		myStmt = myConn.createStatement();
		int myRs = myStmt.executeUpdate(sql);
		System.out.println("Database deleted....."+myRs);
	}

	
}
