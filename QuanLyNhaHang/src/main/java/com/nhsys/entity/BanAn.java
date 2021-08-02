package com.nhsys.entity;

public class BanAn {
    private int MaBan;
    private String SoBan;
    private String TrangThai;
    public BanAn() {
    }

    public BanAn(int MaBan, String SoBan, String TrangThai) {
        this.MaBan = MaBan;
        this.SoBan = SoBan;
        this.TrangThai = TrangThai;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public String getSoBan() {
        return SoBan;
    }

    public void setSoBan(String SoBan) {
        this.SoBan = SoBan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
