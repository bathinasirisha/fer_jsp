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

@WebServlet("/displayEditExpenseOptions")
public class DisplayEditExpenseOptionsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object username = session.getAttribute("username");

		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		// 2.call the service

		FERService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.getExpenses(userId);

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, username);

		if (expenses == null || expenses.isEmpty()) {
			out.println("No Expense Found..");
		} else {

			out.println("ExpenseId &nbsp");

			out.println("<select name='expenseId'>");
			out.println("<option value='' >Please select ExpenseId</option>");

			int value = 0;
			String description = null;
			for (Expense expense : expenses) {
				value = expense.getId(); 
				description = expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
						+ expense.getPrice() + "," + expense.getNumberOfItems() + "," + expense.getTotal() + " and "
						+ expense.getByWhom();
				out.println("<option value='" + value + "'>" + description + "</option>");
			}
			out.println("</select>");
			out.println(
					"<input type=\"submit\"value=\"Next\"onclick=\"javascript: submitForm('displayEditExpense')\">");

		}

		LayoutUtil.displayFooter(request, response);

	}

}