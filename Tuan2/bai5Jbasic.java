import java.util.Scanner;

public class bai5Jbasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu n = ");
        int n= sc.nextInt();
        float sum=0;
        float a[] = new float[n];
        for(int i=0;i<n;i++){
            System.out.println("Nhap Gia Tri Cua Phan Tu Thu "+ (i+1));
            a[i] = sc.nextFloat();
        }
        for(int i=0;i<n;i++){
            if(a[i]>0){
                sum=sum + a[i];
            }
        }
        System.out.println("Tong cua cac phan tu duong la: "+ sum);
    }
}
