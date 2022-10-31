package lab3_4.Samochod;

import java.util.Random;

public class Main {
	static final int car_numbers = 3;

	public static void main(String[] args) {
		String registration = "";
		Random r = new Random();

		for(int i = 0; i < car_numbers; i++) {
			registration = "BIA000"+(i+1);
			Samochod s = new Samochod(registration,r.nextInt(30)+10);
			s.start();
		}
	}
}