/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.menu;

import cr.ac.ucr.projectparchis.view.cust.CustLabel;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

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
        super("PanelMenu");
        initComponets();
        settingComponets();
        confComponets();
        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    private void initComponets() {
        board = new PanelMenuBoard();
        lbIlustration = new CustLabel("lbIlustration", SwingConstants.CENTER);
    }

    private void settingComponets() {
        lbIlustration.setBackground(Color.ORANGE);

    }

    private void confComponets() {
        this.getGbc().gridy = 0;
        this.getGbc().weighty = 1;

        this.getGbc().gridx = 0;
        this.getGbc().weightx = 0.8;
        this.add(lbIlustration, this.getGbc());

        this.getGbc().gridx = 1;
        this.getGbc().weightx = 0.2;
        this.add(board, this.getGbc());
    }

}
