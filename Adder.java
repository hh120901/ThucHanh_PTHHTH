import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote{
    int Cong(int a,int b) throws RemoteException;
    int Tru(int a,int b) throws RemoteException;
}
