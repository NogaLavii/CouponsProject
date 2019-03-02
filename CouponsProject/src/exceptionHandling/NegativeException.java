package exceptionHandling;

public class NegativeException extends Exception {
	/**
	 * this is an exception that will be thrown when trying to add a a negative
	 * number to the data base
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public NegativeException(String messege) {
		super();
		setMessege(messege);
		System.out.println(messege);
	}
}
