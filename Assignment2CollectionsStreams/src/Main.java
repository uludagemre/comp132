import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
	public static void main(String[] args)  {
		Map<Movie,List<Actor>> movieActorPairs = new HashMap<Movie,List<Actor>>();
		try(Scanner scan = new Scanner(Paths.get("movies_sample.txt"))){

			//I separated parts as functions. Only first method (readFile) reads the file and puts the data inside of the map. The others process the movieActorPairs map
			//I could use a list for movies and each Movie object has a field called cast including all actors that played in that movie but 
			//for the sake of this class and using collections I will use a map and hold the cast in the value slot of this map.  

			readFile(scan, movieActorPairs);
//			askForFirstQuestion(movieActorPairs);
			askForSecondQuestion(movieActorPairs);			
			askforThirdQuestion(movieActorPairs);
			askForFourthQuestion(movieActorPairs);
			answerFifthQuestion(movieActorPairs);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("You entered few arguments and program crashed");
		} catch (IOException e) {
			System.out.println("File cannot be read properly!");
		}
	}

	//	This was a the second solution for printing a map but i did not use it!
	//	public static void printMap(Map<Movie,List<Actor>> movieActorPairs ) {
	//		Iterator<?> it = movieActorPairs.entrySet().iterator();
	//		while(it.hasNext()) {
	//			Map.Entry<?,?> pair = (Map.Entry<?,?>)it.next();
	//			System.out.printf("%s %s\n",pair.getKey(),pair.getValue());
	//		}
	//	}

	public static void printInOrderWithLetter(Map<Movie,List<Actor>> movieActorPairs,String order,String character) {

		//		If the user enters ascending below code will work, it uses filtering with streams 
		if (order.equals("ascending")) {
			movieActorPairs.keySet().stream().filter(m -> m.getName().startsWith(character)).sorted( Comparator.comparing(Movie::getName)).forEach((m) -> System.out.printf("%s %n",m.getName()));			
			//		If the user enters descending below code will work it uses filtering with streams
		}else if(order.equals("descending")) {
			movieActorPairs.keySet().stream().filter(m -> m.getName().startsWith(character)).sorted( Comparator.comparing(Movie::getName).reversed()).forEach((m) -> System.out.printf("%s %n",m.getName()));
		}
	}

	public static void askForFirstQuestion(Map <Movie, List<Actor>> movieActorPairs){
		System.out.println("Enter the name and surname of the actor separated by comma (without a space):");
		// 		I get input from the user 
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		String[] actors = input.split(",");
		
		//		Correct input check		
		if(actors[0].endsWith(" ") || actors[1].startsWith(" ")) {
			System.out.println("Wrong input entered!");
			return;
		}
		
		String[] firstActorNameSurname = actors[0].split(" ");
		String[] secondActorNameSurname = actors[1].split(" ");		
		
		
		Actor actor1 = new Actor(firstActorNameSurname[0],firstActorNameSurname[1]);
		Actor actor2 = new Actor(secondActorNameSurname[0],secondActorNameSurname[1]);
		
		//		Correct input check		
		if(Character.isLowerCase(actor1.getName().toCharArray()[0])) {
			System.out.println("Wrong input entered!");
			return;
		}
		if(Character.isLowerCase(actor1.getSurName().toCharArray()[0])) {
			System.out.println("Wrong input entered!");
			return;
		}
		if(Character.isLowerCase(actor2.getName().toCharArray()[0])) {
			System.out.println("Wrong input entered!");
			return;
		}
		if(Character.isLowerCase(actor2.getSurName().toCharArray()[0])) {
			System.out.println("Wrong input entered!");
			return;
		}
		
		//		I iterate the first actor name and search for a match and created a list for actor 
		Iterator<Movie> it = movieActorPairs.keySet().iterator();
		ArrayList<Movie> actor1MovieList = new ArrayList<Movie>();
		while(it.hasNext()){
			Movie currentMovie = (Movie) it.next();
			if(movieActorPairs.get(currentMovie).contains(actor1)){
				actor1MovieList.add(currentMovie);
			};
		}
		//		I iterate the second actor name and search for a match and created a list for actor
		it = movieActorPairs.keySet().iterator();
		ArrayList<Movie> actor2MovieList = new ArrayList<Movie>();
		while(it.hasNext()){
			Movie currentMovie = (Movie) it.next();
			if(movieActorPairs.get(currentMovie).contains(actor2)){
				actor2MovieList.add(currentMovie);
			};
		}
		//		I check if they have a common movie in their lists
		boolean disjoint = Collections.disjoint(actor1MovieList, actor2MovieList);
		if(!disjoint){
			List<Movie>commonList = actor1MovieList.stream().filter(a -> actor2MovieList.contains(a)).collect(Collectors.toList());
			if(commonList.size()>1){
				System.out.println("They co-starred in more than one film : " );
				commonList.stream().forEach(System.out::println);
			}else{
				System.out.println("They co-starred in one film : " );
				commonList.stream().forEach(System.out::println);
			}
		}else{
			System.out.println("They do not have movies in common!");			
		}


	}

	public static void askForSecondQuestion(Map <Movie, List<Actor>> movieActorPairs){

		// My code will read the input from the user and gives the inputed text to the print function accordingly 
		System.out.println("Enter a letter to see the movies that starts with it in ascending or descending order Ex: E ascending ,K descending :");
		Scanner scanOrder = new Scanner(System.in);
		String character = scanOrder.next();
		String order = scanOrder.next();
		char c = character.toCharArray()[0];
		//		Correct input check
		if(!(Character.isUpperCase(c) && (order.equals("ascending") || order.equals("descending")))) {
			System.out.println("Wrong input entered!");
			return;
		}
		
		printInOrderWithLetter(movieActorPairs, order,character);
	}

	public static void askforThirdQuestion(Map <Movie, List<Actor>> movieActorPairs){
		System.out.println("Search movies by first name, please enter the actor's first name:");
		Scanner scanName = new Scanner(System.in);
		String name = scanName.next();
//		Correct input check		
		if(Character.isLowerCase(name.toCharArray()[0])) {
			System.out.println("Wrong input entered!");
			return;
		}

		//		I read the input from the user and search the movieActorPairs map then I put the findings in another map which includes actor names as strings as a key 
		Map <String,List<Movie>> actorMovieMap = new HashMap<String, List<Movie>>();

		System.out.println("Movies played by actors with first name \""+name+"\".");
		System.out.println("Actor's name/Surname				Movie(s) Title(s)");
		System.out.println("--------------------				-----------------");
		Iterator<Movie> it = movieActorPairs.keySet().iterator();
		while(it.hasNext()) {
			Movie movie = (Movie) it.next();
			List<Actor> tempList = movieActorPairs.get(movie);
			tempList.stream().forEach( actor -> {
				if(name.equals(actor.getName())) {
					List<Movie> tempMovieList = null;
					String fullName = actor.getName()+" "+actor.getSurName();
					if(actorMovieMap.get(fullName) == null) {
						tempMovieList = new ArrayList<Movie>();
					}else {
						tempMovieList = actorMovieMap.get(fullName);
					}
					//		Below is a movie list to be added as a value entry to the actor->MovieList map  
					tempMovieList.add(movie);
					actorMovieMap.put(fullName, tempMovieList);
				}
			});
		}
		//		I am printing the actors and movies that they played in 
		actorMovieMap.keySet().stream().forEach(a -> {
			System.out.printf("%-50s",a);
			actorMovieMap.get(a).stream().forEach(m -> {
				System.out.printf("%s (%d) ",m,m.getReleaseYear());
			});
			System.out.println();
		});
	}

	public static void askForFourthQuestion(Map <Movie, List<Actor>> movieActorPairs){


		//		After retrieving the input from the user I process it with a split method and user year values in the predicate.
		System.out.println("Search movies by release date. Please enter the start year and end year of the period you want to search for separated by a space:");
		Scanner scanYears = new Scanner(System.in);
		String years = scanYears.nextLine();
//		Correct input check		
		if(!years.contains(" ")) {
			System.out.println("Wrong input entered!");
			return;
		}

		String[] movieYears = years.split(" ");
		
		int year1 = Integer.parseInt(movieYears[0]);
		int year2 = Integer.parseInt(movieYears[1]);
		Predicate<Movie> yearInterval = m -> (m.getReleaseYear() >= year1 && m.getReleaseYear() <= year2);
		System.out.println("Movies released between "+year1+" - "+year2);
		//		Then using the stream functionality of Java I print the movies between those years.  
		movieActorPairs.keySet().stream().filter(yearInterval).sorted(Comparator.comparing(Movie::getReleaseYear)).forEach((m) -> System.out.printf("%-60s %10d %n",m.getName(),m.getReleaseYear()));


	}

	public static void answerFifthQuestion(Map <Movie, List<Actor>> movieActorPairs){

		//		I am again using a actor->Movie map to find the movies that actors played.  
		Map <String,List<Movie>> actorMovieMap = new HashMap<String, List<Movie>>();
		Iterator<Movie> it = movieActorPairs.keySet().iterator();
		while(it.hasNext()) {
			Movie movie = (Movie) it.next();
			List<Actor> tempList = movieActorPairs.get(movie);
			tempList.stream().forEach( a -> {
				List<Movie> tempMovieList = null;
				String fullName = a.getName()+" "+a.getSurName();
				//		If the actor is encountered for the first time I create a new array list and add it to the map 
				if(actorMovieMap.get(fullName) == null) {
					tempMovieList = new ArrayList<Movie>();
					//		If the actor existed in the map I retrive the movie list of that actor, modify it and put it back
				}else {
					tempMovieList = actorMovieMap.get(fullName);
				}
				tempMovieList.add(movie);
				actorMovieMap.put(fullName, tempMovieList);
			}
					);
		}

		//		Then I created another map and used it for retrieving the info that in how many movies each actor played
		Map <String,Integer> actorMovieCount = new HashMap<String, Integer>();
		actorMovieMap.keySet().stream().forEach( key-> {
			int count = actorMovieMap.get(key).size();
			actorMovieCount.put(key,count);	
		});

		Iterator<?> itCount = actorMovieCount.entrySet().iterator();
		int max = 0;
		int count = 0;
		String actor = null;
		while(itCount.hasNext()) {
			Map.Entry<?, ?> entry =  (Entry<?, ?>) itCount.next();
			count = (int) entry.getValue();
			if (count > max) {
				max = count;
				actor = (String) entry.getKey();
			}
		}
		//		Print the actor with number of movies 
		System.out.println("The actor with the maximum number of movies played is "+actor+ " who has played in "+max+" movies.");

		//		To find the most active year I used stream functionality and groupingBy method which allowed me to classify each year with number of performances in that year.
		//		I stored them in a map. 
		List<Movie> listMovieMostActor = actorMovieMap.get(actor);
		Map<Integer, Long>mymap = listMovieMostActor.stream().collect(Collectors.groupingBy(Movie::getReleaseYear,Collectors.counting()));
		long mostFilmsInAYear = mymap.values().stream().max(Long::compare).get();
		//		Above I find the max number of films played in a year 

		//		After that I retrieve the most productive years info from just above created list and printed them below using streams again.
		List<Integer> productiveYearsList = mymap.entrySet().stream().filter( e-> e.getValue() == mostFilmsInAYear ).map( e-> e.getKey()).collect(Collectors.toList());
		productiveYearsList.stream().forEach( e -> System.out.printf("%d ",e));
		System.out.printf("were his/her most productive year(s in each) with %d movies .",mostFilmsInAYear);

	}

	public static void readFile(Scanner scan,Map <Movie, List<Actor>> movieActorPairs){

		List<Actor> actorList = null;
		Movie movie = null;			
		String line ;

		//While loop takes a Scanner object and this object reads the text file, divides the text file into necessary pieces.

		while(scan.hasNext()) {
			line = scan.nextLine();
			actorList = new ArrayList<Actor>();
			String[] words = line.split("/");
			int count = 0; 
			int yearIndex;
			String movieName ;
			int releaseYear;
			for (String element : words) {
				if(count == 0) { //Since the first word of a line is the name of the movie I must hold a counter 
					yearIndex=element.indexOf("(")+1; //I split the year with index of the string 
					movieName = element.substring(0, yearIndex-2);
					String year = element.substring(yearIndex, yearIndex+4);
					releaseYear = Integer.parseInt(year); 
					movie = new Movie(movieName,releaseYear,null); //initialize the movie object with above fields but the cast will be set afterwards
				}
				else {					
					String[] names = element.split(", ");  //I split the actor names
					String firstName ;
					String secondName ;
					//The condition when the name of an actor consists of firstname and surname
					if(names.length == 2) {
						firstName = names[1];
						secondName = names[0];	
						actorList.add(new Actor(firstName,secondName));
						//The condition when the name of an actor consists of only firstname or nickname
					}else {
						firstName= names[0];
						actorList.add(new Actor(firstName,null));
					}
				}	
				count++;
			}
			//Then I set the cast of movie object that I initialized as null by a method 
			movie.setCast(actorList);
			movieActorPairs.put(movie, movie.getCast());
			actorList = null;
			movie = null;
		}
	}
}
