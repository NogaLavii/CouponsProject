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
		if (customerDBDAO.isCustomerExists(email, password)) {
			return true;
		} else
			return false;
	}

	public void addCouponPurchase(int customerID, int couponID) throws Exception {
		couponDBDAO.addCouponPurchase(customerID, couponID);
	}

	public boolean isCouponPurchaseExists(int customerID, int couponID) throws Exception {
		return couponDBDAO.isCouponPurchaseExists(customerID,couponID);
	}

	public ArrayList<Coupon> getCouponsByCstmr(int customerID) throws Exception {
		return couponDBDAO.getCouponsByCstmr(customerID);
	}

	Customer getOneCustomer(int customerID) throws Exception {
		return customerDBDAO.getOneCustomer(customerID);
	}

}
