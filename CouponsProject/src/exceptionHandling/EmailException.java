package exceptionHandling;



public  class EmailException  extends Exception {
	/**
	 * this is an exception that will be thrown when trying to enter an invalid email address
	 */
	private static final long serialVersionUID = 1L;
	private String messege;

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public EmailException (String messege) {
		super();
		setMessege(messege);
		System.out.println(messege);
	}
}