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
        initParameters();
    }

    public CustButton(String name, String actionCommand) {
        initParameters(name, actionCommand);
    }

    public CustButton(String name, String actionCommand, Dimension pref) {
        initParameters(name, actionCommand, pref);
    }

    public CustButton(String name, String actionName, Dimension pref, boolean content) {
        initParameters(name, actionName, pref, content);
    }

    private void initParameters() {
        this.setName("btnDefault");
        this.setActionCommand("btnDefaultComand");
        this.setVisible(true);
    }

    private void initParameters(String name, String actionCommand) {
        this.setName(name);
        this.setActionCommand(actionCommand);
        this.setVisible(true);
    }

    private void initParameters(String name, String actionCommand, Dimension pref) {
        this.setName(name);
        this.setActionCommand(actionCommand);
        this.setPreferredSize(pref);
        this.setVisible(true);
    }

    private void initParameters(String name, String actionName, Dimension pref, boolean border) {
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
