/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.nhanvien;

import com.nhsys.dao.*;
import com.nhsys.entity.BanAn;
import com.nhsys.entity.ChiTietHoaDon;
import com.nhsys.entity.HoaDon;
import com.nhsys.entity.NhanVien;
import com.nhsys.entity.ThucDon;
import com.nhsys.utils.ButtonRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static com.nhsys.panel.nhanvien.NV_SoDoBan.MABANKH;
import static com.nhsys.ui.HT_Login.MANVLogin;
import com.nhsys.utils.MsgBox;
import java.awt.BorderLayout;

/**
 *
 * @author VU
 */
public class NV_FillMonAn extends javax.swing.JPanel {

    public static String GhiChuYCK;
    public static double tongTien = 0;
    public static boolean isDatMon = true;
    List<ThucDon> DSTD = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH = new ArrayList<>();
    List<JButton> listBt = new ArrayList<>();
    ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
    HoaDonDAO HDdao = new HoaDonDAO();
    public static DefaultTableModel model;
    public static String[] header = {"Tên món", "Số lượng", "Thành tiền", "Thao tác"};
    public static String[] header1 = {"Tên món", "Số lượng", "Thành tiền"};
    List<BanAn> DSBA = new ArrayList<>();
    String MaNV;
    String TenBan;
    int MaBan;
    int MaHD, tienmon = 0, tongtien = 0;

    String tenMenu;
    HoaDon hd;
    Timer t1;

    /**
     * Creates new form QL_MonAn
     */
    public NV_FillMonAn(int maban) {
        initComponents();
        MaBan = maban;
        lblSoBan.setText(Integer.toString(maban));
        FillmonAn(DanhSachMon1);
        DanhSachMon1.setLayout(new FlowLayout(FlowLayout.CENTER));
//        jPanel1.removeAll();
//        jPanel1.setLayout(new BorderLayout());
//        NV_SoDoBan = new NV_SoDoBan();
//        jPanel1.add(NV_SoDoBan);
        jLabel1.updateUI();
    }

    public void FillmonAn(JPanel DanhSachMon) {
        int hMonAn = 0;
        //xóa hết món ăn
        DanhSachMon1.removeAll();
        DSTD = new ThucDonDAO().selectAll();
//        if(loaiTD.equalsIgnoreCase("Best Seller")){
//            DSTD = new ThucDonDAO().selectBestSellerMenu( menu);
//        }
//        else if (TenTD.equals("")) {
//            DSTD = new ThucDonDAO().selectAllMenu(loaiTD, menu);
//        } else {
//            DSTD = new ThucDonDAO().selectByTen(TenTD, menu);
//        }
        //fill món ăn
        if (DSTD != null) {
            for (int i = 0; i < DSTD.size(); i++) {
                DSTD.get(i).getHinhAnh();
                JPanel panelMonAn = new MonAnPanel("logos\\" + DSTD.get(i).getHinhAnh(), DSTD.get(i).getTenMon().split("_")[0]);
                panelMonAn.addMouseListener(new CustomMouseListener(panelMonAn, DSTD.get(i)));
//                JPanel panelMonAn = new MonAnPanel("logos\\" + "kimchi.jpg", "Mực");
                DanhSachMon.add(panelMonAn);
                hMonAn += 80;
            }
        }
        DanhSachMon.setPreferredSize(new Dimension(200, hMonAn));
        DanhSachMon.validate();
        DanhSachMon.repaint();
        DSMon.repaint();
        DSMon.validate();
    }

    public static void fillTableGoiMon(boolean NVThemMonMoi) {
        //nếu nhân có tín hiệu của nhân viên thêm món mới thì mới load database -> để nhanh hơn
        tongTien = 0;
//        if (NVThemMonMoi) {
//            DSCTHDKH = new ChiTietHoaDonDAO().getchiTietHoaDonbySoBan(KHSoBan);
//        }
        if (isDatMon) {
            model = new DefaultTableModel(header, 0);
        } else {
            model = new DefaultTableModel(header1, 0);
        }
        model.setRowCount(0); //Xóa tát cả các hàng trên table
        for (ChiTietHoaDon cthd : DSCTHDKH) {
            double ThanhTien;
            int SoLuong = cthd.getSoLuong();
            double GiaTien = cthd.getGiatien();
            ThanhTien = SoLuong * GiaTien;
            tongTien += ThanhTien;
            Object[] row = {cthd.getTenMon().split("_")[0], SoLuong, ThanhTien};
            model.addRow(row); //Thêm 1 hàng vàoJTable
        }
        tblDSMonAn1.setModel(model);
        tblDSMonAn1.setRowHeight(30);
        tblDSMonAn1.getColumnModel().getColumn(0).setPreferredWidth(150);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < 3; x++) {
            tblDSMonAn1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        txtTongTien.setText("TỔNG TIỀN: " + tongTien);
        //Đây là thêm nút vào table
    }

