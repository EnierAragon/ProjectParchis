/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.cust;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author enier
 */
public class CustButton extends JButton {

    public CustButton() {
        this.setName("btnDefault");
        this.setActionCommand("btnDefaultComand");
        centered();
        this.setVisible(true);
    }

    public CustButton(String text, String actionCommand) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        centered();
        this.setVisible(true);
    }

    public CustButton(String text, String actionCommand, Dimension pref) {
        this.setText(text);
        this.setActionCommand(actionCommand);
        this.setPreferredSize(pref);

        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        centered();

        this.setVisible(true);
    }

    private void centered() {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);

        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);

        this.setIconTextGap(0);
    }

}
