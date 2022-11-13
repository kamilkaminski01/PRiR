package lab3_4.Filozofowie;

import java.util.concurrent.Semaphore;

public class Filozofowie3 extends Thread{
	static int MAX;
	static Semaphore[] fork;
	int num;

	public Filozofowie3(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while(true) {
			//myslenie
			System.out.println("Mysli: " + num);
			try {
				Thread.sleep((long)(5000*Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(num == 0) {
				fork[(num+1)%MAX].acquireUninterruptibly();
				fork[num].acquireUninterruptibly();
			} else {
				fork[num].acquireUninterruptibly();
				fork[(num+1)%MAX].acquireUninterruptibly();
			}

			//jedzenie
			System.out.println("Zaczyna jesc: " + num);
			try {
				Thread.sleep((long)(3000*Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Konczy jesc: " + num);
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
			new Filozofowie3(i).start();
	}
}