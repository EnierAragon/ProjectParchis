/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author enier
 */
public class CustPanel extends JPanel {

    protected Dimension min = new Dimension(50, 50);
    protected Dimension max = new Dimension(5000, 5000);
    protected Dimension def = new Dimension(800, 800);
    
    public CustPanel() {
        initParameters();
    }

    private void initParameters() {
        this.setName("DefaultCustPanel");
        this.setSize(def);
        this.setPreferredSize(def);
        this.setMaximumSize(max);
        this.setMinimumSize(min);
    }

}
