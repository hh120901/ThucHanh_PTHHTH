package onThi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	private int port;
	private InetAddress host;
	public ChatClient(int port, InetAddress host) {
		this.port = port;
		this.host = host;
	}
	public void excute() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập vào tên của bạn: ");
		String name = sc.nextLine();
		Socket client = new Socket(host, port);
		Readclient read = new Readclient(client);
		read.start();
		WriteClient write = new WriteClient(client,name);
		write.start();
	}
	public static void main(String[] args) throws IOException {
		ChatClient client = new ChatClient(1234, InetAddress.getLocalHost());
		client.excute();
	}
}

class Readclient extends Thread {
	private Socket client;
	public Readclient(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		DataInputStream dis=null;
		try {
			dis = new DataInputStream(client.getInputStream());
			while(true) {
				String sms = dis.readUTF();
				System.out.println(sms);
			}
		} catch (IOException e) {
			try {
				client.close();
				dis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error: " + e1);

			}
		}
	}
}

class WriteClient extends Thread{
	private Socket client;
	private String name;
	public WriteClient(Socket client,String name) {
		this.client = client;
		this.name = name;
	}
	@Override
	public void run() {
		DataOutputStream dos= null;
		Scanner sc = null;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			sc= new Scanner(System.in);
					
			while(true) {
				String sms = sc.nextLine();
				dos.writeUTF(name+ ": " +sms);
				
			}
					
		} catch (Exception e) {
			try {
				client.close();
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error: " + e1);

			}
		}
	}
}
