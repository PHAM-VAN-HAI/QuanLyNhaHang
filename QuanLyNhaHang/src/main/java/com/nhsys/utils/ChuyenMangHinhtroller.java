/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import com.nhsys.entity.DanhMucBean;
import com.nhsys.panel.nhanvien.NV_DatBan;
import com.nhsys.panel.nhanvien.NV_SoDoBan;
import com.nhsys.ui.QL_DanhMucJPN;
import com.nhsys.ui.QL_NhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class ChuyenMangHinhtroller {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenMangHinhtroller(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem, String MHC) {
        if (MHC.equals("NV")) {
            kindSelected = "SoDoBan";
        } else {
            kindSelected = "NhanVien";
        }
        jpnItem.setBackground(new Color(255, 153, 51));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new NV_SoDoBan());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }

    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "SoDoBan":
                    node = new NV_SoDoBan();
                    break;
                case "KhoaSo": {
//                    try {
//                        node =new NV_DoanhThuNgay();
//                    } catch (ParseException ex) {
//                        Logger.getLogger(ChuyenMangHinhtroller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                break;
                case "DatBan":
                    node = new NV_DatBan();
                    break;
                case "NhanVien":
//                    node = new QL_NhanVien();
                    break;
                case "DoanhThu":
//                    node = new QL_DoanhThuThang();
                    break;
                case "DanhMuc":
                    node = new QL_DanhMucJPN();
                    break;
                case "ThucDon":
//                    node = new QL_ThucDon();
                    break;
                case "HangHoa":
//                    node = new QL_HangHoa();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(204, 204, 204));
            jlbItem.setBackground(new Color(204, 204, 204));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            jpnItem.setBackground(new Color(204, 204, 204));
            jlbItem.setBackground(new Color(204, 204, 204));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255, 153, 51));
            jlbItem.setBackground(new Color(255, 153, 51));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(204, 204, 204));
                jlbItem.setBackground(new Color(204, 204, 204));
            }
        }

    }

    private void setChangeBackgroud(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(255, 153, 51));
                item.getJlb().setBackground(new Color(247, 167, 77));
            } else {
                item.getJpn().setBackground(new Color(204, 204, 204));
                item.getJlb().setBackground(new Color(204, 204, 204));

            }
        }
    }
}
