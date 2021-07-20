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
public class NhanVien {
    String MaNV;
    String MatKhau;
    String HoTen;
    String SoDT;
    String ChucVu;
    boolean GioiTinh;
    String PathAvatar;

    public NhanVien(String MaNV, String MatKhau, String HoTen, String SoDT, String ChucVu, boolean GioiTinh, String PathAvatar) {
        this.MaNV = MaNV;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.SoDT = SoDT;
        this.ChucVu = ChucVu;
        this.GioiTinh = GioiTinh;
        this.PathAvatar = PathAvatar;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getPathAvatar() {
        return PathAvatar;
    }

    public void setPathAvatar(String PathAvatar) {
        this.PathAvatar = PathAvatar;
    }

   
    
    
}
