package DomainModels;

public class SP_KM {

    private String idSP;
    private String idKM;

    public SP_KM() {
    }

    public SP_KM(String idSP, String idKM) {
        this.idSP = idSP;
        this.idKM = idKM;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    @Override
    public String toString() {
        return "SP_KM{" + "idSP=" + idSP + ", idKM=" + idKM + '}';
    }

}
