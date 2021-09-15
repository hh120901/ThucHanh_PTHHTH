import java.io.IOException;
import java.util.Scanner;

public class bai2Basic {
    public static boolean soNguyenTo(int n) {
        if (n <= 1) {
            return false;
        }
        else if (n % 2 == 0) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n = ");
        int n =sc.nextInt();
        if(soNguyenTo(n)){
            System.out.println(n+" la so nguyen to!");
        } else {
            System.out.println(n+" khong phai la so nguyen!");
        }
    }
}
