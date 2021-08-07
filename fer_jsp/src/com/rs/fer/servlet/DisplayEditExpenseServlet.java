package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet{
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		int expenseId = Integer.parseInt(request.getParameter("expenseId"));
		
		Expense expense=ferService.getExpense(expenseId);


		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		if (expense==null) {
			out.println("Expense not found");
		} else {
			
			session.setAttribute("expenseId",expenseId);
			out.println("<table border='1' align='center' height='50px' width=60px>");
			out.println("<tr>");

			out.println("<td colspan='6' align='center'>Edit EXpenses</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Expense Type</td>");
			out.println("<td><input type='text' name='expenseType' value='"+expense.getExpenseType()+"'></td>");
			out.println("</tr>");


			out.println("<tr>");
			out.println("<td>Date</td>");
			out.println("<td><input type='text' name='date' value='"+expense.getDate()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Price</td>");
			out.println("<td><input type='text' name='price' value='"+expense.getPrice()+"'></td>");
			out.println("</tr>");



			out.println("<tr>");
			out.println("<td>No Of Items</td>");
			out.println("<td><input type='text' name='noOfItems' value='"+expense.getNumberOfItems()+"'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Total</td>");
			out.println("<td><input type='text' name='total' value='"+expense.getTotal()+"'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>By Whom</td>");
				out.println("<td><input type='text' name='byWhom' value='"+expense.getByWhom()+"'></td>");
				out.println("</tr>");

			out.println("<tr>");
			out.println("<input type=\"submit\"value=\"Edit Expense\"onclick=\"javascript: submitForm('editExpense')\">");

				out.println("</td>");
				out.println("</tr>");
			out.println("</tr>");
			out.println("</table>");
		}
		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}

}
