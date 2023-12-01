package PhieuNhap;

import java.io.Serializable;
import java.util.Scanner;

public class ChiTietPhieuNhap implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String mapn;
	private String masanpham;
	private int soluong;
	private double dongia;
	private double thanhtien;

	public ChiTietPhieuNhap(String mapn, String masanpham, int soluong, double dongia, double thanhtien) {
		
		this.mapn = mapn;
		this.masanpham = masanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}

	public ChiTietPhieuNhap() {
		
	}
public ChiTietPhieuNhap(ChiTietPhieuNhap d) {
this.mapn=d.mapn;
this.masanpham=d.masanpham;
this.soluong=d.soluong;
this.dongia=d.dongia;
this.thanhtien=d.thanhtien;
	}

@Override
public String toString() {
	return "ChiTietPhieuNhap [mapn=" + mapn + ", masanpham=" + masanpham + ", soluong=" + soluong + ", dongia=" + dongia
			+ ", thanhtien=" + thanhtien + "]";
}

public String getMapn() {
	return mapn;
}

public void setMapn(String mapn) {
	this.mapn = mapn;
}

public String getMasanpham() {
	return masanpham;
}

public void setMasanpham(String masanpham) {
	this.masanpham = masanpham;
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
	
	System.out.println("nhap  ma san pham");
	this.masanpham=sc.nextLine();
	System.out.println("nhap so luong san pham");
	this.soluong=Integer.parseInt(sc.nextLine());
	
}
public void xuat() {
	System.out.println(this);
}
	
}
