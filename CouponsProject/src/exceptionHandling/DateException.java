package exceptionHandling;

public class DateException extends Exception {
	/**
	 * this is an exception that will be thrown when the Date trying to enter the data base is invalid
	 */
	private static final long serialVersionUID = 1L;
private String messege;

	public String getMessege() {
	return messege;
}

public void setMessege(String messege) {
	this.messege = messege;
}

	public DateException(String messege) {
		super();
		setMessege(messege);
		System.out.println(messege);
	}
}
