package com.rs.fer.servlet;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;

public class GetUserMain {

	public static void main(String[] args) {
		
			
				//1.load the inputs.
				
					int userId=2;
					
				//2.call the service
					
					FERService ferService= new FERServiceImpl();
					User user=ferService.getUser(userId);
			
				System.out.println("......................");
				//System.out.println("id: " + user.getId());
				System.out.println("firstname: " + user.getFirstName());
				System.out.println("middlename: " + user.getMiddleName());
				System.out.println("lastname: " + user.getLastName());
				
				System.out.println(".................");
				System.out.println("Email:" +user.getEmail());
				System.out.println("mobile: " + user.getMobile());
				
				Address address=user.getAddress();
				System.out.println("......................");
				System.out.println("line1: " + address.getLine1());
				System.out.println("line2: " + address.getLine2());
				System.out.println("city: " + address.getCity());
				System.out.println("state: " + address.getState());
				System.out.println("pincode: " + address.getPincode());
				System.out.println("country: " + address.getCountry());
				
				System.out.println(".................");

		}
		

	}


