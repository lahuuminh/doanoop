package hoadon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import PhieuNhap.DanhSachPhieuNhap;

public class DanhSachChiTietHoaDon implements Serializable {
	 private static final long serialVersionUID = 1L;
   private ChiTietHoaDon[] dscthd=new ChiTietHoaDon[1000];
   private int n;
public DanhSachChiTietHoaDon(ChiTietHoaDon[] dscthd, int n) {

	this.dscthd = dscthd;
	this.n = n;
}
public DanhSachChiTietHoaDon() {
	
}
public DanhSachChiTietHoaDon(DanhSachChiTietHoaDon d) {
	this.dscthd=d.dscthd;
	this.n=d.n;
	
}
public ChiTietHoaDon[] getDscthd() {
	return dscthd;
}
public void setDscthd(ChiTietHoaDon[] dscthd) {
	this.dscthd = dscthd;
}
public int getN() {
	return n;
}
public void setN(int n) {
	this.n = n;
}
public void nhap(){

	Scanner sc=new Scanner(System.in);
	
	
    System.out.println("nhap so luong hoa don");
    n=sc.nextInt();
	

	for (int i=0;i<n;i++){

	dscthd[i]=new ChiTietHoaDon();

	dscthd[i].nhap();

	}

	}
public void xuat(){
	String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma hoa don","Ma san pham","So luong","Don gia","Thanh tien");
    System.out.println(header1);
	for (int i=0;i<n;i++){

dscthd[i].xuat();;

	}

	}
public void them(){
	dscthd[n]=new ChiTietHoaDon();
	dscthd[n].nhap();
	n++;
	}
public void them(ChiTietHoaDon x){
	dscthd[n]=new ChiTietHoaDon (x);
	n++;
	}
public int tim(String ma) {
	for(int i=0;i<=n;i++) {
		if(i==n) {
			return -2;
		}
		if(dscthd[i].getMahd().compareTo(ma)==0) {
			return i;
		}
	}
	return -1;
}
public void xoa(String ma) {
	int vitri=tim(ma);
	if(vitri==-1) {
		System.out.println("khong co hoa don nao co ma nay");
		return ;
	}
	for(int i=vitri;i<n;i++) {
		dscthd[i]=dscthd[i+1];
	}
	n--;
}
public void xoa() {
	Scanner sc=new Scanner(System.in);
	System.out.println("nhap ma hoa don muon xoa");
	String ma=sc.nextLine();
	System.out.println(ma);
	Boolean flag=true;
	
	while(flag) {
		int vitri=tim(ma);
		if(vitri==-1) {
			
		}else if(vitri==-2){
			flag=false;
		}
		else{
			for(int i=vitri;i<n;i++) {
				dscthd[i]=dscthd[i+1];
			}
			n--;
		}
	}
System.out.println(1);
}	
public void suaTheoMa() {
	Scanner sc=new Scanner(System.in);
	System.out.println("nhap ma hoa don muon sua");
	String ma=sc.nextLine();
	int vitri=tim(ma);
	if(vitri==-1) {
		System.out.println("khong co hoa don nao co ma nay");
		return ;
	}
	System.out.println("hoa don truoc khi sua");
   dscthd[vitri].xuat();
	dscthd[vitri]=new ChiTietHoaDon();
	dscthd[vitri].nhap();
	System.out.println("sua thanh cong");
	System.out.println("sau khi sua");
	dscthd[vitri].xuat();
}
public DanhSachChiTietHoaDon timMaHd(String ma) {
	DanhSachChiTietHoaDon cthd=new DanhSachChiTietHoaDon();
	
	for(int i=0;i<n;i++) {
	if(dscthd[i].getMahd().compareTo(ma)==0) {
	  cthd.them(dscthd[i]);
	}
}
	return cthd;
}
public DanhSachChiTietHoaDon timMaSp(String ma) {
	DanhSachChiTietHoaDon cthd=new DanhSachChiTietHoaDon();
	
	for(int i=0;i<n;i++) {
	if(dscthd[i].getMasp().compareTo(ma)==0) {
	  cthd.them(dscthd[i]);
	}
}
	return cthd;
}
public DanhSachChiTietHoaDon timTien(double tien) {
	DanhSachChiTietHoaDon cthd=new DanhSachChiTietHoaDon();
	
	for(int i=0;i<n;i++) {
	if(dscthd[i].getThanhtien()==tien) {
	  cthd.them(dscthd[i]);
	}
}
	return cthd;
}
public void ghi(DanhSachChiTietHoaDon dscthd) {
	 String filePath = "chitiethoadon.dat";

       try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
           // Write the array to the file
       
           objectOutputStream.writeObject(dscthd);

           System.out.println("GHI FILE THANH CONG");
       } catch (IOException e) {
           System.err.println("Error writing to the file: " + e.getMessage());
       }
}
public void doc() {
	 String filePath = "chitiethoadon.dat";
	  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
           // Read the object from the file
          DanhSachChiTietHoaDon data = (DanhSachChiTietHoaDon) objectInputStream.readObject();

           // Display the read object
            this.dscthd=data.dscthd;
            this.n=data.n;
           System.out.println("doc thanh cong");
       } catch (IOException | ClassNotFoundException e) {
           System.err.println("Error reading from the file: " + e.getMessage());
       }
}

}