package lab3_4.Negatyw;

public class Main {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 4; i++) {
			GrayScale g = new GrayScale(i);
			g.start();
			g.join();
		}
		long end = System.currentTimeMillis();
		System.out.println("Obliczenia zakonczone w " +(end-start)+ " millisekund");
	}
}
