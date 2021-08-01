<<<<<<< HEAD
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
    

   
    
   
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.entity;

/**
 *
 * @author anhha
 */
public class HoaDon {
    int MaHD;
    String NgayTao;
    String TenKH;
    String MaNV;
    String MaBan;
    float TongTien;

    public HoaDon(int MaHD, String NgayTao, String TenKH, String MaNV, String MaBan, float TongTien) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TenKH = TenKH;
        this.MaNV = MaNV;
        this.MaBan = MaBan;
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
    
    
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
}
