package lab3_4.Negatyw;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) throws Exception {
		File input = new File("samples/flower.png");
		BufferedImage image = ImageIO.read(input);
		int width = image.getWidth();
		int height = image.getHeight();
		int halfWidth = width / 2;
		int halfHeight = height / 2;

		long start = System.currentTimeMillis();

		Negatyw n1 = new Negatyw(image, 0, 0, halfWidth, halfHeight);
		Negatyw n2 = new Negatyw(image, halfWidth, 0, width, halfHeight);
		Negatyw n3 = new Negatyw(image, 0, halfHeight, halfWidth, height);
		Negatyw n4 = new Negatyw(image, halfWidth, halfHeight, width, height);

		n1.start();
		n2.start();
		n3.start();
		n4.start();

		try{
			n1.join();
			n2.join();
			n3.join();
			n4.join();
		} catch (Exception e){
			e.printStackTrace();
		}
		ImageIO.write(image, "png", new File("outputs/flower_new.png"));
		long end = System.currentTimeMillis();
		System.out.println("Obliczenia zakonczone w " +(end-start)+ " millisekund");
	}
}
