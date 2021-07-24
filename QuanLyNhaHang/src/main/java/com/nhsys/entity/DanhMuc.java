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
public class DanhMuc {
    int MaDanhmuc;
    String TenDanhmuc;
    String MoTa;

    public DanhMuc(int MaDanhmuc, String TenDanhmuc, String MoTa) {
        this.MaDanhmuc = MaDanhmuc;
        this.TenDanhmuc = TenDanhmuc;
        this.MoTa = MoTa;
    }

    public DanhMuc() {
    }

    public int getMaDanhmuc() {
        return MaDanhmuc;
    }

    public void setMaDanhmuc(int MaDanhmuc) {
        this.MaDanhmuc = MaDanhmuc;
    }

    public String getTenDanhmuc() {
        return TenDanhmuc;
    }

    public void setTenDanhmuc(String TenDanhmuc) {
        this.TenDanhmuc = TenDanhmuc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
