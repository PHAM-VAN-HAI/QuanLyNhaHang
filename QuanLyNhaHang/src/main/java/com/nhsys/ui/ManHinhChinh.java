package com.nhsys.ui;

import com.nhsys.entity.DanhMucBean;
import com.nhsys.panel.nhanvien.NV_Menu;
import static com.nhsys.panel.nhanvien.NV_Menu.jpnDatBanQL;
import static com.nhsys.panel.nhanvien.NV_Menu.jpnDoanhThuQL;
import static com.nhsys.panel.nhanvien.NV_Menu.jpnSoDoBanQL;
import static com.nhsys.panel.nhanvien.NV_Menu.lblDatBanQL;
import static com.nhsys.panel.nhanvien.NV_Menu.lblDoanhThuQL;
import static com.nhsys.panel.nhanvien.NV_Menu.lblSoDoBanQL;
import com.nhsys.panel.quanly.QL_Menu;
import static com.nhsys.panel.quanly.QL_Menu.jpnDoanhThuCN;
import static com.nhsys.panel.quanly.QL_Menu.jpnHangHoaCN;
import static com.nhsys.panel.quanly.QL_Menu.jpnNhanVienCN;
import static com.nhsys.panel.quanly.QL_Menu.jpnThucDonCN;
import static com.nhsys.panel.quanly.QL_Menu.lblDanhMucCN;
import static com.nhsys.panel.quanly.QL_Menu.lblDoanhThuCN;
import static com.nhsys.panel.quanly.QL_Menu.lblHangHoaCN;
import static com.nhsys.panel.quanly.QL_Menu.lblNhanVienCN;
import static com.nhsys.panel.quanly.QL_Menu.lblThucDonCN;
import com.nhsys.utils.ChuyenMangHinhtroller;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import static com.nhsys.panel.quanly.QL_Menu.jpnDanhMucCN;

public class ManHinhChinh extends javax.swing.JFrame {

    //biến
    static ChuyenMangHinhtroller controller;
    Timer t;
//    public static NV_XemMon frmXemMon;

    //Hàm ======================================================================
    //Hàm ======================================================================
    //Hàm ======================================================================
    //fill Panel Quản lý
    public void initQL() {
        jpnMenubar.removeAll();
        JPanel menuPanel = new NV_Menu(this);
        menuPanel.setSize(250, 663);
        menuPanel.repaint();
        menuPanel.validate();
        jpnMenubar.add(menuPanel);
        jpnMenubar.setPreferredSize(new Dimension(250, 663));
        jpnMenubar.repaint();
        jpnMenubar.validate();
        controller = new ChuyenMangHinhtroller(jpnMain);
        controller.setView(jpnSoDoBanQL, lblSoDoBanQL, "NV");
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("SoDoBan", jpnSoDoBanQL, lblSoDoBanQL));
        listItem.add(new DanhMucBean("KhoaSo", jpnDoanhThuQL, lblDoanhThuQL));
        listItem.add(new DanhMucBean("DatBan", jpnDatBanQL, lblDatBanQL));
        controller.setEvent(listItem);
    }

    //fill panel Chức năng
    public void initNV() {
        jpnMenubar.removeAll();
        JPanel menuPanel = new QL_Menu(this);
        menuPanel.setSize(260, 663);
        menuPanel.repaint();
        menuPanel.validate();
        jpnMenubar.add(menuPanel);
        jpnMenubar.setPreferredSize(new Dimension(260, 663));
        jpnMenubar.repaint();
        jpnMenubar.validate();
        controller = new ChuyenMangHinhtroller(jpnMain);
        controller.setView(jpnNhanVienCN, lblNhanVienCN, "QL");
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVienCN, lblNhanVienCN));
        listItem.add(new DanhMucBean("DoanhThu", jpnDoanhThuCN, lblDoanhThuCN));
        listItem.add(new DanhMucBean("ThucDon", jpnThucDonCN, lblThucDonCN));
        listItem.add(new DanhMucBean("DanhMuc", jpnDanhMucCN, lblDanhMucCN));
        listItem.add(new DanhMucBean("HangHoa", jpnHangHoaCN, lblHangHoaCN));
        controller.setEvent(listItem);
    }

    //end ======================================================================
    public ManHinhChinh(boolean isManager) {
        initComponents();
        if (isManager) {
            initQL();
        } else {
            initQL();
            btnNV.setIcon(null);
            btnQL.setIcon(null);
            btnNV.setBackground(new Color(255, 153, 51));
            btnQL.setBackground(new Color(255, 153, 51));
            btnNV.setBorder(null);
            btnQL.setBorder(null);
            btnNV.setEnabled(false);
            btnQL.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jpnSystem = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNV = new javax.swing.JButton();
        btnQL = new javax.swing.JButton();
        jpnTitle = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        jpnMenubar = new javax.swing.JPanel();
        jpnMain = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(10, 10));

        jpnSystem.setBackground(new java.awt.Color(255, 153, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnNV.setBackground(new java.awt.Color(255, 255, 255));
        btnNV.setForeground(new java.awt.Color(255, 51, 0));
        btnNV.setText("Home");
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });

        btnQL.setBackground(new java.awt.Color(255, 255, 255));
        btnQL.setText("Quản Lý");
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnSystemLayout = new javax.swing.GroupLayout(jpnSystem);
        jpnSystem.setLayout(jpnSystemLayout);
        jpnSystemLayout.setHorizontalGroup(
            jpnSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSystemLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnNV, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(567, 567, 567)
                .addComponent(jLabel11))
        );
        jpnSystemLayout.setVerticalGroup(
            jpnSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnSystemLayout.createSequentialGroup()
                .addGroup(jpnSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jpnTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTieuDe.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 153, 0));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("SƠ ĐỒ BÀN");

        javax.swing.GroupLayout jpnTitleLayout = new javax.swing.GroupLayout(jpnTitle);
        jpnTitle.setLayout(jpnTitleLayout);
        jpnTitleLayout.setHorizontalGroup(
            jpnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTitleLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        jpnTitleLayout.setVerticalGroup(
            jpnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe)
                .addContainerGap())
        );

        jpnMenubar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnMenubarLayout = new javax.swing.GroupLayout(jpnMenubar);
        jpnMenubar.setLayout(jpnMenubarLayout);
        jpnMenubarLayout.setHorizontalGroup(
            jpnMenubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );
        jpnMenubarLayout.setVerticalGroup(
            jpnMenubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpnMain.setBackground(new java.awt.Color(255, 255, 255));
        jpnMain.setLayout(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMenubar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnMenubar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVActionPerformed
        // TODO add your handling code here:
        initQL();
    }//GEN-LAST:event_btnNVActionPerformed

    private void btnQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLActionPerformed
        // TODO add your handling code here:
        initNV();
    }//GEN-LAST:event_btnQLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NV_ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NV_ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NV_ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NV_ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChinh(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNV;
    private javax.swing.JButton btnQL;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JPanel jpnMain;
    public static javax.swing.JPanel jpnMenubar;
    private javax.swing.JPanel jpnSystem;
    private javax.swing.JPanel jpnTitle;
    public static javax.swing.JLabel lblTieuDe;
    // End of variables declaration//GEN-END:variables

}
