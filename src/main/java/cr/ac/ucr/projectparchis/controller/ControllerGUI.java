/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.view.FrameGUI;
import cr.ac.ucr.projectparchis.view.game.PanelGame;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import cr.ac.ucr.projectparchis.view.options.PanelOption;
import cr.ac.ucr.projectparchis.view.options.PanelQuest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author enier
 */
public class ControllerGUI implements ActionListener {
    
    PanelMenu vPanelMenu;
    
    PanelGame vPanelGame;
    PanelOption vPanelOption;
    PanelQuest vPanelQuest;
    FrameGUI vFrameMain;
    
    public ControllerGUI(FrameGUI vFrameMain, PanelMenu vPanelMenu, PanelGame vPanelGame, PanelOption vPanelOption, PanelQuest vPanelQuest) {
        this.vPanelMenu = vPanelMenu;
        this.vPanelGame = vPanelGame;
        this.vPanelOption = vPanelOption;
        this.vPanelQuest = vPanelQuest;
        this.vFrameMain = vFrameMain;
        initComponets();
    }
    
    private void initComponets() {
        vPanelMenu.heyListenMenus(this);
        vPanelGame.heyListenMenus(this);
        vFrameMain.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnPlay":
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.remove(vPanelMenu);
                vFrameMain.panelChange(vPanelGame);
                break;
            case "btnSurrender":
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.remove(vPanelGame);
                vFrameMain.panelChange(vPanelMenu);
                break;
            case "btnLore":
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.msg("Algunas civilizaciones estan en conflicto, gana al contrario en una simulacion de tablero");
                break;
            case "btnHTP":
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.msg("Es un simple juego de parchis, tira el dado y responde preguntas faciles, gana si llegas al centro o cosigues muchos puntos, No los pierdas!");
                break;
            case "btnExit":
                System.out.println("[LOG] Press: " + e.getActionCommand());
                System.exit(0);
                break;
            default:
                System.out.println("[LOG] OutOfSwitch: " + e.getActionCommand());
        }
    }
    
}
