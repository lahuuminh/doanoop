package sanpham;

import java.io.Serializable;
import java.util.Scanner;



public class ThucAn extends SanPham implements Serializable{
	 private static final long serialVersionUID = 1L;
	private String cachthucchebien;

	public ThucAn(String ma, String ten, String donvitinh, double dongia, int soluong,String cachthucchebien){
		super(ma, ten, donvitinh, dongia,soluong);
		this.cachthucchebien=cachthucchebien;
	}

	public ThucAn(String cachthucchebien) {
	
		this.cachthucchebien ="";
	}
     

	public ThucAn() {
		
	}

	@Override
	public String toString() {
		return "ThucAn [cachthucchebien=" + cachthucchebien + "]";
	}

	public String getCachthucchebien() {
		return cachthucchebien;
	}

	public void setCachthucchebien(String cachthucchebien) {
		this.cachthucchebien = cachthucchebien;
	}
	@Override
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		super.nhap();
		
		System.out.println("Cach thuc che bien");
		this.cachthucchebien=sc.nextLine();
		
		
	}
	public void xuat() {
		String row = String.format("%-20s%-20s%-20s%-20.2f%-20d%s",this.getMa(),this.getTen(),this.getDonvitinh(),this.getDongia(),this.getSoluong(),this.getCachthucchebien());
		
	    System.out.println(row);
	
		}

	@Override
	public String moTaSP() {
		return "Thuc an ngon:" +this.getTen() +"cach thuc che bien:"+this.cachthucchebien+". Gia:" + this.getDongia()+"vnd";
	}

	
	



	

}
