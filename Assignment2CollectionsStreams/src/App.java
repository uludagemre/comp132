import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;


public class App {
	public static void main(String[] args)  {
		Map<Movie,List<Actor>> movieActorPairs = new HashMap<Movie,List<Actor>>();
		try(Scanner scan = new Scanner(Paths.get("movies_sample.txt"))){
			List<Actor> list = null;
			Movie movie = null;			
			readFile(scan, list, movie, movieActorPairs);
			
			askForFirstQuestion(movieActorPairs);
			askForSecondQuestion(movieActorPairs);
			
			askForFourthQuestion(movieActorPairs);
			
			
			
//			Iterator it = movieActorPairs.keySet().iterator();
//			Movie tempMovie;
//			while(it.hasNext()) {
//					tempMovie = (Movie) it.next();
//					System.out.println(tempMovie);
//					System.out.println("Kevin Bacon is in one of the movies: "+movieActorPairs.get(tempMovie).contains(actor1));
//			}
			

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Array Index Exceeded");
		} catch (IOException e) {
			System.out.println("File cannot be read!");
		}
	}

	public static void printMap(Map<Movie,List<Actor>> movieActorPairs ) {
		Iterator<?> it = movieActorPairs.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<?,?> pair = (Map.Entry<?,?>)it.next();
			System.out.printf("%s %s\n",pair.getKey(),pair.getValue());
		}
	}

	public static void alternatePrint(Map<Movie,List<Actor>> movieActorPairs,String order) {
		 
		if (order.equals("A")) {
			movieActorPairs.keySet().stream().sorted( Comparator.comparing(Movie::getName)).forEach((m) -> System.out.printf("%s %n",m.getName()));			
		}else if(order.equals("D")) {
			movieActorPairs.keySet().stream().sorted( Comparator.comparing(Movie::getName).reversed()).forEach((m) -> System.out.printf("%s %n",m.getName()));
		}
	}
	
	public static void askForFirstQuestion(Map <Movie, List<Actor>> movieActorPairs){
		System.out.println("Enter the name and surname of the actor separated by comma (without a space):");
	
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		String[] actors = input.split(",");
		
		String[] firstActorNames = actors[0].split(" ");
		String[] secondActorNames = actors[1].split(" ");		
				
		Actor actor1 = new Actor(firstActorNames[0],firstActorNames[1]);
		Actor actor2 = new Actor(secondActorNames[0],secondActorNames[1]);
		
		System.out.println(actor1);
		System.out.println(actor2);
	}
	
	public static void askForSecondQuestion(Map <Movie, List<Actor>> movieActorPairs){
		
		System.out.println("You must decide if you want sort Movies in Decending or Ascending order by specifying A or D: ");
		Scanner scanOrder = new Scanner(System.in);
		String order = scanOrder.next();	
		alternatePrint(movieActorPairs, order);
	}
	
	public static void askForFourthQuestion(Map <Movie, List<Actor>> movieActorPairs){
		
		System.out.println("Search movies by release date. Please enter the start year and end year of the period you want to search for separated by a space:");
		Scanner scanYears = new Scanner(System.in);
		String years = scanYears.nextLine();
		String[] movieYears = years.split(" ");
		int year1 = Integer.parseInt(movieYears[0]);
		int year2 = Integer.parseInt(movieYears[1]);
		Predicate<Movie> yearInterval = m -> (m.getReleaseYear() >= year1 && m.getReleaseYear() <= year2);
		System.out.println("Movies released between "+year1+" - "+year2);
		movieActorPairs.keySet().stream().filter(yearInterval).sorted(Comparator.comparing(Movie::getReleaseYear)).forEach((m) -> System.out.printf("%-40s %10d %n",m.getName(),m.getReleaseYear()));
		
		
	}
	
	
	public static void readFile(Scanner scan,List<Actor> list, Movie movie ,Map <Movie, List<Actor>> movieActorPairs){
		String line = scan.nextLine();
		while(scan.hasNext()) {
			list = new ArrayList<Actor>();
			String[] words = line.split("/");
			int count = 0;
			int yearIndex;
			String movieName ;
			int releaseYear;
			for (String element : words) {
				if(count == 0) {
					yearIndex=element.indexOf("(")+1;
					movieName = element.substring(0, yearIndex-2);
					String year = element.substring(yearIndex, yearIndex+4);
					releaseYear = Integer.parseInt(year);
					movie = new Movie(movieName,releaseYear,null);
				}
				else {					
					Actor actor;
					String[] names = element.split(", ");
					String firstName ;
					String secondName ;
					if(names.length == 2) {
						firstName = names[1];
						secondName = names[0];	
						list.add(new Actor(firstName,secondName));
					}else {
						firstName= names[0];
						list.add(new Actor(firstName,null));
					}
				}	
				count++;
			}
			movie.setCast(list);
			movieActorPairs.put(movie, movie.getCast());
			list = null;
			movie = null;
			line = scan.nextLine();
		}
	}
}
