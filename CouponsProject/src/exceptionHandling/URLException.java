package exceptionHandling;

public class URLException extends Exception {
	/**
	 * this is an exception that will be thrown when trying to add an invalid url to
	 * the data base
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public URLException(String messege) {
		super();
		setMessege(messege);
		System.out.println(messege);
	}
}
