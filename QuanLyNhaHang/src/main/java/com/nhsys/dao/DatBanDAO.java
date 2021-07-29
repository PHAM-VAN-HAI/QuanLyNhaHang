/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.DatBan;
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
public class DatBanDAO extends NHDAO<DatBan, String> {

    String INSERT_SQL = "INSERT INTO DatBan(MaDatBan, MaBan, MaKH, NgayDatBan, GioDat,SoNguoi, GhiChu)VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE DatBan SET MaBan= ?, MaKH= ?, NgayDatBan= ?,GioDat = ?, SoNguoi= ?, GhiChu= ? where MaDatBan= ?";
    String DELETE_SQL = "DELETE FROM DatBan WHERE MaDatBan =?";
    String SELECT_ALL_SQL = "SELECT * FROM DatBan";
    String SELETE_BY_ID_SQL = "SELECT * FROM DatBan WHERE MaDatBan =?";

    @Override
    public void insert(DatBan entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaDatBan(), entity.getMaban(), entity.getMaKH(), entity.getNgayDatBan(), entity.getGioDat(), entity.getSoNguoi(), entity.getGhiChu());
        } catch (Exception ex) {
//            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void update(DatBan entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMaban(), entity.getMaKH(), entity.getNgayDatBan(), entity.getGioDat(), entity.getSoNguoi(), entity.getGhiChu(), entity.getMaDatBan());
        } catch (Exception ex) {
//            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
//            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public DatBan selectById(String id) {
        List<DatBan> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DatBan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<DatBan> selectBySql(String sql, Object... args) {
        List<DatBan> list = new ArrayList<DatBan>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                DatBan entity = new DatBan();
                entity.setMaDatBan(rs.getInt("MaDatBan"));
                entity.setMaban(rs.getString("MaBan"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setNgayDatBan(rs.getString("NgayDatBan"));
                entity.setGioDat(rs.getString("GioDat"));
                entity.setSoNguoi(rs.getInt("SoNguoi"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DatBan> selectByTang() {
        String sql = "select * from DATBAN order by NgayDat desc";
        return this.selectBySql(sql);
    }

    public List<DatBan> selectByGiam() {
        String sql = "select * from DATBAN order by NgayDat asc";
        return this.selectBySql(sql);
    }
}
