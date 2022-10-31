package lab3_4.MonteCarlo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj promien kola: ");
        MonteCarlo.radius = scanner.nextDouble();

        System.out.print("Podaj liczbe prob: ");
        int iterations = scanner.nextInt();

        MonteCarlo m1 = new MonteCarlo(iterations, MonteCarlo.radius, MonteCarlo.radius, 0, 0);
        m1.start();
        MonteCarlo m2 = new MonteCarlo(iterations, MonteCarlo.radius, MonteCarlo.radius, MonteCarlo.radius, 0);
        m2.start();
        MonteCarlo m3 = new MonteCarlo(iterations, MonteCarlo.radius, MonteCarlo.radius, 0, MonteCarlo.radius);
        m3.start();
        MonteCarlo m4 = new MonteCarlo(iterations, MonteCarlo.radius, MonteCarlo.radius, MonteCarlo.radius, MonteCarlo.radius);
        m4.start();

        try {
            m1.join();
            m2.join();
            m3.join();
            m4.join();
        } catch (Exception e) {
        	e.printStackTrace();
        }

        double surface = (m1.result + m2.result + m3.result + m4.result)/MonteCarlo.iterations*Math.pow(2*MonteCarlo.radius, 2);
        double pi = 4*(m1.result + m2.result + m3.result + m4.result)/MonteCarlo.iterations;
        System.out.println("PI: "+pi);
        System.out.println("Pole kola wynosi: "+surface);
	}
}
