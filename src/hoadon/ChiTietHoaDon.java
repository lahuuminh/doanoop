package hoadon;

import java.io.Serializable;
import java.util.Scanner;

public class ChiTietHoaDon implements Serializable {
	 private static final long serialVersionUID = 1L;
	private String mahd;
	private String masp;
	private int soluong;
	private double dongia;
	private double thanhtien;

	public ChiTietHoaDon() {
	
	}
	public ChiTietHoaDon(ChiTietHoaDon d) {
		this.mahd=d.mahd;
		this.masp=d.masp;
		this.soluong=d.soluong;
		this.dongia=d.dongia;
		this.thanhtien=d.thanhtien;
}
	
	public ChiTietHoaDon(String mahd, String masp, int soluong, double dongia, double thanhtien) {
		super();
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", dongia=" + dongia
				+ ", thanhtien=" + thanhtien + "]";
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma san pham");
		this.masp=sc.nextLine();
		System.out.println("nhap so luong");
		this.soluong=sc.nextInt();
	}
	public void xuat() {
		System.out.println(this);
	}


}
