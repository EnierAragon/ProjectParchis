/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
    
    CustPanel container;
    PanelGameBoard board;
    PanelGameCanvas canvas;
    
    public PanelGame() {
        initComponets();
        confComponets();
        this.setBackground(CustPalette.DARK_GRAY);
        this.setVisible(true);
    }
    
    private void initComponets() {
        container = new CustPanel("container", new Dimension(1280, 900));
        container.setBackground(CustPalette.DARK_GRAY);
        board = new PanelGameBoard();
        canvas = new PanelGameCanvas();
    }
    
    private void confComponets() {
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.gridheight = 1;
        this.gbc.gridwidth = 1;
        this.gbc.weightx = 0;
        this.gbc.weighty = 0;
        container.add(canvas, this.gbc);
        
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.weighty = 1;

        //(896) 768 + 128{32*4}
        this.gbc.gridx = 0;
        this.gbc.weightx = 0;
        this.add(container, gbc);
        
        this.gbc.insets = new Insets(0, 0, 0, 0);
        this.gbc.gridx = 1;
        this.gbc.weightx = 1;
        this.add(board, gbc);
    }
    
    public void heyListenMenus(ActionListener a) {
        board.btnSurrender.addActionListener(a);
    }
    
    public void heyListenActions(ActionListener a) {
        board.btnDraw.addActionListener(a);
    }
    
    public void heyListenMouse(MouseListener a) {
        canvas.addMouseListener(a);
    }
    
    public void heyListenMotionMouse(MouseMotionListener a) {
        canvas.addMouseMotionListener(a);
    }
    
}
