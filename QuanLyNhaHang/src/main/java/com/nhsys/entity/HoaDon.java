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
    
    
}
