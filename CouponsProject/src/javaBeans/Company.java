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
	//----------------------prop------------------
	private int id;
	private String name;
	private String email;
	private String password;
	ArrayList<Coupon>companysCoupons=new ArrayList<>();


	//----------------------constructor-----------
	/**
	 * 
	 * @param id company id in the COMPANY table on the data base 
	 * @param name the company's name
	 * @param email the email address of the company
	 * @param password the company's password in our project network
	 * @param companysCoupons is an arrayList of all the coupons that this company has
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


	//----------------------getter+setter-----------

	public int getId() {
		return id;
	}

/**
 * 
 * @param id the company's id on the 	company table on the DB
 * @throws InvalidIDException declared in exceptionHandling package
 * @see exceptionHandling.InvalidIDException
 */
	public void setId(int id)throws InvalidIDException {
		if(id<0) {
			throw new InvalidIDException("Error. ID cannot be negative");
		}
		this.id = id;
	}


	public String getName() {
		return name;
	}

/**
 * 
 * @param name the company name
 * @throws ShortStringException declared in exceptionHandling package
 * @see exceptionHandling.ShortStringException
 */
	public void setName(String name)throws ShortStringException {
	if(name.length()<3) {
		throw new ShortStringException("Error. Must contain more then 3 charechters");
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
		if(password.length()<3) {
			throw new ShortStringException("Error. Must contain more then 3 chareckters");
		}
		else this.password =password;
	}

	public ArrayList<Coupon> getCompaniesCoupons() {
		return companysCoupons;
	}

	public void setCompaniesCoupons(ArrayList<Coupon> companiesCoupons) {
		this.companysCoupons = companiesCoupons;
	}
	@Override
	public String toString() {
		return "Company ID: " + id + ",\nName: " + name + ",\neMail: " + email + ",\nPassword: " + password + "."+"Coupons: "+"Coupons: "+companysCoupons.toString();
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
/**
 * @param emailStr this an extremely smart regex that validates if the email address is valid 
 * @return boolean
 */
		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	


}
