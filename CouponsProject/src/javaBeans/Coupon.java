package javaBeans;


import java.util.Date;

import exceptionHandling.DateException;
import exceptionHandling.InvalidIDException;
import exceptionHandling.NegativeException;
import exceptionHandling.ShortStringException;
import exceptionHandling.URLException;


public class Coupon{
	/**
	 * the coupon bean file, with exception handling, has props setters getters constructor and a toString method 
	 */
	// ---------------------prop----------------------------------
	
	private int id, company_id,category_id,  amount;
	private String title, description, image;
	private Date start_date;
	private Date end_date;
	private double price;
//	CategoriesEnum category;
	
	// ---------------------constructor--------------------------------
	/**
	 * Creates new coupon with the following parameters
	 * @param id the coupon's id
	 * @param company_id the company's id
	 * @param amount the amount of coupons
	 * @param title the coupon title
	 * @param description the coupon description
	 * @param image the url for an image of the coupon
	 * @param start_date the start date of the coupon
	 * @param end_date the end date of the coupon
	 * @param price the coupon's price 
	 * @param category the enum category of the coupon
	 * @throws Exception general exception
	 * @see exceptionHandling package.
	 */
	public Coupon(int id, int company_id, int category_id,  String title, String description, String image,
								Date start_date,Date end_date,int amount, double price)throws Exception{
		
		super();
		setId( id);
		setCompany_id(company_id);
		setCategory_id(category_id);
		setTitle(title);
		setDescription(description);
		setImage(image);
		setStart_date(start_date,end_date);
		setEnd_date(end_date);
		setAmount(amount);
		setPrice(price);
	}
	

	public Coupon(int company_id, int category_id,  String title, String description,
		Date start_date, Date end_date,int amount, double price, String image) throws Exception {
	super();
	setCompany_id(company_id);
	setCategory_id(category_id);
	setTitle(title);
	setDescription(description);
	setStart_date(start_date,end_date);
	setEnd_date(end_date);
	setAmount(amount);
	setPrice(price);
	setImage(image);
}


	// ---------------------getter+setter-------------------------

	public int  getCategory_id() {
		return category_id;
	}
	
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

/**
 * 
 * @param id coupon id
 * @throws InvalidIDException declared in exceptionHandling package
 * @see exceptionHandling.InvalidIDException
 */
	public void setId(int id) throws InvalidIDException{
		if (id<0) {
			throw new InvalidIDException("Error. ID cannot be negative");
		}
		else this.id = id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) throws InvalidIDException{
		if (company_id<0) {
			throw new InvalidIDException("Error. ID can not be negative");
		}
		else	this.company_id = company_id;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) throws NegativeException{
		if(amount<0) {
			throw new NegativeException("Error. Amount can not be negative");
		}
		else this.amount =amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title)throws ShortStringException{
		if(title.length()<2) {
			throw new ShortStringException("Error. Title is too short");
		}
		else {
			this.title =title;
		}
	}

	public String getDescription() {
		return description;
	}
/**
 * 
 * @param description coupon's description 
 * @throws ShortStringException declared in exceptionHandling package
 * @see exceptionHandling.ShortStringException
 */
	public void setDescription(String description)throws ShortStringException{
		if(description.length()<5){
			throw new ShortStringException("Error. Description is too short");
		}
		else this.description = description;
	}

	public String getImage() {
		return image;
	}
/**
 * 
 * @param image url of the coupon image
 * @throws URLException declared in exceptionHandling package
 * @see exceptionHandling.URLException
 */
	public void setImage(String image)throws URLException  {
	if(image.length()>4 ) {
		this.image =image;
			}
	else throw new URLException("Error. URL is invalid, must contain more then 4 chareckters and `.png`");
	}

	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date of the coupon
	 * @param end_date of the coupon
	 * @throws DateException  declared in exceptionHandling package
	 * @see exceptionHandling.DateException
	 */
	public void setStart_date(Date start_date , Date end_date)throws DateException {
		if(start_date.after(end_date)) {
			throw new DateException("Error. Start date cannot be after the End date ");
			}
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) throws DateException{
		if(end_date.before(start_date)) {
			throw new DateException("Error. End date cannot be before the Start date");
			}
		else this.end_date=end_date;
	}

	public double getPrice() {
		return price;
	}
/**
 * @param price coupon's price in double type
 * @throws NegativeException declared in exceptionHandling package
 * @see exceptionHandling.NegativeException
 */
	public void setPrice(double price)throws NegativeException{
	if(price<0) {
		throw new NegativeException("Error. Price cannot be negative");
	}
	else this.price = price;
	}
	// ---------------------methods--------------------------------
	@Override
	public String toString() {
		return "Coupon ID: " + id + ",\nCompany ID: " + company_id + ",\nCategory ID: " +  ",\nAmount: "
				+ amount + ",\nTitle: " + title + ",\nDescription=" + description + ",\nImage link: " + image + ",\nStart Date: "
				+ start_date + ",\nEnd Date: " + end_date + ",\nPrice: " + price +"$.\nCategory: "+category_id+ "\nThank You. ";
	}
	

}
