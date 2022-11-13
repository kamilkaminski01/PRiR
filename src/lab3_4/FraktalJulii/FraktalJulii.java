package lab3_4.FraktalJulii;

public class FraktalJulii extends Thread {
	final static int N = 4096;
	final static int CUTOFF = 100;
	static int[][] set = new int[N][N];
	int index;
	int begin = 0;
	int end = 0;

	//ustawienie numeracji wątków
	public FraktalJulii(int index) {
		this.index = index;
	}

	//procedura wykonywana przez każdy z 4 wątków sprawdzająca czy dany punkt należy do zbioru Julii
	@Override
	public void run() {
		switch (index) {
			case 0 -> {
				// begin = 0;
				end = (N / 4);
			}
			case 1 -> {
				begin = (N / 4);
				end = (N / 4) * 2;
			}
			case 2 -> {
				begin = (N / 4) * 2;
				end = (N / 4) * 3;
			}
			case 3 -> {
				begin = (N / 4) * 3;
				end = N;
			}
		}

		for (int i = begin; i < end; i++) {
			for (int j = 0; j < N; j++) {
				//przeskalowanie punktów do układu wspolrzednych kartezjanskich
				double cr = -0.25; //-0.2;
                double ci = 0.76; //0.65;
                double zr = i * (1.25 - -1.25) / N + -1.25;
                double zi = j * (1.25 - -1.25) / N + -1.25;
                int k = 0;

                // sprawdzenie
                while (k < CUTOFF && zr * zr + zi * zi < 4.0) {
                    double newr = cr + zr * zr - zi * zi;
                    double newi = ci + 2 * zr * zi;
                    zr = newr;
                    zi = newi;
                    k++;
                }
                set[i][j] = k;
			}
		}
	}
}
