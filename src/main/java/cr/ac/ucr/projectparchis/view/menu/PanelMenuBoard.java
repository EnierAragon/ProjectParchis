/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.menu;

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
public class PanelMenuBoard extends CustPanel {

    protected CustButton btnPlay;
    protected CustButton btnLore;
    protected CustButton btnHowToPlay;
    protected CustButton btnExit;
    protected CustLabel lbIcon;

    public PanelMenuBoard() {
        super("PanelMenuBoard", new Dimension(320, 900));
        initComponets();
        initTextures();
        confComponents();
        this.setBackground(CustPalette.DARK_GRAY);
    }

    private void initComponets() {
        lbIcon = new CustLabel("", new Dimension(180, 180));
        btnPlay = new CustButton("Jugar", "btnPlay", new Dimension(270, 90));
        btnHowToPlay = new CustButton("Acerca de", "btnHTP", new Dimension(270, 90));
        btnLore = new CustButton("Lore", "btnLore", new Dimension(270, 90));
        btnExit = new CustButton("Salir", "btnExit", new Dimension(270, 135));
    }

    private void initTextures() {
        //base
        btnPlay.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnPlay.getPreferredSize())));
        btnHowToPlay.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnHowToPlay.getPreferredSize())));
        btnLore.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnLore.getPreferredSize())));
        btnExit.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnExit.getPreferredSize())));
        //pressed
        btnPlay.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnPlay.getPreferredSize())));
        btnHowToPlay.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnHowToPlay.getPreferredSize())));
        btnLore.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnLore.getPreferredSize())));
        btnExit.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnExit.getPreferredSize())));
        //rollOver
        btnPlay.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnPlay.getPreferredSize())));
        btnHowToPlay.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnHowToPlay.getPreferredSize())));
        btnLore.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnLore.getPreferredSize())));
        btnExit.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnExit.getPreferredSize())));
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
