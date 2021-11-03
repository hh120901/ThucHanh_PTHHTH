package tuan8;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8877);
			XuLyIntf obj = (XuLyIntf) reg.lookup("XuLyChuoi");
			boolean loop= true;
			while(loop) {
				System.out.println(inMenu());
				System.out.print("Nhập vào lựa chọn của bạn: ");
				int choose = sc.nextInt();
				switch (choose) 
				{
					case 1: {
						System.out.println("Nhap vao chuoi ki tu: ");
						sc.nextLine();
						String input = sc.nextLine();
						if(input.contains("exit")) {
							System.out.println("Đã Thoát!");
							loop=false;
							break;
						}
						int dem = obj.demSoTu(input);
						System.out.println("So tu trong chuoi la: "+ dem);
						break;
					}
					case 2:
					{
						System.out.println("Nhap vao chuoi ki tu: ");
						sc.nextLine();
						String input = sc.nextLine();
						if(input.contains("exit")) {
							System.out.println("Đã Thoát!");
							loop=false;
							break;
						}
						String rev = obj.daoNguocChuoi(input);
						System.out.println("Chuoi sau khi dao nguoc la: "+rev);
						break;
					}
					case 0: {
						System.out.println("Đã Thoát!");
						loop=false;
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	public static String inMenu() {
		String menu = "1. Đếm số từ trong chuỗi \n"
					+ "2. Đảo ngược chuỗi";
		
		return menu;
	}
}
