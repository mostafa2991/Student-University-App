package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil StudentDbUtil;
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	

	@Override
	public void init() throws ServletException {
		super.init();
		// create out student dbutil and pass it 
	try {
		StudentDbUtil = new StudentDbUtil(dataSource);
		
	}
	catch (Exception exc) {
		throw new ServletException(exc);
	}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
		// list the students in mvc 
		listStudents(request, response);
	}
catch (Exception exc) {
	throw new ServletException(exc);
}
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response)
	
		throws Exception {
			
		
		
		// get students from dbutil 
		List<Student> students = StudentDbUtil.getStudents();
		
		
		//add students to the request 
		request.setAttribute("STUDENT_LIST", students);
		
		// send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	
	}
}















