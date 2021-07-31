package com.nhsys.entity;

public class HoaDon {
    private int maHD;
    private int Maban;
    private double tongTien;
    private String maNV;
    private String tenNV;
    private String ngayTao;
   
    private String TrangThai;

    public HoaDon() {
    }

    public HoaDon(int maHD, int Maban, double tongTien, String maNV, String tenNV, String ngayTao, String TrangThai) {
        this.maHD = maHD;
        this.Maban = Maban;
        this.tongTien = tongTien;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaban() {
        return Maban;
    }

    public void setMaban(int Maban) {
        this.Maban = Maban;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    

   
    
   
}
