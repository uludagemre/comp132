package question2;

import java.util.Scanner;

public class IndexTest {
   public static void main(String args[]) {
      // get input string
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter a string:");
      String input = scanner.nextLine();

      // get search character
      System.out.println("Please enter a character:");
      char searchKey = scanner.next().charAt(0);

      // display index of first occurrence
      System.out.printf("\nFirst '%s' occurs at index %d\n", 
         searchKey, FindIndexEmre.indexOf(input, searchKey));
   
      // display index of last occurrence
      System.out.printf("Last '%s' occurs at index %d\n", 
         searchKey, FindIndexEmre.lastIndexOf(input, searchKey));
   } 
}