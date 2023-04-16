/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author ACER
 */
public class SanPham {

    private String id;
    private String maSP;
    private String tenSP;
    private double giaBan;
    private String moTa;
    private String anh;
    private DanhMuc danhMuc;
    private String trangThai;
    private Size size;
    private HoaDonChiTiet hdct;

    public SanPham() {
    }

    public HoaDonChiTiet getHdct() {
        return hdct;
    }

    public void setHdct(HoaDonChiTiet hdct) {
        this.hdct = hdct;
    }

    public SanPham(String maSP, String tenSP, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }

    public SanPham(String tenSP, double giaBan) {
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }

   public SanPham(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham(String id, String maSP, String tenSP, double giaBan, String moTa, DanhMuc danhMuc, String trangThai, Size size) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
        this.size = size;
    }

    public SanPham(String maSP, String tenSP, double giaBan, String moTa, String anh, DanhMuc danhMuc, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.anh = anh;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
    }

    public SanPham(String maSP, String tenSP, double giaBan, String moTa, DanhMuc danhMuc, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
    }

    public SanPham(String maSP, String tenSP, double giaBan, String moTa, DanhMuc danhMuc, String trangThai, Size size) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
        this.size = size;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", moTa=" + moTa + ", anh=" + anh + ", danhMuc=" + danhMuc + ", trangThai=" + trangThai + ", size=" + size + '}';
    }

    public Object[] toRowData() {
        return new Object[]{false, maSP, tenSP};
    }

    public Object[] torowdata1() {
        return new Object[]{false, maSP, tenSP};
    }
}