    public void setTablegoiMon() {
        if (isDatMon) {
            tblDSMonAn1.getColumn("Thao tác").setCellRenderer(new ButtonRenderer());
            tblDSMonAn1.getColumn("Thao tác").setCellEditor(new ButtonEditor(new JCheckBox()));
        }
    }

    class CustomMouseListener implements MouseListener {

        JPanel pn;
        ThucDon td;

        public CustomMouseListener(JPanel pn, ThucDon td) {
            this.pn = pn;
            this.td = td;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (isDatMon) {
                checkTable();
                boolean coMonAn = false;
                int r = -1;
                for (int i = 0; i < tblDSMonAn1.getRowCount(); i++) {
                    if (td.getTenMon().split("_")[0].equals(tblDSMonAn1.getValueAt(i, 0))) {
                        //check xem đã có món ăn trên table chưa
                        coMonAn = true;
                        r = i;
                    }
                }

                ChiTietHoaDon cthd = new ChiTietHoaDon();
                //nếu chưa có thì thêm vào số lượng là 1
                if (!coMonAn) {
                    cthd.setTenMon(td.getTenMon());
                    cthd.setSoLuong(1);
                    cthd.setGiatien(td.getGiaTien());
                    cthd.setMaMon(td.getMaMon());
                    tongTien += td.getGiaTien();
                    DSCTHDKH.add(cthd);
                } else {
                    int soluong = DSCTHDKH.get(r).getSoLuong();
                    soluong = soluong + 1;
                    tongTien += DSCTHDKH.get(r).getGiatien();
                    DSCTHDKH.get(r).setSoLuong(soluong);
                }
                fillTableGoiMon(false);
                setTablegoiMon();
            } else {
//                if (MsgBox.confirm(pn, "Bạn muốn thêm món mới?")) {
//                    NetworkClient.chatToServer(KHSoBan + "-ThemMonAnMoiKH");
//                    MsgBox.alert(null, "Vui lòng đợi nhân viên xác nhận");
//                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pn.setBackground(new Color(255, 153, 51));

        }

        @Override

        public void mouseReleased(MouseEvent e) {
            pn.setBackground(new Color(204, 204, 204));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pn.setBackground(new Color(255, 153, 51));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            pn.setBackground(new Color(204, 204, 204));
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;
        JTable tb;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            //ở đây lấy table nè
            this.tb = table;
            if (isSelected) {
                button.setBackground(new Color(255, 153, 51));
            } else {
                button.setBackground(new Color(255, 153, 51));
            }
            button.setIcon(new ImageIcon("src\\com\\nhsys\\icon\\Delete.png"));
            isPushed = true;
            return button;
        }

        Timer t;

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int r = tb.getSelectedRow();
                if (r > -1) {
                    int soluong = (int) tb.getValueAt(r, 1);
                    if (soluong == 1) {
                        tongTien -= DSCTHDKH.get(r).getGiatien();
                        DSCTHDKH.remove(r);
                    } else {
                        DSCTHDKH.get(r).setSoLuong(soluong - 1);
                        tongTien -= DSCTHDKH.get(r).getGiatien();
                    }
                    t = new Timer(100, (ActionEvent e) -> {
                        checkTable();
                        fillTableGoiMon(false);
                        setTablegoiMon();
                        t.stop();
                    });
                    t.start();
                }
            };
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    //set BG bt
    public void setBackgroundBT(JButton btClick) {
        for (JButton bt : listBt) {
            if (bt.equals(btClick)) {
                btClick.setBackground(new Color(252, 214, 112));
            } else {
                bt.setBackground(new Color(204, 204, 204));
            }
        }
    }

    public void checkTable() {
        t1 = new Timer(100, (e) -> {
            int soRow = tblDSMonAn1.getRowCount();
            if (soRow > 0) {
                btnDatMon.setEnabled(true);

            } else {
                btnDatMon.setEnabled(false);

            }
            t1.stop();
        });
        t1.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnCenter = new javax.swing.JPanel();
        tabs6 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        DSMon = new javax.swing.JScrollPane();
        DanhSachMon1 = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        btnDatMon = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        jCroMonAn = new javax.swing.JScrollPane();
        tblDSMonAn1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblSoBan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 600));

