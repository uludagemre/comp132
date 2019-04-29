package question2;

public class FindIndex {
	   public static int indexOf(String input, char search) {
	      // loop through the characters
	      for(int i = 0; i <input.length(); i++) {
	         if (input.charAt(i) == search) {
	            return i;
	         }
	      } 	      
	      return -1; // if we do not find it
	   }
	   
	   public static int lastIndexOf(String input, char search) {
	      // loop through the characters in reverse
	      for(int i = input.length() - 1; i>= 0; i--) {
	         if (input.charAt(i) == search) {
	            return i;
	         }
	      } 
	      return -1; // if we do not find it
	   } 
}
