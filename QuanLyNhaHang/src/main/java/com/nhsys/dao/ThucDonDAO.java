/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.ThucDon;
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
public class ThucDonDAO extends NHDAO<ThucDon, String> {

    String INSERT_SQL = "INSERT INTO ThucDon(MaMon, TenMon, GiaTien, HinhAnh, MaDanhMuc)VALUES(?,?,?,?,?)";
    String SELECT_ALL_SQLXM = "SELECT * FROM ThucDon";

    @Override
    public void insert(ThucDon entity) {
        try {
//            XJdbc.update(INSERT_SQL, entity.getMaMon(), entity.getTenMon(), entity.getGiaTien(), entity.getHinhAnh(), entity.getMaDanhMuc());
        } catch (Exception ex) {
//            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ThucDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ThucDon selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThucDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQLXM); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<ThucDon> selectBySql(String sql, Object... args) {
        List<ThucDon> list = new ArrayList<ThucDon>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ThucDon enity = new ThucDon();
                enity.setMaMon(rs.getString("MaMon"));
                enity.setTenMon(rs.getString("TenMon"));
                enity.setGiaTien(rs.getFloat("GiaTien"));
                enity.setHinhAnh(rs.getString("HinhAnh"));
                enity.setLoai(rs.getString("Loai"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
