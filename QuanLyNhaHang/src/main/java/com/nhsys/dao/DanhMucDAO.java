/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.DanhMuc;
import com.nhsys.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhha
 */
public class DanhMucDAO extends NHDAO<DanhMuc, String> {

    //String INSERT_SQL = "INSERT INTO DanhMuc(MaDanhMuc, TenDanhMuc, MoTa)VALUES(? ,? ,?)";
    String INSERT_SQL = "INSERT INTO DanhMuc(MaDanhMuc, TenDanhMuc, MoTa)VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE DanhMuc SET TenDanhMuc=?, MoTa=? where MaDanhMuc = ?";
    String DELETE_SQL = "DELETE FROM DanhMuc WHERE MaDanhMuc = ?";
    String SELECT_ALL_SQL = "SELECT * FROM DanhMuc";
    String SELETE_BY_ID_SQL = "SELECT * FROM DanhMuc WHERE MaDanhMuc = ?";

    @Override
    public void insert(DanhMuc entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaDanhmuc(), entity.getTenDanhmuc(), entity.getMoTa());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(DanhMuc entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenDanhmuc(), entity.getMoTa(), entity.getMaDanhmuc());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DanhMuc selectById(String id) {
        List<DanhMuc> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DanhMuc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> list = new ArrayList<DanhMuc>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                DanhMuc enity = new DanhMuc();
                enity.setMaDanhmuc(rs.getString("MaDanhMuc"));
                enity.setTenDanhmuc(rs.getString("TenDanhMuc"));
                enity.setMoTa(rs.getString("MoTa"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DanhMuc> selectByOrderD() {
        String sql = "SELECT * FROM DanhMuc ORDER BY TenDanhMuc desc";
        return this.selectBySql(sql);
    }

    public List<DanhMuc> selectByOrderA() {
        String sql = "SELECT * FROM DanhMuc ORDER BY TenDanhMuc ASC";
        return this.selectBySql(sql);
    }

    public List<DanhMuc> timNhanVienTheoTenDM(String TenDanhMuc) {
        String sql = "SELECT * FROM DanhMuc WHERE TenDanhMuc LIKE N'%" + TenDanhMuc + "%' ";
        return this.selectBySql(sql);
    }

}
