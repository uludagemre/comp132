package question;

public class OrderAllChoicesQuestion extends MultipleChoice implements PartialCreditGiveable {

	private int[] studentsOrdering;
	private int[] correctOrdering;
	
	public OrderAllChoicesQuestion(String text, double points, String[] choices, int[] stdOrdering, int[] cOrdering) {
		super(text, points, choices);		
		studentsOrdering = stdOrdering;
		correctOrdering = cOrdering;
	}

	@Override
	public double getGrade() {
		double result = 0;
		
		if(isAnsweredCompletelyCorrectly())
			result = getPoints();
		
		return result;
	}

	@Override
	public boolean isAnsweredCompletelyCorrectly() {		
		for(int i = 0; i < correctOrdering.length; i++) {
			if(correctOrdering[i] != studentsOrdering[i])
				return false;
		}
		
		return true;
	}

	@Override
	public double getPartialCredit() {
		double result = 0;
		int correctNum = 0;
		
		for(int i = 0; i < correctOrdering.length; i++) {
			if(correctOrdering[i] == studentsOrdering[i])
				correctNum ++;
		}
		
		result = (getPoints() / correctOrdering.length) * correctNum;
		
		return result;
	}

}
