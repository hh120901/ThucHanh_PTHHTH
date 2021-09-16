import java.util.*;
public class ToaDoXY {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ToaDoXY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public ToaDoXY() {
		super();
		
	}
	public void nhapToaDo()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap toa do x: ");
		this.x=sc.nextInt();
		
		System.out.print("\nNhap toa do y: ");
		this.y=sc.nextInt();
	}
	public void inToaDo() {
		System.out.print("Toa do: ");
		System.out.println("("+x+","+y+")");
	}
	public void tinhKhoangCach() {
		double kc= Math.sqrt(x*x+y*y);
		System.out.println("Khoang cach tu toa do (" + x +","+ y+") la: "+ kc);
	}
	public static void main(String[] args) {
		ToaDoXY first= new ToaDoXY(10,20);
		ToaDoXY second= new ToaDoXY(30,40);
		ToaDoXY nhaptd1 = new ToaDoXY();
		first.inToaDo();
		second.inToaDo();
		first.tinhKhoangCach();
		second.tinhKhoangCach();
		nhaptd1.nhapToaDo();
		nhaptd1.inToaDo();
		nhaptd1.tinhKhoangCach();
	}
}