/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.cust;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author enier
 */
public class CustPanel extends JPanel {

    protected Dimension min = new Dimension(850, 480);
    protected Dimension max = new Dimension(2560, 1440);
    protected Dimension def = new Dimension(1280, 720);

    protected GridBagConstraints gbc = new GridBagConstraints();
    protected GridBagConstraints gbcVoid = new GridBagConstraints();

    public CustPanel() {
        initParameters();
    }

    public CustPanel(String name) {
        initParameters(name);
    }

    public CustPanel(String name, Dimension pref) {
        initParameters(name, pref);
    }

    public CustPanel(String name, Dimension pref, Dimension size) {
        initParameters(name, pref, size);
    }

    public CustPanel(String name, Dimension def, Dimension min, Dimension max, LayoutManager layoutManager) {
        initParameters(name, def, min, max, layoutManager);
    }

    private void initParameters() {
        gbc.fill = GridBagConstraints.NONE;
        this.setName("DefaultCustPanel");
        this.setLayout(new GridBagLayout());
        this.setMaximumSize(this.max);
        this.setMinimumSize(this.min);
    }

    private void initParameters(String name) {
        gbc.fill = GridBagConstraints.NONE;
        this.setName(name);
        this.setLayout(new GridBagLayout());
        this.setMaximumSize(this.max);
        this.setMinimumSize(this.min);
    }

    private void initParameters(String name, Dimension pref) {
        gbc.fill = GridBagConstraints.NONE;
        this.setName(name);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(pref);
        this.setMaximumSize(this.max);
        this.setMinimumSize(this.min);
    }

    private void initParameters(String name, Dimension pref, Dimension size) {
        gbc.fill = GridBagConstraints.NONE;
        this.setName(name);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(pref);
        this.setSize(size);
        this.setMaximumSize(this.max);
        this.setMinimumSize(this.min);
    }

    private void initParameters(String name, Dimension def, Dimension min, Dimension max, LayoutManager layoutManager) {
        gbc.fill = GridBagConstraints.NONE;
        this.setName(name);
        this.setLayout(layoutManager);
        this.setPreferredSize(def);
        this.setMaximumSize(max);
        this.setMinimumSize(min);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void cleanGbc() {
        gbc = gbcVoid;
        gbc.fill = GridBagConstraints.BOTH;
    }

}
