/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.options;

import cr.ac.ucr.projectparchis.view.cust.CustButton;
import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author enier
 */
public class PanelOption extends CustPanel {

    CustPanel container1;
    CustPanel container2;

    CustButton btnStart;

    CustLabel lbTitleTeam;
    CustLabel lbTitleName;

    JTextField txtName;

    ButtonGroup grup;
    JRadioButton rBtnBlue;
    JRadioButton rBtnGreen;
    JRadioButton rBtnWhite;
    JRadioButton rBtnBlack;

    public PanelOption() {
        super("Selection", new Dimension(800, 400));
        initParameters();
        confComponets();
        confPanel1();
        confPanel2();
    }

    private void initParameters() {
        container1 = new CustPanel("container1", new Dimension(400, 400));
        container2 = new CustPanel("container2", new Dimension(400, 400));
        container1.setBackground(Color.BLUE);
        container2.setBackground(Color.GREEN);

        btnStart = new CustButton("Empezar", "btnStart", new Dimension(240, 90));

        lbTitleName = new CustLabel("Nombre:", new Dimension(240, 60));
        lbTitleTeam = new CustLabel("Equipo", new Dimension(240, 60));

        txtName = new JTextField("");
        txtName.setPreferredSize(new Dimension(240, 40));

        rBtnBlack = new JRadioButton("Negro");
        rBtnBlack.setPreferredSize(new Dimension(120, 60));
        rBtnBlack.setHorizontalAlignment(SwingConstants.CENTER);

        rBtnWhite = new JRadioButton("Blanco");
        rBtnWhite.setPreferredSize(new Dimension(120, 60));
        rBtnWhite.setHorizontalAlignment(SwingConstants.CENTER);

        rBtnGreen = new JRadioButton("Verde");
        rBtnGreen.setPreferredSize(new Dimension(120, 60));
        rBtnGreen.setHorizontalAlignment(SwingConstants.CENTER);

        rBtnBlue = new JRadioButton("Azul");
        rBtnBlue.setPreferredSize(new Dimension(120, 60));
        rBtnBlue.setHorizontalAlignment(SwingConstants.CENTER);

        grup = new ButtonGroup();
        grup.add(rBtnBlue);
        grup.add(rBtnGreen);
        grup.add(rBtnWhite);
        grup.add(rBtnBlack);
    }

    private void confPanel1() {
        cleanGbc();
        this.gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 15, 15, 15);

        //columna 1
        this.gbc.gridx = 0;

        //label titulo nombre
        this.gbc.gridy = 1;
        container1.add(lbTitleName, this.gbc);

        //Espacio de text Nombre
        this.gbc.gridy = 2;
        container1.add(txtName, this.gbc);

        //boton empezar
        gbc.insets = new Insets(50, 15, 15, 15);
        this.gbc.gridy = 3;
        this.gbc.gridheight = 3;
        container1.add(btnStart, this.gbc);

    }

    private void confPanel2() {
        cleanGbc();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 15, 15, 15);

        //label titulo grupo
        this.gbc.gridwidth = 2;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        container2.add(lbTitleTeam, this.gbc);

        this.gbc.gridwidth = 1;
        // boton radio azul
        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        container2.add(rBtnBlue, this.gbc);

        // boton radio blanco
        this.gbc.gridx = 0;
        this.gbc.gridy = 2;
        container2.add(rBtnWhite, this.gbc);

        // boton radio negro
        this.gbc.gridx = 1;
        this.gbc.gridy = 1;
        container2.add(rBtnBlack, this.gbc);

        // boton radio verde
        this.gbc.gridx = 1;
        this.gbc.gridy = 2;
        container2.add(rBtnGreen, this.gbc);

    }

    private void confComponets() {
        cleanGbc();

        this.gbc.gridy = 0;

        this.gbc.gridx = 0;
        this.gbc.weightx = 0;
        this.add(container1, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.weightx = 0;
        this.add(container2, this.gbc);
    }

}
