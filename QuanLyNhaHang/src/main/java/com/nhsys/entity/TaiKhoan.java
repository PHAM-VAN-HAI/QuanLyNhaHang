/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.entity;

/**
 *
 * @author VU
 */
public class TaiKhoan {

    private String TenDN;
    private String matKhau;
    private boolean vaiTro = false;
    
    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public boolean getVaiTro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
