package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	Logger logger= Logger.getLogger(FERServiceImpl.class); 
	@Override
	public boolean registration(User user) {

		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		logger.info("registration:: user:"+user);
		logger.debug("registration:: password: "+user.getPassword());

		try {
			connection = DBUtil.getConnection();

			String inputsql = "insert into user (firstname,middlename,lastname,email,username,password,mobile) values(?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobile());

			int numOfRecAffected = preparedStatement.executeUpdate();

			isRegister = numOfRecAffected > 0;

		} catch (SQLException e) {
			logger.error("registration:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("registration:: isRegister: "+isRegister);

		return isRegister;
	}
	
	
	@Override
	public int login(String username, String password) {

		int userId = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("login:: username:"+username);
		logger.debug("login:: password: "+password);

		try {
			connection = DBUtil.getConnection();
			String inputsql = "select * from user where username=? and password=?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userId = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			logger.error("login:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);

		}
		logger.info("login:: userId: "+userId);

		return userId;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isAddExpense = false;
		logger.info("addExpense:: ExpenseType:"+expense.getExpenseType());
		logger.info("addExpense:: Date:"+expense.getDate());
		logger.info("addExpense:: Price:"+expense.getPrice());
		logger.info("addExpense:: NumberOfItems:"+expense.getNumberOfItems());
		logger.info("addExpense:: Total:"+expense.getTotal());
		logger.info("addExpense:: ByWhom:"+expense.getByWhom());
		logger.info("addExpense:: UserId:"+expense.getUserId());

		//logger.debug("addExpense:: password: "+password);

		try {
			connection = DBUtil.getConnection();

			String inputsql = "insert into expense (expenseType,date,price,numberOfItems,total,byWhom,userId) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(inputsql);
			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setInt(7, expense.getUserId());

			int numOfRecAffected = preparedStatement.executeUpdate();

			isAddExpense = numOfRecAffected > 0;
		} catch (SQLException e) {
			logger.error("addExpense:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("addExpense:: isAddExpense: "+isAddExpense);

		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isEditExpense = false;
		logger.info("editExpense:: ExpenseType:"+expense.getExpenseType());
		logger.info("editExpense:: Date:"+expense.getDate());
		logger.info("editExpense:: Price:"+expense.getPrice());
		logger.info("editExpense:: NumberOfItems:"+expense.getNumberOfItems());
		logger.info("editExpense:: Total:"+expense.getTotal());
		logger.info("editExpense:: ByWhom:"+expense.getByWhom());
		logger.info("editExpense:: expenseId:"+expense.getId());
		try {
			connection = DBUtil.getConnection();

			String inputsql = "update expense set expenseType=?, date=?, price=?, numberOfItems=?,"
					+ "total=?, byWhom=? where id=?";
			preparedStatement = connection.prepareStatement(inputsql);
			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setInt(7, expense.getId());

			int numOfRecAffected = preparedStatement.executeUpdate();

			isEditExpense = numOfRecAffected > 0;
		} catch (SQLException e) {
			logger.error("editExpense:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		logger.info("editExpense:: isEditExpense: "+isEditExpense);

		return isEditExpense;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isDelete = false;
		logger.info("deleteExpense:: ExpenseId:"+expenseId);


		try {
			connection = DBUtil.getConnection();

			String inputsql = "delete from expense where id=?";
			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setInt(1, expenseId);
			int numOfRecAffected = preparedStatement.executeUpdate();

			isDelete = numOfRecAffected > 0;
		} catch (SQLException e) {
			logger.error("deleteExpense:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("deleteExpense:: isDelete: "+isDelete);

		return isDelete;
	}

	@Override
	public boolean resetPassword(String newPassword, int userId, String currentPassword) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isReset = false;
		
		logger.debug("resetPassword:: newPassword:"+newPassword);
		logger.info("resetPassword:: userId:"+userId);

		logger.debug("resetPassword:: currentPassword:"+currentPassword);


		try {
			connection = DBUtil.getConnection();

			String inputsql = "update user set password=? where id=? and password=?";
			preparedStatement = connection.prepareStatement(inputsql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, userId);
			preparedStatement.setString(3, currentPassword);

			int numOfRecAffected = preparedStatement.executeUpdate();

			isReset = numOfRecAffected > 0;
		} catch (SQLException e) {
			logger.error("resetPassword:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("resetPassword:: isReset: "+isReset);

		return isReset;
	}

	@Override
	public List<Expense> getExpenses(int userId) {

		List<Expense> expenses = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("getExpenses:: userId:"+userId);


		try {

			connection = DBUtil.getConnection();

			String inputsql = "select * from expense where userId=?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			Expense expense = null;

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int uId = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setExpenseType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setByWhom(byWhom);
				expense.setUserId(userId);

				expenses.add(expense);
			}
		} catch (SQLException e) {
			logger.error("getExpenses:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("getExpenses:: expenses: "+expenses);

		return expenses;

	}

	@Override
	public Expense getExpense(int expenseId) {

		Expense expense = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("getExpense:: expense:"+expenseId);


		try {

			connection = DBUtil.getConnection();

			String inputsql = "select * from expense where id=?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setInt(1, expenseId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int userId = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setExpenseType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setByWhom(byWhom);
				expense.setUserId(userId);

			}
		} catch (SQLException e) {
			logger.error("getExpense:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		logger.info("getExpense:: expense: "+expense);

		return expense;

	}

	@Override
	public List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate) {

		List<Expense> expenses = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("getExpenseReport:: userId:"+userId);
		logger.info("getExpenseReport:: expenseType:"+expenseType);
		logger.info("getExpenseReport:: fromDate:"+fromDate);
		logger.info("getExpenseReport:: toDate:"+toDate);


		try {

			connection = DBUtil.getConnection();

			String inputsql = "select * from expense where userId=? and expenseType=? and date between ? and ?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setInt(1, userId);

			preparedStatement.setString(2, expenseType);

			preparedStatement.setString(3, fromDate);
			preparedStatement.setString(4, toDate);

			ResultSet resultSet = preparedStatement.executeQuery();

			Expense expense = null;

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				expenseType = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numberOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int uId = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setExpenseType(expenseType);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numberOfItems);
				expense.setTotal(total);
				expense.setByWhom(byWhom);
				expense.setUserId(userId);

				expenses.add(expense);
			}
		} catch (SQLException e) {
			logger.error("getExpense:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("getExpenseReport:: expenses: "+expenses);

		return expenses;
	}

	@Override
	public User getUser(int userId) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("getUser:: userId:"+userId);


		try {
			connection = DBUtil.getConnection();

			String inputsql = "select u.*, a.* from user u left join address a on u.id=a.userId where u.id=?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				userId = resultSet.getInt(1);
				String firstname = resultSet.getString(2);
				String middlename = resultSet.getString(3);
				String lastname = resultSet.getString(4);
				String email = resultSet.getString(5);
				String username = resultSet.getString(6);
				String password = resultSet.getString(7);
				String mobile = resultSet.getString(8);

				user = new User();
				user.setId(userId);
				user.setFirstName(firstname);
				user.setMiddleName(middlename);
				user.setLastName(lastname);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				user.setMobile(mobile);

				int addrId = resultSet.getInt(9);
				String line1 = resultSet.getString(10);
				String line2 = resultSet.getString(11);
				String city = resultSet.getString(12);
				String state = resultSet.getString(13);
				String pincode = resultSet.getString(14);
				String country = resultSet.getString(15);
				int uId = resultSet.getInt(16);

				Address address = new Address();
				address.setId(addrId);
				address.setLine1(line1);
				address.setLine2(line2);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				address.setCountry(country);
				address.setUserId(userId);

				user.setAddress(address);
			}

		} catch (SQLException e) {
			logger.error("getUser:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("getUser:: user: "+user);

		return user;
	}

	@Override
	public boolean updateUser(User user) {

		boolean isUserUpdate = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		logger.info("updateUser:: FirstName:"+user.getFirstName());
		logger.info("updateUser:: MiddleName:"+user.getMiddleName());
		logger.info("updateUser:: LastName:"+user.getLastName());
		logger.info("updateUser:: Email:"+user.getEmail());
		logger.info("updateUser:: UserName:"+user.getUsername());
		logger.info("updateUser:: Password:"+user.getPassword());
		logger.info("updateUser:: mobile:"+user.getMobile());
		




		try {
			connection = DBUtil.getConnection();

			String inputsql = "update user set firstname=?, middlename=?, lastname=?, email=?, username=?, password=?,mobile=? where id=?";
			preparedStatement = connection.prepareStatement(inputsql);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobile());
			preparedStatement.setInt(8, user.getId());
			int numOfRecAffected = preparedStatement.executeUpdate();
			// System.out.println(numOfRecAffected);

			if (numOfRecAffected <= 0) {
				System.out.println("user update is failed.");
			} else {

				Address address = user.getAddress();
				int addressId = address.getId();
				logger.info("updateUser:: addressId:"+address.getId());

				logger.info("updateUser:: Line1:"+address.getLine1());
				logger.info("updateUser:: Line2:"+address.getLine2());
				logger.info("updateUser:: City:"+address.getCity());
				logger.info("updateUser:: State:"+address.getState());
				logger.info("updateUser:: PinCode:"+address.getPincode());
				logger.info("updateUser:: Country:"+address.getCountry());
				logger.info("updateUser:: UserId:"+address.getUserId());



				if (addressId == 0) {
					inputsql = "insert into address (line1,line2,city,state,pincode,country,userId) values(?,?,?,?,?,?,?)";
					preparedStatement = connection.prepareStatement(inputsql);
					preparedStatement.setString(1, address.getLine1());
					preparedStatement.setString(2, address.getLine2());
					preparedStatement.setString(3, address.getCity());
					preparedStatement.setString(4, address.getState());
					preparedStatement.setString(5, address.getPincode());
					preparedStatement.setString(6, address.getCountry());
					preparedStatement.setInt(7, user.getId());
					numOfRecAffected = preparedStatement.executeUpdate();
					if (numOfRecAffected > 0) {
						System.out.println("address inserted successfully.");
					}

				} else {

					inputsql = "update address set line1=?, line2=?, city=?, state=?, pincode=?, country=? where id=?";

					preparedStatement.setString(1, address.getLine1());
					preparedStatement.setString(2, address.getLine2());
					preparedStatement.setString(3, address.getCity());
					preparedStatement.setString(4, address.getState());
					preparedStatement.setString(5, address.getPincode());
					preparedStatement.setString(6, address.getCountry());
					preparedStatement.setInt(7, addressId);
					numOfRecAffected = preparedStatement.executeUpdate();
					if (numOfRecAffected > 0) {
						System.out.println("address updated successfully.");
					}
				}

			}
			isUserUpdate = numOfRecAffected > 0;

		} catch (SQLException e) {
			logger.error("getUser:: SQLException: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		logger.info("getUpdateUser:: isUserUpdate: "+isUserUpdate);

		return isUserUpdate;
	}

	@Override
	public boolean isEmailAvailable(String email) {
		int userId = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			String inputsql = "select * from user where email=?";

			preparedStatement = connection.prepareStatement(inputsql);

			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return false;
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return true;
	}
}
