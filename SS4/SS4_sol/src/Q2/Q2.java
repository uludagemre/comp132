package Q2;

public class Q2 {

	public static void main(String[] args) {
		try { // call someMethod 
	         someMethod();
	      }
	      catch (Exception exception) {
	          System.err.printf("%s\n\n", exception.getMessage());
	          exception.printStackTrace();
	      }
	   } 

	   // call someMethod2; rethrow Exceptions back to main
	   public static void someMethod() throws Exception {
	      try { // call someMethod2 
	         someMethod2();
	      } 
	      catch (Exception exception2) {
	         throw exception2; // rethrow the Exception
	      } 
	   } 

	   // throw Exception back to someMethod
	   public static void someMethod2() throws Exception {
	      throw new Exception("Exception thrown in someMethod2");
	   } 
	}
