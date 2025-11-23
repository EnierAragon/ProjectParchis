/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.model.GameState;
import cr.ac.ucr.projectparchis.model.entities.Player;
import cr.ac.ucr.projectparchis.model.logic.Table;
import cr.ac.ucr.projectparchis.view.FrameGUI;
import cr.ac.ucr.projectparchis.view.game.PanelGame;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import cr.ac.ucr.projectparchis.view.options.PanelOption;
import cr.ac.ucr.projectparchis.view.options.PanelQuest;

/**
 *
 * @author enier
 */
public class ControllerMain {
    
    PanelMenu vPanelMenu = new PanelMenu();
    PanelGame vPanelGame = new PanelGame();
    PanelOption vPanelOption = new PanelOption();
    PanelQuest vPanelQuest = new PanelQuest();
    FrameGUI vFrameMain = new FrameGUI(vPanelMenu);
    
    Player mYouPlayer = new Player();
    Player mCpuPlayer = new Player();
    Table mRecTable = new Table();
    GameState mGameState = new GameState();
    
    ControllerGameplay cGameplay = new ControllerGameplay(vFrameMain, vPanelGame);
    ControllerSprite cSprite = new ControllerSprite();
    ControllerGUI cGUI;
    
    public ControllerMain() {
        initComponets();
    }
    
    private void initComponets() {
        cGUI = new ControllerGUI(vFrameMain, vPanelMenu, vPanelGame, vPanelOption, vPanelQuest);
    }
    
}
