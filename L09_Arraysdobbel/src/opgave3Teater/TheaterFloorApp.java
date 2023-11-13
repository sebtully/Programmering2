package opgave3Teater;

import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		Scanner scan = new Scanner(System.in);
		System.out.println("Vælg sæde: ");
		int seat = scan.nextInt();
		System.out.println("Vælg række: ");
		int row = scan.nextInt();
		theater.reserveSeat(seat, row);

		// TODO
	}
}
