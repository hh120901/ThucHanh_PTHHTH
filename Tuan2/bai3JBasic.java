import java.util.Scanner;

public class bai3JBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b,c, delta,x1,x2;
        do{
            System.out.println("Nhap vao a (#0): ");
            a = sc.nextDouble();
        }while(a==0);
        System.out.println("Nhap vao b: ");
            b = sc.nextDouble();
        System.out.println("Nhap vao c: ");
           c = sc.nextDouble();
        delta= Math.pow(b, 2)-4*a*c;
        if(delta<0){
            System.out.println("PT vo nghiem");
        }
        else if(delta==0){
            x1=x2=-b/(2*a);
            System.out.println("Phuong trinh co nghiem kep x1 = x2 = "+ x1);
        }
        else{
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co nghiem x1="+x1);
            System.out.println("PT co nghiem x2="+x2);
        }
    }
}
