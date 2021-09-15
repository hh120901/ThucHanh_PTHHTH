import java.util.Scanner;

public class bai4JBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n = ");
        int n = sc.nextInt();
        int sum=0;
        for (int i=0;i<=n;i++){
            sum+=i;
        }
        System.out.println("Tong cua day so tu 1->n la: "+ sum);
    }
}
