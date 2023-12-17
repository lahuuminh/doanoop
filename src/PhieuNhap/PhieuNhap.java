package PhieuNhap;

import java.io.Serializable;
import java.util.Scanner;

import until.ValidInput;



public class PhieuNhap implements Serializable {
	 private static final long serialVersionUID = 1L;
	
		private String maphieu;
		private String ngay;
		private String manv;
		private String mancc;
		private double tongtien;
		
		public PhieuNhap(String maphieu, String ngay, String manv, String mancc, double tongtien) {
			
			this.maphieu = maphieu;
			this.ngay=ngay;
			this.manv = manv;
			this.mancc = mancc;
			this.tongtien = tongtien;
		}
		
		public PhieuNhap() {
			
		}
		
		public PhieuNhap(PhieuNhap d) {
			this.maphieu=d.maphieu;
			this.ngay =d.ngay;
			this.manv = d.manv;
			this.mancc = d.mancc;
			this.tongtien = d.tongtien;
		}

		
		
		public String getMaphieu() {
			return maphieu;
		}

		public void setMaphieu(String maphieu) {
			this.maphieu = maphieu;
		}

		public String getNgay() {
			return ngay;
		}

		public void setNgay(String ngay) {
			this.ngay = ngay;
		}

		public String getManv() {
			return manv;
		}

		public void setManv(String manv) {
			this.manv = manv;
		}

		public String getMancc() {
			return mancc;
		}

		public void setMancc(String mancc) {
			this.mancc = mancc;
		}

		public double getTongtien() {
			return tongtien;
		}

		public void setTongtien(double tongtien) {
			this.tongtien = tongtien;
		}

		
		@Override
		public String toString() {
			return "PhieuNhap [maphieu=" + maphieu + ", ngay=" + ngay + ", manv=" + manv + ", mancc=" + mancc
					+ ", tongtien=" + tongtien + "]";
		}

		public void nhap() {
			Scanner sc=new Scanner(System.in);
			System.out.println("nhap ma phieu nhap ");
			this.maphieu=sc.nextLine();
//			System.out.println("nhap ngay lap");
			this.ngay=ValidInput.getValidDate(sc,"nhap ngay lap");
			System.out.println("nhap ma nhan vien");
			this.manv=sc.nextLine();
			System.out.println("nhap ma nha cung cap ");
			this.mancc=sc.nextLine();
			
		}
		public void xuat() {
			 String row = String.format("%-30s%-30s%-30s%-30s%.2f",this.getMaphieu(),this.getNgay(),this.getManv(),this.getMancc(),this.getTongtien());
			System.out.println(row);
		}

	}

