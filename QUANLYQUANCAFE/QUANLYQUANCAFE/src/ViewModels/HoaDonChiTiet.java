package ViewModels;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vietv
 */
public class HoaDonChiTiet {

    private SanPham idSP;
    private String idHD;
    private int soLuong;
    private double giaTien;
    private String ghiChu;
    private Topping idTopping;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int soLuong) {
        this.soLuong = soLuong;
    }

    public Topping getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(Topping idTopping) {
        this.idTopping = idTopping;
    }

    public HoaDonChiTiet(SanPham idSP, int soLuong, Topping idTopping, double giaTien) {
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.idTopping = idTopping;
    }

    public HoaDonChiTiet(SanPham idSP, String idHD, int soLuong, double giaTien, String ghiChu) {
        this.idSP = idSP;
        this.idHD = idHD;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
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

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idSP=" + idSP + ", idHD=" + idHD + ", soLuong=" + soLuong + ", giaTien=" + giaTien + ", ghiChu=" + ghiChu + ", idTopping=" + idTopping + '}';
    }

    public Object[] toRowdata() {
        return new Object[]{idSP.getMaSP(), idSP.getTenSP(), soLuong, idSP.getGiaBan(), giaTien};
    }

}
