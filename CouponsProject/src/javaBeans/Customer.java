package javaBeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptionHandling.EmailException;
import exceptionHandling.InvalidIDException;
import exceptionHandling.ShortStringException;

public class Customer {
	/**
	 * customer bean java file props setters getters constructor and a toString
	 * method regex for email validation
	 */
	// ---------------------prop----------------------------------

	private int id;
	private String first_name, last_name, email, password;

	// ---------------------constructor--------------------------------
	/**
	 * 
	 * @param id         the customer id in the CUSTOMER table on the DB
	 * @param first_name customer's first name
	 * @param last_name  customer's last name
	 * @param email      customer's email
	 * @param password   customer's password
	 * @throws Exception general exception
	 * @see exceptionHandling
	 */
	public Customer(int id, String first_name, String last_name, String email, String password) throws Exception {
		super();
		setId(id);
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setPassword(password);
	}
	
	

	public Customer(String first_name, String last_name, String email, String password)throws Exception {
		super();
		setFirst_name(first_name);
		setLast_name(last_name);
		setEmail(email);
		setPassword(password);
	}



	// ---------------------getter+setter-------------------------
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id the customer's id in the CUSTOMER table on the DB
	 * @throws InvalidIDException declared in exceptionHandling package
	 * @see exceptionHandling.InvalidIDException
	 */
	public void setId(int id) throws InvalidIDException {
		if (id < 0) {
			throw new InvalidIDException("Error. ID cannot be negative");
		} else
			this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	/**
	 * 
	 * @param first_name customer's first name
	 * @throws ShortStringException declared in exceptionHandling package
	 * @see exceptionHandling.ShortStringException
	 */
	public void setFirst_name(String first_name) throws ShortStringException {
		if (first_name.length() < 1) {
			throw new ShortStringException("Error. First name is too short");
		} else
			this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) throws ShortStringException {
		if (last_name.length() < 1) {
			throw new ShortStringException("Error. Last name is too short");
		} else
			this.last_name = last_name;
		;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email the customers email address
	 * @throws EmailException declared in exceptionHandling package
	 * @see exceptionHandling.EmailException
	 */
	public void setEmail(String email) throws EmailException {

		if (validate(email)) {
			this.email = email;
		} else
			throw new EmailException("Error. Email is invalid, must be longer then 5 chareckters and contain `@`");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws ShortStringException {
		if (password.length() < 3) {
			throw new ShortStringException("Error. Password is too short");
		} else
			this.password = password;
	}

	// ---------------------methods--------------------------------
	@Override
	public String toString() {
		return "Customer ID: " + id + ",\nFirst name: " + first_name + ",\nLast name: " + last_name + ",\neMail: "
				+ email + ",\nPassword: " + password + ". ";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	/**
	 * @param emailStr this an extremely smart regex that validates if the email address is valid 
	 * @return boolean
	 */
	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

}
