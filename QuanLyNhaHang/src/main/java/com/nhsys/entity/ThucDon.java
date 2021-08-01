package com.nhsys.entity;

public class ThucDon {
<<<<<<< HEAD
    private String maTD;
    private String TenTD;
    private double giaTien;
    private String loai;
    private String hinhAnh;
    private String tgCheBien;

    public ThucDon() {
=======
    private String MaMon;
    private String TenMon;
    private double GiaTien;
    private String HinhAnh;
    private String Loai;

    public ThucDon(String MaMon, String TenMon, double GiaTien, String HinhAnh, String Loai) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.GiaTien = GiaTien;
        this.HinhAnh = HinhAnh;
        this.Loai = Loai;
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
    }

    
    public ThucDon(String maTD, String TenTD, double giaTien, String loai, String hinhAnh, String tgCheBien) {
        this.maTD = maTD;
        this.TenTD = TenTD;
        this.giaTien = giaTien;
        this.loai = loai;
        this.hinhAnh = hinhAnh;
        this.tgCheBien = tgCheBien;
    }

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
    }

    public String getTenTD() {
        return TenTD;
    }

    public void setTenTD(String TenTD) {
        this.TenTD = TenTD;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

<<<<<<< HEAD
    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTgCheBien() {
        return tgCheBien;
    }

    public void setTgCheBien(String tgCheBien) {
        this.tgCheBien = tgCheBien;
    }
=======
    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
    
    
}
