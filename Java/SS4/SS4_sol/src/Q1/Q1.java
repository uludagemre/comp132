package Q1;

public class Q1 {

	public static void main(String[] args) {
		try { // throw ExceptionC 
	         throw new ExceptionC();
	      } 
	      catch (ExceptionA exception1) { // catch ExceptionA and subclasses 
	         System.err.println("First Exception subclass caught. \n");
	      } 
	      
	      try { // throw ExceptionB 
	         throw new ExceptionB();
	      }
	      catch (ExceptionA exception2) { // catch ExceptionA and subclasses 
	         System.err.println("Second Exception subclass caught. \n");
	      } 
	   } 
	} 

	// exception subclasses
	class ExceptionA extends Exception {
	   // empty class body
	}

	class ExceptionB extends ExceptionA {
	   // empty class body
	} 

	class ExceptionC extends ExceptionB {
	   // empty class body
	} 

	

