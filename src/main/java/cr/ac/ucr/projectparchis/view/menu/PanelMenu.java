/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.menu;

import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 * Esta clase es el menu principal del juego permite salir de mismo, ir a la
 * seccion de como jugar ir a la pantalla de lore y ir a la pantalla de juego
 * con una pantalla intermedia para elegir el color y el nombre.
 *
 * Tamaño 1280 x 720 px
 *
 * Rejilla 32 x 30 px
 *
 * 40 columnas x 24 filas
 *
 * Canvas = 29 columnas x 22 filas
 *
 * icon = 4x4 → agregar un dimencion en todos sus lados de 30x30
 *
 * botones = 6x2
 *
 * agregar dimencion = 30x30 entre exit y botones
 *
 * exit = 6x3
 *
 * gabs = 30
 *
 * @author enier
 */
public class PanelMenu extends CustPanel {

    PanelMenuBoard board;
    CustLabel lbIlustration;

    public PanelMenu() {
        super("PanelMenu", new Dimension(1600, 900));
        initComponets();
        settingComponets();
        confComponets();
        this.setBackground(CustPalette.GRAY);
        this.setVisible(true);
    }

    private void initComponets() {
        board = new PanelMenuBoard();
        lbIlustration = new CustLabel("", new Dimension(1280, 900));
    }

    private void settingComponets() {
        lbIlustration.setBackground(CustPalette.DARK_GRAY);

    }

    private void confComponets() {
        this.gbc.gridy = 0;
        this.gbc.weighty = 1;

        this.gbc.gridx = 0;
        this.gbc.weightx = 0.7;
        this.add(lbIlustration, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.weightx = 0.3;
        this.add(board, this.gbc);
    }

    public void heyListenMenus(ActionListener a) {
        board.btnPlay.addActionListener(a);
        board.btnExit.addActionListener(a);

        board.btnLore.addActionListener(a);
        board.btnHowToPlay.addActionListener(a);
    }

}
