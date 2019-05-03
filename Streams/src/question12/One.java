package question12;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class One {
	public static void main(String[] args) {
		
		Random random = new Random();
		int[] randomElements = new int[10];
		
		
		for (int i = 0; i < randomElements.length; i++) {
			randomElements[i]=random.nextInt(1000);
		}

		System.out.printf("Our array looks like this [ %s ]%n",Arrays.stream(randomElements).mapToObj(String::valueOf).collect(Collectors.joining(" , ")));
		System.out.printf("The number of even numbers in our array is %d%n",Arrays.stream(randomElements).filter(x -> x%2 == 0).count());
		System.out.printf("The number of odd numbers in our array is %d%n",Arrays.stream(randomElements).filter(x -> x%2 == 1).count());
		System.out.printf("The average of all numbers in our array is %.2f%n",Arrays.stream(randomElements).average().getAsDouble());
		System.out.printf("The average of even numbers in our array is %.2f%n",Arrays.stream(randomElements).filter(x -> x %2 == 0).average().getAsDouble());
		System.out.printf("The average of odd numbers in our array is %.2f%n",Arrays.stream(randomElements).filter(x -> x %2 == 1).average().getAsDouble());
	}
}
