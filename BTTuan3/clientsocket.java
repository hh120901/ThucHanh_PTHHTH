package BTTuan3;
import java.io.*;
import java.net.Socket;

public class clientsocket {
    public final static String serIP = "127.0.0.1";
    public final static int serPort = 7;
    public static void main(String[] args) throws InterruptedException, IOException{
        Socket s = null;
        try{
            s= new Socket(serIP, serPort);
            System.out.println("Client da duoc tao");
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            for(int i='0';i<='9';i++)
            {
                os.write(i);
                int ch = is.read();
                System.out.println((char)ch);
                Thread.sleep(2000);
            }
        }
        catch (IOException ie){
            System.out.println("Error:  Can't create socket!!!");

        }
        finally{ 
            if(s!=null){
                s.close();
            }
        }
    }
}
