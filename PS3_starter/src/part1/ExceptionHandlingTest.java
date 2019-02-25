package part1;

import java.util.*;

public class ExceptionHandlingTest {

	/* Do not change this part -------------------------------------------*/
	private static Random rand = new Random(5);

	private static void stupidMethod() throws Exception {
		int type = rand.nextInt(6);

		switch(type) {
		case 1:
			throw new Exception();
		case 2: 
			throw new RuntimeException();
		case 3: 
			throw new NullPointerException();
		case 4: 
			throw new IllegalArgumentException();
		case 5: 
			throw new NumberFormatException();
		}
	}
	/*------------------------------------------------------------------- */	

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Trial "+i);
			try{
				stupidMethod();
				System.out.println("Yay, there is no exception");
			}
			catch(NumberFormatException e){
				System.out.println("I catched a "+e);
			}catch(IllegalArgumentException e){
				System.out.println("I catched an "+e);
			}catch(NullPointerException e){
				System.out.println("I catched a "+e);
			}catch(RuntimeException e){
				System.out.println("I catched a "+e);
			}catch(Exception e){
				System.out.println("I catched an "+e);
			}

		}
	}

}
