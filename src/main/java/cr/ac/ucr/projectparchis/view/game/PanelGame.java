/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;

/**
 * Este panel es el lugar donde se compone la pantalla de juego incluye un panel
 * donde se renderisa el juego y un panel lateral donde se muetra el nombre del
 * jugador, puntuacion, los dados, accion que se esta realizando en el momento,
 * color que esta jugando en el momento y la opcion de salir del juego
 * prematuramente
 *
 *
 *
 * @author enier
 */
public class PanelGame extends CustPanel {

    PanelGameBoard board;
    PanelGameCanvas canvas;

    public PanelGame() {
        initComponets();
        confComponets();
        this.setBackground(Color.yellow);
        this.setVisible(true);
    }

    private void initComponets() {
        board = new PanelGameBoard();
        canvas = new PanelGameCanvas();
    }

    private void confComponets() {
        this.gbc.gridy = 0;
        this.gbc.weighty = 1;

        this.gbc.gridx = 0;
        this.gbc.weightx = 0.7;
        this.add(canvas, gbc);

        this.gbc.gridx = 1;
        this.gbc.weightx = 0.3;
        this.add(board, gbc);
    }

}
