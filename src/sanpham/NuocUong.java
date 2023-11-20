package sanpham;

import java.util.Scanner;

public class NuocUong extends SanPham {
	private String theloai;
	private String duong;

	

	public NuocUong() {
		}
	public NuocUong(String ma, String ten, String donvitinh, double dongia,int soluong,String theloai, String duong) {
		super(ma,ten,donvitinh,dongia,soluong);
		this.theloai = theloai;
		this.duong = duong;
	}

	public NuocUong(String theloai, String duong) {
		super();
		this.theloai = theloai;
		this.duong = duong;
	}
	@Override
	public String toString() {
		return "NuocUong [theloai=" + theloai + ", duong=" + duong + "]";
	}



	public String getTheloai() {
		return theloai;
	}



	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}



	public String getDuong() {
		return duong;
	}



	public void setDuong(String duong) {
		this.duong = duong;
	}
@Override
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		super.nhap();
		System.out.println("nhap the loai nuoc uong ");
		this.theloai=sc.nextLine();
		System.out.println("nhap nuoc it duong hay nhieu duong");
		this.duong=sc.nextLine();
	
		
		
	}
	public void xuat() {
		super.xuat();
		System.out.print(",theloai:"+this.theloai+",duong:"+this.duong);
			System.out.println();
	
		}
	




	
}
