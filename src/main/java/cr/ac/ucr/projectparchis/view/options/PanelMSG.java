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
import javax.swing.ImageIcon;

/**
 *
 * @author enier
 */
public class PanelMSG extends CustPanel {

    private CustLabel lbText = new CustLabel("", new Dimension(600, 250));
    private CustButton btnOK = new CustButton("OK", "btnOK", new Dimension(60, 60));

    public PanelMSG() {
        super("", new Dimension(800, 400));
        this.setBackground(CustPalette.DARK_GRAY);
        confComponets();
        initTextures();
    }

    private void initTextures() {
        btnOK.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_BASE_TEXTURE, btnOK.getPreferredSize())));
        btnOK.setPressedIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_PRES_TEXTURE, btnOK.getPreferredSize())));
        btnOK.setRolloverIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.BUTTON_SELEC_TEXTURE, btnOK.getPreferredSize())));

        lbText.setIcon(new ImageIcon(TextureLoader.loadScaledPixel(Textures.LABEL_V3_TEXTURE, lbText.getPreferredSize())));
    }

    private void confComponets() {
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(2, 0, 2, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(lbText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(btnOK, gbc);
    }

    public void setText(String text) {
        int w = lbText.getWidth();
        if (w <= 0) {
            w = lbText.getPreferredSize().width;
        }
        w = (int) (w * 0.65);
        lbText.setText("<html><div style='width:" + w + "px; text-align:center;'>"
                + text
                + "</div></html>");
    }

    public void heyListenMenus(ActionListener a) {
        btnOK.addActionListener(a);
    }

}
