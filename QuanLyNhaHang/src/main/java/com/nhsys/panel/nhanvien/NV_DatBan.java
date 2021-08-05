package com.nhsys.panel.nhanvien;

import com.nhsys.dao.DatBanDAO;
import com.nhsys.entity.DatBan;
import com.nhsys.utils.Auth;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.XDate;
import com.nhsys.utils.mouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class NV_DatBan extends javax.swing.JPanel {

    public NV_DatBan() {
        initComponents();
        init();
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
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
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        cldNgayDat = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        cboNgayDat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatBan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1109, 593));
        setPreferredSize(new java.awt.Dimension(1109, 593));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/user.png"))); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenKH.setText("Tên Khách Hàng");
        txtTenKH.setBorder(null);
        txtTenKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKHFocusLost(evt);
            }
        });
        txtTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenKHMouseClicked(evt);
            }
        });
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

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

        btnThem.setBackground(new java.awt.Color(255, 153, 51));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("ĐẶT BÀN MỚI");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 51));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA ĐẶT BÀN");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 153, 51));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA ĐẶT BÀN");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        cldNgayDat.setDate(new Date());
        cldNgayDat.setDateFormatString("dd-MM-yyyy");
        cldNgayDat.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cldNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cldNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtMaDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(txtName6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addGap(43, 43, 43))
        );

        tabs.addTab("Cập Nhật", jPanel1);

        jPanel2.setBackground(new java.awt.Color(247, 239, 239));

        cboNgayDat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboNgayDat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày đặt", "Mới nhất ↓", "Cũ nhất  ↑" }));
        cboNgayDat.setBorder(null);
        cboNgayDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNgayDatActionPerformed(evt);
            }
        });

        tblDatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDatBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt bàn", "Mã Bàn", "Mã Khách Hàng", "Ngày Đặt", "Giờ Đặt", "Số người", "Ghi chú", "Mã NV"
            }
        ));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<8;x++){
            tblDatBan.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }

        tblDatBan.setRowHeight(30);

        tblDatBan.getColumnModel().getColumn(0).setPreferredWidth(3);
        tblDatBan.getColumnModel().getColumn(3).setPreferredWidth(3);
        tblDatBan.getColumnModel().getColumn(5).setPreferredWidth(3);
        tblDatBan.getColumnModel().getColumn(7).setPreferredWidth(3);
        tblDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatBan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNgayDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNgayDatActionPerformed

    private void tblDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatBanMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblDatBan.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblDatBanMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!checkVal()) {
            return;
        }
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtName6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName6ActionPerformed

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void txtSoNguoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoNguoiMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtSoNguoi, "Số người");
    }//GEN-LAST:event_txtSoNguoiMouseClicked

    private void txtSoNguoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoNguoiFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtSoNguoi, "Số người");
    }//GEN-LAST:event_txtSoNguoiFocusLost

    private void txtGioDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioDatActionPerformed

    private void txtGioDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGioDatMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtGioDat, "Giờ đặt");
    }//GEN-LAST:event_txtGioDatMouseClicked

    private void txtGioDatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGioDatFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtGioDat, "Giờ đặt");
    }//GEN-LAST:event_txtGioDatFocusLost

    private void txtMaDatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDatBanActionPerformed

    private void txtMaDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaDatBanMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtMaDatBan, "Mã đặt bàn");
    }//GEN-LAST:event_txtMaDatBanMouseClicked

    private void txtMaDatBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaDatBanFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtMaDatBan, "Mã đặt bàn");
    }//GEN-LAST:event_txtMaDatBanFocusLost

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtSDT, "Số điện thoại");
    }//GEN-LAST:event_txtSDTMouseClicked

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtSDT, "Số điện thoại");
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenKHMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtTenKH, "Tên Khách Hàng");
    }//GEN-LAST:event_txtTenKHMouseClicked

    private void txtTenKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtTenKH, "Tên Khách Hàng");
    }//GEN-LAST:event_txtTenKHFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNgayDat;
    private com.toedter.calendar.JDateChooser cldNgayDat;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDatBan;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGioDat;
    private javax.swing.JTextField txtMaDatBan;
    private javax.swing.JTextField txtName6;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
    DatBanDAO dao = new DatBanDAO();
    int row = -1;

    void init() {
        tblDatBan.setDefaultEditor(Object.class, null);
        this.fillTable(); // đổ dữ liệu nhân viên vào bảng
        this.updateStatus(); // cập nhật trạng thái form
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblDatBan.getRowCount() - 1);

        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDatBan.getModel();
        model.setRowCount(0);
        try {
            List<DatBan> list;
            if (cboNgayDat.getSelectedIndex() == 0) {
                list = dao.selectAll();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getHoTenKH(),
                        db.getSDTKH(),
                        db.getNgayDatBan(),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),
                        db.getMaNV(),};
                    model.addRow(row);
                }
            } else if (cboNgayDat.getSelectedIndex() == 1) {
                list = dao.selectByTang();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getHoTenKH(),
                        db.getSDTKH(),
                        db.getNgayDatBan(),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),
                        db.getMaNV(),};
                    model.addRow(row);
                }
            } else {
                list = dao.selectByGiam();
                for (DatBan db : list) {
                    Object[] row = {
                        db.getMaDatBan(),
                        db.getHoTenKH(),
                        db.getSDTKH(),
                        db.getNgayDatBan(),
                        db.getGioDat(),
                        db.getSoNguoi(),
                        db.getGhiChu(),
                        db.getMaNV(),};
                    model.addRow(row);
                }

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    boolean checkVal() {
        Date ngayHT = XDate.toDate(java.time.LocalDate.now().toString(), "yyyy-MM-dd");
        Date ngayNhap = cldNgayDat.getDate();
        if (txtMaDatBan.getText().isEmpty() || txtMaDatBan.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập mã đặt bàn!");
            return false;
        }
        if (txtTenKH.getText().isEmpty() || txtTenKH.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập tên khách hàng!");
            return false;
        }
        if (txtSDT.getText().isEmpty() || txtSDT.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập số điện thoại khách hàng!");
            return false;
        }
        try {
            Integer.valueOf(txtSDT.getText());
            if (txtSDT.getText().length() > 15) {
                MsgBox.alert(this, "Số điện thoại không hợp lệ!");
                return false;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Số điện thoại không hợp lệ!");
            e.printStackTrace();
        }
        if (!ngayNhap.before(ngayHT)) {
            MsgBox.alert(this, "Ngày đăng ký không được lớn hơn ngày hiện tại!");
            return false;
        }
        if (txtGioDat.getText().isEmpty() || txtGioDat.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập giờ đặt!");
            return false;
        } else if (!txtGioDat.getText().matches("\\d{1,2}:\\d{1,2}")) {
            MsgBox.alert(this, "Thời gian không đúng định dạng MM:ss!");
            return false;
        }
        String[] parts = txtGioDat.getText().toString().split(":");
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
        if (txtSoNguoi.getText().isEmpty() || txtSoNguoi.getText().equalsIgnoreCase("")) {
            MsgBox.alert(this, "Bạn chưa nhập số lượng người!");
            return false;
        }
        try {
            Integer.valueOf(txtSoNguoi.getText());
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Số lượng người phải là số tự nhiên");
            return false;
        }
        return true;
    }

    void insert() {
        DatBan db = this.getForm();
        try {
            dao.insert(db); // thêm mới
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        DatBan db = this.getForm();
        try {
            dao.update(db); // cập nhật
            this.fillTable(); // đổ lại bảng
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        String madm = txtMaDatBan.getText();
        try {
            dao.delete(madm);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại!");
        }
    }

    void edit() {
        String madm = (String) tblDatBan.getValueAt(this.row, 0);
        DatBan db = dao.selectById(madm);
        this.setForm(db);
        this.updateStatus();
        tabs.setSelectedIndex(0);
    }

    void clearForm() {
        DatBan db = new DatBan();
        this.setForm(db);
        this.row = -1;
        this.updateStatus();
    }

    void setForm(DatBan db) {
        txtMaDatBan.setText(db.getMaDatBan());
        txtTenKH.setText(db.getHoTenKH());
        txtSDT.setText(db.getSDTKH());
        cldNgayDat.setDate(db.getNgayDatBan());
        txtGioDat.setText(db.getGioDat());
        txtSoNguoi.setText(String.valueOf(db.getSoNguoi()));
        txtGhiChu.setText(db.getGhiChu());
    }

    DatBan getForm() {
        DatBan db = new DatBan();
        db.setMaDatBan(txtMaDatBan.getText());
        db.setHoTenKH(txtTenKH.getText());
        db.setSDTKH(txtSDT.getText());
        db.setNgayDatBan(cldNgayDat.getDate());
        db.setGioDat(txtGioDat.getText());
        db.setSoNguoi(Integer.valueOf(txtSoNguoi.getText()));
        db.setGhiChu(txtGhiChu.getText());
        db.setMaNV(Auth.user.getMaNV());
        return db;
    }
}
