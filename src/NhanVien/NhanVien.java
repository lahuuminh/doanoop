package NhanVien;

import java.io.Serializable;
import java.util.Scanner;

import until.ValidInput;

public class NhanVien implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String ma;
	private String ho;
	private String ten;
	private String ngaysinh;
	private float luong;
	
	public NhanVien(String ma, String ho, String ten, String ngaysinh, float luong) {
		
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.luong = luong;
	}
	
	public NhanVien() {
		
	}
	
	public NhanVien(NhanVien d) {
		this.ma=d.ma;
		this.ma =d.ma;
		this.ho = d.ho;
		this.ten = d.ten;
		this.ngaysinh=d. ngaysinh;
		this.luong = d.luong;
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
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	

	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ho=" + ho + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", luong=" + luong
				+ "]";
	}
	
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nhan vien");
		this.ma=sc.nextLine();
		System.out.println("nhap ho nhan vien");
		this.ho=sc.nextLine();
		System.out.println("nhap ten nhan vien");
		this.ten=sc.nextLine();
		
//		System.out.println("nhap ngay sinh nhan vien");
		this.ngaysinh=ValidInput.getValidDate(sc, "nhap ngay sinh nhan vien");
//		System.out.println("nhap luong nhan vien");
		this.luong=ValidInput.getValidFloat(sc,"nhap luong nhan vien");
		
		
	}
	public void xuat() {
		String row = String.format("%-30s%-30s%-30s%-30s%.2f",this.getMa(),this.getHo(),this.getTen(),this.getNgaysinh(),this.getLuong());
        System.out.println(row);
		
	}

}
