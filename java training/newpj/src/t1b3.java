import java.util.Scanner;

public class t1b3 {
    private double a;
    private double b;
    private double c;

    public t1b3() {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void check(double a, double b, double c){
        if(a+b>c && b+c>a && c+a>b)
            System.out.println("Ba số đúng là 3 cạnh của 1 tam giác");
        else
            System.out.println("Ba số không phải là 3 cạnh của 1 tam giác");
    }

    public static void main(String[] args){
        System.out.println("Vui lòng nhập các cạnh: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("a= ");
        double a = sc.nextDouble();
        System.out.print("b= ");
        double b = sc.nextDouble();
        System.out.print("c= ");
        double c = sc.nextDouble();

        t1b3 b3 = new t1b3();
        b3.setA(a);
        b3.setB(b);
        b3.setC(c);
        b3.check(a,b,c);
    }
}
