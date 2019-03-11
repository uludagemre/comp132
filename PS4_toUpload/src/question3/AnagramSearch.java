package question3;

public class AnagramSearch {
	
	private static boolean equalHistogram(int[] hist1, int[] hist2){
		for(int i = 0; i < hist1.length; i++){
			if(hist1[i] != hist2[i]){
				return false;}
		}
		return true;
	}

	public static int searchAnagramSubstring(String text, String pattern){
		int count = 0;
		int n = text.length();
		int m = pattern.length();
		if(n < m | m == 0 | n == 0){
			return 0;
		}
		//initialize arrays for all ASCII possibilities	
		int textHist[] = new int[256];
		int patHist[] = new int[256];
		
		//initial histogram window of size m on both arrays 
		int i = 0;
		for(i = 0; i < m; i++){
			patHist[pattern.charAt(i)]++;
			textHist[text.charAt(i)]++;
		}

		//search the pattern histogram in a sliding window of text histogram
		do{
			//O(1) time check as array size is constant
			if(equalHistogram(textHist, patHist)){
				System.out.println("anagram found : "+text.substring(i-m, i)+" at index "+(i-m));
				count++;
			}
			
			//slide the text histogram window by 1 position to the right and check for anagram
			textHist[text.charAt(i)]++;
			textHist[text.charAt(i-m)]--;
		} while(++i< n);
		
		//check the last window
		if(equalHistogram(textHist, patHist)){
			System.out.println("anagram found : "+text.substring(i-m, i)+" at index "+(i-m));
			count++;
		}
		
		return count;
	}

}
