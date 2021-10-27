import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote{
    String sayHello() throws RemoteException;
}
