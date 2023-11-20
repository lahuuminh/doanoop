package NhaCungCap;

import java.util.Scanner;

public class QuanLyDanhSachNhaCungCap {
		public void menu() {
				
				Boolean dk=true;
				DanhSachNhaCungCap a=new DanhSachNhaCungCap();
				a.doc();
				while(dk) {
					
					System.out.println("------------MENU QUAN LY NHAN VIEN-------------");
					int luachon;
					System.out.println("1.XEM DANH SACH NHA CUNG CAP");
					System.out.println("2.THEM NHA CUNG CAP");
					System.out.println("3.XOA NHA CUNG CAP");
					System.out.println("4.SUA THONG TIN NHA CUNG CAP");
					System.out.println("5.TIM KIEM NHA CUNG CAP");
					System.out.println("6.THOAT");
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
						System.out.println("1.TIM KIEM THEO MA NHA CUNG CAP");
						System.out.println("2.TIM KIEM THEO TEN NHAN CUNG CAP");
						System.out.println("NHAP LUA CHON");
						luachontimkiem = Integer.parseInt(sc.nextLine());
						switch (luachontimkiem) {
						case 1:
							System.out.println("NHAP MA NHA CUNG CAP");
							String ma=sc.nextLine();
							DanhSachNhaCungCap nccma =a.timMa(ma);
							System.out.println("NHA CUNG CAP THEO MA");
						    nccma.xuat();
							break;
						case 2:
							System.out.println("NHAP TEN NHA CUNG CAP");
							String ten=sc.nextLine();
							DanhSachNhaCungCap nccten =a.timTen(ten);
							System.out.println("NHA CUNG CAP THEO TEN");
						    nccten.xuat();
							break;
					default:
						break;
						}
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
