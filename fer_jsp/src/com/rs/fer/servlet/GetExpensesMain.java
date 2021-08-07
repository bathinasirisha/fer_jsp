package com.rs.fer.servlet;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;

public class GetExpensesMain {

	public static void main(String[] args) {
		
		//1.load the inputs.
		int userId=2;
		
		//2.call the service
		
		FERService ferService=new FERServiceImpl();
		List<Expense> expenses=ferService.getExpenses(userId);
		
		//3.print the status
		
		for(Expense expense : expenses) {
			 
			 System.out.println("id: "+expense.getId()); 
			 System.out.println("ExpenseType: "+expense.getExpenseType()); 
			 System.out.println("Date: "+expense.getDate());
			 System.out.println("price: "+expense.getPrice());
			 System.out.println("numberOfItems: "+expense.getNumberOfItems());
			 System.out.println("Total: "+expense.getTotal());
			 System.out.println("byWhom: "+expense.getByWhom());
			 System.out.println("userId: "+expense.getUserId());
			 System.out.println("....................................");
		}
		
	}
	
}
