package Lambda.ex2student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex2 {

	public static void main(String[] args) {
		List<Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new Runner("Ib", 30),
				new Runner("Per", 50),
				new Runner("Ole", 27),
				new Runner("Ulla", 40),
				new Runner("Jens", 35),
				new Runner("Hans", 28)));
		System.out.println(runners);
		System.out.println();
		//opgaveA
		//Udskriv en linie for hver løber med name og lapTime ved at bruge List.forEach() metoden med en Consumer lambda
		runners.forEach(runner -> {
			System.out.println("Name: " + runner.getName() + " + " + "LapTime: " + runner.getLapTime());
		});

		System.out.println();
		//opgaveB
		//Som a), men udskriv kun løberne med lapTime < 30.
		runners.forEach(runner -> { if(runner.getLapTime() < 30)
			System.out.println("Name: " + runner.getName() + " + " + "LapTime: " + runner.getLapTime());
		});
		//opgaveC
		//Sorter løberne stigende efter lapTime ved at bruge List.sort() metoden med en Comparator lambda. Udskriv løberne.
		System.out.println();
		runners.sort((r1,r2)->r1.getLapTime()-r2.getLapTime());
		System.out.println("Sorted: " + runners);
	}
}