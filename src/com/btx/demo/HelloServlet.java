package com.btx.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// super.doGet(req, resp);
	
		
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.println("<h1>list all req headers:</h1>");
		Enumeration<String> reqNames = req.getHeaderNames();
		
		while (reqNames.hasMoreElements()) {
			String name = reqNames.nextElement();
			out.println("<p>"+name+":" + req.getHeader(name)+"</p>");
		}
		
		
		Collection<String> respNames =  resp.getHeaderNames();
		out.println("\n<h1>list all resp headers:</h1>");
		for (String name : respNames)
		{
			out.println(name+":" + resp.getHeader(name));
		}
		
//		System.out.println(req.getHeaderNames());
//		resp.sendRedirect("http://www.baidu.com");
		
		out.close();
//		nothing...
//		nothing2...
//		nothing3...
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// super.doPost(req, resp);
		resp.sendRedirect("http://www.baidu.com");
		System.out.println("do post...");
	}

}
