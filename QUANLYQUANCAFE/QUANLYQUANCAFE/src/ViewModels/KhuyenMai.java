package ViewModels;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vietv
 */
public class KhuyenMai {

    private String ID;
    private String maKM;
    private String tenKM;
    private String hinhThucGG;
    private double mucGiam;
    private String tgBatDau;
    private String tgKetThuc;
    private String trangThai;
    private String moTa;

    public KhuyenMai() {
    }

    public KhuyenMai(String ID, String maKM, String tenKM, String hinhThucGG, double mucGiam, String tgBatDau, String tgKetThuc, String trangThai, String moTa) {
        this.ID = ID;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.hinhThucGG = hinhThucGG;
        this.mucGiam = mucGiam;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public KhuyenMai(String maKM, String tenKM, String hinhThucGG, double mucGiam, String tgBatDau, String tgKetThuc, String trangThai, String moTa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.hinhThucGG = hinhThucGG;
        this.mucGiam = mucGiam;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public KhuyenMai(double mucGiam) {
        this.mucGiam = mucGiam;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getHinhThucGG() {
        return hinhThucGG;
    }

    public void setHinhThucGG(String hinhThucGG) {
        this.hinhThucGG = hinhThucGG;
    }

    public double getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(double mucGiam) {
        this.mucGiam = mucGiam;
    }

    public String getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(String tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public String getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(String tgKetThuc) {
        this.tgKetThuc = tgKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "ID=" + ID + ", maKM=" + maKM + ", tenKM=" + tenKM + ", hinhThucGG=" + hinhThucGG + ", mucGiam=" + mucGiam + ", tgBatDau=" + tgBatDau + ", tgKetThuc=" + tgKetThuc + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }

    public Object[] toRowData() {
        return new Object[]{ID, maKM, tenKM, hinhThucGG, mucGiam, tgBatDau, tgKetThuc, trangThai, moTa};
    }
}