        tabs6.setBackground(new java.awt.Color(255, 229, 153));
        tabs6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabs6.setForeground(new java.awt.Color(255, 153, 51));
        tabs6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        DSMon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DSMon.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        DanhSachMon1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout DanhSachMon1Layout = new javax.swing.GroupLayout(DanhSachMon1);
        DanhSachMon1.setLayout(DanhSachMon1Layout);
        DanhSachMon1Layout.setHorizontalGroup(
            DanhSachMon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        DanhSachMon1Layout.setVerticalGroup(
            DanhSachMon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        DSMon.setViewportView(DanhSachMon1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(DSMon, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearch)
                .addContainerGap())
            .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DSMon, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        tabs6.addTab("GỌI MÓN", jPanel11);

        btnDatMon.setBackground(new java.awt.Color(255, 153, 51));
        btnDatMon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDatMon.setForeground(new java.awt.Color(255, 255, 255));
        btnDatMon.setText("ĐẶT MÓN");
        btnDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatMonActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 153, 51));

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 153, 51));
        txtTongTien.setText(" TỔNG TIỀN: ");
        txtTongTien.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTongTien)
                .addContainerGap())
        );

        jCroMonAn.setBackground(new java.awt.Color(255, 255, 255));

        tblDSMonAn1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDSMonAn1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Số Lượng", "Thành tiền", "Thao tác"
            }
        ));
        jCroMonAn.setViewportView(tblDSMonAn1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Bàn:");

        lblSoBan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblSoBan.setForeground(new java.awt.Color(255, 153, 0));
        lblSoBan.setText("0");

        javax.swing.GroupLayout JpnCenterLayout = new javax.swing.GroupLayout(JpnCenter);
        JpnCenter.setLayout(JpnCenterLayout);
        JpnCenterLayout.setHorizontalGroup(
            JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnCenterLayout.createSequentialGroup()
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnCenterLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnCenterLayout.createSequentialGroup()
                        .addComponent(tabs6, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnCenterLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpnCenterLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpnCenterLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jCroMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        JpnCenterLayout.setVerticalGroup(
            JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnCenterLayout.createSequentialGroup()
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSoBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs6, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnCenterLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jCroMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatMon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnCenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    NV_SoDoBan NV_SoDoBan;
    NhanVienDAO NVDao = new NhanVienDAO();
    List<NhanVien> nvl = new ArrayList<>();
    private void btnDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatMonActionPerformed
        //         TODO add your handling code here:

        System.out.println(MABANKH);
        System.out.println(MANVLogin);
        System.out.println(tongTien);
        NVDao.selectById(MaNV);
        ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();
        if (btnDatMon.getText().equals("ĐẶT MÓN")) {
            isDatMon = false;
            //khi đặt món thì set lại nút

            btnDatMon.setText("CẬP NHẬT");
            //tạo hd mới và set dữ liệu cần thiết
            hd = new HoaDon();
            hd.setNgayTao(java.time.LocalDate.now().toString());
            hd.setMaNV(MANVLogin);
            hd.setMaBan(MABANKH);
//            hd.setTongTien(tongTien);
//            hd.setTrangThai("Chưa thanh toán");
            new HoaDonDAO().insert(hd);
            int mahd;
            //tiếp tục lấy hóa đơn với trạng thái chưa thanh toán và số bàn đúng với số bàn hiện tại
//            List<HoaDon> hd = new HoaDonDAO().selectAllProcL2("Chưa thanh toán", MABANKH);
//            mahd = hd.get(0).getMaHD();
//            System.out.println(mahd);
            //thêm vào hóa đơn chi tiết
            for (ChiTietHoaDon cthd : DSCTHDKH) {
//                cthd.setMaHD(mahd);
                dao.insert(cthd);
            }

//            HoaDon hdmoi = HDdao.selectById(mahd);

            try {
//                hdmoi.setTrangThai("Đã thanh toán");
//                hdmoi.setTongTien(tongTien);
//                HDdao.updateTT(hdmoi);
                MsgBox.alert(this, "Thanh toán thành công");
                reloadSodo(1);
                isDatMon = true;

            } catch (Exception e) {
                System.out.println("Thanh toán thất bại");
                e.printStackTrace();
            }

            fillTableGoiMon(false);
            DSCTHDKH.removeAll(DSCTHDKH);
        }
    }//GEN-LAST:event_btnDatMonActionPerformed

    public void reloadSodo(int i) {
        JpnCenter.removeAll();
        tabs6.removeAll();
        jCroMonAn.removeAll();
        tblDSMonAn1.removeAll();
        switch (i) {
            case 1:
                NV_SoDoBan = new NV_SoDoBan();
                JpnCenter.setLayout(new BorderLayout());
                JpnCenter.add(NV_SoDoBan);
                break;
        }
        JpnCenter.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane DSMon;
    private javax.swing.JPanel DanhSachMon1;
    private javax.swing.JPanel JpnCenter;
    private javax.swing.JButton btnDatMon;
    private javax.swing.JScrollPane jCroMonAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSoBan;
    private javax.swing.JTabbedPane tabs6;
    public static javax.swing.JTable tblDSMonAn1;
    private static javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
