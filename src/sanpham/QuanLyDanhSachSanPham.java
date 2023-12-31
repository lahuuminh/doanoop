package sanpham;

import java.util.Iterator;
import java.util.Scanner;

import hoadon.DanhSachChiTietHoaDon;
import until.ValidInput;






public class QuanLyDanhSachSanPham {

public void menu() {
		
		Boolean dk=true;
		DanhSachSanPham a=new DanhSachSanPham();
		DanhSachChiTietHoaDon dscthd=new DanhSachChiTietHoaDon();
		a.doc();
		dscthd.doc();
		
		while(dk) {
			
			System.out.println("------------MENU QUAN LY SAN PHAM-------------");
			int luachon;
			System.out.println("1.XEM SAN PHAM");
			System.out.println("2.THEM SAN PHAM");
			System.out.println("3.XOA SAN PHAM");
			System.out.println("4.SUA THONG TIN SAN PHAM");
			System.out.println("5.TIM KIEM SAN PHAM");
			System.out.println("6.THONG KE SAN PHAM");
			System.out.println("7.THOAT");
//			System.out.println("NHAP LUA CHON");
			Scanner sc=new Scanner(System.in);
			luachon = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
			switch (luachon) {
			case 1:
				System.out.println(String.format("%-60s","Danh sach san pham"));
				a.xuat();
				break;
			case 2:
				a.them();
				break;
			case 3:
				a.xoa();
				break;
			case 4:
				a.suaTheoMa();
				break;
			case 5:
				Boolean flag=true;
				while(flag) {
					
					int luachontimkiem;
					System.out.println("----------MENU TIM KIEM------------");
					System.out.println("1.TIM KIEM THEO TEN SAN PHAM");
					System.out.println("2.TIM KIEM THEO MA SAN PHAM");
					System.out.println("3.TIM KIEM THEO VUNG GIA CUA SAN PHAM");
					System.out.println("4.THOAT");
//				System.out.println("NHAP LUA CHON");
					luachontimkiem = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
					switch (luachontimkiem) {
					case 1:
						System.out.println("NHAP TEN SAN PHAM");
						String ten=sc.nextLine();
						DanhSachSanPham sp =a.timTen(ten);
						System.out.println("DANH SACH SAN PHAM THEO TEN");
						sp.xuat();
						break;
					case 2:
						System.out.println("NHAP MA SAN PHAM");
						String ma=sc.nextLine();
						DanhSachSanPham spma =a.timMa(ma);
						System.out.println("SAN PHAM THEO MA");
						spma.xuat();
						break;
					case 3:
						System.out.println("NHAP GIA 1");
						double gia1=Double.parseDouble(sc.nextLine());
						System.out.println("NHAP GIA 2");
						double gia2=Double.parseDouble(sc.nextLine());
						DanhSachSanPham spgia =a.timGia(gia1, gia2);
						System.out.println("SAN PHAM THEO VUNG GIA");
						spgia.xuat();
						System.out.println("So san pham tim thay:"+spgia.getN());
						break;
					case 4:
						flag=false;
						break;
					default:
						break;
					}
				}
				break;
			case 6:
				Boolean flagtk=true;
				while(flagtk) {
					
					int luachonthongke;
					System.out.println("----------MENU THONG KE------------");
					System.out.println("1.THONG KE SO LUONG BAN DUOC CUA TUNG SAN PHAM");
					System.out.println("2.Thoat");
					luachonthongke=ValidInput.getValidInteger(sc,"nhap lua chon");
					switch (luachonthongke) {
					case 1:
						System.out.println("So luong ban duoc cua tung san pham");
						a.thongKeSPBDC(dscthd.getDscthd(),dscthd.getN());
						break;
					case 2:
						flagtk=false;
						break;
					default:
						break;
						
					}
					
				}
					break;
			case 7:
				dk=false;
				break;
		
}
		
}
		a.ghi(a);
}
}
