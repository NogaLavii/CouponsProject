package facade;

import DAO.CompanyDAO;
import DAO.CouponDAO;
import DAO.CustomerDAO;
import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;
import javaBeans.*;
public abstract class ClientFacade {
	/**
	 * Client Facade is an abstract class, to be inheareted with AdminFacade class
	 * Login() method will be implemented in all the facade to authenticate details.
	 */
	CompanyDAO<Company> companyDBDAO = new CompanyDBDAO();
	CustomerDAO<Customer> customerDBDAO = new CustomerDBDAO();
	CouponDAO<Coupon> couponDBDAO = new CouponDBDAO();

	public boolean login(String email, String password) throws Exception {
		return false;
	}

}
