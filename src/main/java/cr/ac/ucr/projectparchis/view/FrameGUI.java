/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view;

import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author enier
 */
public class FrameGUI extends JFrame {

    JDialog popFrame;

    GridBagConstraints gbc = new GridBagConstraints();
    PanelMenu panelMenu;

    public FrameGUI() {
        super();
        initParameters();
        initComponets();
        confComponets();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
//        this.setVisible(true);
        this.pack();

        laterInit();

        //pruebas
//        pop(panelOption);
    }

    public FrameGUI(PanelMenu panel) {
        super();
        initParameters();
        initComponets(panel);
        confComponets();

        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        pack();

        laterInit();

        //pruebas
//        pop(panelOption);
    }

    private void initParameters() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setBackground(Color.yellow);
        this.setPreferredSize(new Dimension(1600, 900));
        this.setMinimumSize(new Dimension(850, 480));
        this.setMaximumSize(new Dimension(2560, 1440));
    }

    private void initComponets() {
        panelMenu = new PanelMenu();
    }

    private void initComponets(PanelMenu panel) {
        panelMenu = panel;
    }

    private void confComponets() {
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.weightx = 1;
        this.gbc.weighty = 1;

        this.getContentPane().add(panelMenu, this.gbc);

    }

    private void laterInit() {
        popFrame = new JDialog(this, "", true);
        popFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        popFrame.setLocationRelativeTo(this);
        popFrame.setSize(800, 400);

    }

    public void panelChange(CustPanel panel) {
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.weightx = 1;
        this.gbc.weighty = 1;
        this.getContentPane().add(panel, this.gbc);
        this.revalidate();
        this.repaint();
    }

    public JPanel pop(JPanel panel) {
        popFrame.getContentPane().removeAll();
        popFrame.add(panel);
        popFrame.revalidate();
        popFrame.repaint();
        popFrame.setVisible(true);
        return panel;
    }

    public void msg(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

}
