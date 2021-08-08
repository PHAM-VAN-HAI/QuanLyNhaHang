/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anhha
 */
public class MovePanel_Dialog extends JPanel {

    private Point startPoint; // Tọa độ của lần nhấp chuột vào form đầu tiên
    private JDialog dialog;

    public MovePanel_Dialog(JDialog dialog) {
        this.dialog = dialog;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // Lấy vị trí của cửa sổ
                int thisX = dialog.getLocation().x;
                int thisY = dialog.getLocation().y;

                // Xác định mức độ di chuyển của con chuột từ tọa độ ban đầu
                int xMoved = e.getX() - startPoint.x;
                int yMoved = e.getY() - startPoint.y;

                // Di chuyển cửa sổ đến vị trí chuột hiện tại
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                dialog.setLocation(X, Y);
            }
        });
    }
}
