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
        menu.removeAll();
        JPanel menuPanel = new NV_Menu(this);
        menuPanel.setSize(220, 663);
        menuPanel.repaint();
        menuPanel.validate();
        menu.add(menuPanel);
        menu.setPreferredSize(new Dimension(220, 663));
        menu.repaint();
        menu.validate();
        controller = new ChuyenMangHinhtroller(MHC);
        controller.setView(jpnSoDoBanQL, lblSoDoBanQL, "NV");
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("SoDoBan", jpnSoDoBanQL, lblSoDoBanQL));
        listItem.add(new DanhMucBean("KhoaSo", jpnDoanhThuQL, lblDoanhThuQL));
        listItem.add(new DanhMucBean("DatBan", jpnDatBanQL, lblDatBanQL));
        controller.setEvent(listItem);
    }

    //fill panel Chức năng
    public void initCN() {
        menu.removeAll();
        JPanel menuPanel = new QL_Menu(this);
        menuPanel.setSize(220, 663);
        menuPanel.repaint();
        menuPanel.validate();
        menu.add(menuPanel);
        menu.setPreferredSize(new Dimension(220, 663));
        menu.repaint();
        menu.validate();
        controller = new ChuyenMangHinhtroller(MHC);
        controller.setView(jpnNhanVienCN, lblNhanVienCN, "CN");
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVienCN, lblNhanVienCN));
        listItem.add(new DanhMucBean("DoanhThu", jpnDoanhThuCN, lblDoanhThuCN));
        listItem.add(new DanhMucBean("ThucDon", jpnThucDonCN, lblThucDonCN));
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
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNV = new javax.swing.JButton();
        btnQL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        MHC = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(10, 10));

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TEXT.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnNV.setBackground(new java.awt.Color(255, 255, 255));
        btnNV.setForeground(new java.awt.Color(255, 51, 0));
        btnNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.png"))); // NOI18N
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });

        btnQL.setBackground(new java.awt.Color(255, 255, 255));
        btnQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CNManager.png"))); // NOI18N
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnNV, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(567, 567, 567)
                .addComponent(jLabel11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTieuDe.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 153, 0));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("SƠ ĐỒ BÀN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe)
                .addContainerGap())
        );

        menu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );

        MHC.setBackground(new java.awt.Color(255, 255, 255));
        MHC.setLayout(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MHC, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MHC, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        initCN();
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
    public static javax.swing.JPanel MHC;
    private javax.swing.JButton btnNV;
    private javax.swing.JButton btnQL;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblTieuDe;
    public static javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables

}
