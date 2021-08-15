/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import com.nhsys.entity.DanhMucBean;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anhha
 */
public class ChuyenMangHinhtrollerTest {
    
    public ChuyenMangHinhtrollerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
   

    /**
     * Test of setView method, of class ChuyenMangHinhtroller.
     */
    @org.junit.jupiter.api.Test
    public void testSetView() {
        System.out.println("setView");
        JPanel jpnItem = null;
        JLabel jlbItem = null;
        String MHC = "";
        ChuyenMangHinhtroller instance = null;
        instance.setView(jpnItem, jlbItem, MHC);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvent method, of class ChuyenMangHinhtroller.
     */
    @org.junit.jupiter.api.Test
    public void testSetEvent() {
        System.out.println("setEvent");
        List<DanhMucBean> listItem = null;
        ChuyenMangHinhtroller instance = null;
        instance.setEvent(listItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
