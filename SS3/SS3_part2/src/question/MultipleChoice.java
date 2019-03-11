package question;

public abstract class MultipleChoice extends Question {

	private String[] choices;
			
	public MultipleChoice(String text, double points, String[] choices) {
		super(text, points);
		this.choices = choices;
	}
	
	public abstract boolean isAnsweredCompletelyCorrectly();
}
