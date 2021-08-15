/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.nhanvien;

import com.nhsys.ui.HT_DoiMatKhau;
import com.nhsys.ui.HT_Login;
import com.nhsys.ui.ManHinhChinh;
import static com.nhsys.ui.ManHinhChinh.lblTieuDe;
import com.nhsys.utils.MsgBox;

/**
 *
 * @author Hai Tran
 */
public class NV_Menu extends javax.swing.JPanel {

    /**
     * Creates new form QL_MenuMHC
     */
    public NV_Menu(ManHinhChinh parent) {
        initComponents();
        this.parent = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnDoanhThuQL = new javax.swing.JPanel();
        lblDoanhThuQL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpnSoDoBanQL = new javax.swing.JPanel();
        lblSoDoBanQL = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblDoiMatKhau = new javax.swing.JLabel();
        jpnDatBanQL = new javax.swing.JPanel();
        lblDatBanQL = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jpnDoanhThuQL.setBackground(new java.awt.Color(204, 204, 204));
        jpnDoanhThuQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnDoanhThuQLMouseClicked(evt);
            }
        });

        lblDoanhThuQL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDoanhThuQL.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThuQL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuQL.setText("DOANH THU");
        lblDoanhThuQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoanhThuQLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnDoanhThuQLLayout = new javax.swing.GroupLayout(jpnDoanhThuQL);
        jpnDoanhThuQL.setLayout(jpnDoanhThuQLLayout);
        jpnDoanhThuQLLayout.setHorizontalGroup(
            jpnDoanhThuQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDoanhThuQL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        jpnDoanhThuQLLayout.setVerticalGroup(
            jpnDoanhThuQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDoanhThuQL, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Documents\\Tai Lieu\\MonHoc-DuAn1\\Du-An-1\\QuanLyNhaHang\\logos\\logo.png")); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(250, 250));
        jLabel9.setMinimumSize(new java.awt.Dimension(250, 250));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jpnSoDoBanQL.setBackground(new java.awt.Color(204, 204, 204));

        lblSoDoBanQL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSoDoBanQL.setForeground(new java.awt.Color(255, 255, 255));
        lblSoDoBanQL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoDoBanQL.setText("SƠ ĐỒ BÀN");
        lblSoDoBanQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoDoBanQLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnSoDoBanQLLayout = new javax.swing.GroupLayout(jpnSoDoBanQL);
        jpnSoDoBanQL.setLayout(jpnSoDoBanQLLayout);
        jpnSoDoBanQLLayout.setHorizontalGroup(
            jpnSoDoBanQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoDoBanQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSoDoBanQLLayout.setVerticalGroup(
            jpnSoDoBanQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSoDoBanQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoDoBanQL, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        lblDoiMatKhau.setBackground(new java.awt.Color(204, 204, 204));
        lblDoiMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoiMatKhau.setText("  ĐỔI MẬT KHẨU");
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );

        jpnDatBanQL.setBackground(new java.awt.Color(204, 204, 204));
        jpnDatBanQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnDatBanQLMouseClicked(evt);
            }
        });

        lblDatBanQL.setBackground(new java.awt.Color(204, 204, 204));
        lblDatBanQL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDatBanQL.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBanQL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatBanQL.setText("ĐẶT BÀN");
        lblDatBanQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatBanQLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnDatBanQLLayout = new javax.swing.GroupLayout(jpnDatBanQL);
        jpnDatBanQL.setLayout(jpnDatBanQLLayout);
        jpnDatBanQLLayout.setHorizontalGroup(
            jpnDatBanQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDatBanQL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnDatBanQLLayout.setVerticalGroup(
            jpnDatBanQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDatBanQL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 82, 82));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        lblDangXuat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("  ĐĂNG XUẤT");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnDatBanQL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnDatBanQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnDoanhThuQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnSoDoBanQL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jpnSoDoBanQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDoanhThuQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblDoanhThuQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuQLMouseClicked
        // TODO add your handling code here:
        lblTieuDe.setText("DANH SÁCH HÓA ĐƠN");
    }//GEN-LAST:event_lblDoanhThuQLMouseClicked

    private void jpnDoanhThuQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDoanhThuQLMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jpnDoanhThuQLMouseClicked

    private void lblSoDoBanQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoDoBanQLMouseClicked
        // TODO add your handling code here:
        lblTieuDe.setText("SƠ ĐỒ BÀN");
    }//GEN-LAST:event_lblSoDoBanQLMouseClicked
    public static ManHinhChinh parent;

    private void lblDatBanQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatBanQLMouseClicked
        lblTieuDe.setText("DANH SÁCH ĐẶT BÀN");
    }//GEN-LAST:event_lblDatBanQLMouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        
    }//GEN-LAST:event_jPanel10MouseClicked

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        // TODO add your handling code here:
        try {
            new HT_DoiMatKhau().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi:"+e);
        }
    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    private void jpnDatBanQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDatBanQLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnDatBanQLMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        try {
            if (MsgBox.confirm(parent, "Bạn có muốn đăng xuất ?")) {
                new HT_Login().setVisible(true);
                parent.dispose();
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JPanel jpnDatBanQL;
    public static javax.swing.JPanel jpnDoanhThuQL;
    public static javax.swing.JPanel jpnSoDoBanQL;
    private javax.swing.JLabel lblDangXuat;
    public static javax.swing.JLabel lblDatBanQL;
    public static javax.swing.JLabel lblDoanhThuQL;
    private javax.swing.JLabel lblDoiMatKhau;
    public static javax.swing.JLabel lblSoDoBanQL;
    // End of variables declaration//GEN-END:variables
}
