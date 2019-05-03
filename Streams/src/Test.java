import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import employee.Employee;

public class Test {
	public static void main(String[] args) {
		
		Person[] people= {new Person("emre","uludag"),new Person("ali","uludag"),new Person("mehmet","uludag"),new Person("aylin","uludag")};
		List<Person> list = Arrays.asList(people);

		Function<Person, String> byFirstName = Person::getName;
		Comparator<Person> nameThenFirst =
				Comparator.comparing(byFirstName).thenComparing(byFirstName);
				
		
		list.stream().sorted(nameThenFirst).forEach(System.out::println);
		
		
		
		
	}
}

class Person{
	private String name;
	private String surName;
	
	public Person(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}
	
	public String getName() {
		return this.name;
	}
	public String getSurName() {
		return this.surName;
	}
	public String toString() {
		return name+" "+surName;
	}
}
