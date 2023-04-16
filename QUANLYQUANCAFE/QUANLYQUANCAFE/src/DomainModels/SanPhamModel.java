/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ACER
 */
public class SanPhamModel {

    private String id;
    private String maSP;
    private String tenSP;
    private double giaBan;
    private String moTa;
    private String anh;
    private String idSize;
    private String idCB;
    private String idDM;
    private String trangThai;
    private String idKM;

    public SanPhamModel(String idKM) {
        this.idKM = idKM;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public SanPhamModel() {
    }

    public SanPhamModel(String maSP, String tenSP, double giaBan, String moTa, String idDM, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.idDM = idDM;
        this.trangThai = trangThai;
    }

    public SanPhamModel(String id, String maSP, String tenSP, double giaBan, String moTa, String anh, String idSize, String idCB, String idDM, String trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.anh = anh;
        this.idSize = idSize;
        this.idCB = idCB;
        this.idDM = idDM;
        this.trangThai = trangThai;
    }

    public SanPhamModel(String maSP, String tenSP, double giaBan, String moTa, String idSize, String idDM, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.idSize = idSize;
        this.idDM = idDM;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdCB() {
        return idCB;
    }

    public void setIdCB(String idCB) {
        this.idCB = idCB;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
