/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.cust;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author enier
 */
public class CustLabel extends JLabel {

    Dimension min = new Dimension(10, 10);
    Dimension pref = new Dimension(300, 150);
    Dimension max = new Dimension(400, 150);

    public CustLabel() {
        this.setHorizontalAlignment(CENTER);
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
    }

    public CustLabel(Icon image) {
        super(image);
        this.setOpaque(true);
    }

    public CustLabel(Icon image, Dimension pref) {
        super(image);
        this.setMinimumSize(min);
        this.setPreferredSize(pref);
        this.setMaximumSize(max);
        this.setOpaque(true);
    }

    public CustLabel(String text) {
        super(text);
        this.setHorizontalAlignment(CENTER);
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
    }

    public CustLabel(String text, Dimension pref) {
        super(text);
        this.setHorizontalAlignment(CENTER);
        this.setMinimumSize(min);
        this.setPreferredSize(pref);
        this.setMaximumSize(max);
        this.setOpaque(true);
    }

    public CustLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setMinimumSize(min);
        this.setPreferredSize(pref);
        this.setMaximumSize(max);
        this.setOpaque(true);
    }

    public CustLabel(String text, Dimension pref, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setMinimumSize(min);
        this.setPreferredSize(pref);
        this.setMaximumSize(max);
        this.setOpaque(true);
    }

}
