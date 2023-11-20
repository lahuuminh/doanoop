package PhieuNhap;

import java.util.Scanner;

import sanpham.DanhSachSanPham;

public class QuanLyDanhSachPhieuNhap {
public void menu() {
		
		Boolean dk=true;
		DanhSachPhieuNhap a=new DanhSachPhieuNhap();
		DanhSachSanPham dssp=new DanhSachSanPham();
		DanhSachChiTietPhieuNhap dsctpn=new DanhSachChiTietPhieuNhap();
		a.doc();
		dssp.doc();
		dsctpn.doc();
		while(dk) {
			
			System.out.println("------------MENU QUAN LY DANH SACH PHIEU NHAP-------------");
			int luachon;
			System.out.println("1.XEM DANH SACH PHIEU NHAP");
			System.out.println("2.THEM PHIEU NHAP");
			System.out.println("3.XOA PHIEU NHAP");
			System.out.println("4.SUA THONG TIN PHIEU NHAP");
			System.out.println("5.TIM KIEM PHIEU NHAP");
			System.out.println("6.THONG KE PHIEU NHAP");
			System.out.println("7.THOAT");
			System.out.println("NHAP LUA CHON");
			Scanner sc=new Scanner(System.in);
			luachon = Integer.parseInt(sc.nextLine());
			switch (luachon) {
			case 1:
				System.out.println("DANH SACH PHIEU NHAP");
				a.xuat();
				break;
			case 2:
				a.them(dsctpn,dssp);
				break;
			case 3:
				a.xoa();
				break;
			case 4:
				a.suaTheoMa();
				break;
			case 5:
                int luachontimkiem;
				System.out.println("----------MENU TIM KIEM------------");
				System.out.println("1.TIM KIEM MA PHIEU NHAP");
				System.out.println("2.TIM KIEM THEO NGAY");
				System.out.println("3.TIM KIEM THEO MA NHA CUNG CAP");
				System.out.println("NHAP LUA CHON");
				luachontimkiem = Integer.parseInt(sc.nextLine());
				switch (luachontimkiem) {
				case 1:
					System.out.println("NHAP MA PHIEU NHAP");
					String ma=sc.nextLine();
					DanhSachPhieuNhap pnma =a.timMaNhaCungCap(ma);
					System.out.println("PHIEU NHAP THEO MA");
				    pnma.xuat();
					break;
				case 2:
					System.out.println("NHAP NGAY LAP");
					String ngay=sc.nextLine();
					DanhSachPhieuNhap pnnl=a.timNgay(ngay);
					System.out.println("PHIEU NHAP THEO NGAY LAP");
				    pnnl.xuat();
					break;
				case 3:
					System.out.println("NHAP MA NHA CUNG CAP");
					String mancc=sc.nextLine();
					DanhSachPhieuNhap plncc=a.timMaNhaCungCap(mancc);
					System.out.println("PHIEU LAP THEO MA NHA CUNG CAP");
				    plncc.xuat();
					break;
			default:
				break;
				}
			case 6:
				System.out.println("----------MENU THONG KE------------");
				System.out.println("1.THONG KE TONG TIEN NHAP HANG CUA THANG");
				int thang=Integer.parseInt(sc.nextLine());
				a.thongKeTienNhapHang(thang);
			case 7:
				dk=false;
				break;
			default:
				break;
}
		}
		a.ghi(a);
		dssp.ghi(dssp);
		dsctpn.ghi(dsctpn);
}
}