package DAO;

import java.util.ArrayList;

import javaBeans.Coupon;

public interface CouponDAO<t>{
	/**
	 * @param coupon will let me manipulate data on the COUPON table's data members
	 *               on the DB
	 * @throws Exception , SQLException
	 */
	boolean isCouponExists(String title, int companyID) throws Exception;

	void addCoupon(Coupon coupon) throws Exception;

	void updateCoupon(Coupon coupon) throws Exception;

	ArrayList<Coupon> getAllCoupons(int company_id) throws Exception;

	Coupon getOneCoupon(int couponID) throws Exception;

	ArrayList<Coupon> getCouponsByCtgry(int category_id, int companyID) throws Exception;

	void deleteCoupon(int couponID) throws Exception;

	void addCouponPurchase(int customerID, int couponID) throws Exception;

	void deleteCouponPurchase(int customerID, int couponID) throws Exception;
	public boolean isCouponPurchaseExists(int customerID, int couponID) throws Exception;
	ArrayList<Coupon> getCouponsByPrice(int companyID, double price) throws Exception;

	ArrayList<Coupon> getCouponsByCstmr(int customerID) throws Exception;

	boolean isCouponAvailble(int couponID) throws Exception;

	ArrayList<Coupon> getCustomersCouponsByCtgry(int catgoryID, int customerID) throws Exception;
	ArrayList<Coupon> getCustomersCouponsByPrice(int customerID, double price)throws Exception;
	
}
