import java.util.Scanner;

public class t1b4 {
    private double a;
    private double b;
    private double c;

    public t1b4() {
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
        if(a*a+b*b==c*c || b*b+c*c==a*a || c*c+a*a==b*b)
            System.out.println("Ba số đúng là 3 cạnh của 1 tam giác vuông");
        else
            System.out.println("Ba số không phải là 3 cạnh của 1 tam giác vuông");
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

        t1b4 b4 = new t1b4();
        b4.setA(a);
        b4.setB(b);
        b4.setC(c);
        b4.check(a,b,c);
    }
}
