package khachhang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import hoadon.DanhSachHoaDon;

public class DanhSachKhachHang implements DanhSachKhachHangI,Serializable {
	 private static final long serialVersionUID = 1L;
  private KhachHang[] dskh=new KhachHang[100];
  private int n;
public DanhSachKhachHang(int n) {
	
	this.n = n;
}
public DanhSachKhachHang() {
	this.n=0;
}
public DanhSachKhachHang(DanhSachKhachHang d) {
	this.dskh=d.dskh;
	this.n=d.n;
	
}
public KhachHang[] getDskh() {
	return dskh;
}
public void setDskh(KhachHang[] dskh) {
	this.dskh = dskh;
}
public int getN() {
	return n;
}
public void setN(int n) {
	this.n = n;
}
@Override
public String toString() {
	return "DanhSachKhachHang [dskh=" + Arrays.toString(dskh) + ", n=" + n + "]";
}
public void nhap(){

	Scanner sc=new Scanner(System.in);
	
	
    System.out.println("nhap so luong khach hang");
    n=sc.nextInt();
	

	for (int i=0;i<n;i++){

	dskh[i]=new KhachHang();

	dskh[i].nhap();

	}
	}
public void xuat(){

	for (int i=0;i<n;i++){

System.out.println(dskh[i]);

	}

	}
public void them(){
	dskh[n]=new KhachHang();
	dskh[n].nhap();
	n++;
	}
public void them(KhachHang x){
	dskh[n]=new KhachHang(x);
	n++;
	}
public int tim(String ma) {
	for(int i=0;i<n;i++) {
		if(dskh[i].getMa().compareTo(ma)==0) {
			return i;
		}
	}
	return -1;
}
public void xoa(String ma) {
	int vitri=tim(ma);
	if(vitri==-1) {
		System.out.println("khong co khach hang nao co ma nay");
		return ;
	}
	for(int i=vitri;i<n;i++) {
		dskh[i]=dskh[i+1];
	}
	n--;
}
public void xoa() {
	Scanner sc=new Scanner(System.in);
	System.out.println("nhap ma khach hang muon xoa");
	String ma=sc.nextLine();
	int vitri=tim(ma);
	if(vitri==-1) {
		System.out.println("khong co khach hang nao co ma nay");
		return ;
	}
	for(int i=vitri;i<n;i++) {
		dskh[i]=dskh[i+1];
	}
	n--;
	System.out.println("xoa thanh cong");
}
public void suaTheoMa() {
	Scanner sc=new Scanner(System.in);
	System.out.println("nhap ma khach hang muon sua");
	String ma=sc.nextLine();
	int vitri=tim(ma);
	if(vitri==-1) {
		System.out.println("khong co khach hang nao co ma nay");
		return ;
	}
	System.out.println("hoa don truoc khi sua");
    dskh[vitri].xuat();
	dskh[vitri]=new KhachHang();
	dskh[vitri].nhap();
	System.out.println("sua thanh cong");
	System.out.println("sau khi sua");
	dskh[vitri].xuat();
}
public DanhSachKhachHang timMa(String ma) {
	DanhSachKhachHang kh=new DanhSachKhachHang();
	
	for(int i=0;i<n;i++) {
	if(dskh[i].getMa().compareTo(ma)==0) {
	  kh.them(dskh[i]);
	}
}
	return kh;
	

}
public DanhSachKhachHang timHo(String ho) {
	DanhSachKhachHang kh=new DanhSachKhachHang();
	
	for(int i=0;i<n;i++) {
	if(dskh[i].getHo().compareTo(ho)==0) {
	  kh.them(dskh[i]);
	}
}
	return kh;
}
public DanhSachKhachHang timSDT(String sdt) {
	DanhSachKhachHang kh=new DanhSachKhachHang();
	
	for(int i=0;i<n;i++) {
	if(dskh[i].getHo().compareTo(sdt)==0) {
	  kh.them(dskh[i]);
	}
}
	return kh;
}
public void TKTen(String ten) {
	int count=0;
	for (int i = 0; i <n; i++) {
		if(dskh[i].getTen().compareTo(ten)==0) {
			count++;
		}
	}
	System.out.println("SO NGUUOI CO TEN "+ten+"la:"+count);
}
public void ghi() {
	 String filePath = "khachhang.dat";

       try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
           // Write the array to the file
       
           objectOutputStream.writeObject(this);

           System.out.println("GHI FILE THANH CONG");
       } catch (IOException e) {
           System.err.println("Error writing to the file: " + e.getMessage());
       }
}
public void doc() {
	 String filePath = "khachhang.dat";
	  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
           // Read the object from the file
          DanhSachKhachHang data = (DanhSachKhachHang) objectInputStream.readObject();

           // Display the read object
            this.dskh=data.dskh;
            this.n=data.n;
           System.out.println("doc thanh cong");
       } catch (IOException | ClassNotFoundException e) {
           System.err.println("Error reading from the file: " + e.getMessage());
       }
}
}
