/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view;

import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import cr.ac.ucr.projectparchis.view.options.PanelMSG;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author enier
 */
public class FrameGUI extends JFrame {

    GridBagConstraints gbc = new GridBagConstraints();

    JDialog popFrameUtil;
    JDialog popFrameMSG;

    PanelMSG panelMSG = new PanelMSG();
    PanelMenu panelMenu;

    public FrameGUI() {
        super();
        initParameters();
        initComponets();
        confComponets();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();

        laterInit();
    }

    public FrameGUI(PanelMenu panel) {
        super();
        initParameters();
        initComponets(panel);
        confComponets();

        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        pack();

        laterInit();
    }

    private void initParameters() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setResizable(false);
        this.setBackground(CustPalette.MAGENTA);
        this.setPreferredSize(new Dimension(1625, 935));
        this.setMinimumSize(new Dimension(850, 480));
        this.setMaximumSize(new Dimension(2560, 1440));
    }

    private void initComponets() {
        panelMenu = new PanelMenu();
    }

    private void initComponets(PanelMenu panel) {
        panelMenu = panel;
    }

    private void confComponets() {
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.weightx = 1;
        this.gbc.weighty = 1;

        this.getContentPane().add(panelMenu, this.gbc);

    }

    private void laterInit() {
        popFrameUtil = new JDialog(this, "", true);
        popFrameUtil.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        popFrameUtil.setAlwaysOnTop(true);
        popFrameUtil.setLocationRelativeTo(this);
        popFrameUtil.setResizable(true);
        popFrameUtil.setBackground(CustPalette.DARK_GRAY);
        popFrameUtil.setSize(825, 450);

        popFrameMSG = new JDialog(this, "", true);
        popFrameMSG.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        popFrameMSG.setAlwaysOnTop(true);
        popFrameMSG.setLocationRelativeTo(this);
        popFrameMSG.setResizable(false);
        popFrameMSG.setBackground(CustPalette.DARK_GRAY);
        popFrameMSG.setSize(825, 450);

    }

    public void panelChange(CustPanel panel) {
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.weightx = 1;
        this.gbc.weighty = 1;
        this.getContentPane().add(panel, this.gbc);
        this.revalidate();
        this.repaint();
    }

    public JPanel pop(JPanel panel) {
        popFrameUtil.getContentPane().removeAll();
        popFrameUtil.add(panel);
        popFrameUtil.revalidate();
        popFrameUtil.repaint();
        popFrameUtil.setVisible(true);
        return panel;
    }

    public void popClose() {
        popFrameUtil.setVisible(false);
    }

    public void msg(String text) {
        panelMSG.setText(text);
        popFrameMSG.getContentPane().removeAll();
        popFrameMSG.add(panelMSG);
        popFrameMSG.revalidate();
        popFrameMSG.repaint();
        popFrameMSG.setVisible(true);
    }

    public void msgClose() {
        popFrameMSG.setVisible(false);
    }

    public void heyListenMenus(ActionListener a) {
        panelMSG.heyListenMenus(a);
    }

}
