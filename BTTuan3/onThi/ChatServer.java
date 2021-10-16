package onThi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer {
	private int port;
	public static  ArrayList<Socket> listSK;
	
	public ChatServer(int port) {
		super();
		this.port = port;
	}
	public void excute() throws IOException {
		ServerSocket server = new ServerSocket(port);
		WriteServer write = new WriteServer();
		write.start();
		System.out.println("Server is listening...");
		while(true) {
			Socket socket = server.accept();
			System.out.println("Da ket noi voi "+ socket);
			ChatServer.listSK.add(socket);
			ReadServer read = new ReadServer(socket);
			read.start();
		}
	}
	public static void main(String[] args) throws IOException {
		ChatServer.listSK = new ArrayList<>();
		ChatServer server = new ChatServer(1234);
		server.excute();
	}
}


// Class read server
class ReadServer extends Thread{
	private Socket server;
	public ReadServer(Socket server) {
		this.server = server;
	}
	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(server.getInputStream());
			while(true) {
				String sms = dis.readUTF();
				for (Socket item: ChatServer.listSK)
				{
					if(item.getPort() != server.getPort()) {
						DataOutputStream dos = new DataOutputStream(item.getOutputStream());
						dos.writeUTF(sms);
					}
				}
				System.out.println(sms);
			}
		} catch (Exception e) {
			try {
				dis.close();
				server.close();
			} catch (Exception e2) {
				System.out.println("Error" +e2);
			}
		}
	}
	
	
}

// class write server
class WriteServer extends Thread{
	@Override
	public void run() {
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			String sms = sc.nextLine();
			try {
				for(Socket item: ChatServer.listSK)
				{
					dos = new DataOutputStream(item.getOutputStream());
					dos.writeUTF("Server: "+ sms);
				}
			}
			 catch (Exception e) {
				System.out.println("Error: "+ e);
			}
			
		}
	}
}