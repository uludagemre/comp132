package exceptions;

public class OutOfArrowException extends Exception {
	
	public OutOfArrowException(){}
	
	public OutOfArrowException(String message)
	{
		super(message);
	}

	@Override
	public String toString() {
		return "OutOfArrowException:";
	}
	

}
