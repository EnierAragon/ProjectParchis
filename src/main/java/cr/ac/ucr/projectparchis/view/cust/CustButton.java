/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.cust;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author enier
 */
public class CustButton extends JButton {

    Dimension min = new Dimension(10, 10);
    Dimension max = new Dimension(800, 800);

    public CustButton() {
        this.setName("btnDefault");
        this.setActionCommand("btnDefaultComand");
        this.setVisible(true);
    }

    public CustButton(String text, String actionCommand) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        this.setVisible(true);
    }

    public CustButton(String text, String actionCommand, Dimension pref) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        this.setPreferredSize(pref);
        this.setVisible(true);
    }

    public CustButton(String text, String actionCommand, Dimension pref, Dimension size) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        this.setPreferredSize(pref);
        this.setSize(size);
        this.setVisible(true);
    }

    public CustButton(String name, String actionName, Dimension pref, boolean border) {
        this.setName(name);
        this.setActionCommand(actionName);
        this.setMinimumSize(min);
        this.setMaximumSize(max);
        this.setPreferredSize(pref);
        this.setContentAreaFilled(border);
        this.setBorderPainted(border);
        this.setVisible(true);

    }

}
