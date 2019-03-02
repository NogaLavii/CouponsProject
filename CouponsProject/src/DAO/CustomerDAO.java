package DAO;

import java.util.ArrayList;

import javaBeans.Customer;

public interface CustomerDAO<T> {
	/**
	 *  customer  will let me manipulate data on the CUSTOMER table's data members  on the DB
	 * @throws Exception , SQLException  SQL exception is java's built in exception. used to validate data manipulation on the data base 
	 * @param password is the customer password
	 * @param email is the customer email address
	 * @return void
	 */
	boolean isCustomerExists(String email, String password) throws Exception;

	void addCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer) throws Exception;

	void deleteCustomer(int customerID) throws Exception;
	
	ArrayList<Customer> getAllCustomers() throws Exception;

	Customer getOneCustomer(int customerID) throws Exception;
}