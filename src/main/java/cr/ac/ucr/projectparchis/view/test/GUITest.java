/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.test;

import javax.swing.JFrame;

/**
 *
 * @author enier
 */
public class GUITest extends JFrame {

    PanelTest pTest;

    public GUITest() {
        pTest = new PanelTest();
        this.setSize(400, 400);
        this.getContentPane().add(pTest);
    }

    public PanelTest getPanelTest() {
        return pTest;
    }

}
