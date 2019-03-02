package exceptionHandling;

public class ObjectExists extends Exception {
	/**
	 * this is an exception that will be thrown when trying to add an object to the
	 * data base which exists there already.
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public ObjectExists(String messege) {
		super();
		setMessege(messege);
		System.out.println(messege);
	}

}
