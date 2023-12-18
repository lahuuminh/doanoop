package PhieuNhap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import NhanVien.DanhSachNhanVien;
import NhanVien.NhanVien;
import hoadon.DanhSachChiTietHoaDon;
import hoadon.DanhSachHoaDon;
import sanpham.DanhSachSanPham;
import sanpham.NuocUong;
import sanpham.QuanLyDanhSachSanPham;
import sanpham.SanPham;
import sanpham.ThucAn;
import until.ValidInput;

public class DanhSachPhieuNhap implements Serializable{
	 private static final long serialVersionUID = 1L;
	private PhieuNhap[] dspn=new PhieuNhap[100];
	private int n;
	public DanhSachPhieuNhap(int n) {
		this.n = n;
	}
	public DanhSachPhieuNhap() {
		this.n = 0;
	}
	public DanhSachPhieuNhap(DanhSachPhieuNhap d) {
		this.n = d.n;
		this.dspn=d.dspn;
	}
	public PhieuNhap[] getDspn() {
		return dspn;
	}
	public void setDspn(PhieuNhap[] dspn) {
		this.dspn = dspn;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	

	@Override
	public String toString() {
		return "DanhSachPhieuNhap [dspn=" + Arrays.toString(dspn) + ", n=" + n + "]";
	}
	public void nhap(){

		Scanner sc=new Scanner(System.in);
		
		
        System.out.println("nhap so phieu nhap");
        n=sc.nextInt();
		

		for (int i=0;i<n;i++){

		dspn[i]=new PhieuNhap();

		dspn[i].nhap();

		}

		}
	public void xuat(){
		String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma phieu","Ngay","Ma nhan vien","Ma nha cung cap","Tong tien");
        System.out.println(header1);
		for (int i=0;i<n;i++){

	        dspn[i].xuat();

		}

		}
	public void them(DanhSachChiTietPhieuNhap dsctpn,DanhSachSanPham dssp){
		Scanner sc=new Scanner(System.in);
		PhieuNhap pn=new PhieuNhap();
		pn.nhap();
//		System.out.println("nhap so luong san pham");
		int soluong=ValidInput.getValidInteger(sc, "nhap so luong san pham");
		double tongtien=0;
		for (int i = 0; i <soluong; i++) {
			ChiTietPhieuNhap ctpn=new ChiTietPhieuNhap();
			ctpn.nhap();
			DanhSachSanPham dsspt=dssp.timMa(ctpn.getMasanpham());
			if(dsspt.getN()==0) {
				System.out.println("khong co san pham nao co ma nay");
				continue;
			}else {
				SanPham sp=dsspt.getDssp()[0];
				double thanhtien=sp.getDongia()*ctpn.getSoluong();
				ctpn.setDongia(sp.getDongia());
				ctpn.setThanhtien(thanhtien);
				ctpn.setMapn(pn.getMaphieu());
				dsctpn.them(ctpn);
				tongtien+=thanhtien;
				sp.setSoluong(sp.getSoluong()+ctpn.getSoluong());
			}
		}
		if(tongtien==0) {
			System.out.println("tao phieu nhap khong thanh cong");
		}else {
			
			pn.setTongtien(tongtien);
			dspn[n]=pn;
			System.out.println("tao phieu nhap thanh cong,phieu nhap cua ban la");
			String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma phieu","Ngay","Ma nhan vien","Ma nha cung cap","Tong tien");
	        System.out.println(header1);
			dspn[n].xuat();
			DanhSachChiTietPhieuNhap temp=dsctpn.timMaPN(pn.getMaphieu());
			temp.xuat();
			n++;
		}
		}
		
		
		
	public void them(PhieuNhap x){
		dspn[n]=new PhieuNhap(x);
		n++;
		}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(dspn[i].getMaphieu().compareTo(ma)==0) {
				return i;
			}
		}
		return -1;
	}
	public void xoa(String ma) {
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co phieu nhap nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dspn[i]=dspn[i+1];
		}
		n--;
	}
	public void xoa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma phieu nhap muon xoa");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co phieu nhap nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dspn[i]=dspn[i+1];
		}
		n--;
		System.out.println("xoa thanh cong");
	}	
	public void suaTheoMa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma phieu nhap muon sua");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co phieu nhap nao co ma nay");
			return ;
		}
		System.out.println("phieu nhap truoc khi sua");
	    dspn[vitri].xuat();
		dspn[vitri]=new PhieuNhap();
		dspn[vitri].nhap();
		System.out.println("sua thanh cong");
		System.out.println("sau khi sua");
		dspn[vitri].xuat();
	}
	public DanhSachPhieuNhap timMaPhieu(String maphieu) {
		DanhSachPhieuNhap pn=new DanhSachPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(dspn[i].getMaphieu().compareTo(maphieu)==0) {
		  pn.them(dspn[i]);
		}
	}
		return pn;
		

	}
	public DanhSachPhieuNhap timNgay(String ngay) {
		DanhSachPhieuNhap pn=new DanhSachPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(dspn[i].getNgay().compareTo(ngay)==0) {
		  pn.them(dspn[i]);
		}
	}
		return pn;
		

	}
	public DanhSachPhieuNhap timMaNhaCungCap(String manhacungcap) {
		DanhSachPhieuNhap pn=new DanhSachPhieuNhap();
		
		for(int i=0;i<n;i++) {
		if(dspn[i].getMancc().compareTo(manhacungcap)==0) {
		  pn.them(dspn[i]);
		}
	}
		return pn;
		

	}

	public void ghi(DanhSachPhieuNhap dspn) {
		 String filePath = "phieunhap.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dspn);

	            System.out.println("GHI FILE THANH CONG");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "phieunhap.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachPhieuNhap data = (DanhSachPhieuNhap) objectInputStream.readObject();

	            // Display the read object
	             this.dspn=data.dspn;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}

}
