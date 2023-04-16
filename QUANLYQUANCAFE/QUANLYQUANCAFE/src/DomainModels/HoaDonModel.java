/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author vietv
 */
public class HoaDonModel {

    private String ID;
    private String maHD;
    private String ngayLapHD;
    private double thanhTien;
    private String phuongThucThanhToan;
    private String IDKM;
    private String IDNV;
    private String IDBan;
    private String tinhhTrang;

    public HoaDonModel() {
    }

    public HoaDonModel(String IDBan) {
        this.IDBan = IDBan;
    }

    public HoaDonModel(String maHD, String tinhhTrang) {
        this.maHD = maHD;
        this.tinhhTrang = tinhhTrang;
    }

    public HoaDonModel(String ID, String maHD, String ngayLapHD, double thanhTien, String phuongThucThanhToan, String IDKM, String IDNV, String IDBan, String tinhhTrang) {
        this.ID = ID;
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.IDKM = IDKM;
        this.IDNV = IDNV;
        this.IDBan = IDBan;
        this.tinhhTrang = tinhhTrang;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getIDKM() {
        return IDKM;
    }

    public void setIDKM(String IDKM) {
        this.IDKM = IDKM;
    }

    public String getIDNV() {
        return IDNV;
    }

    public void setIDNV(String IDNV) {
        this.IDNV = IDNV;
    }

    public String getIDBan() {
        return IDBan;
    }

    public void setIDBan(String IDBan) {
        this.IDBan = IDBan;
    }

    public String getTinhhTrang() {
        return tinhhTrang;
    }

    public void setTinhhTrang(String tinhhTrang) {
        this.tinhhTrang = tinhhTrang;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "ID=" + ID + ", maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", thanhTien=" + thanhTien + ", phuongThucThanhToan=" + phuongThucThanhToan + ", IDKM=" + IDKM + ", IDNV=" + IDNV + ", IDBan=" + IDBan + ", tinhhTrang=" + tinhhTrang + '}';
    }

    public Object[] toRowData() {
        return new Object[]{ID, maHD, ngayLapHD, thanhTien, phuongThucThanhToan, IDKM, IDNV, IDBan, tinhhTrang};

    }
}
