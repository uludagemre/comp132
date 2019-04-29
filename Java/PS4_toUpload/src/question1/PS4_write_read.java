package question1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PS4_write_read {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(Paths.get("./src/huntington.txt"))) //To read from console it is System.in
		{
			System.out.println("Read successfully");
			try (Formatter output = new Formatter("./src/HD_report.txt")) 
			{

			output.format("Name\t");
			output.format("Surname\t");
			output.format("Number Of Repeats\t\t");
			output.format("Disease Status\t\n");
			
			input.nextLine();
			
			while(input.hasNextLine()){
				
				
//				String[] splited = line.split("\\s+");
//				
//				String name = splited[0];
//				String surname = splited[1];
//				String dnaSequence = splited[2];
				
				String name = input.next();
				String surname= input.next();
				String dnaSequence = input.next();
				
				DiseaseStatusHD status = getDiseaseStatus(dnaSequence);
				int numberOfRepeats = numberOfRepats(dnaSequence, "CAG");
				output.format("%s\t",name);
				output.format("%s\t",surname);
				output.format("%-19s\t\t",Integer.toString(numberOfRepeats));
				output.format("%s\t\n",status);
			}

			/*\t\t\t\t\t*/
			
			
			
			} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
				e.printStackTrace();
			}
		} catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
		}
	}
	public static DiseaseStatusHD getDiseaseStatus(String sequence){
		int countOfCags = 0;
		countOfCags=numberOfRepats(sequence, "CAG");

		if (countOfCags<26) return DiseaseStatusHD.WILL_NOT_DEVELOP_HD;
		else if (countOfCags>=27 && countOfCags<=35 ) return DiseaseStatusHD.OFFSPRING_AT_RISK;
		else if (countOfCags>=36 && countOfCags<=39 ) return DiseaseStatusHD.AT_HD_RISK;
		else if (countOfCags>40) return DiseaseStatusHD.WILL_DEVELOP_HD;
		else{
			return DiseaseStatusHD.WILL_NOT_DEVELOP_HD;
		}
	}
	public static int numberOfRepats(String sequence, String dnaRepeat){
		int numberOfRepeats = 0;	 
		Pattern expression = Pattern.compile(dnaRepeat);
		Matcher matcher = expression.matcher(sequence);
		while(matcher.find()){
			numberOfRepeats++;
		}
		return numberOfRepeats;
	}
	
}
