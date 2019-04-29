package question;

public abstract class Question {
	
	private String questionText;
	private double points;
	
	public Question(String text, double points)
	{
		this.questionText = text;
		this.points = points;
	}
	
	public String getQuestionText() {
		return questionText;
	}

	public double getPoints() {
		return points;
	}
	
	public abstract double getGrade();

}
