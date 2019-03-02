package exceptionHandling;

public class ShortStringException extends Exception {
	/**
	 * this is an exception that will be thrown when trying to add a too-short
	 * String to the data base
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public ShortStringException(String message) {
		super();
		setMessege(message);
		System.out.println(message);
	}
}
