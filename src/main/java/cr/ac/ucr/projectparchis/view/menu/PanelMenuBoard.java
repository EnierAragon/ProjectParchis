/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.menu;

import cr.ac.ucr.projectparchis.view.cust.CustButton;
import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

/**
 *
 * @author enier
 */
public class PanelMenuBoard extends CustPanel {

    protected CustButton btnPlay;
    protected CustButton btnLore;
    protected CustButton btnHowToPlay;
    protected CustButton btnExit;
    protected CustLabel lbIcon;

    public PanelMenuBoard() {
        super("PanelMenuBoard", new Dimension(384, 720));
        initComponets();
        confComponents();
        this.setBackground(Color.GREEN);
    }

    private void initComponets() {
        btnPlay = new CustButton("btnPlay", "btnPlay");
        btnHowToPlay = new CustButton("btnHTP", "btnHTP");
        btnLore = new CustButton("btnLore", "btnLore");
        btnExit = new CustButton("btnExit", "btnExit");
        lbIcon = new CustLabel("Icon", SwingConstants.CENTER);
    }

    private void confComponents() {
        this.gbc.fill = GridBagConstraints.BOTH;

        //icono superior
        this.gbc.insets = new Insets(30, 125, 60, 125);
        
        this.gbc.gridx = 3;
        this.gbc.gridy = 2;
        this.gbc.gridwidth = 2;
        this.gbc.gridheight = 2;
        
        this.gbc.weightx = 0.2;
        this.gbc.weighty = 0.8;
        lbIcon.setBackground(Color.GRAY);
        this.add(lbIcon, this.gbc);

        //botones
        this.gbc.insets = new Insets(0, 60, 30, 60);
        
        this.gbc.gridx = 2;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        
        this.gbc.weightx = 0.5;
        this.gbc.weighty = 0.5;

        //boton play
        this.gbc.gridy = 8;
        this.add(btnPlay, this.gbc);

        //boton HTP
        this.gbc.gridy = 11;
        this.add(btnHowToPlay, this.gbc);

        //boton lore
        this.gbc.gridy = 14;
        this.add(btnLore, this.gbc);

        //boton exit
        this.gbc.insets = new Insets(60, 60, 30, 60);
        
        this.gbc.gridy = 19;
        this.gbc.gridx = 2;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 3;
        
        this.gbc.weightx = 0.5;
        this.gbc.weighty = 0.5;
        this.add(btnExit, this.gbc);

    }

}
