package question;

public class WrittenQuestion extends Question implements PartialCreditGiveable{
    
	private String[] correctAnswerWords;
	private String[] responseWords;
	
	public WrittenQuestion(String text, String[] resWords, String[] corWords, double points) {
		super(text, points);
		correctAnswerWords = corWords;
		responseWords = resWords;
	}
	
	@Override
	public double getGrade() {		
		if(correctAnswerWords.length != responseWords.length)
		    return 0;
		
		for(int i = 0; i < correctAnswerWords.length; i++) {
			if(!correctAnswerWords[i].equals(responseWords[i]))
				return 0;
		}
		
		return getPoints();
	}

	@Override
	public double getPartialCredit() {
		double result = 0;
		int correctNums = 0;
		
		for(int i = 0; i < correctAnswerWords.length; i++) {
			if(correctAnswerWords[i].equals(responseWords[i]))
				correctNums++;
		}
		
		result = (getPoints() / correctAnswerWords.length) * correctNums;
		return result;
	}

}
