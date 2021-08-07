package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet{
	FERService ferService = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		//int expenseId=Integer.parseInt(session.getAttribute("expenseId").toString());

		String expenseType=request.getParameter("expenseType");
		String fromDate=request.getParameter("fromDate");
		String toDate=request.getParameter("toDate");
		
		//2.call the service
		
		FERService ferService=new FERServiceImpl();
		List<Expense> expenses=ferService.getExpenseReport(userId,expenseType,fromDate,toDate);
		
		//expense=ferService.getExpenseReport(userId,expenseType,fromDate,toDate);


		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		if (expenses==null || expenses.isEmpty()) {
			out.println("Expense not found");
		} else {
			
			out.println("<table border='1' align='center'>");
			out.println("	<tr>");

			out.println("		<td colspan='6' align='center'>Expense Report</td>");
			out.println("	</tr>");

			out.println("	<tr>");
			out.println("		<td>Expense Type</td>");
			out.println("		<td>Date</td>");
			out.println("		<td>Price</td>");
			out.println("		<td>No Of Items</td>");
			out.println("		<td>Total</td>");
			out.println("		<td>By Whom</td>");
			out.println("	</tr>");

			for(Expense expense : expenses) {
				out.println("	<tr>");
				out.println("		<td>"+expense.getExpenseType()+"</td>");
				out.println("		<td>"+expense.getDate()+"</td>");
				out.println("		<td>"+expense.getPrice()+"</td>");
				out.println("		<td>"+expense.getNumberOfItems()+"</td>");
				out.println("		<td>"+expense.getByWhom()+"</td>");
				out.println("		<td>"+expense.getUserId()+"</td>");
				out.println("	</tr>");

			}
			
			out.println("</table>");
		}
		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}

}
