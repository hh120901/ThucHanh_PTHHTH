package BTTuan3;

import java.io.IOException;
import java.util.Random;

public class baitap1 extends Thread{
    public String nameT;
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is running...");
        System.out.println("Tao ra day so: ");
        int a[] = new int[10];
        Random rand = new Random();
        for (int i =0; i<3;i++){
            a[i]= rand.nextInt(100)+1;
            System.out.println(a[i]);
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Day so cua " + Thread.currentThread().getName()+ " la " + a[0]+ " "+ a[1] +" "+a[2]);
    }
    public static void main(String[] args) throws IOException{
        baitap1 t1= new baitap1();
        baitap1 t2 = new baitap1();
        baitap1 t3 = new baitap1();
       
        t1.start();
        t2.start();
        t3.start();
    }
}
