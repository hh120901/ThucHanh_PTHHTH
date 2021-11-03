import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("192.168.1.20",11114);
            Adder obj = (Adder) reg.lookup("HelloObj");
            int a = 25;
            int b =4;
            int tong= obj.Cong(a,b);
            int hieu= obj.Tru(a,b);
            System.out.println(a + " + "+b +" = " + tong);
            System.out.println(a + " - "+b +" = " + hieu);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
