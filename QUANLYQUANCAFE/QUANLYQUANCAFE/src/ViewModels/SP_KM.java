package ViewModels;

import DomainModels.*;

public class SP_KM {

    private SanPham idSP;
    private KhuyenMai idKM;

    public SP_KM() {
    }

    public SP_KM(SanPham idSP, KhuyenMai idKM) {
        this.idSP = idSP;
        this.idKM = idKM;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public KhuyenMai getIdKM() {
        return idKM;
    }

    public void setIdKM(KhuyenMai idKM) {
        this.idKM = idKM;
    }

    @Override
    public String toString() {
        return "SP_KM{" + "idSP=" + idSP + ", idKM=" + idKM + '}';
    }

}
