/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietModel {

    private String IDSP;
    private String IDHD;
    private int soLuong;
    private double giaTien;
    private String ghiChu;
    private String topping;

    public HoaDonChiTietModel() {
    }

    public HoaDonChiTietModel(String IDSP, String IDHD, int soLuong) {
        this.IDSP = IDSP;
        this.IDHD = IDHD;
        this.soLuong = soLuong;
    }

    public HoaDonChiTietModel(String IDSP, String IDHD, int soLuong, String topping) {
        this.IDSP = IDSP;
        this.IDHD = IDHD;
        this.soLuong = soLuong;
        this.topping = topping;
    }

    public HoaDonChiTietModel(String IDSP) {
        this.IDSP = IDSP;
    }

    public HoaDonChiTietModel(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public HoaDonChiTietModel(String IDSP, String IDHD, int soLuong, double giaTien, String ghiChu) {
        this.IDSP = IDSP;
        this.IDHD = IDHD;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
    }

    public String getIDHD() {
        return IDHD;
    }

    public void setIDHD(String IDHD) {
        this.IDHD = IDHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
