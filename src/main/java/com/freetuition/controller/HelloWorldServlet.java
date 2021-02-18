package com.freetuition.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.getWriter().write("Welcome Page");
//		RequestDispatcher rd = request.getRequestDispatcher("hello.html");
//		rd.include(request,response);
		
		
//		response.sendRedirect("http://www.google.com");  
		
//		RequestDispatcher view = request.getRequestDispatcher("hello.html");
//		view.forward(request, response);
//		
		//from video
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("HellowWorldServlet sayd The student is confirmed:" +request.getParameter("firstName") +" ");
		out.println("</body></html>");
		
		
	}

}
