/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nhsys.entity.TaiKhoan;
import com.nhsys.utils.XJdbc;

/**
 *
 * @author VU
 */
public class TaikhoanDao {

    public TaiKhoan selectByTaiKhoan(String TenDN) {
       String sql="select * from NhanVien where MaNV=?";
        List<TaiKhoan> list = this.selectBySql(sql, TenDN);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    TaiKhoan tk = new TaiKhoan();
                    tk.setTenDN(rs.getString("MaNV"));
                    tk.setMatKhau(rs.getString("HoTen"));
                    tk.setVaiTro(rs.getBoolean("GioiTinh"));
                    list.add(tk);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
