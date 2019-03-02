package DAO;

import java.util.ArrayList;

import javaBeans.Coupon;

public interface CouponDAO<t>{
	/**
	 * @param coupon will let me manipulate data on the COUPON table's data members
	 *               on the DB
	 * @throws Exception , SQLException
	 */
	boolean doesCouponExist(String title, int companyID) throws Exception;

	void addCoupon(Coupon coupon) throws Exception;

	void updateCoupon(Coupon coupon) throws Exception;

	ArrayList<Coupon> getAllCoupons(int company_id) throws Exception;

	Coupon getCouponByID(int couponID) throws Exception;

	ArrayList<Coupon> getCouponsByCategory(int category_id, int companyID) throws Exception;

	void deleteCoupon(int couponID) throws Exception;

	void purchaseCoupon(int customerID, int couponID) throws Exception;

	void deleteCouponPurchase(int customerID, int couponID) throws Exception;
	
	public boolean isCouponPurchased(int customerID, int couponID) throws Exception;
	
	ArrayList<Coupon> getCouponsByPrice(int companyID, double price) throws Exception;

	ArrayList<Coupon> getCouponsByCustomer(int customerID) throws Exception;

	boolean isCouponAvailble(int couponID) throws Exception;

	ArrayList<Coupon> getCustomersCouponsByCategory(int catgoryID, int customerID) throws Exception;
	
	ArrayList<Coupon> getCustomersCouponsByPrice(int customerID, double price)throws Exception;
	
}
