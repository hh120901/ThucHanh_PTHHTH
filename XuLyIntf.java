package tuan8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface XuLyIntf extends Remote{
	 int demSoTu(String input) throws RemoteException;
	 String daoNguocChuoi(String input) throws RemoteException;
}
