package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.util.LayoutUtil;

@WebServlet("/displayExpenseReport")
public class DisplayExpenseReport extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Object username=session.getAttribute("username");
		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, username);
		
		request.getRequestDispatcher("ExpenseReport.html").include(request, response);
		LayoutUtil.displayFooter(request, response);
		
		
	}

}
