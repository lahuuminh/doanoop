package NhaCungCap;

import java.io.Serializable;
import java.util.Scanner;

public class NhaCungCap  implements Serializable {
	 private static final long serialVersionUID = 1L;

	private String ma;
	private String ten;
	private String diachi;
	public NhaCungCap() {
		
	}	
	public NhaCungCap(NhaCungCap d) {
		this.ma=d.ma;
		this.ten=d.ten;
		this.diachi=d.diachi;
	}
	public NhaCungCap(String ma, String ten, String diachi) {
		this.ma = ma;
		this.ten = ten;
		this.diachi = diachi;
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public String toString() {
		return "NhaCungCap [ma=" + ma + ", ten=" + ten + ", diachi=" + diachi + "]";
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nha cung cap");
		this.ma=sc.nextLine();
		System.out.println("nhap ten nha cung cap");
		this.ten=sc.nextLine();
		System.out.println("nhap dia chi nha cung cap");
		this.diachi=sc.nextLine();
	}
	public void xuat() {
		String row = String.format("%-30s%-30s%s",this.getMa(),this.getTen(),this.getDiachi());
        System.out.println(row);
	}
}
