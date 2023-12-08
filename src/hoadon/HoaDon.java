package hoadon;

import java.io.Serializable;
import java.util.Scanner;

import until.ValidInput;

public class HoaDon implements Serializable {
	 private static final long serialVersionUID = 1L;
	private String ma;
	private String ngaylap;
	private String makhach;
	private double tongtien;
	private String manhanvien;
	public HoaDon(String ma, String ngaylap, String makhach, String manhanvien,Double tongtien) {
		this.ma = ma;
		this.ngaylap = ngaylap;
		this.makhach = makhach;
		this.manhanvien = manhanvien;
		this.tongtien=tongtien;
	}
public HoaDon() {
		
	}
public HoaDon(HoaDon d) {
		this.ma=d.ma;
		this.ngaylap=d.ngaylap;
		this.makhach=d.makhach;
		this.manhanvien=d.manhanvien;
		this.tongtien=d.tongtien;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}
	public String getMakhach() {
		return makhach;
	}
	public void setMakhach(String makhach) {
		this.makhach = makhach;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}
	@Override
	public String toString() {
		return "HoaDon [ma=" + ma + ", ngaylap=" + ngaylap + ", makhach=" + makhach + ", tongtien=" + tongtien
				+ ", manhanvien=" + manhanvien + "]";
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma hoa don");
		this.ma=sc.nextLine();
		System.out.println("nhap ma khach");
		this.makhach=sc.nextLine();
		System.out.println("nhap ma nhan vien");
		this.manhanvien=sc.nextLine();
//		System.out.println("nhap  ngay lap hoa don");
		this.ngaylap=ValidInput.getValidDate(sc, "nhap  ngay lap hoa don");
	}
	public void xuat() {
		System.out.println(this);
	}
}
