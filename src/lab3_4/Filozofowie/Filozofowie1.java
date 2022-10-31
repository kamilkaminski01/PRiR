package lab3_4.Filozofowie;

import java.util.concurrent.Semaphore;

public class Filozofowie1 extends Thread {
	static int MAX = 100;
	static Semaphore[] fork = new Semaphore[MAX];
	int num;

	public Filozofowie1(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while(true) {
			// myslenie
			System.out.println("Mysli: " + num);
			try {
				Thread.sleep((long)(7000*Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			fork[num].acquireUninterruptibly(); //przechwycenie L widelca
			fork[(num+1)%MAX].acquireUninterruptibly(); //przechwycenie P widelca

			// jedzenie
			System.out.println("Zaczyna jesc: " + num);
			try {
				Thread.sleep((long)(5000*Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Konczy jesc: "+ num);
			fork[num].release(); //zwolnienie L widelca
			fork[(num+1)%MAX].release(); //zwolnienie P widelca
		}
	}

	public static void process(int max) {
		MAX = max;

		for (int i=0; i<MAX; i++)
			fork[i] = new Semaphore(1);

		for (int i=0; i<MAX; i++)
			new Filozofowie1(i).start();
	}
}