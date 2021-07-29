package com.nhsys.panel.nhanvien;

import com.nhsys.dao.DatBanDAO;
import com.nhsys.entity.DatBan;
import com.nhsys.utils.Auth;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.XDate;
import com.nhsys.utils.mouseEvent;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnDatBan = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSuaDatBan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtMaDatBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtGioDat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtName6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        cldNgayDat = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        cboNgayDat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN ĐẶT BÀN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel4.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

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
        jPanel4.add(btnDatBan);

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
        jPanel4.add(btnXoa);

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
        jPanel4.add(btnSuaDatBan);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtName.setText("Mã Khách Hàng");
        txtName.setBorder(null);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/user.png"))); // NOI18N

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSDT.setText("Số điện thoại");
        txtSDT.setBorder(null);
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSDTMouseClicked(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/phone-call.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/calendarB24.png"))); // NOI18N

        txtMaDatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaDatBan.setText("Mã đặt bàn");
        txtMaDatBan.setBorder(null);
        txtMaDatBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaDatBanFocusLost(evt);
            }
        });
        txtMaDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaDatBanMouseClicked(evt);
            }
        });
        txtMaDatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDatBanActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/coding.png"))); // NOI18N

        txtGioDat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtGioDat.setText("Giờ đặt");
        txtGioDat.setBorder(null);
        txtGioDat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGioDatFocusLost(evt);
            }
        });
        txtGioDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGioDatMouseClicked(evt);
            }
        });
        txtGioDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioDatActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/clock.png"))); // NOI18N

        txtSoNguoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoNguoi.setText("Số người");
        txtSoNguoi.setBorder(null);
        txtSoNguoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoNguoiFocusLost(evt);
            }
        });
        txtSoNguoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoNguoiMouseClicked(evt);
            }
        });
        txtSoNguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/users.png"))); // NOI18N

        txtName6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtName6.setText("Ghi chú của khách hàng:");
        txtName6.setBorder(null);
        txtName6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName6ActionPerformed(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        cldNgayDat.setDateFormatString("dd-MM-yyyy");
        cldNgayDat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cldNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtName6)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cldNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(txtName6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập Nhật", jPanel1);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh Sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtName, "Họ và tên");
    }//GEN-LAST:event_txtNameFocusLost

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtName, "Họ và tên");
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtSDT, "Số điện thoại");
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtSDT, "Số điện thoại");
    }//GEN-LAST:event_txtSDTMouseClicked

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtMaDatBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaDatBanFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtMaDatBan, "Mã đặt bàn");
    }//GEN-LAST:event_txtMaDatBanFocusLost

    private void txtMaDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaDatBanMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtMaDatBan, "Mã đặt bàn");
    }//GEN-LAST:event_txtMaDatBanMouseClicked

    private void txtMaDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDatBanActionPerformed

    private void txtGioDatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGioDatFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtGioDat, "Giờ đặt");
    }//GEN-LAST:event_txtGioDatFocusLost

    private void txtGioDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGioDatMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtGioDat, "Giờ đặt");
    }//GEN-LAST:event_txtGioDatMouseClicked

    private void txtGioDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioDatActionPerformed

    private void txtSoNguoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoNguoiFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtSoNguoi, "Số người");
    }//GEN-LAST:event_txtSoNguoiFocusLost

    private void txtSoNguoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoNguoiMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtSoNguoi, "Số người");
    }//GEN-LAST:event_txtSoNguoiMouseClicked

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void txtName6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatBan;
    private javax.swing.JButton btnSuaDatBan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNgayDat;
    private com.toedter.calendar.JDateChooser cldNgayDat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGioDat;
    private javax.swing.JTextField txtMaDatBan;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName6;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNguoi;
    // End of variables declaration//GEN-END:variables
}
