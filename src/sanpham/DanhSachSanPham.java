package sanpham;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import hoadon.DanhSachHoaDon;
import hoadon.HoaDon;






public  class DanhSachSanPham implements Serializable {
	 private static final long serialVersionUID = 1L;
	private  SanPham[] dssp=new SanPham[100];
	private int n;
	public DanhSachSanPham( int n) {
		this.n = n;
	}
	public DanhSachSanPham() {
		this.n=0;
	}
	public DanhSachSanPham(DanhSachSanPham d) {
		this.dssp=d.dssp;
		this.n=d.n;
	}
	public SanPham[] getDssp() {
		return dssp;
	}
	public void setDssp(SanPham[] dssp) {
		this.dssp = dssp;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "DanhSachSanPham [dssp=" + Arrays.toString(dssp) + ", n=" + n + "]";
	}
	public void nhap(){

		Scanner sc=new Scanner(System.in);
		
		
        System.out.println("nhap so luong san pham");
        n=sc.nextInt();
		

		for (int i=0;i<n;i++){
		    System.out.println("1.Nhap thuc an");
			System.out.println("2.Nhap nuoc uong");
			int luachon=sc.nextInt();
			if(luachon==1) {
				dssp[i]=new ThucAn();
				dssp[i].nhap();
				
			   
			}else {
				dssp[i]=new NuocUong();
				dssp[i].nhap();
				
			}

		

		}

		}
	public void xuat(){

		for (int i=0;i<n;i++){

	if(dssp[i] instanceof ThucAn) {
		ThucAn a=new ThucAn();
		a=(ThucAn)dssp[i];
		a.xuat();
	}
	if(dssp[i] instanceof NuocUong) {
		
		NuocUong b=new NuocUong();
		b=(NuocUong)dssp[i];
		b.xuat();
		
	}

		}

		}
	public void them(){
		System.out.println("1.Nhap thuc an");
		System.out.println("2.Nhap nuoc uong");
		Scanner sc=new Scanner(System.in);
		int luachon=sc.nextInt();
		if(luachon==1) {
			
			dssp[n]=new ThucAn();
			dssp[n].nhap();
			n++;
		}else {
			dssp[n]=new NuocUong();
			dssp[n].nhap();
			n++;
		}
		}
	public void them(ThucAn a){
			dssp[n]=a;
			
			n++;
	}
	public void them(NuocUong a){
		dssp[n]=a;
		
		n++;
}
	public void them(SanPham a){
		dssp[n]=a;
		
		n++;
}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(dssp[i].getMa().compareTo(ma)==0) {
				return i;
			}
		}
		return -1;
	}
	public void xoa(String ma) {
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co san pham nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dssp[i]=dssp[i+1];
		}
		n--;
	}
	public void xoa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma san phamm muon xoa");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co san pham nao co ma nay");
			return ;
		}
		for(int i=vitri;i<n;i++) {
			dssp[i]=dssp[i+1];
		}
		n--;
		System.out.println("xoa thanh cong");
	}	
	
	public void suaTheoMa() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap ma san pham muon sua");
		String ma=sc.nextLine();
		int vitri=tim(ma);
		if(vitri==-1) {
			System.out.println("khong co san pham nao co ma nay");
			return ;
		}
		
		if(dssp[vitri] instanceof ThucAn) {
			
		
	
		dssp[vitri].nhap();
		dssp[vitri].xuat();
		}
		if(dssp[vitri] instanceof NuocUong) {
			
			
		
			
			dssp[vitri].nhap();
			dssp[vitri].xuat();
			
		}
	  
	}
	public DanhSachSanPham timTen(String ten) {
		DanhSachSanPham sp=new DanhSachSanPham();
		
			for(int i=0;i<n;i++) {
			if(dssp[i].getTen().compareTo(ten)==0) {
				sp.them(dssp[i]);
			}
		}
			return sp;

	}
	public DanhSachSanPham timMa(String ma) {
		DanhSachSanPham sp=new DanhSachSanPham();
		
		for(int i=0;i<n;i++) {
		if(dssp[i].getMa().compareTo(ma)==0) {
		  sp.them(dssp[i]);
		}
	}
		return sp;
		

	}
	public DanhSachSanPham timGia(double gia1,double gia2) {
		DanhSachSanPham sp=new DanhSachSanPham();
		
		for(int i=0;i<n;i++) {
		if(dssp[i].getDongia()>=gia1&&dssp[i].getDongia()<=gia2) {
		  sp.them(dssp[i]);
		}
	}
		return sp;
		

	}
	public void ghi(DanhSachSanPham dspn) {
		 String filePath = "sanpham.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dspn);

	            System.out.println("GHI FILE THANH CONG");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "sanpham.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachSanPham data = (DanhSachSanPham) objectInputStream.readObject();

	            // Display the read object
	             this.dssp=data.dssp;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}
}
