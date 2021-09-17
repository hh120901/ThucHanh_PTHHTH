import java.util.*;
import java.io.*;

public class PhanSo {
	private int tuSo;
	private int mauSo;
	//getter setter
	public int getTuSo() {
		return tuSo;
	}

	public void setTuSo(int tuSo) {
		this.tuSo = tuSo;
	}

	public int getMauSo() {
		return mauSo;
	}

	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}
	// constructor
	public PhanSo() {
		super();
		// TODO Auto-generated constructor stub
	}
	// constructor
	public PhanSo(int tuSo, int mauSo) {
		super();
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}
	// Phuong thuc in ps ra man hinh
	public void inPS() {
		System.out.println("Phan so cua ban la: "+ tuSo +"/"+mauSo);
	}
	// Phuong thuc khoi tao phan so
	public void nhapPS() throws IOException{
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap Vao Tu So: ");
			tuSo = sc.nextInt();
			System.out.print("\nNhap Vao Mau So: ");
			mauSo = sc.nextInt();
		}
		catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
	public void nghichDao() {
		int temp= 0;
		temp = tuSo;
		tuSo = mauSo;
		mauSo = temp;
		System.out.println("Phan so sau khi nghich dao: "+ tuSo +"/"+mauSo);
	}
	public void tinhPS() {
		double giatri=1.0*tuSo/mauSo;
		System.out.println("Gia tri thuc cua phan so: "+giatri);
	}
	public void congPS(PhanSo ps)
	{
		int tu = this.getTuSo()*ps.mauSo + this.getMauSo()*ps.getTuSo();
		int mau = this.getMauSo()*ps.getMauSo();
		System.out.println("Tong 2 phan so = "+tu+"/"+mau);
	}
	public void nhan2ps(PhanSo ps) {
		int tu = this.getTuSo()*ps.getTuSo();
		int mau = this.getMauSo()*ps.getMauSo();
		System.out.println("Phep Nhan 2 phan so = "+tu+"/"+mau);
	}
	public void chia2ps(PhanSo ps) {
		int tu = this.getTuSo()*ps.getMauSo();
		int mau = this.getMauSo()*ps.getTuSo();
		System.out.println("Phep Chia 2 phan so = "+tu+"/"+mau);
	}
	public static void main(String[] args) throws IOException {
		PhanSo ps = new PhanSo();
		PhanSo ex = new PhanSo(2,3);
		ps.nhapPS();
		ps.inPS();	
		ps.tinhPS();
		ps.nghichDao();
		ps.congPS(ex);
		ps.nhan2ps(ex);
		ps.chia2ps(ex);
	}
}
