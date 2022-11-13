package lab3_4.MonteCarlo;

public class MonteCarlo extends Thread {
    static int iterations;
    double xStart, yStart, xStop, yStop;
    double result = 0;
    int in = 0;

    public MonteCarlo(int iterations, double xStart, double yStart, double xStop, double yStop) {
        MonteCarlo.iterations = iterations;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xStop = xStop;
        this.yStop = yStop;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            double x = Math.random();
            double y = Math.random();

            if((x*x) + (y*y) <= 1)
            	in++;
        }

        System.out.println("In: "+in+" All: "+(iterations));
        result = in;
    }
}
