package NhanVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import hoadon.DanhSachHoaDon;
import khachhang.DanhSachKhachHang;

public class DanhSachNhanVien implements Serializable {
	 private static final long serialVersionUID = 1L;
	private NhanVien[] dsnv=new NhanVien[100];
	private int n;
	public DanhSachNhanVien(int n) {
		this.n = n;
	}
	public DanhSachNhanVien() {
		this.n = 0;
	}
	public DanhSachNhanVien(DanhSachNhanVien d) {
		this.n = d.n;
		this.dsnv=d.dsnv;
	}
	public NhanVien[] getDsnv() {
		return dsnv;
	}
	public void setDsnv(NhanVien[] dsnv) {
		this.dsnv = dsnv;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "DanhSachNhanVien [dsnv=" + Arrays.toString(dsnv) + ", n=" + n + "]";
	}

	public void nhap(){

		Scanner sc=new Scanner(System.in);
		
		
        System.out.println("nhap so nhan vien");
        n=sc.nextInt();
		

		for (int i=0;i<n;i++){

		dsnv[i]=new NhanVien();

		dsnv[i].nhap();

		}

		}
	public void xuat(){
		String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma","Ho","Ten","Ngay sinh","Luong");
        System.out.println(header1);

		for (int i=0;i<n;i++){

	dsnv[i].xuat();

		}

		}
	public void them(){
		dsnv[n]=new NhanVien();
		dsnv[n].nhap();
		n++;
		}
	public void them(NhanVien x){
		dsnv[n]=new NhanVien(x);
		n++;
		}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(dsnv[i].getMa().compareTo(ma)==0) {
				return i;
			}
		}
		return -1;
	}
	public void xoa(String ma) {
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nhan vien nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dsnv[i]=dsnv[i+1];
		}
		n--;
	}
	public void xoa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nhan vien muon xoa");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nhan vien nao co ma nay");
			return;
		}
		for(int i=vitri;i<n;i++) {
			dsnv[i]=dsnv[i+1];
		}
		n--;
		System.out.println("xoa thanh cong");
	}	
	public void suaTheoMa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nhan vien muon sua");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nhan vien nao co ma nay");
			return ;
		}
		System.out.println("nhan vien truoc khi sua");
	    dsnv[vitri].xuat();
		dsnv[vitri]=new NhanVien();
		dsnv[vitri].nhap();
		System.out.println("sua thanh cong");
		System.out.println("sau khi sua");
		dsnv[vitri].xuat();
	}
	DanhSachNhanVien timLuong(float luong) {
		DanhSachNhanVien nv=new DanhSachNhanVien();
		
		for(int i=0;i<n;i++) {
		if(dsnv[i].getLuong()==luong) {
		  nv.them(dsnv[i]);
		}
	}
		return nv;
		

	}
	public DanhSachNhanVien timNgaySinh(String ngay) {
		DanhSachNhanVien nv=new DanhSachNhanVien();

		for(int i=0;i<n;i++) {
			if(dsnv[i].getNgaysinh().compareTo(ngay)==0) {
				nv.them(dsnv[i]);
			}
		}
		return nv;


	}
	public DanhSachNhanVien timnTen(String ten) {
		DanhSachNhanVien nv=new DanhSachNhanVien();

		for(int i=0;i<n;i++) {
			if(dsnv[i].getTen().compareTo(ten)==0) {
				nv.them(dsnv[i]);
			}
		}
		return nv;


	}public DanhSachNhanVien timnyMa(String ma) {
		DanhSachNhanVien nv=new DanhSachNhanVien();

		for(int i=0;i<n;i++) {
			if(dsnv[i].getMa().compareTo(ma)==0) {
				nv.them(dsnv[i]);
			}
		}
		return nv;


	}

	public void ghi(DanhSachNhanVien dsnv) {
		 String filePath = "nhanvien.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dsnv);

	            System.out.println("GHI FILE THANH CONG");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "nhanvien.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachNhanVien data = (DanhSachNhanVien) objectInputStream.readObject();

	            // Display the read object
	             this.dsnv=data.dsnv;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}
}


