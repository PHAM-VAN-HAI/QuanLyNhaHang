package com.nhsys.ui;

import utils.XImage;

public class MonAnPanel extends javax.swing.JPanel {

    public MonAnPanel(String hinh, String ten) {

        initComponents();
        XImage.setHinh(lblHinhAnh, hinh, 244,150);
        lblTen.setText(ten);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinhAnh = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        lblHinhAnh.setBackground(new java.awt.Color(255, 153, 153));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LOGO.png"))); // NOI18N

        lblTen.setBackground(new java.awt.Color(255, 255, 255));
        lblTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTen.setText("Ten mon an");
        lblTen.setFocusCycleRoot(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblTen;
    // End of variables declaration//GEN-END:variables
}
