/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.model.GameState;
import cr.ac.ucr.projectparchis.view.FrameGUI;
import cr.ac.ucr.projectparchis.view.game.PanelGame;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import cr.ac.ucr.projectparchis.view.options.PanelOption;
import cr.ac.ucr.projectparchis.view.resources.sound.SoundBank;
import cr.ac.ucr.projectparchis.view.resources.textures.TexturesBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author enier
 */
public class ControllerGUI implements ActionListener {

    GameState mGameState;

    PanelMenu vPanelMenu;
    PanelGame vPanelGame;

    PanelOption vPanelOption;
    FrameGUI vFrameMain;

    public ControllerGUI(FrameGUI vFrameMain, PanelMenu vPanelMenu, PanelGame vPanelGame, PanelOption vPanelOption, GameState mGameState) {
        this.mGameState = mGameState;
        this.vPanelMenu = vPanelMenu;
        this.vPanelGame = vPanelGame;
        this.vPanelOption = vPanelOption;
        this.vFrameMain = vFrameMain;
        initComponets();
    }

    private void initComponets() {
        vPanelMenu.heyListenMenus(this);
        vPanelOption.heyListenMenus(this);
        vPanelGame.heyListenMenus(this);
        vFrameMain.heyListenMenus(this);
        vFrameMain.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnPlay":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());

                vFrameMain.pop(vPanelOption);
                break;
            case "btnGO":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());

                vPanelGame.getBoard().nameUpdateText(vPanelOption.getTextName());
                mGameState.setGroup(vPanelOption.getSelectedTeamColor());
                switch (vPanelOption.getSelectedTeamColor()) {
                    case "Negro":
                        System.out.println("[LOG] Texture Select: " + e.getActionCommand());
                        vPanelGame.getCanvas().modSincP1(mGameState.chipsP1, TexturesBank.CHIP_BLACK);
                        vPanelGame.getCanvas().modSincP2(mGameState.chipsP2, TexturesBank.CHIP_WHITE);
                        vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_BLACK);
                        break;
                    case "Blanco":
                        System.out.println("[LOG] Texture Select: " + e.getActionCommand());
                        vPanelGame.getCanvas().modSincP1(mGameState.chipsP1, TexturesBank.CHIP_WHITE);
                        vPanelGame.getCanvas().modSincP2(mGameState.chipsP2, TexturesBank.CHIP_BLACK);
                        vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_WHITE);
                        break;
                    case "Verde":
                        System.out.println("[LOG] Texture Select: " + e.getActionCommand());
                        vPanelGame.getCanvas().modSincP1(mGameState.chipsP1, TexturesBank.CHIP_GREEN);
                        vPanelGame.getCanvas().modSincP2(mGameState.chipsP2, TexturesBank.CHIP_BLUE);
                        vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_GREEN);
                        break;
                    case "Azul":
                        System.out.println("[LOG] Texture Select: " + e.getActionCommand());
                        vPanelGame.getCanvas().modSincP1(mGameState.chipsP1, TexturesBank.CHIP_BLUE);
                        vPanelGame.getCanvas().modSincP2(mGameState.chipsP2, TexturesBank.CHIP_GREEN);
                        vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_BLUE);
                        break;
                    default:
                        System.out.println("[WARNING] State Icon Out Of Switch: " + e.getActionCommand());
                }

                vFrameMain.remove(vPanelMenu);
                vFrameMain.panelChange(vPanelGame);
                vFrameMain.popClose();
                vPanelGame.getCanvas().start();
                
                break;
            case "btnOK":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.msgClose();
                break;
            case "btnSurrender":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.remove(vPanelGame);
                vFrameMain.panelChange(vPanelMenu);
                break;
            case "btnLore":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.msg("Algunas civilizaciones estan en conflicto, gana al contrario en una simulacion de tablero");
                break;
            case "btnHTP":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());
                vFrameMain.msg("Es un simple juego de parchis, tira el dado y responde preguntas faciles, gana si llegas al centro o cosigues muchos puntos, No los pierdas!");
                break;
            case "btnExit":
                SoundBank.click();
                System.out.println("[LOG] Press: " + e.getActionCommand());
                System.exit(0);
                break;
            default:
                System.out.println("[WARNING] Controller GUI Out Of Switch: " + e.getActionCommand());
        }
    }

}
