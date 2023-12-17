package sanpham;

import java.io.Serializable;
import java.util.Scanner;

import until.ValidInput;

public abstract class SanPham implements Serializable{
	 private static final long serialVersionUID = 1L;
	 private  String ma;
	private String ten;
	private String donvitinh;
	private double dongia;
	private  int soluong;
	public SanPham() {
		ma="";
		ten="sanpham";
		donvitinh="";
		dongia=1.0;
		soluong=0;
	}
	public SanPham(String ma, String ten, String donvitinh, double dongia,int soluong) {
		this.ma = ma;
		this.ten = ten;
		this.donvitinh = donvitinh;
		this.dongia = dongia;
		this.soluong=soluong;
	}
	@Override
	public String toString() {
		return "SanPham [ma=" + ma + ", ten=" + ten + ", donvitinh=" + donvitinh + ", dongia=" + dongia + ", soluong="
				+ soluong + "]";
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public int getSoluong() {
		return soluong;
	}
	public  void nhapsanpham() {
		System.out.println("Nhapsanpham");
	};
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap  ma san pham");
		this.ma=sc.nextLine();
		System.out.println("nhap  ten san pham");
		this.ten=sc.nextLine();
		System.out.println("nhap don vi tinh san pham");
		this.donvitinh=sc.nextLine();
//		System.out.println("nhap so luong san pham");
		this.soluong=ValidInput.getValidInteger(sc,"nhap so luong san pham");
//		System.out.println("nhap don gia san pham");
		this.dongia=ValidInput.getValidDouble(sc,"nhap don gia san pham");
	}
	public void xuat() {
		System.out.print("ma:"+this.ma+",ten:"+this.ten+",donvitinh:"+this.donvitinh+",dongia:"+this.dongia+",soluong:"+this.soluong);
		}
	public abstract String moTaSP();
	
}
