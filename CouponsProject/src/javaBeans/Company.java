package javaBeans;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptionHandling.EmailException;
import exceptionHandling.InvalidIDException;
import exceptionHandling.ShortStringException;

public class Company {

/**
 * Company bean file with exception handling
 */
	//----------------------props------------------
	private int id;
	private String name;
	private String email;
	private String password;
	ArrayList<Coupon>companyCoupons=new ArrayList<>();


	//----------------------constructors-----------
	/**
	 * 
	 * @param id - Company id in the Companies table in the database 
	 * @param name - Company name
	 * @param email - Company email address
	 * @param password - Company's password to access system
	 * @param companysCoupons - An ArrayList of all the company's coupons
	 * @throws Exception general exception
	 * @see exceptionHandling
	 */
	
	public Company(int id, String name, String email, String password) throws Exception {
		super();
		setId(id);
		setName(name);
		setEmail(email);
		setPassword(password);
	}
	
	
	public Company(String name, String email, String password) throws Exception{
		super();
		setName(name);
		setEmail(email);
		setPassword(password);
	}


	//----------------------getters + setters-----------

	public int getId() {
		return id;
	}

	/**
	 * @param id - The company's ID in the Companies table in the DB
	 * @throws InvalidIDException declared in exceptionHandling package
	 * @see exceptionHandling.InvalidIDException
	 */
	
	public void setId(int id)throws InvalidIDException {
		if(id < 0) {
			throw new InvalidIDException("Error. ID must not be negative");
		}
		this.id = id;
	}


	public String getName() {
		return name;
	}

	/**
	 * @param name - Company name
	 * @throws ShortStringException declared in exceptionHandling package
	 * @see exceptionHandling.ShortStringException
	 */
	
	public void setName(String name)throws ShortStringException {
	if(name.length() < 3) {
		throw new ShortStringException("Error. Company name must be composed of at least 3 characters");
	}
	else this.name =name;
	}


	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email the company email address
	 * @throws EmailException declared in exceptionHandling package
 * @see exceptionHandling.EmailException
	 */

	public void setEmail(String email) throws EmailException {
	if (validate(email)) {
		this.email = email;
	}
	else throw new EmailException("Error. Email is not valid. ");
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) throws ShortStringException {
		if(password.length() < 3) {
			throw new ShortStringException("Error. Password must be composed of at least 3 characters");
		}
		else this.password =password;
	}

	public ArrayList<Coupon> getCompaniesCoupons() {
		return companyCoupons;
	}

	public void setCompanyCoupons(ArrayList<Coupon> companyCoupons) {
		this.companyCoupons = companyCoupons;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nemail: " + email + "\nPassword: " + password + "\nCoupons: " + companyCoupons.toString();
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	/**
	 * @param emailStr - Is an extremely smart regex that validates if the email address is valid 
	 * @return boolean
	 */
	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}
	
}
