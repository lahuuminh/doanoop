package NhaCungCap;

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
import khachhang.KhachHang;

public class DanhSachNhaCungCap implements Serializable {
	 private static final long serialVersionUID = 1L;
     private  NhaCungCap[] dsncc=new NhaCungCap[100];
     private int n;
	public DanhSachNhaCungCap(int n) {
		this.n = n;
	}
	public DanhSachNhaCungCap() {
		n=0;
	}
	public DanhSachNhaCungCap(DanhSachNhaCungCap d) {
		this.n=d.n;
		this.dsncc=d.dsncc;
	}
	public NhaCungCap[] getDsncc() {
		return dsncc;
	}
	public void setDsncc(NhaCungCap[] dsncc) {
		this.dsncc = dsncc;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "DanhSachNhaCungCap [dsncc=" + Arrays.toString(dsncc) + ", n=" + n + "]";
	}
	public void nhap(){

		Scanner sc=new Scanner(System.in);
		
		
	    System.out.println("nhap so luong khach hang");
	    n=sc.nextInt();
		

		for (int i=0;i<n;i++){

		dsncc[i]=new NhaCungCap();

		dsncc[i].nhap();

		}
		}
	public void xuat(){
		String header1 = String.format("%-30s%-30s%s","Ma","Ten","Dia chi");
        System.out.println(header1);

		for (int i=0;i<n;i++){

	dsncc[i].xuat();

		}

		}
	public void them(){
		dsncc[n]=new NhaCungCap();
		dsncc[n].nhap();
		n++;
		}
	public void them(NhaCungCap x){
		dsncc[n]=new NhaCungCap(x);
		n++;
		}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(dsncc[i].getMa().compareTo(ma)==0) {
				return i;
			}
		}
		return -1;
	}
	public void xoa(String ma) {
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nha cung cap nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dsncc[i]=dsncc[i+1];
		}
		n--;
	}
	public void xoa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nha cung cap muon xoa");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nha cung cap nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dsncc[i]=dsncc[i+1];
		}
		n--;
		System.out.println("xoa thanh cong");
	}
	public void suaTheoMa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma nha cung cap muon sua");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co nha cung cap nao co ma nay");
			return ;
		}
		System.out.println("nha cung truoc khi sua");
		dsncc[vitri].xuat();
		dsncc[vitri]=new NhaCungCap();
		dsncc[vitri].nhap();
		System.out.println("sua thanh cong");
		System.out.println("sau khi sua");
		dsncc[vitri].xuat();
	}
	public DanhSachNhaCungCap timMa(String ma) {
		DanhSachNhaCungCap ncc=new DanhSachNhaCungCap();
		
		for(int i=0;i<n;i++) {
		if(dsncc[i].getMa().compareTo(ma)==0) {
		  ncc.them(dsncc[i]);
		}
	}
		return ncc;
		

	}
	public DanhSachNhaCungCap timDC(String dc) {
		DanhSachNhaCungCap ncc=new DanhSachNhaCungCap();
		
		for(int i=0;i<n;i++) {
		if(dsncc[i].getDiachi().compareTo(dc)==0) {
		  ncc.them(dsncc[i]);
		}
	}
		return ncc;
		

	}
	public DanhSachNhaCungCap timTen(String ten) {
		DanhSachNhaCungCap ncc=new DanhSachNhaCungCap();
		
		for(int i=0;i<n;i++) {
		if(dsncc[i].getTen().compareTo(ten)==0) {
		  ncc.them(dsncc[i]);
		}
	}
		return ncc;
	}


	public void ghi(DanhSachNhaCungCap dsncc) {
		 String filePath = "nhacungcap.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dsncc);

	            System.out.println("GHI FILE THANH CONG");
	            objectOutputStream.close();
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "nhacungcap.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachNhaCungCap data = (DanhSachNhaCungCap) objectInputStream.readObject();

	            // Display the read object
	             this.dsncc=data.dsncc;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	            objectInputStream.close();
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}
}
