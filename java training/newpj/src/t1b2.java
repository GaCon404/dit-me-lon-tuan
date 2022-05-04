import java.util.Scanner;

public class t1b2 {
    private int number;

    public t1b2() {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void Doc_chu_so(int number){
        switch (number){
            case 0: System.out.println("Không"); break;
            case 1: System.out.println("Một"); break;
            case 2: System.out.println("Hai"); break;
            case 3: System.out.println("Ba"); break;
            case 4: System.out.println("Bốn"); break;
            case 5: System.out.println("Năm"); break;
            case 6: System.out.println("Sáu"); break;
            case 7: System.out.println("Bảy"); break;
            case 8: System.out.println("Tám"); break;
            case 9: System.out.println("Chín"); break;
            default:
                System.out.println("Nhập số từ 0 - 9");
                break;
        }
    }
    public static void main(String[] args){
        System.out.println("Vui lòng nhập số cần đọc");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        t1b2 b2 = new t1b2();
        b2.setNumber(number);
        b2.Doc_chu_so(number);
    }
}
