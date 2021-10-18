// package dateTimemenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Server {
	private int port;

	public Server(int port) {
		super();
		this.port = port;
	}
	
	public void excute() throws IOException{
		ServerSocket server = new ServerSocket(port);
//		ServerWrite write = new ServerWrite();
//		write.start();
		System.out.println("Server is listening...");
		while(true) {
			Socket socket = server.accept();
			System.out.println("Da ket noi voi: "+socket);
			System.out.println("1. Time");
			System.out.println("2. Date");
			System.out.println("3. Date & Time");
			System.out.println("Cho client chon chuc nang: ...");
			ServerRead read = new ServerRead(socket);
			read.start();
		}
		
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server(12333);
		server.excute();
	}
}
//class ServerWrite extends Thread{
//	public Socket server;
//	@Override
//	public void run() {
//		Date today = new Date();
//		SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.YYYY");
//		String s= String.format("Ngay hom nay: ", sdf.format(today));
//		DataOutputStream dos = null;
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			int n = sc.nextInt();
//			try {
//				dos = new DataOutputStream(server.getOutputStream());
//				dos.writeBytes(s);
//			} catch (Exception e) {
//				System.out.println("Error: "+ e);
//			}
//		}
//		
//	}
//}

class ServerRead extends Thread{
	public Socket server;
	
	public ServerRead(Socket server){
		
		this.server = server;
	}
//	public String process(int n) {
//		Date dNow = new Date( );
//	    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.YYYY");
//	    SimpleDateFormat ti = new SimpleDateFormat ("hh:mm:ss a zzz");
//	    String date=("Date hien tai: " + ft.format(dNow));
//	    String time=("Time: "+ti.format(dNow));
//	    if(n==1) {
//	    	return time;
//	    }
//	    else if(n==2) {
//	    	return date;
//	    }
//	    return "null";
//	}
	@Override
	public void run() {
		DataInputStream dis = null;
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.YYYY");
	      String date=("Date hien tai: " + ft.format(dNow));
	      SimpleDateFormat ti = new SimpleDateFormat ("hh:mm:ss a zzz");
	      String time=("Time: "+ti.format(dNow));
	      SimpleDateFormat dt = new SimpleDateFormat ("E dd.MM.YYYY 'at' hh:mm:ss a zzz");
	      String datetime = ("Date & Time: " + dt.format(dNow));
		try {
			dis = new DataInputStream(server.getInputStream());
			while(true) {
				int n = dis.read();
				System.out.println("Client yeu cau: "+n);
				if(n==1) {
					DataOutputStream dos = new DataOutputStream(server.getOutputStream());
					dos.writeUTF(time);
				}
				else if(n==2){
					DataOutputStream dos = new DataOutputStream(server.getOutputStream());
					dos.writeUTF(date);
				}
				else if(n==3) {
					DataOutputStream dos = new DataOutputStream(server.getOutputStream());
					dos.writeUTF(datetime);
				}
				else {
					DataOutputStream dos = new DataOutputStream(server.getOutputStream());
					dos.writeUTF("Vui long chon chuc nang 1 hoac 2 hoac 3");
				}
				
			}
		} catch (Exception e) {
			try {
				dis.close();
				server.close();
			} catch (Exception e2) {
				System.out.println("Error: "+e2);
			}
			
			
		}
	}
}

