package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String email,driver;
	ServletConfig config;
	ServletContext context;
	
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		this.context=config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=config.getInitParameter("email");
		System.out.println("Email : "+email);
		driver=context.getInitParameter("driver");
		System.out.println("Driver : "+driver);
	}


}
