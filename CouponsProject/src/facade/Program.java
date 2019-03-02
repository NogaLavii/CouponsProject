package facade;


public class Program {
/**
 * 
 * class Program hold main method that calls one method only - checkItAll()
 * this where all the tests will be executed. 
 *  
 */
	public static void main(String[] args) {
		try {
			
			Test.checkItAll();
		} catch(Exception e) {
			e.getStackTrace();
}
	}

}
