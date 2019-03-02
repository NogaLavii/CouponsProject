package DAO;

import java.util.ArrayList;

import javaBeans.Company;

public interface CompanyDAO<T> {
	/**
	 * 
	 * @param email  will be the customer Email	 
	 * @param password customer password

	 * @return void
	 * @throws Exception general exception 
	 */
	boolean isCompanyExists(String email, String password) throws Exception;
	

	void addCompany(Company company) throws Exception;

	void updateCompany(Company company) throws Exception;

	void deleteCompany(int companyID) throws Exception;

	ArrayList<Company> getAllCompanies() throws Exception;

	Company getOneCompany(int companyID) throws Exception;
	
	
	
}