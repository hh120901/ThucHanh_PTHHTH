package BTTuan3;

import java.net.ServerSocket;
import java.net.Socket;



public class SerDual {
    public final static int serPort = 7;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(serPort);
            System.out.println("Server da duoc tao...");
            while (true){
                try {
                    Socket s = ss.accept();
                    RequestProcessing rq= new RequestProcessing(s);
                    rq.start();
                } catch (Exception e1) {
                    System.out.println("Connection error: "+ e1);
                }
            }
        } catch (Exception e2) {
           System.out.println("Server Error: "+e2);
        }    
    }
}
