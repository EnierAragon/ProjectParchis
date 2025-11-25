/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.view.game.PanelGame;
import cr.ac.ucr.projectparchis.view.menu.PanelMenu;
import cr.ac.ucr.projectparchis.view.options.PanelOption;
import cr.ac.ucr.projectparchis.view.options.PanelQuest;
import cr.ac.ucr.projectparchis.view.resources.textures.*;

/**
 *
 * @author enier
 */
public class ControllerSprite {

    TexturesBank textureBank;
    PanelMenu vPanelMenu;
    PanelGame vPanelGame;
    PanelOption vPanelOption;
    PanelQuest vPanelQuest;

    public ControllerSprite(TexturesBank textureBank, PanelMenu vPanelMenu, PanelGame vPanelGame, PanelOption vPanelOption, PanelQuest vPanelQuest) {
        this.textureBank = textureBank;
        this.vPanelMenu = vPanelMenu;
        this.vPanelGame = vPanelGame;
        this.vPanelOption = vPanelOption;
        this.vPanelQuest = vPanelQuest;
    }

}
