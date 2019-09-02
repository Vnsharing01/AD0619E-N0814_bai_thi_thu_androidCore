package vn.itplus.cmnthi;

import java.io.Serializable;

public class CongViec implements Serializable {
    private String TieuDe;
    private String NoiDung;

    public CongViec() {

    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String toString(){
        return "Tiêu Đề: "+ getTieuDe() + "\nNội Dung: "+ getNoiDung();
    }
}
