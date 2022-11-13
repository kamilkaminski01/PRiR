package lab3_4.Samochod;

import java.util.Random;

public class Samochod extends Thread {
	private String registration;
	private int fuel;

	public Samochod (String registration, int fuel) {
		this.registration = registration;
		this.fuel = fuel;
	}

	public void refueling(int fuel) {
		System.out.println("Samochod "+ registration +" zatankowal "+fuel+"l paliwa");
		this.fuel += fuel;
		run();
	}

	@Override
	public void run() {
		Random r = new Random();

		while(true) {
			System.out.println("Ilosc paliwa "+ registration +": "+ fuel +"l");

			if(fuel < 3 && fuel > 0) {
				System.out.println("Samochod "+ registration +" musi zatankowac");
				refueling(r.nextInt(10)+2);
				break;
			}
			fuel--;
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
