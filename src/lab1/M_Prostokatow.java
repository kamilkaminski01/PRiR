package lab1;//package cW;

public class M_Prostokatow extends Thread{
    private double a;
    private double h;
    private double result;

    public M_Prostokatow(double a, double h){
        this.a = a;
        this.h = h;
    }
    public static double fp(double x, double h1){
//        return(Math.cos(Math.pow(x,3)+0.7)) / (1.1+Math.cos(0.3*x*0.1));
        return (x*x*h1);
    }
//    public void run(){
//        result = fp(h);
//    }
    public double getResult(){
        return result;
    }
}