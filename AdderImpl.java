import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderImpl extends UnicastRemoteObject implements Adder {
    public AdderImpl() throws RemoteException{
        super();

    }
    public String sayHello(){
        return "Hello World!!!";
    }
}
