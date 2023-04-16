package DomainModels;

public class Ban_HoaDonModel {

    private String IDBan;
    private String IDHD;
    private String tachBan;
    private String gopBan;
    private String tachHD;
    private String gopHD;

    public Ban_HoaDonModel(String IDBan, String IDHD, String tachBan, String gopBan, String tachHD, String gopHD) {
        this.IDBan = IDBan;
        this.IDHD = IDHD;
        this.tachBan = tachBan;
        this.gopBan = gopBan;
        this.tachHD = tachHD;
        this.gopHD = gopHD;
    }

    public Ban_HoaDonModel(String IDBan) {
        this.IDBan = IDBan;
    }

    public Ban_HoaDonModel() {
    }

    public String getIDBan() {
        return IDBan;
    }

    public void setIDBan(String IDBan) {
        this.IDBan = IDBan;
    }

    public String getIDHD() {
        return IDHD;
    }

    public void setIDHD(String IDHD) {
        this.IDHD = IDHD;
    }

    public String getTachBan() {
        return tachBan;
    }

    public void setTachBan(String tachBan) {
        this.tachBan = tachBan;
    }

    public String getGopBan() {
        return gopBan;
    }

    public void setGopBan(String gopBan) {
        this.gopBan = gopBan;
    }

    public String getTachHD() {
        return tachHD;
    }

    public void setTachHD(String tachHD) {
        this.tachHD = tachHD;
    }

    public String getGopHD() {
        return gopHD;
    }

    public void setGopHD(String gopHD) {
        this.gopHD = gopHD;
    }

    @Override
    public String toString() {
        return "Ban_HoaDon{" + "IDBan=" + IDBan + ", IDHD=" + IDHD + ", tachBan=" + tachBan + ", gopBan=" + gopBan + ", tachHD=" + tachHD + ", gopHD=" + gopHD + '}';
    }

}
