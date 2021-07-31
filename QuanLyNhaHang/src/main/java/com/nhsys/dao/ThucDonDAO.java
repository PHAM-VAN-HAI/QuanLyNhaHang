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
        }
    }

    @Override
    public void update(ThucDon entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenTD(), entity.getGiaTien(), entity.getLoai(), entity.getHinhAnh(), entity.getTgCheBien(), entity.getMaTD());
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ThucDon selectById(String id) {
        List<ThucDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

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
    }

    @Override
    protected List<ThucDon> selectBySql(String sql, Object... args) {
        List<ThucDon> list = new ArrayList<ThucDon>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ThucDon enity = new ThucDon();
                enity.setMaTD(rs.getString("MaTD"));
                enity.setTenTD(rs.getString("TenTD"));
                enity.setGiaTien(rs.getFloat("GiaTien"));
                enity.setLoai(rs.getString("Loai"));
                enity.setHinhAnh(rs.getString("HinhAnh"));
                enity.setTgCheBien(rs.getString("ThoiGianCheBien"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
