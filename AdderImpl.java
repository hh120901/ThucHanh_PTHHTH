import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class AdderImpl extends UnicastRemoteObject implements Adder {
    public AdderImpl() throws RemoteException{
        super();

    }

@Override
public int Cong(int a, int b) throws RemoteException {
       // TODO Auto-generated method stub
       return a+b;
}

@Override
public int Tru(int a, int b) throws RemoteException {
       // TODO Auto-generated method stub
       return a-b;
}
   
}
