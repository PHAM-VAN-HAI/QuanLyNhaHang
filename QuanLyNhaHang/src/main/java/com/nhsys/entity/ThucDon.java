package com.nhsys.entity;

public class ThucDon {
    private String MaMon;
    private String TenMon;
    private double GiaTien;
    private String HinhAnh;
    private String MaDanhMuc;

    public ThucDon(String MaMon, String TenMon, double GiaTien, String HinhAnh, String MaDanhMuc) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.GiaTien = GiaTien;
        this.HinhAnh = HinhAnh;
        this.MaDanhMuc = MaDanhMuc;
    }

    public ThucDon() {
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(String MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

   
    
    
}
