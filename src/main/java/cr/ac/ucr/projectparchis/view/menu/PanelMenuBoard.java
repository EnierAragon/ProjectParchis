/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.menu;

import cr.ac.ucr.projectparchis.view.cust.CustButton;
import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author enier
 */
public class PanelMenuBoard extends CustPanel {

    private CustButton btnPlay;
    private CustButton btnLore;
    private CustButton btnHowToPlay;
    private CustButton btnExit;
    private CustLabel lbIcon;

    public PanelMenuBoard() {
        super("PanelMenuBoard");
        initComponets();
        confComponents();
        this.setBackground(Color.red);
    }

    private void initComponets() {
        btnPlay = new CustButton("btnPlay", "btnPlay");
        btnHowToPlay = new CustButton("btnHTP", "btnHTP");
        btnLore = new CustButton("btnLore", "btnLore");
        btnExit = new CustButton("btnExit", "btnExit");
        lbIcon = new CustLabel();
    }

    private void confComponents() {
        this.getGbc().fill = GridBagConstraints.BOTH;
        this.getGbc().insets = new Insets(30, 150, 60, 150);
        
        //icono superior
        this.getGbc().gridx = 3;
        this.getGbc().gridy = 2;
        this.getGbc().gridwidth = 2;
        this.getGbc().gridheight = 2;
        this.getGbc().weightx = 0.2;
        this.getGbc().weighty = 0.8;
        lbIcon.setBackground(Color.CYAN);
        this.add(lbIcon, this.getGbc());

        //botones
        this.getGbc().insets = new Insets(0, 60, 30, 60);
        this.getGbc().gridx = 2;
        this.getGbc().gridwidth = 6;
        this.getGbc().gridheight = 2;
        this.getGbc().weightx = 0.5;
        this.getGbc().weighty = 0.5;

        //boton play
        this.getGbc().gridy = 8;
        this.add(btnPlay, this.getGbc());

        //boton HTP
        this.getGbc().gridy = 11;
        this.add(btnHowToPlay, this.getGbc());

        //boton lore
        this.getGbc().gridy = 14;
        this.add(btnLore, this.getGbc());

        //boton exit
        this.getGbc().insets = new Insets(60, 60, 30, 60);
        this.getGbc().gridy = 19;
        this.getGbc().gridx = 2;
        this.getGbc().gridwidth = 6;
        this.getGbc().gridheight = 3;
        this.getGbc().weightx = 0.5;
        this.getGbc().weighty = 0.5;
        this.add(btnExit, this.getGbc());

    }

}
