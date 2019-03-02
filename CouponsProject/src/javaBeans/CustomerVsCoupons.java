package javaBeans;

import exceptionHandling.InvalidIDException;

public class CustomerVsCoupons {
	/**
	 * customer vs coupon bean file for the db table, props setters getters
	 * constructor and a toString method
	 */
	// ---------------------prop----------------------------------

	private int customer_id, coupon_id;

	// ---------------------constructor--------------------------------
	/**
	 * 
	 * @param customer_id on this table of all the purchased coupons this prop
	 *                    indicates the coupon's customer's id
	 * @param coupon_id   indicates the coupon's id
	 * @throws Exception general exception
	 */

	public CustomerVsCoupons(int customer_id, int coupon_id) throws Exception {
		super();
		setCustomr_id(customer_id);
		setCoupon_id(coupon_id);
	}

	// ---------------------getters + setters-------------------------

	public int getCustomr_id() {
		return customer_id;
	}

	/**
	 * 
	 * @param customer_id as it sounds..
	 * @throws InvalidIDException declared in exceptionHandling package
	 * @see exceptionHandling.InvalidIDException
	 */
	public void setCustomr_id(int customer_id) throws InvalidIDException {
		if (customer_id < 0) {
			throw new InvalidIDException("Error. Invalid  customer ID");
		}

		else
			this.customer_id = customer_id;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) throws InvalidIDException {
		if (coupon_id < 0) {
			throw new InvalidIDException("Error. Invalid coupon ID");
		} else
			this.coupon_id = coupon_id;
	}

	// ---------------------methods-------------------------
	@Override
	public String toString() {
		return "Customer ID: " + customer_id + ",\tCoupon ID: " + coupon_id + ".";
	}

}
