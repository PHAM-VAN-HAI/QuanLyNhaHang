/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.NhanVien;
import com.nhsys.utils.XJdbc;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class NhanVienDAO extends NHDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NHANVIEN(MaNV, TenNV, SDT, Email, NgaySinh, GioiTinh, CMND, VaiTro, DiaChi, Hinh, MatKhau)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NHANVIEN SET TenNV=?, SDT=?, Email=?, NgaySinh=?, GioiTinh=?, CMND=?, VaiTro=?, DiaChi=?, Hinh=?, MatKhau=? where MaNV = ?";
    String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MaNV =?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELETE_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV =?";

    @Override
    public void insert(NhanVien entity) {
//        try {
//            XJdbc.update(INSERT_SQL, entity.getMaNV(), entity.getTenNV(), entity.getSDT(), entity.getEmail(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getCMND(), entity.getVaiTro(), entity.getDiaChi(), entity.getHinh(), entity.getMatKhau());
//        } catch (Exception ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVien selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVien> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
