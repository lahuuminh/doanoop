package PhieuNhap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import hoadon.DanhSachChiTietHoaDon;
import hoadon.DanhSachHoaDon;

public class DanhSachChiTietPhieuNhap implements Serializable{
	 private static final long serialVersionUID = 1L;
	private ChiTietPhieuNhap[] ctpn=new ChiTietPhieuNhap[100];
    private int n;
    public DanhSachChiTietPhieuNhap() {
		
	}
    public DanhSachChiTietPhieuNhap(DanhSachChiTietPhieuNhap d) {
		this.ctpn=d.ctpn;
		this.n=d.n;
	}
	public DanhSachChiTietPhieuNhap(ChiTietPhieuNhap[] ctpn, int n) {
		
		this.ctpn = ctpn;
		this.n = n;
	}
	@Override
	public String toString() {
		return "DanhSachChiTietPhieuNhap [ctpn=" + Arrays.toString(ctpn) + ", n=" + n + "]";
	}
	public ChiTietPhieuNhap[] getCtpn() {
		return ctpn;
	}
	public void setCtpn(ChiTietPhieuNhap[] ctpn) {
		this.ctpn = ctpn;
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

		ctpn[i]=new ChiTietPhieuNhap();

		ctpn[i].nhap();

		}

		}
	public void xuat(){

		for (int i=0;i<n;i++){

	System.out.println(ctpn[i]);

		}

		}
	public void them(){
		ctpn[n]=new ChiTietPhieuNhap();
		ctpn[n].nhap();
		n++;
		}
	public void them(ChiTietPhieuNhap x){
		ctpn[n]=new ChiTietPhieuNhap(x);
		n++;
		}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(ctpn[i].getMapn().compareTo(ma)==0) {
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
			ctpn[i]=ctpn[i+1];
		}
		n--;
	}
	public void xoa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma hoa don muon xoa");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co hoa don nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			ctpn[i]=ctpn[i+1];
		}
		n--;
		System.out.println("xoa thanh cong");
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
	   ctpn[vitri].xuat();
		ctpn[vitri]=new ChiTietPhieuNhap();
		ctpn[vitri].nhap();
		System.out.println("sua thanh cong");
		System.out.println("sau khi sua");
		ctpn[vitri].xuat();
	}
	public DanhSachChiTietPhieuNhap timMaPN(String ma) {
		DanhSachChiTietPhieuNhap dsctpn=new DanhSachChiTietPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(ctpn[i].getMapn().compareTo(ma)==0) {
		  dsctpn.them(ctpn[i]);
		}
	}
		return dsctpn;
	}
	public DanhSachChiTietPhieuNhap timMaSp(String ma) {
		DanhSachChiTietPhieuNhap dsctpn=new DanhSachChiTietPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(ctpn[i].getMapn().compareTo(ma)==0) {
		  dsctpn.them(ctpn[i]);
		}
	}
		return dsctpn;
	}
	public DanhSachChiTietPhieuNhap timTien(Double tien) {
		DanhSachChiTietPhieuNhap dsctpn=new DanhSachChiTietPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(ctpn[i].getThanhtien()==tien) {
		  dsctpn.them(ctpn[i]);
		}
	}
		return dsctpn;
	}
	public void ghi(DanhSachChiTietPhieuNhap dsctpn) {
		 String filePath = "chitietphieunhap.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dsctpn);

	            System.out.println("GHI FILE THANH CONG");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "chitietphieunhap.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachChiTietPhieuNhap data = (DanhSachChiTietPhieuNhap) objectInputStream.readObject();

	            // Display the read object
	             this.ctpn=data.ctpn;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}

}
