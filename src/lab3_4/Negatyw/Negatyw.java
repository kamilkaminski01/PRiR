package lab3_4.Negatyw;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Negatyw extends Thread {
	BufferedImage image;
	int xStart, xStop, yStart, yStop;

	public Negatyw(BufferedImage image, int xStart, int yStart, int xStop, int yStop) {
		this.xStart = xStart;
		this.yStart = yStart;
		this.xStop = xStop;
		this.yStop = yStop;
		this.image = image;
	}

	@Override
	public void run() {
		try {
			 //odczyt pixeli obrazu w dwoch petlach po kolumnach i wierszach
			for(int i=xStart; i<xStop; i++) {
				for(int j=yStart; j<yStop; j++) {
					//odczyt skladowych koloru RGB
					Color c = new Color(image.getRGB(j, i));
					int red = (c.getRed());
					int green = (c.getGreen());
					int blue = (c.getBlue());

					//negatyw
					int final_red = 255-red;
					int final_green = 255-green;
					int final_blue = 255-blue;
					Color newColor = new Color(final_red, final_green, final_blue);
					image.setRGB(j,i,newColor.getRGB());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
