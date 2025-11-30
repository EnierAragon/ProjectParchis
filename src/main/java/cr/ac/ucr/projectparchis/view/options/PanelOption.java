/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.options;

import cr.ac.ucr.projectparchis.view.cust.CustButton;
import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import cr.ac.ucr.projectparchis.view.resources.textures.TextureLoader;
import cr.ac.ucr.projectparchis.view.resources.textures.Textures;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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

    CustButton btnGO;

    CustLabel lbTitleTeam;
    CustLabel lbTitleName;

    JTextField txtName;

    ButtonGroup group;
    JRadioButton rBtnBlue;
    JRadioButton rBtnGreen;
    JRadioButton rBtnWhite;
    JRadioButton rBtnBlack;

    public PanelOption() {
        super("Selection", new Dimension(800, 400));
        initParametersProp();
        initTextures();
        confComponets();
        confPanel1();
        confPanel2();
    }

    private void initParametersProp() {
        this.setBackground(CustPalette.DARK_GRAY);
        container1 = new CustPanel("container1", new Dimension(400, 400));
        container2 = new CustPanel("container2", new Dimension(400, 400));
        container1.setBackground(CustPalette.DARK_GRAY);
        container2.setBackground(CustPalette.DARK_GRAY);

        btnGO = new CustButton("Empezar", "btnGO", new Dimension(240, 90));

        lbTitleName = new CustLabel("Nombre:", new Dimension(240, 60));
        lbTitleTeam = new CustLabel("Equipo", new Dimension(240, 60));

        txtName = new JTextField("");
        txtName.setPreferredSize(new Dimension(240, 40));
        txtName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setBackground(CustPalette.GRAY);

        rBtnBlack = new JRadioButton("Negro");
        rBtnBlack.setPreferredSize(new Dimension(120, 60));
        rBtnBlack.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnBlack.setBackground(CustPalette.DARK_GRAY);
        rBtnBlack.setForeground(CustPalette.GRAY);
        rBtnBlack.setActionCommand("Negro");

        rBtnWhite = new JRadioButton("Blanco");
        rBtnWhite.setPreferredSize(new Dimension(120, 60));
        rBtnWhite.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnWhite.setBackground(CustPalette.DARK_GRAY);
        rBtnWhite.setForeground(CustPalette.GRAY);
        rBtnWhite.setActionCommand("Blanco");

        rBtnGreen = new JRadioButton("Verde");
        rBtnGreen.setPreferredSize(new Dimension(120, 60));
        rBtnGreen.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnGreen.setBackground(CustPalette.DARK_GRAY);
        rBtnGreen.setForeground(CustPalette.GRAY);
        rBtnGreen.setActionCommand("Verde");

        rBtnBlue = new JRadioButton("Azul");
        rBtnBlue.setSelected(true);
        rBtnBlue.setPreferredSize(new Dimension(120, 60));
        rBtnBlue.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnBlue.setBackground(CustPalette.DARK_GRAY);
        rBtnBlue.setForeground(CustPalette.GRAY);
        rBtnBlue.setActionCommand("Azul");

        group = new ButtonGroup();
        group.add(rBtnWhite);
        group.add(rBtnBlack);
        group.add(rBtnGreen);
        group.add(rBtnBlue);
    }

    private void initTextures() {
        btnGO.setIcon(
                new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnGO.getPreferredSize())));
        btnGO.setPressedIcon(
                new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnGO.getPreferredSize())));
        btnGO.setRolloverIcon(
                new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnGO.getPreferredSize())));

        lbTitleName.setIcon(new ImageIcon(
                TextureLoader.loadScaledPixel(Textures.LABEL_V2_TEXTURE, lbTitleName.getPreferredSize())));
        lbTitleTeam.setIcon(new ImageIcon(
                TextureLoader.loadScaledPixel(Textures.LABEL_V2_TEXTURE, lbTitleTeam.getPreferredSize())));

    }

    private void confPanel1() {
        cleanGbc();
        this.gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 15, 15, 15);

        // columna 1
        this.gbc.gridx = 0;

        // label titulo nombre
        this.gbc.gridy = 1;
        container1.add(lbTitleName, this.gbc);

        // Espacio de text Nombre
        this.gbc.gridy = 2;
        container1.add(txtName, this.gbc);

        // boton empezar
        gbc.insets = new Insets(50, 15, 15, 15);
        this.gbc.gridy = 3;
        this.gbc.gridheight = 3;
        container1.add(btnGO, this.gbc);

    }

    private void confPanel2() {
        cleanGbc();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 15, 15, 15);

        // label titulo grupo
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

    public void heyListenMenus(ActionListener a) {
        this.btnGO.addActionListener(a);
    }

    public String getSelectedTeamColor() {
        if (group.getSelection() == null) {
            return null;
        }
        return group.getSelection().getActionCommand();
    }

    public String getTextName() {
        if (this.txtName.getText().equals("") || this.txtName.getText().equals(" ")) {
            return "Dump";
        } else {
            return this.txtName.getText();
        }
    }

}
