/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.entity;

import java.util.Date;

/**
 *
 * @author anhha
 */
public class HangHoa {
    String MaHangHoa;
    String TenHangHoa;
    Date NgayNhap;
    String DonVi;
    float SoLuong;
    float ChiPhi;
    float TongChiPhi;

    public HangHoa(String MaHangHoa, String TenHangHoa, Date NgayNhap, String DonVi, float SoLuong, float ChiPhi, float TongChiPhi) {
        this.MaHangHoa = MaHangHoa;
        this.TenHangHoa = TenHangHoa;
        this.NgayNhap = NgayNhap;
        this.DonVi = DonVi;
        this.SoLuong = SoLuong;
        this.ChiPhi = ChiPhi;
        this.TongChiPhi = TongChiPhi;
    }

    public HangHoa() {
    }

    public String getMaHangHoa() {
        return MaHangHoa;
    }

    public void setMaHangHoa(String MaHangHoa) {
        this.MaHangHoa = MaHangHoa;
    }

    public String getTenHangHoa() {
        return TenHangHoa;
    }

    public void setTenHangHoa(String TenHangHoa) {
        this.TenHangHoa = TenHangHoa;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getChiPhi() {
        return ChiPhi;
    }

    public void setChiPhi(float ChiPhi) {
        this.ChiPhi = ChiPhi;
    }

    public float getTongChiPhi() {
        return TongChiPhi;
    }

    public void setTongChiPhi(float TongChiPhi) {
        this.TongChiPhi = TongChiPhi;
    }
    
    
}
