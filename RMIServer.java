import java.rmi.Naming;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        
        try {
            //tao doi tuong
            AdderImpl obj = new AdderImpl();
            //dang ki ten
            LocateRegistry.createRegistry(11114);
            Registry reg = LocateRegistry.getRegistry(11114);
            reg.bind("HelloObj", obj);
            System.out.println("CALC Object is registried");
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
}
