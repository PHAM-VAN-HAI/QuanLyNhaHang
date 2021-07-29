package com.nhsys.panel.nhanvien;

import com.nhsys.dao.DatBanDAO;
import com.nhsys.entity.DatBan;
import com.nhsys.utils.Auth;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.XDate;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class NV_DatBan extends javax.swing.JPanel {

    //Biến
    DatBanDAO dao = new DatBanDAO();

    public NV_DatBan() {
        initComponents();
        fillToTable();
    }

    //Hàm    
    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
        model.setRowCount(0);
        try {
            List<DatBan> list;
            if (cboNgayDat.getSelectedIndex() == 0) {
                list = dao.selectAll();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getMaban(),
                        db.getMaKH(),
                        XDate.formatDate(db.getNgayDatBan()),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),};
                    model.addRow(row);
                }
            } else if (cboNgayDat.getSelectedIndex() == 1) {
                list = dao.selectByTang();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getMaban(),
                        db.getMaKH(),
                        XDate.formatDate(db.getNgayDatBan()),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),};
                    model.addRow(row);
                }
            } else {
                list = dao.selectByGiam();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getMaban(),
                        db.getMaKH(),
                        XDate.formatDate(db.getNgayDatBan()),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),};
                    model.addRow(row);
                }

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không thể xóa đặt bàn!");
        } else if (MsgBox.confirm(this, "Bạn thực sự muốn xóa đặt bàn này?")) {
            int[] rows = tblDanhSach.getSelectedRows();
            if (rows.length > 0) {
                for (int row : rows) {
                    String madb = tblDanhSach.getValueAt(row, 0).toString();
                    dao.delete(madb);
                }
                this.fillToTable();
            }
        }
    }

    void edit() {
        if (checkVal()) {
            try {
                for (int i = 0; i < tblDanhSach.getRowCount(); i++) {
                    String madb = (String) tblDanhSach.getValueAt(i, 0);
                    DatBan db = dao.selectById(madb);
                    db.setMaDatBan(Integer.valueOf(String.valueOf(tblDanhSach.getValueAt(i, 0))));
                    db.setMaban(String.valueOf(tblDanhSach.getValueAt(i, 1)));
                    db.setMaKH(Integer.valueOf(String.valueOf(tblDanhSach.getValueAt(i, 2))));
                    String ar[] = String.valueOf(tblDanhSach.getValueAt(i, 3)).split("-");
                    String date = ar[2] + "-" + ar[1] + "-" + ar[0];
                    db.setNgayDatBan(date);
                    db.setGioDat(String.valueOf(tblDanhSach.getValueAt(i, 4)));
                    db.setSoNguoi(Integer.valueOf(String.valueOf(tblDanhSach.getValueAt(i, 5))));
                    db.setGhiChu(String.valueOf(tblDanhSach.getValueAt(i, 6)));
                    dao.update(db);
                }
                MsgBox.alert(this, "Cập nhật đặt bàn thành công!");
            } catch (Exception e) {
//            MsgBox.alert(this, "Lỗi định dạng dữ liệu. Vui lòng kiểm tra lại!");
                e.printStackTrace();
            }
        }
    }

    boolean checkVal() {
        Date ngayHT = XDate.toDate(java.time.LocalDate.now().toString(), "yyyy-MM-dd");
        for (int i = 0; i < tblDanhSach.getRowCount(); i++) {
            Date ngayNhap = XDate.toDate(tblDanhSach.getValueAt(i, 2).toString(), "dd-MM-yyyy");

            if (tblDanhSach.getValueAt(i, 1).toString().isEmpty()) {
                MsgBox.alert(this, "Bạn chưa nhập họ và tên!");
                return false;
            }
            if (tblDanhSach.getValueAt(i, 0).toString().isEmpty()) {
                MsgBox.alert(this, "Bạn chưa nhập mã đặt bàn!");
                return false;
            } else if (tblDanhSach.getValueAt(i, 0).toString().length() > 10) {
                MsgBox.alert(this, "Mã thành đặt bàn tối đa chỉ 10 ký tự!");
                return false;
            }
            if (!ngayNhap.before(ngayHT)) {
                MsgBox.alert(this, "Ngày đăng ký không được lớn hơn ngày hiện tại!");
                return false;
            }
            if (tblDanhSach.getValueAt(i, 3).toString().isEmpty()) {
                MsgBox.alert(this, "Bạn chưa nhập giờ đặt!");
                return false;
            }
            if (!tblDanhSach.getValueAt(i, 3).toString().matches("\\d{1,2}:\\d{1,2}")) {
                MsgBox.alert(this, "Thời gian không đúng định dạng MM:ss!");
                return false;
            }
            String[] parts = tblDanhSach.getValueAt(i, 3).toString().split(":");
            String part1 = parts[0];
            String part2 = parts[1];
            try {
                if (Integer.valueOf(part1) < 0 || Integer.valueOf(part2) < 0 || Integer.valueOf(part1) > 24 || Integer.valueOf(part2) > 60) {
                    MsgBox.alert(this, "Thời gian không đúng định dạng hh:MM!");
                    return false;
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Thời gian không đúng định dạng hh:MM!");
                return false;
            }
            if (tblDanhSach.getValueAt(i, 4).toString().length() > 12) {
                MsgBox.alert(this, "Số điện thoại không đúng định dạng!");
                return false;
            }
            try {
                Integer.valueOf(tblDanhSach.getValueAt(i, 4).toString());

            } catch (Exception e) {
                MsgBox.alert(this, "Số điện thoại không đúng định dạng!");
                return false;
            }

            if (tblDanhSach.getValueAt(i, 5).toString().isEmpty()) {
                MsgBox.alert(this, "Bạn chưa nhập số lượng người!");
                return false;
            }
        }
        return true;

    }
    //end

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cboNgayDat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnDatBan = new javax.swing.JButton();
        btnSuaDatBan = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(247, 239, 239));

        cboNgayDat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboNgayDat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày đặt", "Mới nhất ↓", "Cũ nhất  ↑" }));
        cboNgayDat.setBorder(null);
        cboNgayDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNgayDatActionPerformed(evt);
            }
        });

        tblDanhSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt bàn", "Mã Bàn", "Mã Khách Hàng", "Ngày Đặt", "Giờ Đặt", "Số người", "Ghi chú"
            }
        ));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<8;x++){
            tblDanhSach.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }

        tblDanhSach.setRowHeight(30);

        tblDanhSach.getColumnModel().getColumn(0).setPreferredWidth(3);
        tblDanhSach.getColumnModel().getColumn(3).setPreferredWidth(3);
        tblDanhSach.getColumnModel().getColumn(5).setPreferredWidth(3);
        tblDanhSach.getColumnModel().getColumn(7).setPreferredWidth(3);
        jScrollPane1.setViewportView(tblDanhSach);

        btnXoa.setBackground(new java.awt.Color(255, 153, 51));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deletez.png"))); // NOI18N
        btnXoa.setText("XÓA ĐẶT BÀN");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDatBan.setBackground(new java.awt.Color(255, 153, 51));
        btnDatBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDatBan.setForeground(new java.awt.Color(255, 255, 255));
        btnDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addD.png"))); // NOI18N
        btnDatBan.setText("ĐẶT BÀN MỚI");
        btnDatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatBanActionPerformed(evt);
            }
        });

        btnSuaDatBan.setBackground(new java.awt.Color(255, 153, 51));
        btnSuaDatBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSuaDatBan.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addD.png"))); // NOI18N
        btnSuaDatBan.setText("SỬA ĐẶT BÀN");
        btnSuaDatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDatBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSuaDatBan)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatBan)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cboNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnDatBan)
                    .addComponent(btnSuaDatBan))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNgayDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayDatActionPerformed
        // TODO add your handling code here:
        fillToTable();
    }//GEN-LAST:event_cboNgayDatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatBanActionPerformed
        // TODO add your handling code here:
        try {
//            new NV_DatBanMoi().setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDatBanActionPerformed

    private void btnSuaDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDatBanActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_btnSuaDatBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatBan;
    private javax.swing.JButton btnSuaDatBan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNgayDat;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables
}
