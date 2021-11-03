package tuan8;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class XuLyImpl extends UnicastRemoteObject implements XuLyIntf{
	protected XuLyImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int demSoTu(String input) throws RemoteException {
		final char SPACE = ' ';
		final char TAB = '\t';
		final char Break_line= '\n';
		if(input == null || input.contains("exit"))
		{
			return -1;
		}

		int count = 0;
		int size = input.length();
		boolean notCount= true;
		for (int i= 0;i<size; i++) {
			if(input.charAt(i)!= SPACE && input.charAt(i)!= TAB && input.charAt(i) != Break_line)
			{
				if(notCount) {
					count++;
					notCount= false;
				}
			}
			else
			{
				notCount = true;
			}
		}
		return count;
	}

	@Override
	public String daoNguocChuoi(String input) throws RemoteException {
		if(input == null || input.contains("exit"))
		{
			return null;
		}
		else{
			StringBuilder str = new StringBuilder(input);
			return str.reverse().toString();
		}
		// TODO Auto-generated method stub
	}

}
