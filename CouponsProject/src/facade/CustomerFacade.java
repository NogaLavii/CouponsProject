package facade;

import java.util.ArrayList;

import javaBeans.Coupon;
import javaBeans.Customer;

public class CustomerFacade extends ClientFacade {
	/**
	 * CustomerFacde extends ClientFacade and manipulates data of customer The
	 * methods here are empty because all the logic is at the DBDAO keeping the
	 * facade clean.
	 *  login() method must be implemented and checks the details in
	 * the data base.
	 * 
	 */
	@Override
	public boolean login(String email, String password) throws Exception {
		if (customerDBDAO.doesCustomerExist(email, password)) {
			return true;
		} else
			return false;
	}

	public void purchaseCoupon(int customerID, int couponID) throws Exception {
		couponDBDAO.purchaseCoupon(customerID, couponID);
	}

	public boolean isCouponPurchased(int customerID, int couponID) throws Exception {
		return couponDBDAO.isCouponPurchased(customerID,couponID);
	}

	public ArrayList<Coupon> getCouponsByCustomer(int customerID) throws Exception {
		return couponDBDAO.getCouponsByCustomer(customerID);
	}

	Customer getCustomerByID(int customerID) throws Exception {
		return customerDBDAO.getCustomerByID(customerID);
	}

}
