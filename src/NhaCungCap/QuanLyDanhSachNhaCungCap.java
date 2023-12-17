package NhaCungCap;

import java.util.Scanner;

import until.ValidInput;

public class QuanLyDanhSachNhaCungCap {
		public void menu() {
				
				Boolean dk=true;
				DanhSachNhaCungCap a=new DanhSachNhaCungCap();
				a.doc();
				while(dk) {
					
					System.out.println("------------MENU QUAN LY NHA CUNG CAP-------------");
					int luachon;
					System.out.println("1.XEM DANH SACH NHA CUNG CAP");
					System.out.println("2.THEM NHA CUNG CAP");
					System.out.println("3.XOA NHA CUNG CAP");
					System.out.println("4.SUA THONG TIN NHA CUNG CAP");
					System.out.println("5.TIM KIEM NHA CUNG CAP");
					System.out.println("6.THOAT");
//					System.out.println("NHAP LUA CHON");
					Scanner sc=new Scanner(System.in);
					luachon =ValidInput.getValidInteger(sc,"NHAP LUA CHON");
					switch (luachon) {
					case 1:
						System.out.println("DANH SACH NHA CUNG CAP");
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
							System.out.println("1.TIM KIEM THEO MA NHA CUNG CAP");
							System.out.println("2.TIM KIEM THEO TEN NHAN CUNG CAP");
							System.out.println("3.TIM KIEM THEO DIA CHI NHAN CUNG CAP");
							System.out.println("4.THOAT");
//						System.out.println("NHAP LUA CHON");
							luachontimkiem =ValidInput.getValidInteger(sc,"NHAP LUA CHON");
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
							case 3:
								System.out.println("NHAP DIA CHI NHA CUNG CAP");
								String dc=sc.nextLine();
								DanhSachNhaCungCap nccdc =a.timDC(dc);
								System.out.println("NHA CUNG CAP THEO DIA CHI");
								nccdc.xuat();
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

