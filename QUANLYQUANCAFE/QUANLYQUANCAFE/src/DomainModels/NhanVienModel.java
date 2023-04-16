/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author hdo48
 */
public class NhanVienModel {
      private String id;
    private String maNV;
    private String tenNV;
    private String ngaySinh;
    private String SDT;
    private String idCV;
     private boolean trangThai;
    private boolean GioiTinh;
    private String diaChi;

    public NhanVienModel(String id, String maNV, String tenNV, String ngaySinh, String SDT, String idCV, boolean trangThai, boolean GioiTinh, String diaChi) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.idCV = idCV;
        this.trangThai = trangThai;
        this.GioiTinh = GioiTinh;
        this.diaChi = diaChi;
    }

    public NhanVienModel(String maNV) {
        this.maNV = maNV;
    }
    

  

    public NhanVienModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "id=" + id + ", maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", idCV=" + idCV + ", trangThai=" + trangThai + ", GioiTinh=" + GioiTinh + ", diaChi=" + diaChi + '}';
    }
    

   
    
}
