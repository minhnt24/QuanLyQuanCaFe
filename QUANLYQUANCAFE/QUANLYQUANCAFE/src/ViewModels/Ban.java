/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class Ban {

    private String id;
    private String maBan;
    private String tenBan;
    private String moTa;
    private String loaiBan;
    private KhuVuc IDKV;
    private String trangThai;

    public Ban() {
    }

    public Ban(String id) {
        this.id = id;
    }

    public Ban(String maBan, String tenBan) {
        this.maBan = maBan;
        this.tenBan = tenBan;
    }

    public Ban(String tenBan, String loaiBan, String trangThai) {
        this.tenBan = tenBan;
        this.loaiBan = loaiBan;
        this.trangThai = trangThai;
    }

    public Ban(String id, String maBan, String tenBan, String moTa, String loaiBan, KhuVuc IDKV) {
        this.id = id;
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;

    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Ban(String maBan, String tenBan, String moTa, String loaiBan, KhuVuc IDKV, String trangThai) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.moTa = moTa;
        this.loaiBan = loaiBan;
        this.IDKV = IDKV;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoaiBan() {
        return loaiBan;
    }

    public void setLoaiBan(String loaiBan) {
        this.loaiBan = loaiBan;
    }

    public KhuVuc getIDKV() {
        return IDKV;
    }

    public void setIDKV(KhuVuc IDKV) {
        this.IDKV = IDKV;
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", maBan=" + maBan + ", tenBan=" + tenBan + ", moTa=" + moTa + ", loaiBan=" + loaiBan + ", IDKV=" + IDKV + ", trangThai=" + trangThai + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maBan, tenBan, moTa, loaiBan, IDKV.getTenKV(),trangThai};
    }

    public Object[] toRowDataTT() {
        return new Object[]{tenBan, loaiBan, trangThai};
    }

}
