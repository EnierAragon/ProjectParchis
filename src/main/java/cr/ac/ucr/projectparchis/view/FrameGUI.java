/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view;

import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author enier
 */
public class FrameGUI extends JFrame {

    GridBagConstraints gbc = new GridBagConstraints();
    PanelMenu panelMenu;

    public FrameGUI() {
        initParameters();
        initComponets();
        this.getContentPane().add(panelMenu, gbc);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void initParameters() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setBackground(Color.yellow);
        this.setPreferredSize(new Dimension(1280, 720));
        this.setMinimumSize(new Dimension(850, 480));
        this.setMaximumSize(new Dimension(2560, 1440));
    }

    private void initComponets() {
        panelMenu = new PanelMenu();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
    }

}
