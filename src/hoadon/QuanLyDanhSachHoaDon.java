package hoadon;

import java.util.Scanner;

import sanpham.DanhSachSanPham;
import sanpham.SanPham;
import until.ValidInput;

public class QuanLyDanhSachHoaDon {
public void menu() {
		
		Boolean dk=true;
		DanhSachSanPham dssp=new DanhSachSanPham();
		dssp.doc();
		
		DanhSachHoaDon dshd=new DanhSachHoaDon();
		dshd.doc();
		DanhSachChiTietHoaDon dscthd=new DanhSachChiTietHoaDon();
		dscthd.doc();
		
	
		  
		while(dk) {
			
			System.out.println("------------MENU QUAN LY HOA DON------------");
			int luachon;
			System.out.println("1.XEM DANH SACH HOA DON");
			System.out.println("2.THEM HOA DON");
			System.out.println("3.XOA HOA DON");
			System.out.println("4.SUA THONG TIN HOA DON");
			System.out.println("5.TIM KIEM HOA DON");
			System.out.println("6.THONG KE HOA DON");
			System.out.println("7.THOAT");
//			System.out.println("NHAP LUA CHON");
			Scanner sc=new Scanner(System.in);
			luachon =ValidInput.getValidInteger(sc,"NHAP LUA CHON");
			switch (luachon) {
			case 1:
				System.out.println("DANH SACH HOA DON");
				dshd.xuat();
				break;
			case 2:
			    dshd.them(dssp, dscthd);
				break;
			case 3:
				dshd.xoa();
				break;
			case 4:
				dshd.suaTheoMa();
				break;
			case 5:
				 int luachontimkiem;
					System.out.println("----------MENU TIM KIEM HOA DON------------");
					System.out.println("1.TIM KIEM THEO MA KHACH");
					System.out.println("2.TIM KIEM THEO NGAY LAP");
					System.out.println("3.TIM KIEM THEO TONG TIEN LON HON");
					System.out.println("4.THOAT");
					luachontimkiem = ValidInput.getValidInteger(sc,"nhap lua chon tim kiem");
					switch (luachontimkiem) {
					case 1:
						System.out.println("NHAP MA KHACH HANG");
						String ma=sc.nextLine();
						DanhSachHoaDon hdma =dshd.timMaKhach(ma);
						System.out.println("HOA DON THEO MA KHACH");
					    hdma.xuat();
						break;
					case 2:
//						System.out.println("NHAP NGAY LAP HOA DON");
						String ngay=ValidInput.getValidDate(sc,"NHAP NGAY LAP HOA DON");
						DanhSachHoaDon hdngay =dshd.timNL(ngay);
						System.out.println("HOA DON THEO NGAY LAP");
					    hdngay.xuat();
						break;
					case 3:
//						System.out.println("NHAP SO TIEN HOA DON");
						double tien=ValidInput.getValidDouble(sc,"NHAP SO TIEN HOA DON");
						DanhSachHoaDon hdgia =dshd.timGiaTien(tien);
						System.out.println("HOA DON THEO TONG TIEN");
					    hdgia.xuat();
						break;
					case 4:
						break;
				    default:
					break;
					}
					break;
				case 6:
					 int luachonthonge;
						System.out.println("----------MENU THONG KE HOA DON------------");
						System.out.println("1.THONG KE THEO TONG DANH THU");
						System.out.println("2.THONG KE DANH THU THEO QUY");
						System.out.println("3.THOAT");
						luachonthonge = ValidInput.getValidInteger(sc,"nhap lua chon thong ke cua ban");
						switch (luachonthonge) {
						case 1: 
							dshd.TKDoanThu();
							break;
						case 2: 
							dshd.TKQuy();
							break;
						case 3:
							break;
						default:
						break;
						}
					break;
				case 7:
					dk=false;
					break;
				default:
					break;
			

		}
			
			
		
}
		dshd.ghi(dshd);
		dssp.ghi(dssp);
		dscthd.ghi(dscthd);
}
}
