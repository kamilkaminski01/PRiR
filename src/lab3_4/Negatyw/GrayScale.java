package lab3_4.Negatyw;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class GrayScale extends Thread {
	BufferedImage image;
	int width;
	int height;
	int index;

	public GrayScale(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		int begin = 0, end = 0;

        switch (index) {
            case 0 -> {
                // begin = 0;
                end = (width / 4);
            }
            case 1 -> {
                begin = (height / 4);
                end = (width / 4) * 2;
            }
            case 2 -> {
                begin = (height / 4) * 2;
                end = (width / 4) * 3;
            }
            case 3 -> {
                begin = (height / 4) * 3;
                end = width;
            }
        }

		try {
			//odczyt obrazu z pliku
			File input = new File("samples/flower.png");
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();

			 //odczyt pixeli obrazu w dwoch petlach po kolumnach i wierszach
			for(int i=1; i<height-1; i++) {
				for(int j=1; j<width-1; j++) {
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
			ImageIO.write(image, "png", new File("outputs/flower_new.png"));
			System.out.println("Watek "+index+" ukonczyl prace.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
