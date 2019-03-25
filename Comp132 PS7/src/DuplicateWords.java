import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class DuplicateWords {
	public static void main(String[] args)throws IOException {

		System.out.println("Enter words separated by spaces ('.' to quit):");
		ArrayList<String> wordArray = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String inputWord = input.next();
		int wordCount = 0;
		int duplicateCount = 0;
		while(!inputWord.equals(".")){
			if(hasTheWord(inputWord, wordArray)){
				System.out.println("Duplicate detected: "+inputWord);
				inputWord = input.next();
				duplicateCount++;
				continue;
			}
			wordCount++;
			wordArray.add(inputWord);
			inputWord = input.next();
		}
		System.out.println(wordCount+" distinct words: ");
		System.out.println(wordArray);
		System.out.println(duplicateCount);
	}
	
	public static boolean hasTheWord(String word,ArrayList<String> array){
		return array.contains(word);
	}
}