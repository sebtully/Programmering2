package opgave3Teater;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
					  { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
					  { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
					  { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
					  { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
					  { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			 		  { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
				      { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
					  { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */

	public int buySeat(int row, int seat) {
		// TODO
		int seatBought = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				if (seats[i][j] == 0) {
					seatBought = seats[i][j];
					seats[i][j] = 0;
				}
			}
		}
		return seatBought;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */
	public int buySeat(int price) {
		// TODO
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				if (seats[i][j] == price) {
					seats[i][j] = 0;

				}
			}

		}
		return price;

	}

	public void printTheaterFloor() {
		// TODO
	}

	public void reserveSeat(int seat, int row) {


	}
}
