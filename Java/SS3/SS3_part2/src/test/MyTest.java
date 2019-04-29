package test;

import question.*;

public class MyTest {

	public static void main(String[] args) {
	    
		String[] q1CorrectAnswers = new String[2];
		q1CorrectAnswers[0] = "0100";
		q1CorrectAnswers[1] = "1111";
		
		String[] q1StdAnswers = new String[2];
		q1StdAnswers[0] = "0010";
		q1StdAnswers[1] = "1111";
		
		WrittenQuestion q1 = new WrittenQuestion("Convert the following numbers into 4-bit binary numbers: 4 15", q1StdAnswers, q1CorrectAnswers, 20.0);
		
		String[] q2Choices = new String[4];
		q2Choices[0] = "O(lgn)";
		q2Choices[1] = "O(n)";
		q2Choices[2] = "O(nlgn)";
		q2Choices[3] = "O(n^2)";
		
		int q2CorrectChoice = 2;
		int q2StdChoice = 2;
		
		PickOneChoiceQuestion q2 = new PickOneChoiceQuestion("What is the average case complexity of the quick sort algoritm?", 20.0, 
				q2Choices, q2StdChoice, q2CorrectChoice);
		
		String[] q3Choices = new String[4];
	    q2Choices[0] = "BinarySearch";  
		q2Choices[1] = "Linear Search";
	    q2Choices[2] = "Merge Sort";
	    q2Choices[3] = "Bubble Sort";

		int[] q3CorrectOrder = {1, 2, 3, 4};
		
		int[] q3StdOrder = {1,2,4,3};
		
		OrderAllChoicesQuestion q3 = new OrderAllChoicesQuestion("Order the following algorithms in the complexity of their average case from lower complexity to higher complexity", 60,
				q3Choices, q3StdOrder, q3CorrectOrder);
		
		double q1Credit = q1.getPartialCredit();
		double q2Credit = q2.getGrade();
		double q3Credit = q3.getPartialCredit();
	        
        System.out.println("Total grade from first question is: " + q1Credit);
        System.out.println("Total grade from second question is: " + q2Credit);
        System.out.println("Total grade from third question is: " + q3Credit);
	        
        double total = q1Credit + q2Credit + q3Credit;
	        
        System.out.println("Total grade from the quiz is: " + total);
	}

}
