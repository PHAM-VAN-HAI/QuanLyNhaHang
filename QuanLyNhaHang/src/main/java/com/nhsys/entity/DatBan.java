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
public class DatBan {

    int MaDatBan;
    String Maban;
    int MaKH;
    String NgayDatBan;
    String GioDat;
    int SoNguoi;
    String GhiChu;

    public DatBan(int MaDatBan, String Maban, int MaKH, String NgayDatBan, String GioDat, int SoNguoi, String GhiChu) {
        this.MaDatBan = MaDatBan;
        this.Maban = Maban;
        this.MaKH = MaKH;
        this.NgayDatBan = NgayDatBan;
        this.GioDat = GioDat;
        this.SoNguoi = SoNguoi;
        this.GhiChu = GhiChu;
    }

    public DatBan() {
    }

    public int getMaDatBan() {
        return MaDatBan;
    }

    public void setMaDatBan(int MaDatBan) {
        this.MaDatBan = MaDatBan;
    }

    public String getMaban() {
        return Maban;
    }

    public void setMaban(String Maban) {
        this.Maban = Maban;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayDatBan() {
        return NgayDatBan;
    }

    public void setNgayDatBan(String NgayDatBan) {
        this.NgayDatBan = NgayDatBan;
    }

    public String getGioDat() {
        return GioDat;
    }

    public void setGioDat(String GioDat) {
        this.GioDat = GioDat;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    

}
