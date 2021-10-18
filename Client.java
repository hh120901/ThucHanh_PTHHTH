// package dateTimemenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {
	private int port;
	private InetAddress host;
	
	public Client(int port, InetAddress host) {
		super();
		this.port = port;
		this.host = host;
	}
	
	public void excute() throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Time");
		System.out.println("2. Date");
		System.out.println("3. Date & Time");
		System.out.println("Moi ban chon chuc nang: ");
		Socket client = new Socket(host,port);
		ClientRead read = new ClientRead(client);
		read.start();
		ClientWrite write = new ClientWrite(client);
		write.start();
	}
	public static void main(String[] args) throws IOException {
		Client client = new Client(12333, InetAddress.getLocalHost());
		client.excute();
	}
}

// class write
class ClientWrite extends Thread{
	public Socket client;
	
	public ClientWrite(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				dos = new DataOutputStream(client.getOutputStream());
				while(true) {
					int n = sc.nextInt();
					dos.write(n);

				}
			} catch (IOException e) {
				try {
					dos.close();
					client.close();
				} catch (IOException e1) {
					System.out.println("Error: "+e1);
				}
			}
		}
	}
}

class ClientRead extends Thread{
	public Socket client;
	
	public ClientRead(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			while(true) {
				String sms = dis.readUTF();
				System.out.println("Server: "+ sms);
			}
		} catch (Exception e) {
			try {
				dis.close();
				client.close();
			} catch (Exception e2) {
				System.out.println("Error: "+e2);
			}
			
		}
	}
}
