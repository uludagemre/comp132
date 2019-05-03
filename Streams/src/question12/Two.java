package question12;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Two {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Emre",24),new Person("Tevfik",23),
				new Person("Ali",21),new Person("Aylin",21),
				new Person("Ahmet",19),new Person("Yaren",27),
				new Person("Serra",10),new Person("Semih",20),
				new Person("Tunç",15),new Person("Efe",12)
				);

		List<Person> people = persons.stream().filter(person -> person.getName().startsWith("A")).collect(Collectors.toList());
		System.out.println(people);
		
		Map <Integer,List<Person>> peopleWithAge = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));
		System.out.println(peopleWithAge);
		
		peopleWithAge.forEach((age , p)-> System.out.format("Age %s : %s  ",age,p));
		System.out.println();
		System.out.printf("Average of all peoples' ages is %.2f%n",persons.stream().mapToDouble(p -> p.getAge()).average().getAsDouble());
		
		IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.getAge()));
		System.out.println(ageSummary);
		
		String namePhrase = people.stream().filter(p -> p.getAge() >= 18).map(p -> p.getName()).collect(Collectors.joining(" and ","Students "," are in COMP132"));
		System.out.println(namePhrase);
		
		Map<Integer, List<Person>> groupByExample = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println(groupByExample);
	}
	
	
}
