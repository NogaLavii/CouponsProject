package facade;


import DBDAO.CompanyDBDAO;
import DBDAO.CustomerDBDAO;

public class LoginManager {
	/**
	 * loginManager class manages all the client logins to the system,
	 *  weather it's a customer company or the administrator himself, 
	 *  Entrance and data manipulation will occur only after authentication.
	 */
	private CompanyDBDAO companyDBDAO= new CompanyDBDAO();
	private CustomerDBDAO customerDBDAO= new CustomerDBDAO();
	
	
	private static LoginManager instance= new LoginManager();

	private LoginManager() {}

	public static LoginManager getInstance() {
		return instance;

	}
/**
 * 
 * @param email
 * @param password
 * @param clientType
 * @return
 * @throws Exception
 */
	public ClientFacade login(String email, String password, ClientType clientType) throws Exception {

		if (clientType == ClientType.Adminstrator) {
			if (email == "admin@admin.com" && password == "admin") {
				System.out.println("login succesfull");
				return new AdminFacade();
			}
		} else if (clientType == ClientType.Company) {
			if (companyDBDAO.isCompanyExists(email, password)) {
				System.out.println("login succesfull");
				return new CompanyFacade();
			}
		} else if (clientType == ClientType.Customer) {
			if (customerDBDAO.isCustomerExists(email, password)) {
				System.out.println("login succesfull");
				return new CustomerFacade();
			}
		}
		System.out.println("Login faild.");
		return null;
	}

}
