package hoadon;

import java.util.Scanner;

import until.ValidInput;

public class QuanLyDanhSachChiTietHoaDon {
	public void menu() {
		
	Boolean dk=true;
	DanhSachChiTietHoaDon dscthd=new DanhSachChiTietHoaDon();
    dscthd.doc();
//	System.out.println(dscthd.getN());
	
	  
	while(dk) {
		
		System.out.println("------------MENU QUAN LY DANH SACH CHI TIET HOA DON-------------");
		int luachon;
		System.out.println("1.XEM DANH CHI TIET HOA DON");
		System.out.println("2.THEM CHI TIET HOA DON");
		System.out.println("3.XOA CHI TIET HOA DON");
		System.out.println("4.SUA THONG TIN CHI TIET HOA DON");
		System.out.println("5.TIM KIEM CHI TIET HOA DON");
		System.out.println("6.THOAT");
//		System.out.println("NHAP LUA CHON");
		Scanner sc=new Scanner(System.in);
		luachon =ValidInput.getValidInteger(sc,"NHAP LUA CHON");
		switch (luachon) {
		case 1:
			System.out.println("DANH SACH CHI TIET HOA DON");
			dscthd.xuat();
			break;
		case 2:
			dscthd.them();
			break;
		case 3:
			dscthd.xoa();
			break;
		case 4:
			dscthd.suaTheoMa();
			break;
		case 5:
		    Boolean flagluachontimkiem=true;
		    while(flagluachontimkiem) {
		    	System.out.println("TIM KIEM CHI TIET HOA DON");
				System.out.println("1.XEM CHI TIET HOA DON THEO MA HOA DON");
				System.out.println("2.TIM CHI TIET HOA DON THEO MA SAN PHAM");
				System.out.println("3.TIM CHI TIET HOA DON THEO TIEN");
				System.out.println("4.THOAT");
				int luachontim;
//				System.out.println("NHAP LUA CHON CUA BAN");
				luachontim=ValidInput.getValidInteger(sc,"NHAP LUA CHON CUA BAN");
				switch (luachontim) {
				case 1:
					String ma;
					System.out.println("NHAP MA HOA DON");
					 ma=sc.nextLine();
					 DanhSachChiTietHoaDon dscthdma= dscthd.timMaHd(ma);
					 System.out.println("DANH SACH CHI TIET HOA DON THEO MA HOA DON");
					 dscthdma.xuat();
					break;
				case 2:
					String masp;
					System.out.println("NHAP MA SAN PHAM");
					 masp=sc.nextLine();
					 DanhSachChiTietHoaDon dscthdmasp= dscthd.timMaSp(masp);
					 System.out.println("DANH SACH CHI TIET HOA DON THEO MA SAN PHAM");
					 dscthdmasp.xuat();
					break;
				case 3:
					double tien;
//					System.out.println("NHAP MA HOA DON");
					 tien=ValidInput.getValidDouble(sc,"NHAP MA HOA DON");
					 DanhSachChiTietHoaDon dscthdt= dscthd.timTien(tien);
					 System.out.println("DANH SACH CHI TIET HOA DON THEO TIEN");
					 dscthdt.xuat();
					break;
				case 4:
					flagluachontimkiem=false;
					break;
				default:
					break;
				}
		    }
			break;
		case 6:
			dk=false;
			break;
		default:
			dk=false;
			break;
}
		
	}
	dscthd.ghi(dscthd);
}
}
