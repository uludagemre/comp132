package question;

public class PickOneChoiceQuestion extends MultipleChoice {

	private int choiceIndex;
	private int correctIndex;
	
	public PickOneChoiceQuestion(String text, double points, String[] choices, int sChoice, int correct) {
		super(text, points, choices);
		choiceIndex = sChoice;
		correctIndex = correct;
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
		boolean result = false;
		
		if(choiceIndex == correctIndex)
			result = true;
		
		return result;
	}

}
