/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.cust;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author enier
 */
public class CustLabel extends JLabel {

    Dimension pref = new Dimension(300, 150);

    public CustLabel() {
        this.setHorizontalAlignment(CENTER);
        this.setBackground(CustPalette.GRAY);
        centered();
        this.setOpaque(true);
    }

    public CustLabel(Icon image) {
        super(image);
        pref = new Dimension(image.getIconWidth(), image.getIconHeight());
        centered();
        this.setOpaque(true);
    }

    public CustLabel(Icon image, Dimension pref) {
        super(image);
        this.setPreferredSize(pref);
        centered();
        this.setOpaque(true);
    }

    public CustLabel(String text) {
        super(text);
        this.setHorizontalAlignment(CENTER);
        this.setBackground(CustPalette.GRAY);
        centered();
        this.setOpaque(true);
    }

    public CustLabel(String text, Dimension pref) {
        super(text);
        this.setPreferredSize(pref);
        this.setBackground(CustPalette.DARK_GRAY);
        centered();
        this.setOpaque(true);
    }

    private void centered() {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);

        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);

        this.setIconTextGap(0);
    }

}
