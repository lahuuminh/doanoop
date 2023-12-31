package PhieuNhap;

import java.util.Scanner;

import sanpham.DanhSachSanPham;
import until.ValidInput;

public class QuanLyDanhSachChiTietPhieuNHap {

public void menu() {
		
		Boolean dk=true;
		DanhSachChiTietPhieuNhap a=new DanhSachChiTietPhieuNhap();
		a.doc();
		while(dk) {
			
			
			System.out.println("------------MENU QUAN LY DANH SACH CHI TIET PHIEU NHAP-------------");
			int luachon;
			System.out.println("1.XEM DANH SACH CHI TIET PHIEU NHAP");
			System.out.println("2.THEM CHI TIET PHIEU NHAP");
			System.out.println("3.XOA CHI TIEIT PHIEU NHAP");
			System.out.println("4.SUA THONG TIN CHI TIET PHIEU NHAP");
			System.out.println("5.TIM KIEM PHIEU NHAP");
			System.out.println("6.THOAT");
//			System.out.println("NHAP LUA CHON");
			Scanner sc=new Scanner(System.in);
			luachon = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
			switch (luachon) {
			case 1:
				System.out.println("DANH SACH CHI TIET PHIEU NHAP");
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
					System.out.println("1.TIM KIEM MA  PHIEU NHAP");
					System.out.println("2.TIM KIEM THEO MA SAN PhAM");
					System.out.println("3.TIM KIEM THEO TIEN");
					System.out.println("4.THOAT");
//				System.out.println("NHAP LUA CHON");
					luachontimkiem = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
					switch (luachontimkiem) {
					case 1:
						System.out.println("NHAP MA CHI TIET PHIEU NHAP");
						String ma=sc.nextLine();
						DanhSachChiTietPhieuNhap ctpnma =a.timMaPN(ma);
						System.out.println("CHI TIET PHIEU NHAP THEO MA");
						ctpnma.xuat();
						break;
					case 2:
						System.out.println("NHAP MA SAN PHAM");
						String masp =sc.nextLine();
						DanhSachChiTietPhieuNhap pnnl=a.timMaSp(masp);
						System.out.println("PHIEU NHAP THEO MA SAN PHAM");
						pnnl.xuat();
						break;
					case 3:
//					System.out.println("NHAP THEO TONG TIEN");
						double tien=ValidInput.getValidDouble(sc,"NHAP TONG TIEN");
						DanhSachChiTietPhieuNhap plncc=a.timTien(tien);
						System.out.println("PHIEU LAP THEO TIEN");
						plncc.xuat();
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
			dk=false;
			break;
			default:
				break;
}
		}
		a.ghi(a);
		
}
}
