package com.hegazy.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
// define datasource for resource
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
//	private CreateNewSchema cn = null;
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//s1 set up printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		//s2 get connection to database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
	try {
		System.out.println("try.....");
	myConn = dataSource.getConnection();
//	cn.testConnectionWithDB();
		
		System.out.println("connection created.....");
	
		//s3   create a sql statement
		String sql = "select * from student";
		myStmt = myConn.createStatement();
		//s4  execute sql query
		myRs = myStmt.executeQuery(sql);
		//s5  process the result set
		while (myRs.next()) {
			String email = myRs.getString("email");
			out.println(email);
		}
		
		
	}
	catch (Exception exc) {
		System.out.println(exc);
		exc.printStackTrace();
		
	}
	}

}
























































