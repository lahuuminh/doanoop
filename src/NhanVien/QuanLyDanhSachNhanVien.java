package NhanVien;

import java.util.Scanner;

public class QuanLyDanhSachNhanVien{
	public void menu() {
			
			Boolean dk=true;
			DanhSachNhanVien a=new DanhSachNhanVien();
			a.doc();
			while(dk) {
				
				System.out.println("------------MENU QUAN LY NHAN VIEN-------------");
				int luachon;
				System.out.println("1.XEM DANH SACH NHAN VIEN");
				System.out.println("2.THEM NHAN VIEN");
				System.out.println("3.XOA NHAN VIEN");
				System.out.println("4.SUA THONG TIN NHAN VIEN");
				System.out.println("5.TIM KIEM NHAN VIEN");
				System.out.println("6.THONG KE NHAN VIEN");
				System.out.println("7.THOAT");
				System.out.println("NHAP LUA CHON");
				Scanner sc=new Scanner(System.in);
				luachon = Integer.parseInt(sc.nextLine());
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
					System.out.println("1.TIM KIEM THEO LUONG NHAN VIEN");
					System.out.println("2.TIM KIEM THEO NGAY SINH NHAN VIEN");
					System.out.println("NHAP LUA CHON");
					luachontimkiem = Integer.parseInt(sc.nextLine());
					switch (luachontimkiem) {
					case 1:
						System.out.println("NHAP LUONG NHAN VIEN");
						float luong=sc.nextFloat();
						DanhSachNhanVien nvluong =a.timLuong(luong);
						System.out.println("NHAN VIEN THEO LUONG");
					    nvluong.xuat();
						break;
					case 2:
						System.out.println("NHAP NGAY SINH NHAN VIEN");
						String ngaysinh=sc.nextLine();
						DanhSachNhanVien nvngaysinh =a.timNgaySinh(ngaysinh);
						System.out.println("NHAN VIEN THEO NGAY SINH");
					    nvngaysinh.xuat();
						break;
				default:
					break;
					}
				case 6:
					int luachonthongke;
					System.out.println("----------MENU THONG KE------------");
					System.out.println("1.THONG KE THEO LUONG NHAN VIEN TRUNG BINH");
					System.out.println("2.THONG KE LUONG MOI THANG PHAI TRA CHO NHAN VIEN");
					luachonthongke = Integer.parseInt(sc.nextLine());
					switch (luachonthongke) {
					case 1: 
						a.TKluong();
						break;
					case 2: 
						a.tKLuongPT();
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
			a.ghi(a);
	}
	}