package tuan8;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		try {
			XuLyImpl obj = new XuLyImpl();
			System.out.println("Tao obj thanh cong!");
			
			LocateRegistry.createRegistry(8877);
			Registry reg = LocateRegistry.getRegistry(8877);
			
			reg.bind("XuLyChuoi", obj);
			
			System.out.println("Dang ky thanh cong!!!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
