/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.HoaDon;
import com.nhsys.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class HoaDonDAO extends NHDAO<HoaDon, Integer> {

    String INSERT_SQL = "INSERT INTO HoaDon(NgayTao, TenKhachHang, MaNV, MaBan, TongTien)VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDon SET NgayTao=?, TenKhachHang=?, MaNV=?, MaBan=?, TongTien=? where MaHD = ?";
    String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD =?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    String SELETE_BY_ID_SQL = "SELECT * FROM HoaDon WHERE MaHD =?";

    @Override
    public void insert(HoaDon entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getNgayTao(), entity.getTenKH(), entity.getMaNV(), entity.getMaBan(), entity.getTongTien());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getNgayTao(), entity.getTenKH(), entity.getMaNV(), entity.getMaBan(), entity.getTongTien(), entity.getMaHD());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HoaDon selectById(Integer id) {
           List<HoaDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
          List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HoaDon enity = new HoaDon();
                enity.setMaHD(rs.getInt("MaHD"));
                enity.setNgayTao(rs.getString("NgayTao"));
                enity.setTenKH(rs.getString("TenKhachHang"));
                enity.setMaNV(rs.getString("MaNV"));
                enity.setMaBan(rs.getInt("MaBan"));
                enity.setTongTien(rs.getFloat("TongTien"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
