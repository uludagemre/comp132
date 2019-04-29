package Q4;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Arrays;

public class MoviesParser {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //Scanning from console
		
		System.out.println("Enter the characters you wish the movie name to contain and press Enter.");
		String inputLettersString = scanner.next();
		char[] inputLettersCharArray = inputLettersString.toCharArray();
		ArrayList<String> moviesWithCharacters = new ArrayList<>();
		
		System.out.println("Enter the lower year limit and press Enter to see movies released after that year in the file.");
		int inputYear = scanner.nextInt();
		ArrayList<String> moviesReleasedLater = new ArrayList<>();
		
		System.out.println("Enter the actor name and press Enter to see all actors with the same name in the file.");
		String actorToFind = scanner.next();
		ArrayList<String> sameNameActors = new ArrayList<>();
		
		//using Scanner to open the file
		try (Scanner input = new Scanner(Paths.get("C:\\Users\\Sukeyna\\eclipse-workspace\\SS4_sol\\src\\movies.txt"))){
			while (input.hasNext()) {
				String movieEntry = input.nextLine();
				ArrayList<String> actors = new ArrayList<>( Arrays.asList(movieEntry.split("/")));
				ArrayList<String> movieNameYear = new ArrayList<>( Arrays.asList(actors.get(0).split("\\(")));
				actors.remove(0);
				
				String movieName = movieNameYear.get(0);
				int letterCount = 0;
				for (char letter:inputLettersCharArray)
				{
					if (movieName.toLowerCase().indexOf(Character.toLowerCase(letter))>=0){letterCount++;}
				}
				if (letterCount == inputLettersCharArray.length) {
				moviesWithCharacters.add("Name:"+movieName);}
				
				Pattern yearFormat = Pattern.compile("\\d{4}");
				Matcher matcherYear = yearFormat.matcher(movieNameYear.get(1));
				if (matcherYear.find()) {
					String year = matcherYear.group();
					if (Integer.parseInt(year)>=inputYear) {
						moviesReleasedLater.add("Name:"+movieName+"Year:"+year);
					}
				}
				ArrayList<String> actorNames = new ArrayList<String>();
				ArrayList<String> actorSurnames = new ArrayList<String>();
				for (String actor:actors) {
					if (1<actor.split(",").length && 0<actor.split(",").length){
					actorNames.add(actor.split(",")[1]);
					actorSurnames.add(actor.split(",")[0]);
					if (actor.split(",")[1].trim().toLowerCase().equals(actorToFind.toLowerCase())) {
						sameNameActors.add("Name:"+actorToFind+" Surname:"+actor.split(",")[0]);}
					}
				}
			}
		}
		catch (IOException|NoSuchElementException|IllegalStateException e) {
			e.printStackTrace();
		}
		
		System.out.println("Movies containing "+inputLettersString+" characters in their name:");
		System.out.println(moviesWithCharacters.toString());
		System.out.println("Movies released in and after the "+inputYear+" year:");
		System.out.println(moviesReleasedLater.toString());
		System.out.println("Actors with "+actorToFind+" name:");
		System.out.println(sameNameActors.toString());
	}

}
