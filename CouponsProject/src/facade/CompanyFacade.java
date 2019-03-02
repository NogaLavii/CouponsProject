package facade;

import java.util.ArrayList;

import DBDAO.CouponDBDAO;
import javaBeans.Company;
import javaBeans.Coupon;
/**
 * CompanyFacade extends ClientFacade and manipulates company dependencies 
 * The methods here are empty because all the logic is at the DBDAO keeping the facade clean.
 * login() method must be implemented and checks the details in the data base.
 * 
 */
public class CompanyFacade extends ClientFacade {
CouponDBDAO couponDBDAO=new CouponDBDAO();
	public boolean login(String email, String password) throws Exception {
		if (companyDBDAO.doesCompanyExist(email, password)) {
			return true;
		} else
			return false;
	}

	public void addCoupon(Coupon coupon) throws Exception {
		couponDBDAO.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) throws Exception {
		couponDBDAO.updateCoupon(coupon);
	}
	

	public void deleteCoupon(int couponID) throws Exception {
		couponDBDAO.deleteCoupon(couponID);
	}

	public ArrayList<Coupon> getAllCoupons(int companyId) throws Exception {
		
		return couponDBDAO.getAllCoupons(companyId);
	}

	ArrayList<Coupon> getCouponsByCategory(int category_id, int companyID) throws Exception {
		return couponDBDAO.getCouponsByCategory(category_id, companyID);
	}

	ArrayList<Coupon> getCouponsByPrice(int companyID, int price) throws Exception {
		return couponDBDAO.getCouponsByPrice(companyID, price);
	}
	
	Company getOneCompany(int companyID) throws Exception{
		return companyDBDAO.getCompanyByID(companyID);
	}
	
}
