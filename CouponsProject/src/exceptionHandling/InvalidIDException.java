package exceptionHandling;

public class InvalidIDException extends Exception {
	/**
	 * this is an exception that will be thrown when trying to enter an invalid ID number
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}
	public InvalidIDException (String message) {
		super( );
		setMessege(message);
		System.out.println(message);
	}
}