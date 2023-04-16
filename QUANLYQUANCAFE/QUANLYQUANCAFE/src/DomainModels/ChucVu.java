/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author hdo48
 */
public class ChucVu {
    private String ID;
    private String macv;
    private String tenCV;

    public ChucVu(String ID, String macv, String tenCV) {
        this.ID = ID;
        this.macv = macv;
        this.tenCV = tenCV;
    }

    public ChucVu() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "ID=" + ID + ", macv=" + macv + ", tenCV=" + tenCV + '}';
    }
    public Object[] toRowData(){
        return new Object[]{ID,macv,tenCV};
    }
}
