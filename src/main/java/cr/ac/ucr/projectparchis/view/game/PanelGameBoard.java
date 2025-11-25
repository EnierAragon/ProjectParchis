/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.view.cust.CustButton;
import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import cr.ac.ucr.projectparchis.view.resources.textures.TextureLoader;
import cr.ac.ucr.projectparchis.view.resources.textures.Textures;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

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
    protected CustButton btnSurrender;
    protected CustButton btnDraw;

    public PanelGameBoard() {
        super("PanelGameBoar", new Dimension(320, 900));
        initComponets();
        initTextures();
        confComponets();

        this.setBackground(CustPalette.DARK_GRAY);
        this.setVisible(true);
    }

    private void initComponets() {
        lbTitleName = new CustLabel("Name", new Dimension(270, 90));
        lbTitleData = new CustLabel("CurrentAction", new Dimension(270, 135));
        lbTitleDraw = new CustLabel("DiceNumber", new Dimension(270, 45));
        lbIconTurn = new CustLabel("StatusIcon", new Dimension(180, 180));
        lbIconDraw = new CustLabel("DiceIcon", new Dimension(150, 150));
        btnDraw = new CustButton("Tirar", "btnDraw", new Dimension(270, 90));
        btnSurrender = new CustButton("Rendirse", "btnSurrender", new Dimension(90, 90));
    }

    private void initTextures() {
        //  botones
        //base
        btnSurrender.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_CBASE_TEXTURE, btnSurrender.getPreferredSize())));
        btnDraw.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnDraw.getPreferredSize())));
        //presed
        btnSurrender.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_CPRES_TEXTURE, btnSurrender.getPreferredSize())));
        btnDraw.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnDraw.getPreferredSize())));
        //rollOver
        btnSurrender.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_CSELEC_TEXTURE, btnSurrender.getPreferredSize())));
        btnDraw.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnDraw.getPreferredSize())));

        //Titulos
        lbTitleName.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.LABEL_V2_TEXTURE, lbTitleName.getPreferredSize())));
        lbTitleData.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.LABEL_V3_TEXTURE, lbTitleData.getPreferredSize())));
        lbTitleDraw.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.LABEL_V3_TEXTURE, lbTitleDraw.getPreferredSize())));
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
        this.add(btnSurrender, this.gbc);

        this.gbc.anchor = GridBagConstraints.CENTER;

        //label nombre
        this.gbc.insets = new Insets(10, 0, 0, 0);
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
        this.gbc.insets = new Insets(5, 0, 0, 0);
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
