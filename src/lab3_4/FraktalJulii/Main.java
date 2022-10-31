package lab3_4.FraktalJulii;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		for(int i=0; i<4; i++) {
			FraktalJulii j = new FraktalJulii(i);
			j.start();
			j.join();
		}
		long end = System.currentTimeMillis();
		System.out.println("Obliczenia zakończone w " +(end-start)+ " millisekund");

		//wstawianie pixeli
		BufferedImage img = new BufferedImage(FraktalJulii.N, FraktalJulii.N, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < FraktalJulii.N; i++) {
			for (int j = 0; j < FraktalJulii.N; j++) {
				int k = FraktalJulii.set[i][j];
				float level;

				if (k < FraktalJulii.CUTOFF)
					//pixel o wspolrzednych i,j należy do zbioru Julii
					level = (float) k / FraktalJulii.CUTOFF;
				else
					//pixel o wspolrzednych i,j nie należy do zbioru Julii
					level = 0;
				Color c = new Color(0, level, 0);
				img.setRGB(i, j, c.getRGB());
			}
		}
		ImageIO.write(img, "PNG", new File("outputs/julia.png"));
	}
}
