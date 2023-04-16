/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Admin
 */
public class ToppingModel {

    private String id;
    private String topping;
    private double giaTien;
    private String trangThai;

    public ToppingModel() {
    }

    public ToppingModel(String id, String topping, double giaTien, String trangThai) {
        this.id = id;
        this.topping = topping;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ToppingModel(String topping, double giaTien, String trangThai) {
        this.topping = topping;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

}
