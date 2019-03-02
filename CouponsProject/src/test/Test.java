package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javaBeans.*;
import facade.*;


public class Test {

	public static void run(String[] args) {


		LoginManager loginManager = LoginManager.getInstance();

		try {
			
			// ------------ADMIN-------------
			
			System.out.println("Testing admin CRUD...");
			
			// Login as admin to insert data to db
			AdminFacade admin = (AdminFacade) loginManager.login("admin@admin.com", "1234", ClientType.ADMINISTRATOR);
			
			// Create company objects
			Company[] companies = new Company[5];
			companies[0] = new Company("Nike","nike@nike.com","nikePass");
			companies[1] = new Company("Bug","bug@bug.com","bugPass");
			companies[2] = new Company("Ivory","ivory@ivory.com","ivoryPass");
			companies[3] = new Company("H-Stern","h-stern@hstern.com","hsternPass123");
			companies[4] = new Company("Castro","castro@castro.com","castroPass");
			
			// Create customer objects
			Customer[] customers = new Customer[5];
			customers[0] = new Customer("Johnny","Bravo","jbrockstar@cartoonnetwork.com","jb123");
			customers[1] = new Customer("Al","Bundy","married2@nomaam.com","4touch");
			customers[2] = new Customer("Freddy","Krueger","fred123@elm.com","fkelm");
			customers[3] = new Customer("Alissa","Wonder","alissa@wonderland.com","rabbit1");
			customers[4] = new Customer("Hannah","Montana","hanale@montana.com","hmhm");
			
			// Add the companies to the database
			for (Company c : companies) {
				admin.addCompany(c);
			}
			// Delete company
			admin.deleteCompany(4);
			// Update company
			companies[3].setName("H Stern");
			companies[3].setEmail("info@hstern.com");
			companies[3].setPassword("hsternPass");
			admin.updateCompany(companies[3]);
			// Read back from DB
			ArrayList<Company> companiesFromDB = admin.getAllCompaniesF();
			if (companiesFromDB.size() == 4 && companiesFromDB.get(3).getName().equals("H STERN") && companiesFromDB.get(3).getEmail().equals("hstern@hstern.com") && companiesFromDB.get(3).getPassword().equals("hsternPass")) {
				System.out.println("Admin - Companies --> Success");
			}
			else {
				System.out.println("Admin - Companies --> Fail");
			}
			
			// Add the customers to the database
			for (Customer c : customers) {
				admin.addCustomer(c);
			}
			// Delete customer
			admin.deleteCustomer(4);
			// Update customer
			customers[3].setFirst_name("Alice");
			customers[3].setLast_name("Wonderland");
			customers[3].setEmail("alice@wonderland.com");
			customers[3].setPassword("rabbit");
			admin.updateCustomer(customers[3]);
			// Read back from DB
			ArrayList<Customer> customersFromDB = admin.getAllCustomersF()
			if (customersFromDB.size() == 4 && customersFromDB.get(3).getFirst_name().equals("Alice") && 
				customersFromDB.get(3).getLast_name().equals("Wonderland") && customersFromDB.get(3).getEmail().equals("alice@wonderland.com") &&
				customersFromDB.get(3).getPassword().equals("rabbit")) {
				System.out.println("Admin - Customers --> Success");
			}
			else {
				System.out.println("Admin - Customers --> Fail");
			}
			
			
			// ------------COMPANY-------------
			
			// Login as admin to insert data to db
			CompanyFacade company = (CompanyFacade) loginManager.login("nike@nike.com", "nikePass", ClientType.COMPANY);
			
			System.out.println("Testing company CRUD...");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			/* Categories:
			 * 1- fashion
			 * 2- jewelry
			 * 3- computers
			 */
			
			// Create coupon objects
			Coupon[] coupons = new Coupon[6];
				
			// Nike T-shirt 50%, 50 coupons, 10$, 2019-02-01 through 2019-06-30
			Date startDate = formatter.parse("2019-02-01");
			Date endDate = formatter.parse("2019-06-30");
			coupons[0] = new Coupon(companies[0].getId(), 1, "T-Shirt half off!", "Get 50% off any Nike logo T-shirt", startDate, endDate, 50, 10.0, "https://i.ebayimg.com/images/g/YOsAAOSwoIlazLel/s-l300.jpg");
				
			// Nike Sneakers 20%, 50 coupons, 8$, 2019-02-01 through 2020-02-01
			startDate = formatter.parse("2019-02-01");
			endDate = formatter.parse("2020-02-01");
			coupons[1] = new Coupon(companies[0].getId(), 1, "20% On Sneakers!", "Get 20% off any Nike Sneakers", startDate, endDate, 50, 8.0, "https://images.nike.com/is/image/DotCom/pwp_sheet2?$NIKE_PWPx3$&$img0=BQ8928_400&$img1=BQ8928_003&$img2=BQ8928_005");
				
			// Bug 30% off, 100 coupons, 5$, 2019-01-01 through 2019-12-31
			startDate = formatter.parse("2019-01-01");
			endDate = formatter.parse("2019-12-31");
			coupons[2] = new Coupon(companies[1].getId(), 3, "30% OFF!", "Get 30% off any Bug Products", startDate, endDate, 100, 7.5, "https://i.guim.co.uk/img/static/sys-images/Guardian/Pix/pictures/2012/2/1/1328121872902/A-computer-bug-007.jpg?width=700&quality=85&auto=format&fit=max&s=0070ca87239fdf83041ef0ad93db14c2");
				
			// Ivory mouse 50%, 20 coupons, 15.5$, 2019-02-01 through 2019-04-30
			startDate = formatter.parse("2019-02-01");
			endDate = formatter.parse("2019-04-30");
			coupons[3] = new Coupon(companies[2].getId(), 3, "50% Off Laser Mouse", "Get 50% off any laser mouse", startDate, endDate, 20, 15.5, "https://www.arp.nl/webmedias/prb/460x460/58eb6cc34c2f85e0fda58cfa.jpg");
			
			// Ivory 1+1 on chargers, 30 coupons, 12$, 2019-01-01 through 2021-12-31
			startDate = formatter.parse("2019-01-01");
			endDate = formatter.parse("2021-12-31");
			coupons[4] = new Coupon(companies[2].getId(), 3, "Buy 1 Get 1 Free on any Charger", "Buy 1 get 1 free on any phone charger", startDate, endDate, 30, 12, "https://4.imimg.com/data4/OG/CC/MY-7810515/mobile-phone-charger-500x500.jpg");
				
			// H Stern 30% off diamond necklaces, 10 coupons, 50$, 2019-01-01 through 2019-12-31
			startDate = formatter.parse("2019-01-01");
			endDate = formatter.parse("2019-12-31");
			coupons[5] = new Coupon(companies[3].getId(), 3, "Get 30% off Diamond Necklace", "Get 30% off selected diamond necklaces", startDate, endDate, 10, 50, "https://imagens.hstern.com.br/imagesmenu/menu_colec_copernicus.jpg");

			company.addCoupon(coupons[0]);
			company.addCoupon(coupons[1]);

			coupons[0].setAmount(60);
			company.updateCoupon(coupons[0]);
			company.deleteCoupon(1);
			
			// Read back from DB
			ArrayList<Coupon> couponsFromDB = company.getAllCoupons(1);
			if (couponsFromDB.size() == 1 && couponsFromDB.get(0).getAmount() == 60) {
				System.out.println("Company - Coupons --> Success");
			}
			else {
				System.out.println("Company - Coupons --> Fail");
			}


			// ------------CUSTOMER-------------
			
			// Login as customer
			CustomerFacade customer = (CustomerFacade) loginManager.login("jbrockstar@cartoonnetwork.com", "jb123", ClientType.CUSTOMER);
						
			System.out.println("Testing customer CRUD...");
			
			// Purchase coupons
			int customerID;
			for (int i; i<customersFromDB.size(); i++) {
				if (customersFromDB.get(i).getEmail().equals("jbrockstar@cartoonnetwork.com")) {
					customerID = i;
					break;
				}
			}
			
			customer.addCouponPurchase(customerID, couponsFromDB.get(0).getId());
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	} // end of run method
} // end of class


