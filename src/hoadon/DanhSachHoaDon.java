package hoadon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import sanpham.DanhSachSanPham;
import sanpham.SanPham;
import until.ValidInput;
public class DanhSachHoaDon implements Serializable{
	 private static final long serialVersionUID =1L;
	private HoaDon[] dshd=new HoaDon[100];
	private int n;
	public DanhSachHoaDon(int n) {
		this.n = n;
	}
	public DanhSachHoaDon() {
		this.n = 0;
	}
	public DanhSachHoaDon(DanhSachHoaDon d) {
		this.n = d.n;
		this.dshd=d.dshd;
	}
	public HoaDon[] getDshd() {
		return dshd;
	}
	public void setDshd(HoaDon[] dshd) {
		this.dshd = dshd;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "DanhSachHoaDon [dshd=" + Arrays.toString(dshd) + ", n=" + n + "]";
	}

	public void nhap(){

		Scanner sc=new Scanner(System.in);
		
		
        System.out.println("nhap so luong hoa don");
        n=sc.nextInt();
		

		for (int i=0;i<n;i++){

		dshd[i]=new HoaDon();

		dshd[i].nhap();

		}

		}
	public void xuat(){
		String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma hoa don","Ma nhan vien","Ma khach","Ngay lap","Tong tien");
        System.out.println(header1);
		for (int i=0;i<n;i++){

	dshd[i].xuat();;

		}

		}
	public void them(DanhSachSanPham dssp,DanhSachChiTietHoaDon dscthd){
		Scanner sc=new Scanner(System.in);
		HoaDon hd=new HoaDon();
		hd.nhap();
		double tongtien=0;
//		System.out.println("nhap so luong san pham muon mua");
		int sl=ValidInput.getValidInteger(sc,"nhap so luong san pham muon mua");
		for (int i = 0; i < sl; i++) {
			SanPham sp;
			ChiTietHoaDon cthd=new ChiTietHoaDon();
			cthd.nhap();
		    DanhSachSanPham dssptv=dssp.timMa(cthd.getMasp());
			if(dssptv.getN()==0) {
				System.out.println("khong co san pham nao co ma nay");
			  
			}else {
				
				sp=dssptv.getDssp()[0];	
				if(sp.getSoluong()<cthd.getSoluong()) {
					System.out.println("san pham chi con lai:"+sp.getSoluong());
					
				}else {
					sp.setSoluong(sp.getSoluong()-cthd.getSoluong());
					cthd.setMahd(hd.getMa());
					cthd.setDongia(sp.getDongia());
					double thanhtien=sp.getDongia()*cthd.getSoluong()*1.0;
					tongtien+=thanhtien;
					cthd.setThanhtien(thanhtien);
					dscthd.them(cthd);
				}
			}
				
		}
		if(tongtien==0) {
			System.out.println("tao hoa don khong thanh cong");
		}else {
			
			hd.setTongtien(tongtien);
			dshd[n]=hd;
			System.out.println("Tao hoa don thanh cong,hoa don cua ban la");
			String header1 = String.format("%-30s%-30s%-30s%-30s%s","Ma hoa don","Ma nhan vien","Ma khach","Ngay lap","Tong tien");
	        System.out.println(header1);
			dshd[n].xuat();
			System.out.println("Cac mat hang trong hoa don");
			DanhSachChiTietHoaDon temp=dscthd.timMaHd(hd.getMa());
			temp.xuat();
			n++;
		}
		}
	public void them(HoaDon x){
		dshd[n]=new HoaDon(x);
		n++;
		}
	public int tim(String ma) {
		for(int i=0;i<n;i++) {
			if(dshd[i].getMa().compareTo(ma)==0) {
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
			dshd[i]=dshd[i+1];
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
			dshd[i]=dshd[i+1];
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
	    dshd[vitri].xuat();
		dshd[vitri]=new HoaDon();
		dshd[vitri].nhap();
		System.out.println("sua thanh cong");
		System.out.println("sau khi sua");
		dshd[vitri].xuat();
	}
	public DanhSachHoaDon timMaKhach(String ma) {
		DanhSachHoaDon hd=new DanhSachHoaDon();
		
		for(int i=0;i<n;i++) {
		if(dshd[i].getMakhach().compareTo(ma)==0) {
		  hd.them(dshd[i]);
		}
	}
		return hd;
		

	}
	public DanhSachHoaDon timNL(String ngaylap) {
		DanhSachHoaDon hd=new DanhSachHoaDon();
		
		for(int i=0;i<n;i++) {
		if(dshd[i].getNgaylap().compareTo(ngaylap)==0) {
		  hd.them(dshd[i]);
		}
	}
		return hd;
	}
	public DanhSachHoaDon timMaHoaDon(String ma) {
		DanhSachHoaDon hd=new DanhSachHoaDon();
		
		for(int i=0;i<n;i++) {
		if(dshd[i].getMa().compareTo(ma)==0) {
		  hd.them(dshd[i]);
		}
	}
		return hd;
	}
	public DanhSachHoaDon timGiaTien(double gia) {
		DanhSachHoaDon hd=new DanhSachHoaDon();
		
		for(int i=0;i<n;i++) {
		if(dshd[i].getTongtien()>=gia) {
		  hd.them(dshd[i]);
		}
	}
		return hd;
	}

	public void TKQuy() {
		double q1,q2,q3,q4;
		q1=q2=q3=q4=0;
		int year = Year.now().getValue();
		for (int i = 0; i <n; i++) {
			
			int thang,nam;
			String[] temp=dshd[i].getNgaylap().split("/");
			nam=Integer.parseInt(temp[2]);
			thang=Integer.parseInt(temp[1]);
			if(thang<4&&nam==year) {
				q1+=dshd[i].getTongtien();
			}
			else if(thang<7&&nam==year) {
				q2+=dshd[i].getTongtien();
			}
			else if(thang<10&&nam==year) {
				q3+=dshd[i].getTongtien();
			}
			else  if(thang<=12&&nam==year) {
				q4+=dshd[i].getTongtien();
			}
		
		}
		String header=String.format("%-30s%-30s%s","Nam","Quy","Doanh thu");
		System.out.println(header);
		String row1=String.format("%-30s%-30s%.2f","2023","1",q1);
		String row2=String.format("%-30s%-30s%.2f","2023","2",q2);
		String row3=String.format("%-30s%-30s%.2f","2023","3",q3);
		String row4=String.format("%-30s%-30s%.2f","2023","4",q4);
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(row4);
		

		
		
		
	}
	public void ghi(DanhSachHoaDon dshd) {
		 String filePath = "hoadon.dat";

	        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            // Write the array to the file
	        
	            objectOutputStream.writeObject(dshd);

	            System.out.println("GHI FILE THANH CONG");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	}
	public void doc() {
		 String filePath = "hoadon.dat";
		  try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
	            // Read the object from the file
	           DanhSachHoaDon data = (DanhSachHoaDon) objectInputStream.readObject();

	            // Display the read object
	             this.dshd=data.dshd;
	             this.n=data.n;
	            System.out.println("doc thanh cong");
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	}


}
