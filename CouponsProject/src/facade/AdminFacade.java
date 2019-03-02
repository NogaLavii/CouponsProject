package facade;

import java.util.ArrayList;

import exceptionHandling.ObjectExists;
import javaBeans.Company;
import javaBeans.Customer;

public class AdminFacade extends ClientFacade {
	
	/**
	 * AdminFacade extends ClientFacade and constituting as Administrator Facade.
	 * Authenticating admin's details (hard coded because there's only one, Me)
	 *  
	 */

	public AdminFacade() {
		super();
	}

	public boolean login(String email, String password) {
		if (email == "admin@admin.com" && password == "admin") {
			return true;
		} else
			return false;
	}

	/**
	 *  Admin manipulation on Companies
	 * @param company a company object. 
	 * @throws Exception by exceptionHandling package.
	 * @see exceptionHanling.
	 * the Delete methods are deleting thoroughly all the object's dependences   
	 */
	public void addCompany(Company company) throws Exception {

		if (!companyDBDAO.isCompanyExists(company.getEmail(), company.getPassword())) {
			companyDBDAO.addCompany(company);
		} else
			throw new ObjectExists("This company exists on the data base already");
	}

	public void updateCompany(Company company) throws Exception {

		companyDBDAO.updateCompany(company);
	}

	public void deleteCompany(int id) throws Exception {
		companyDBDAO.deleteCompany(id);
		
	}

	public ArrayList<Company> getAllCompaniesF() throws Exception {

		return companyDBDAO.getAllCompanies();
	}

	public Company getOneCompany(int id) throws Exception {
		return companyDBDAO.getOneCompany(id);
	}

	/**
	 *  Admin manipulation on Customer
	 * @param customer
	 * @throws Exception
	 */

	public void addCustomer(Customer customer) throws Exception {
		customerDBDAO.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) throws Exception {
		customerDBDAO.updateCustomer(customer);
	}

	public void deleteCustomer(int id) throws Exception {
		customerDBDAO.deleteCustomer(id);
	}

	public ArrayList<Customer> getAllCustomersF() throws Exception {
		return getAllCustomersF();
	}

	public Customer getOneCustomer(int id) throws Exception {
		return getOneCustomer(id);
	}

}
