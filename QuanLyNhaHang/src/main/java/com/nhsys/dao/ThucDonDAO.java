<<<<<<< HEAD<<<<<<< HEAD<<<<<<< HEAD<<<<<<< HEAD
package com.nhsys.dao;

//import com.nhsys.entity.ThanhVien;
import com.nhsys.entity.ThucDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.nhsys.utils.XJdbc;

public class ThucDonDAO extends NHDAO<ThucDon, String> {

    String INSERT_SQL = "INSERT INTO ThucDon(MaTD, TenTD, GiaTien, Loai, HinhAnh, ThoiGianCheBien)VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ThucDon SET  TenTD=?, GiaTien=?, Loai=?, HinhAnh=?, ThoiGianCheBien=? where MaTD = ? ";
    String DELETE_SQL = "DELETE FROM ThucDon WHERE MaTD =?";
    String SELECT_ALL_SQLXM = "SELECT * FROM ThucDon";
    String SELECT_ALL_SQL = "SELECT * FROM ThucDon WHERE Loai like ? and TenTD like ? \n"
            + "or Loai like ? and TenTD like ? ";
    String SELETE_BY_ID_SQL = "SELECT * FROM ThucDon WHERE MaTD =?";
    String SELECT_BY_TEN_SQL = "SELECT * FROM ThucDon WHERE TenTD like ? and TenTD like ? "
            + "or TenTD like ? and TenTD like ?";
    String SELETE_BY_NAME_SQL = "SELECT * FROM ThucDon WHERE TenTD like ?";
    String SELETE_BY_BestSeller_SQL = "select top 10 TD.MaTD, TD.TenTD, TD.GiaTien, TD.Loai, TD.HinhAnh, TD.ThoiGianCheBien from ChiTietHoaDon CT, ThucDon TD where CT.MaTD = TD.MaTD and TD.TenTD like ?  group by TD.MaTD, TD.TenTD ,TD.GiaTien, TD.Loai, TD.HinhAnh, TD.ThoiGianCheBien order by count(CT.MaTD) DESC";
    @Override
    public void insert(ThucDon entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaTD(), entity.getTenTD(), entity.getGiaTien(), entity.getLoai(), entity.getHinhAnh(), entity.getTgCheBien());
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
=======
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

/**
 *
 * @author anhha
 */
public class ThucDonDAO extends NHDAO<ThucDon, String> {

    String INSERT_SQL = "INSERT INTO ThucDon(MaMon, TenMon, GiaTien, HinhAnh, Loai)VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ThucDon SET TenMon=?, GiaTien=?, HinhAnh=?, Loai=? where MaMon = ?";
    String DELETE_SQL = "DELETE FROM ThucDon WHERE MaMon =?";
    String SELECT_ALL_SQL = "SELECT * FROM ThucDon";
    String SELETE_BY_ID_SQL = "SELECT * FROM ThucDon WHERE MaMon =?";

    @Override
    public void insert(ThucDon entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaMon(), entity.getTenMon(), entity.getGiaTien(), entity.getHinhAnh(), entity.getLoai());
        } catch (Exception ex) {
            ex.printStackTrace();
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
        }
    }

    @Override
    public void update(ThucDon entity) {
        try {
<<<<<<< HEAD
            XJdbc.update(UPDATE_SQL, entity.getTenTD(), entity.getGiaTien(), entity.getLoai(), entity.getHinhAnh(), entity.getTgCheBien(), entity.getMaTD());
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
=======
            XJdbc.update(UPDATE_SQL, entity.getTenMon(), entity.getGiaTien(), entity.getHinhAnh(), entity.getLoai(), entity.getMaMon());
        } catch (Exception ex) {
            ex.printStackTrace();
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
<<<<<<< HEAD
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
=======
            ex.printStackTrace();
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
        }
    }

    @Override
    public ThucDon selectById(String id) {
<<<<<<< HEAD
        List<ThucDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
=======
         List<ThucDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

<<<<<<< HEAD
    public List<ThucDon> selectByTen(String ten, String menu) {
        if (menu.contains("A")) {
            return this.selectBySql(SELECT_BY_TEN_SQL, "%" + ten + "%", "%_" + menu + "_", "%" + ten + "%", "%_B_");
        }
        List<ThucDon> list = this.selectBySql(SELECT_BY_TEN_SQL, "%" + ten + "%", "%_" + menu + "_", "", "");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public List<ThucDon> selectByName(String id) {
        List<ThucDon> list = this.selectBySql(SELETE_BY_NAME_SQL, "%" + id + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<ThucDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQLXM);
    }

    public List<ThucDon> selectAllMenu(String loaiTD, String menu) {
        if (menu.contains("A")) {
            return this.selectBySql(SELECT_ALL_SQL, loaiTD, "%_" + menu + "_", loaiTD, "%_B_");
        }
        return this.selectBySql(SELECT_ALL_SQL, loaiTD, "%_" + menu + "_", "", "");
    }

    public List<ThucDon> selectBestSellerMenu(String menu) {
        return this.selectBySql(SELETE_BY_BestSeller_SQL, "%_" + menu + "_");
=======
    @Override
    public List<ThucDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
    }

    @Override
    protected List<ThucDon> selectBySql(String sql, Object... args) {
<<<<<<< HEAD
        List<ThucDon> list = new ArrayList<ThucDon>();
=======
           List<ThucDon> list = new ArrayList<ThucDon>();
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ThucDon enity = new ThucDon();
<<<<<<< HEAD
                enity.setMaTD(rs.getString("MaTD"));
                enity.setTenTD(rs.getString("TenTD"));
                enity.setGiaTien(rs.getFloat("GiaTien"));
                enity.setLoai(rs.getString("Loai"));
                enity.setHinhAnh(rs.getString("HinhAnh"));
                enity.setTgCheBien(rs.getString("ThoiGianCheBien"));
=======
                enity.setMaMon(rs.getString("MaMon"));
                enity.setTenMon(rs.getString("TenMon"));
                enity.setGiaTien(rs.getFloat("GiaTien"));
                enity.setHinhAnh(rs.getString("HinhAnh"));
                enity.setLoai(rs.getString("Loai"));
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
<<<<<<< HEAD

=======
    
    public List<ThucDon> selectByCategory(String category) {
        String sql = "SELECT * FROM ThucDon WHERE Loai like ?";
        return this.selectBySql(sql, "%" + category + "%");
    }

    public List<ThucDon> SearchByDish(String TenMonAn) {
        String sql = "SELECT * FROM ThucDon WHERE TenMon LIKE N'%" + TenMonAn + "%' ";
        return this.selectBySql(sql);
    }
>>>>>>> 61add7f252915e51d3f40000dd468d5e2e64d542
}
