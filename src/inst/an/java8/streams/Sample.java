package inst.an.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {
	public static List<Person> createPeople() {
		return Arrays.asList(
				new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32),
				new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72),
				new Person("Jill", Gender.FEMALE, 12)
				);
	}
	
	public static void main(String[] args) {
		//get, in uppercase, the names of all female older than 18
		List<Person> people = createPeople();
		List<String> names = new ArrayList<String>();
		for(Person person : people) {
			if (person.getAge() > 18) {
				names.add(person.getName().toUpperCase());
			}
		}
		System.out.println(names);
		
		List<String> names2 = 
				people.stream()
					.filter(person -> person.getAge() > 18)
					.map(Person::getName)   //same as 	.map(person -> person.getName())
					.map(String::toUpperCase)
					.collect(Collectors.toList());
		System.out.println(names2);
		
		//to print all the males to the console
		people.stream()
			  .filter(person -> person.getGender() == Gender.MALE)
			  .forEach(System.out::println);
		
		//to print all the males to the console with names capitalized.
		
		people.stream()
		  .filter(person -> person.getGender() == Gender.MALE)
		  .map(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()))
		  .forEach(System.out::println);
		
		//print the sum of the ages of all the males
		System.out.println(
			people.stream()
				  .map(Person::getAge)
				  .reduce(0, (carry, age) -> carry + age));
		//or this way
		System.out.println(
				people.stream()
					  .map(Person::getAge)
					  .reduce(0, Integer::sum));
		//or this way
		System.out.println(
				people.stream()
					  .mapToInt(Person::getAge)	//is the same as mapToInt	not a good approach
					  .sum());
		//or this way
		System.out.println(
				people.stream()
					  .max((person1, person2) -> person1.getAge() > person2.getAge() ? 1 : -1));	//similarly min(); both use comparator
		//count all the non adults
		System.out.println(
				people.stream()
					  .filter(person -> person.getAge() > 18)
					  .count());
		Map<String, Person> map = 
				people.stream()
					  . collect(Collectors.toMap(
							  person -> person.getName() + ":"+person.getAge(),
							  person -> person));
		System.out.println(map);
		
		Map<String, List<Person>> map1 = 
				people.stream()
					  .collect(Collectors.groupingBy(Person::getName));
		map1.forEach((k, v) -> 
				System.out.println(k + " -- "+v));
		
		//find first person whose name is four letters but is older than 25
		System.out.println(
				people.stream()
					  .filter(person -> person.getName().length() == 4)
					  .filter(person -> person.getAge() > 25)
					  .findFirst());
		//same as .. 
		//intermediate Vs terminal operations --> lazy evaluation happens
		System.out.println(
				people.stream()
					  .filter(Sample::is4Letters)
					  .filter(person -> person.getAge() > 25)
					  .findFirst());
		
		//Infinite streams
		Stream.iterate(1, e -> e +1)
			  .filter(e -> e % 2 == 0)
			  .limit(10)
			  .forEach(System.out::println);
	}
	public static boolean is4Letters(Person p) {
		System.out.println("Called for "+p);
		return p.getName().length() == 4;
	}
}
