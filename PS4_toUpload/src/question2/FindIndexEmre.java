package question2;

public class FindIndexEmre {
	
	public static int indexOf(String input, char search) {
		int index = -1;
		char[] inputArray = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			if (inputArray[i] == search) {
				index = i;
				return index;
			}
		}
		return index;
	}
	public static int lastIndexOf(String input, char search) {
		int index = -1;
		char[] inputArray = input.toCharArray();
		for (int i = inputArray.length-1; i >0; i--) {
			if (inputArray[i] == search) {
				index = i;
				return index;
			}
		}
		return index;
	}
	
}
