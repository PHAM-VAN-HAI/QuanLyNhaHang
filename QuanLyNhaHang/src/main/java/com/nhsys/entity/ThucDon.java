package com.nhsys.entity;

public class ThucDon {
    private String maTD;
    private String TenTD;
    private double giaTien;
    private String loai;
    private String hinhAnh;
    private String tgCheBien;

    public ThucDon() {
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
    
    
}
