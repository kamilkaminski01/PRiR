package lab1;

public class Calkowanie {
    public static void main(String[] args) {
        int n;
        double a, b, h, x0, x1, calka = 0;
        n = 1000;
        a = 1.0;
        b = 4.0;
        h = (b-a)/n;
        calka = 0;
        M_Prostokatow[] pr = new M_Prostokatow[n];
        for (int i = 0; i < n; i++) {
            pr[i] = new M_Prostokatow(a + i * h,h);
            pr[i].start();
            try{
                pr[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            calka += pr[i].getResult();
        }
        System.out.printf("Wartosc przyblizona calki oznaczonej dla n=" + n + " - Metoda prostokatow: " + calka);
    }
}
