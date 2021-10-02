package BTTuan3;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class sertuantu {
    public final static int serPort =7;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(serPort);
            System.out.println("Server da duoc tao!!! ");
            while(true){
                try {
                    Socket s =ss.accept();
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    int ch = 0;
                    while(true){
                        ch = is.read();
                        if(ch == -1) break;
                        System.out.println((char)ch);
                        os.write(ch);
                    }
                    s.close();
                } catch (Exception ie1) {
                    System.out.println("Connection error: "+ie1);
                }
            }
        } catch (Exception e) {
            System.out.println("Server creation Error: "+ e);
        }
    }
}
