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
		out.println("list all req headers:");
		Enumeration<String> reqNames = req.getHeaderNames();
		while (reqNames.hasMoreElements()) {
			String name = reqNames.nextElement();
			out.println(name+":" + req.getHeader(name));
		}
		
		
		Collection<String> respNames =  resp.getHeaderNames();
		out.println("list all resp headers:");
		for (String name : respNames)
		{
			out.println(name+":" + resp.getHeader(name));
		}
		
//		System.out.println(req.getHeaderNames());
//		resp.sendRedirect("http://www.baidu.com");
		
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// super.doPost(req, resp);
		resp.sendRedirect("http://www.baidu.com");
		System.out.println("do post...");
	}

}
