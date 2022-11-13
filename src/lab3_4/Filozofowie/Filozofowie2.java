package lab3_4.Filozofowie;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filozofowie2 extends Thread{
	static int MAX;
	static Semaphore[] fork;
	int num;
	Random r;

	public Filozofowie2(int num) {
		this.num = num;
		r = new Random(this.num);
	}

	@Override
	public void run() {
		while (true) {
			// myslenie
			System.out.println("Mysli: " + num);
			try {
				Thread.sleep((long)(5000*Math.random()));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			int side = r.nextInt(2);
			boolean raisedTwoForks = false;

			do {
				if(side == 0) {
					fork[num].acquireUninterruptibly();
					if(!(fork[(num+1)%MAX].tryAcquire())) {
						fork[num].release();
					} else {
						raisedTwoForks = true;
					}
				} else {
					fork[(num+1)%MAX].acquireUninterruptibly();
					if(!(fork[num].tryAcquire())) {
						fork[(num+1)%MAX].release();
					} else {
						raisedTwoForks = true;
					}
				}
			} while (!raisedTwoForks);

			//jedzenie
			System.out.println("Zaczyna jesc: "+ num);
			try {
				Thread.sleep((long)(3000*Math.random()));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Konczy jesc: "+ num);
			fork[num].release();
			fork[(num+1)%MAX].release();
		}
	}

	public static void process(int max) {
		MAX = max;
		fork = new Semaphore[MAX];

		for (int i=0; i<MAX; i++)
			fork[i] = new Semaphore(1);

		for (int i=0; i<MAX; i++)
			new Filozofowie2(i).start();
	}
}
