package Lambda.ex1student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {
		List<Person> list = List.of(
				new Person("Bent", 25), new Person("Susan", 34),
				new Person("Mikael", 60), new Person("Klaus", 44),
				new Person("Birgitte", 17), new Person("Liselotte", 9));
		List<Person> persons = new ArrayList<Person>(list);
		System.out.println(persons);
		System.out.println();



//		Den første person der hedder Klaus
//		System.out.println(findFirst(persons, p -> p.getName().equals("Klaus")));

//		Den første person der har et navn med længden 4
//		System.out.println(findFirst(persons, p -> p.getName().length() ==4 ));

//		Indsæt kode herunder der kalder metoderne findFirst og findAll som beskrevet i opgave 1
		//opgaveA
		//finder den første person i listen af personer med alderen 44.
		System.out.println(findFirst(persons, p -> p.getAge() == 44));
		//opgaveB
		//finder den første person i listen af personer med et navn der starter med 'S'.
		System.out.println(findFirst(persons, p -> p.getName().contains("s")));
		//opgaveC
		//Finder den første person i listen af personer med et navn der indeholder mere end et ’i’.
		System.out.println(findFirst(persons, p -> p.getName().chars().filter(ch -> ch =='i').count() > 1));
		//opgaveD
		//finder den første person i listen af personer med en alder der er lig længden af navnet.
		System.out.println(findFirst(persons, p -> p.getAge() == p.getName().length()));
		//opgaveE
		//programmer en findAll()methode.
		List<Person> list1 = findAll(persons, p -> p.getAge() < 30);
		//opgaveF
		//Find alle personer der har et navn der indeholder bogstavet 'i'.
		System.out.println(findAll(persons, p -> p.getName().contains("i")));
		//opgaveG
		//Find alle personer der har et navn der starter med 'S'.
		System.out.println(findAll(persons, p -> p.getName().startsWith("S")));
		//opgaveH
		//Find alle personer der har et navn der med længde 5.
		System.out.println(findAll(persons, p -> p.getName().length() == 5));
		//opgaveI
		//Find alle personer der har et navn der med længde mindst 6 og alder under 40.
		System.out.println(findAll(persons, p -> p.getName().length() >= 6 && p.getAge() < 40));
	}

	/**
	 * Returns from the list the first person
	 * that satisfies the predicate.
	 * Returns null, if no person satisfies the predicate.
	 */
	public static Person findFirst(List<Person> list, Predicate<Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}

	//findAll()methode.
	public static List<Person> findAll(List<Person> list, Predicate<Person> filter) {
		List<Person> result = new ArrayList<>();
		for (Person p : list) {
			if (filter.test(p))
				result.add(p);
		}
		return result;
	}

}
