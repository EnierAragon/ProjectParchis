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
        super("PanelMenuBoard", new Dimension(320, 900));
        initComponets();
        confComponents();
        this.setBackground(Color.GREEN);
    }

    private void initComponets() {
        lbIcon = new CustLabel("Icon", new Dimension(180, 180));
        btnPlay = new CustButton("btnPlay", "btnPlay", new Dimension(270, 90));
        btnHowToPlay = new CustButton("btnHTP", "btnHTP", new Dimension(270, 90));
        btnLore = new CustButton("btnLore", "btnLore", new Dimension(270, 90));
        btnExit = new CustButton("btnExit", "btnExit", new Dimension(270, 135));
    }

    private void confComponents() {
//        this.gbc.insets = new Insets(↑, ←, ↓, →);
//        this.gbc.insets = new Insets(0, 0, 0, 0);
        this.gbc.anchor = GridBagConstraints.CENTER;
        this.gbc.weightx = 0;
        this.gbc.weighty = 0;
        this.gbc.gridx = 0;
        this.gbc.gridwidth = 6;

        //icono superior
        this.gbc.insets = new Insets(30, 0, 60, 0);
        this.gbc.gridy = 2;
        this.gbc.gridheight = 2;

        this.add(lbIcon, this.gbc);

        //botones
        this.gbc.insets = new Insets(30, 0, 0, 0);
        this.gbc.gridheight = 2;

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
        this.gbc.insets = new Insets(90, 0, 0, 0);
        this.gbc.gridy = 19;
        this.gbc.gridx = 2;
        this.gbc.gridheight = 3;

        this.add(btnExit, this.gbc);

    }

}
