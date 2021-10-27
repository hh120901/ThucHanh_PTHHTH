import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",6667);
            Adder obj = (Adder) reg.lookup("HelloObj");
            String msg = obj.sayHello();
            System.out.println(msg);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
