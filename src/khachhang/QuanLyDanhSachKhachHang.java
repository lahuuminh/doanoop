package khachhang;

import java.util.Scanner;

import until.ValidInput;

public class QuanLyDanhSachKhachHang {
public void menu() {
		
		Boolean dk=true;
		DanhSachKhachHang a=new DanhSachKhachHang();
		a.doc();
		
		while(dk) {
			
			System.out.println("------------MENU QUAN LY KHACH HANG-------------");
			int luachon;
			System.out.println("1.XEM DANH SACH KHACH HANG");
			System.out.println("2.THEM KHACH HANG");
			System.out.println("3.XOA KHACH HANG");
			System.out.println("4.SUA THONG TIN KHACH HANG");
			System.out.println("5.TIM KIEM KHACH HANG");
			System.out.println("6.THONG KE KHACH HANG");
			System.out.println("7.THOAT");
//			System.out.println("NHAP LUA CHON");
			Scanner sc=new Scanner(System.in);
			luachon = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
			switch (luachon) {
			case 1:
				System.out.println("DANH SACH KHACH HANG");
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
                int luachontimkiem;
				System.out.println("----------MENU TIM KIEM------------");
				System.out.println("1.TIM KIEM THEO HO KHACH HANG");
				System.out.println("2.TIM KIEM THEO MA");
				System.out.println("3.TIM KIEM THEO SO DIEN THOAI");
				System.out.println("4.THOAT");
//				System.out.println("NHAP LUA CHON");
				luachontimkiem = ValidInput.getValidInteger(sc,"NHAP LUA CHON");
				switch (luachontimkiem) {
				case 1:
					System.out.println("NHAP HO KHACH HANG");
					String ho=sc.nextLine();
					DanhSachKhachHang khho =a.timHo(ho);
					System.out.println("KHACH HANG THEO HO");
				    khho.xuat();
					break;
				case 2:
					System.out.println("NHAP MA KHACH HANG");
					String ma=sc.nextLine();
					DanhSachKhachHang khma =a.timMa(ma);
					System.out.println("KHACH HANG THEO MA");
				    khma.xuat();
					break;
				case 3:
					System.out.println("NHAP SO DIEN THOAI KHACH HANG");
					String sdt=sc.nextLine();
					DanhSachKhachHang khsdt =a.timSDT(sdt);
					System.out.println("KHACH HANG THEO DIEN THOAI");
				    khsdt.xuat();
					break;
				case 4:
					break;
			default:
				break;
				}
				break;
			case 6:
				System.out.println("----------MENU THONG KE------------");
				System.out.println("1.THONG KE THEO TEN KHACH HANG");
				System.out.println("2.THOAT");
				int luachonthongke=ValidInput.getValidInteger(sc,"nhap lua chon thong ke");
				switch (luachonthongke) {
				case 1: 
					System.out.println("nhap ten khach hang");
					String ten=sc.nextLine();
					a.TKTen(ten);
					break;
				case 2:
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
		a.ghi();
}
}

