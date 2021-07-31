package com.nhsys.entity;

public class ChiTietHoaDon {
    private int maCTHD;
    private String tenTD;
    private String maTD;
    private int maHD;
    private int soLuong;
    private double giatien;
    private double tongTien;
    private String ghiChu;
    private int MaBan;
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maCTHD, String tenTD, String maTD, int maHD, int soLuong, double giatien, double tongTien, String ghiChu, int MaBan) {
        this.maCTHD = maCTHD;
        this.tenTD = tenTD;
        this.maTD = maTD;
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.giatien = giatien;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.MaBan = MaBan;
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getTenTD() {
        return tenTD;
    }

    public void setTenTD(String tenTD) {
        this.tenTD = tenTD;
    }

    public String getMaTD() {
        return maTD;
    }

    public void setMaTD(String maTD) {
        this.maTD = maTD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    
   

    
}
