package DAO;

import java.util.ArrayList;

import javaBeans.Company;

public interface CompanyDAO<T> {
	/**
	 * @param email - Company email	 
	 * @param password - Company password

	 * @return void
	 * @throws Exception general exception 
	 */
	boolean doesCompanyExist(String email, String password) throws Exception;

	void addCompany(Company company) throws Exception;

	void updateCompany(Company company) throws Exception;

	void deleteCompany(int companyID) throws Exception;

	ArrayList<Company> getAllCompanies() throws Exception;

	Company getCompanyByID(int companyID) throws Exception;
	
}