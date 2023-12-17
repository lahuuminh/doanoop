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
			System.out.println("6.THOAT");
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
				Boolean flag=true;
				while(flag) {
					int luachontimkiem;
					System.out.println("----------MENU TIM KIEM------------");
					System.out.println("1.TIM KIEM THEO HO KHACH HANG");
					System.out.println("2.TIM KIEM THEO MA KHACH HANG");
					System.out.println("3.TIM KIEM THEO TEN  KHACH HANG");
					System.out.println("4.TIM KIEM THEO SO DIEN THOAI KHACH HANG");
					System.out.println("5.THOAT");
//				System.out.println("NHAP LUA CHON");
					luachontimkiem = ValidInput.getValidInteger(sc, "NHAP LUA CHON");

					switch (luachontimkiem) {
						case 1:
							System.out.println("NHAP HO KHACH HANG");
							String ho = sc.nextLine();
							System.out.println("KHACH HANG THEO HO");
						     a.timHo(ho);
							break;
						case 2:
							System.out.println("NHAP MA KHACH HANG");
							String ma = sc.nextLine();
							System.out.println("KHACH HANG THEO MA");
							a.timMa(ma);
							break;
						case 3:
							System.out.println("NHAP TEN KHACH HANG");
							String ten = sc.nextLine();
							System.out.println("KHACH HANG THEO TEN");
							a.timTen(ten);
						
							break;
						case 4:
							System.out.println("NHAP SO DIEN THOAI KHACH HANG");
							String sdt = sc.nextLine();
							System.out.println("KHACH HANG THEO DIEN THOAI");
						     a.timSDT(sdt);
							break;
						case 5:
							flag=false;
							break;
						default:
							break;}
				}
			break;
			case 6:
				dk=false;
				break;
			default:
				break;
				}
		}
		a.ghi();
			}
		}

