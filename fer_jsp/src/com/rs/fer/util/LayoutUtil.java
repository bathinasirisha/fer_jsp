package com.rs.fer.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LayoutUtil {
	
	public static void displayHeaderAndLeftFrame(HttpServletRequest request, HttpServletResponse response,PrintWriter out,Object username)
			throws ServletException, IOException {
		request.getRequestDispatcher("Layout/Header.html").include(request, response);
		out.println(username);
		request.getRequestDispatcher("Layout/LeftFrame.html").include(request, response);
	}
	
	public static void displayFooter(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Layout/Footer.html").include(request, response);

	}

}
