package khachhang;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang implements Serializable {
	 private static final long serialVersionUID = 1L;

	private String ma;
	private String ho;
	private String ten;
	private String diachi;
	private String dienthoai;
	public KhachHang(String ma, String ho, String ten, String diachi, String dienthoai) {
	
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
	}
	public KhachHang() {
		
	}
public KhachHang(KhachHang d) {
		this.ma=d.ma;
		this.ho=d.ho;
		this.ten=d.ten;
		this.diachi=d.diachi;
		this.dienthoai=d.dienthoai;
	}
	@Override
	public String toString() {
		return "KhachHang [ma=" + ma + ", ho=" + ho + ", ten=" + ten + ", diachi=" + diachi + ", dienthoai=" + dienthoai
				+ "]";
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma khach");
		this.ma=sc.nextLine();
		System.out.println("nhap  ho khach hang");
		this.ho=sc.nextLine();
		System.out.println("nhap ten khach");
		this.ten=sc.nextLine();
		System.out.println("nhap diachi khach hang");
		this.diachi=sc.nextLine();
		System.out.println("nhap so dien thoai khach hang");
		this.dienthoai=sc.nextLine();
	
		
		
	}
	public void xuat() {
		System.out.println(this);
	}
	
}
