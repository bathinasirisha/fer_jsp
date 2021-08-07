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

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet{

	FERService ferService=null;
	@Override
	public void init() throws ServletException {
		ferService=new FERServiceImpl();
		
	}
		 
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			int expenseId = Integer.parseInt(session.getAttribute("expenseId").toString());
			Expense expense = new Expense();

			expense.setExpenseType(request.getParameter("expenseType"));
			expense.setDate(request.getParameter("date"));
			expense.setPrice(Float.parseFloat(request.getParameter("price")));
			expense.setNumberOfItems(Integer.parseInt(request.getParameter("noOfItems")));
			expense.setTotal((Float.parseFloat(request.getParameter("total"))));
			expense.setByWhom(request.getParameter("byWhom"));
			expense.setId(expenseId);

			boolean isEditExpense = ferService.editExpense(expense);
			
			PrintWriter out=response.getWriter();
			
			LayoutUtil.displayHeaderAndLeftFrame(request, response, out,session.getAttribute("username") );
			if(isEditExpense) {
				out.println("Expense edited successfully..");
			}
			else {
				out.println("Expense edit failed");
			}
			LayoutUtil.displayFooter(request, response);

		}
		@Override
		public void destroy() {
			ferService=null;
		}
	

}
