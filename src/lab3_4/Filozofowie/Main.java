package lab3_4.Filozofowie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj liczbe filozofow: ");
		int num = scanner.nextInt();
		System.out.print("Podaj nr metody 1,2,3: ");
		int method = scanner.nextInt();

        switch (method) {
            case 1 -> Filozofowie1.process(num);
            case 2 -> Filozofowie3.process(num);
            case 3 -> Filozofowie2.process(num);
            default -> {
                System.out.println("Zly parametr, wybierz 1,2 lub 3");
            }
        }
	}
}
