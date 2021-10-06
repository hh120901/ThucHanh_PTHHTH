package BTTuan3;

public class ViduThread extends Thread{
    public void run(){
        System.out.println("Thread is running...");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Priority is: "+ Thread.currentThread().getPriority());
    }
    public static void main(String[] args) throws InterruptedException{
        ViduThread t1 = new ViduThread();
        ViduThread t2 = new ViduThread();

         Thread.sleep(2000);
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        
    }
}
