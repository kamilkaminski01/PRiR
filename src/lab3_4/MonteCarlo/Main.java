package lab3_4.MonteCarlo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj promien kola: ");
        double radius = scanner.nextInt();

        System.out.print("Podaj liczbe prob: ");
        int iterations = scanner.nextInt();

        MonteCarlo m1 = new MonteCarlo(iterations, radius, radius, 0, 0);
        MonteCarlo m2 = new MonteCarlo(iterations, radius, radius, radius, 0);
        MonteCarlo m3 = new MonteCarlo(iterations, radius,radius, 0, radius);
        MonteCarlo m4 = new MonteCarlo(iterations, radius, radius, radius, radius);

        m1.start();
        m2.start();
        m3.start();
        m4.start();

        try {
            m1.join();
            m2.join();
            m3.join();
            m4.join();
        } catch (Exception e) {
        	e.printStackTrace();
        }

        double surface = (m1.result + m2.result + m3.result + m4.result) / iterations * Math.pow(2*radius, 2);
        System.out.println("Pole kola wynosi: "+surface);
//        double pi = (m1.result + m2.result + m3.result + m4.result) / iterations;
//        System.out.println("PI: "+pi);
	}
}
