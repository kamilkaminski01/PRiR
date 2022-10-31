package lab3_4.MonteCarlo;

import java.util.Random;

public class MonteCarlo extends Thread {
    static int iterations;
    static double radius;
    double x_start, y_start, x_end, y_end;
    double result = 0;
    int in = 0;
    Random r;

    public MonteCarlo(int iterations, double x_start, double y_start, double x_end, double y_end) {
        MonteCarlo.iterations = iterations;
        this.x_start = x_start;
        this.y_start = y_start;
        this.x_end = x_end;
        this.y_end = y_end;
        r = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations/4; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();

            if(Math.sqrt((Math.pow(x,2) + Math.pow(y,2))) <= 1)
            	in++;
        }

        System.out.println("In: "+in+" All: "+(iterations/4));
        result = in;
    }
}
