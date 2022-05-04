import java.util.Scanner;

public class t1b1 {
    private int number;

    public t1b1() {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void check(int number){
        if(number>=0) System.out.println("Đây là số nguyên dương");
        else System.out.println("Đây là số nguyên âm");
    }
    public static void main(String[] args){
        System.out.println("Vui lòng nhập số cần kiểm tra");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        t1b1 b1 = new t1b1();
        b1.setNumber(number);

        b1.check(number);
    }
}

