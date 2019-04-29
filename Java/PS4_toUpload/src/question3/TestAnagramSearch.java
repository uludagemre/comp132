package question3;
import question3.AnagramSearch;
import java.util.Scanner;

public class TestAnagramSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the text string to be searched.");
		String txtString = scanner.next();
		
		System.out.println("Enter the pattern you wish to look for and press Enter.");
		String pattern = scanner.next();
		
		System.out.println("In the entered text string there are "+AnagramSearch.searchAnagramSubstring(txtString,pattern)+" anagrams of the entered pattern.");

	}

}
