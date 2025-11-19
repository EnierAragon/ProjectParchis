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
        super("PanelGameBoar", new Dimension(384, 720));
        initComponets();
        confComponets();

        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    private void initComponets() {
        lbTitleName = new CustLabel("Name");
        lbTitleData = new CustLabel("CurrentAction");
        lbTitleDraw = new CustLabel("DiceNumber");
        lbIconTurn = new CustLabel("StatusIcon");
        lbIconDraw = new CustLabel("DiceIcon");
        btnDraw = new CustButton("btnDraw", "btnDraw", new Dimension(60, 180));
        btnExit = new CustButton("btnExit", "btnExit", new Dimension(60, 60));
    }

    private void confComponets() {
        this.gbc.fill = GridBagConstraints.BOTH;
//        this.gbc.insets = new Insets(30, 150, 60, 150);

        this.gbc.weightx = 1;
        this.gbc.weighty = 1;

        //boton salida
        this.gbc.gridx = 5;
        this.gbc.gridy = 1;
        this.gbc.gridwidth = 2;
        this.gbc.gridheight = 2;
        this.add(btnExit, this.gbc);

        //label nombre
        this.gbc.gridx = 1;
        this.gbc.gridy = 3;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        this.add(lbTitleName, this.gbc);

        //label icono de estado
        this.gbc.gridx = 2;
        this.gbc.gridy = 7;
        this.gbc.gridwidth = 4;
        this.gbc.gridheight = 4;
        this.add(lbIconTurn, this.gbc);

        //label accion actual
        this.gbc.gridx = 1;
        this.gbc.gridy = 12;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 3;
        this.add(lbTitleData, this.gbc);

        //label numero de dado
        this.gbc.gridx = 1;
        this.gbc.gridy = 16;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        this.add(lbTitleDraw, this.gbc);

        //label icono dado
        this.gbc.gridx = 1;
        this.gbc.gridy = 18;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        this.add(lbIconDraw, this.gbc);

        //boton tirada
        this.gbc.gridx = 1;
        this.gbc.gridy = 21;
        this.gbc.gridwidth = 6;
        this.gbc.gridheight = 2;
        this.add(btnDraw, this.gbc);

    }

}
