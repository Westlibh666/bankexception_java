package Exception_account;

public class OverdraftException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7323970050161066667L;
	private double deficit;
	
	public OverdraftException(String message,double deficit) {
		super(message);
		this.deficit = deficit;		
	}
	
	public double getDefict() {
		return deficit;
}
}