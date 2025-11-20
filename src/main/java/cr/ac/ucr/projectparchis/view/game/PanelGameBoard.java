/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

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
public class PanelGameBoard extends CustPanel {

    protected CustLabel lbTitleName;
    protected CustLabel lbTitleData;
    protected CustLabel lbTitleDraw;
    protected CustLabel lbIconTurn;
    protected CustLabel lbIconDraw;
    protected CustButton btnExit;
    protected CustButton btnDraw;

    public PanelGameBoard() {
        super("PanelGameBoar", new Dimension(320, 900));
        initComponets();
        confComponets();

        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    private void initComponets() {
//        lbTitleName = new CustLabel("Name", new Dimension(180, 60));
//        lbTitleData = new CustLabel("CurrentAction", new Dimension(180, 90));
//        lbTitleDraw = new CustLabel("DiceNumber", new Dimension(180, 60));
//        lbIconTurn = new CustLabel("StatusIcon", new Dimension(120, 120));
//        lbIconDraw = new CustLabel("DiceIcon", new Dimension(180, 60));
//        btnDraw = new CustButton("btnDraw", "btnDraw", new Dimension(180, 60));
//        btnExit = new CustButton("btnExit", "btnExit", new Dimension(60, 60));
        
        lbTitleName = new CustLabel("Name", new Dimension(270, 90));
        lbTitleData = new CustLabel("CurrentAction", new Dimension(270, 135));
        lbTitleDraw = new CustLabel("DiceNumber", new Dimension(270, 45));
        lbIconTurn = new CustLabel("StatusIcon", new Dimension(180, 180));
        lbIconDraw = new CustLabel("DiceIcon", new Dimension(150, 150));
        btnDraw = new CustButton("btnDraw", "btnDraw", new Dimension(270, 90));
        btnExit = new CustButton("btnExit", "btnExit", new Dimension(90, 90));
    }

    private void confComponets() {
//        this.gbc.insets = new Insets(↑, ←, ↓, →);
//        this.gbc.insets = new Insets(0, 0, 0, 0);

        this.gbc.weightx = 0;
        this.gbc.weighty = 0;
        this.gbc.gridx = 0;
        this.gbc.gridwidth = 6;

        //boton salida
        this.gbc.anchor = GridBagConstraints.EAST;

        this.gbc.gridy = 0;
        this.gbc.gridheight = 2;
        this.add(btnExit, this.gbc);

        this.gbc.anchor = GridBagConstraints.CENTER;

        //label nombre
        this.gbc.gridy = 3;
        this.gbc.gridheight = 2;
        this.add(lbTitleName, this.gbc);

        //label icono de estado
        this.gbc.insets = new Insets(20, 0, 0, 0);
        this.gbc.gridy = 7;
        this.gbc.gridheight = 4;
        this.add(lbIconTurn, this.gbc);

        //label accion actual
        this.gbc.gridy = 12;
        this.gbc.gridheight = 3;
        this.add(lbTitleData, this.gbc);

        //label numero de dado
        this.gbc.gridy = 16;
        this.gbc.gridheight = 1;
        this.add(lbTitleDraw, this.gbc);

        //label icono dado
        this.gbc.insets = new Insets(0, 0, 0, 0);
        this.gbc.gridy = 18;
        this.gbc.gridheight = 2;
        this.add(lbIconDraw, this.gbc);

        //boton tirada
        this.gbc.insets = new Insets(25, 0, 0, 0);
        this.gbc.gridy = 21;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        this.add(btnDraw, this.gbc);

    }

}
