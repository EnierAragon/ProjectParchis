/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.model.GameState;
import cr.ac.ucr.projectparchis.model.entities.Chip;
import cr.ac.ucr.projectparchis.view.FrameGUI;
import cr.ac.ucr.projectparchis.view.game.PanelGame;
import cr.ac.ucr.projectparchis.view.options.PanelQuest;
import cr.ac.ucr.projectparchis.view.resources.textures.TextureLoader;
import cr.ac.ucr.projectparchis.view.resources.textures.Textures;
import cr.ac.ucr.projectparchis.view.resources.textures.TexturesBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Timer;

/**
 *
 * @author enier
 */
public class ControllerGameplay implements ActionListener {

    private boolean running = false;
    private Timer timer;

    boolean draw = false;

    public int lastDice = 1;

    GameState mState;

    FrameGUI vFrameGUI;
    PanelQuest vPanelQuest;
    PanelGame vPanelGame;

    public ControllerGameplay(FrameGUI vFrameGUI, PanelGame vPanelGame, GameState mState, PanelQuest vPanelQuest) {
        initComponets(vFrameGUI, vPanelGame, vPanelQuest);
        this.mState = mState;
        vPanelGame.heyListenActions(this);
        callMotionAdapterMouse();
        callAdapterMouse();
        initGameLoop();
        start();
    }

    private void initComponets(FrameGUI vFrameGUI, PanelGame vPanelGame, PanelQuest vPanelQuest) {
        this.vFrameGUI = vFrameGUI;
        this.vPanelQuest = vPanelQuest;
        this.vPanelGame = vPanelGame;
    }

    public void onCanvasClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnDraw":

                System.out.println("[LOG] Press: " + e.getActionCommand());

                mState.diceRoll();

                vPanelGame.getBoard().diceUpdateIcon(TextureLoader.loadGIF(Textures.DICE_GIF));

                updateDiceContainer();

                draw = true;

                break;

            default:
                System.out.println("[WARNING] Action Event Controller Gameplat Out Of Switch: " + e.getActionCommand());
        }
    }

    private void callAdapterMouse() {
        vPanelGame.heyListenMouse(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("[LOG] Mouse Pressed: x " + e.getX() + ", y " + e.getY());
                if (draw) {
                    Chip cip = mState.getChipInCords(e.getX(), e.getY());
                    System.out.println("enter to cip");
                    if (cip != null) {
                        System.out.println("cip not false");
                        mState.numberUpdate(lastDice, cip, mState.listCycle.current());
                        vPanelGame.getCanvas().updateCord(cip.getX(), cip.getY(), cip.id);
                        draw = false;
                        mState.listCycle.next();
                        updateIconStatusContainer();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("[LOG] Mouse Released: x " + e.getX() + ", y " + e.getY());

            }

        });
    }

    private void callMotionAdapterMouse() {
        vPanelGame.heyListenMotionMouse(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("[LOG] Mouse Drag: x " + e.getX() + ", y " + e.getY());
            }

        });
    }

    private void updateDiceContainer() {
        javax.swing.Timer timer = new javax.swing.Timer(1100, event -> {
            switch (mState.getLastDice()) {
                case 1:
                    vPanelGame.getBoard().diceUpdateText(mState.getLastDiceString());
                    vPanelGame.getBoard().diceUpdateIcon(TexturesBank.DICE1);
                    break;
                case 2:
                    vPanelGame.getBoard().diceUpdateText(mState.getLastDiceString());
                    vPanelGame.getBoard().diceUpdateIcon(TexturesBank.DICE2);
                    break;
                case 3:
                    vPanelGame.getBoard().diceUpdateText(mState.getLastDiceString());
                    vPanelGame.getBoard().diceUpdateIcon(TexturesBank.DICE3);
                    break;
                case 4:
                    vPanelGame.getBoard().diceUpdateText(mState.getLastDiceString());
                    vPanelGame.getBoard().diceUpdateIcon(TexturesBank.DICE4);
                    break;
                case 5:
                    vPanelGame.getBoard().diceUpdateText(mState.getLastDiceString());
                    vPanelGame.getBoard().diceUpdateIcon(TexturesBank.DICE5);
                    break;
                default:
                    System.out.println("[WARNING] Dice Out Of Switch: " + mState.getLastDiceString());
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    private void updateIconStatusContainer() {
        switch (mState.listCycle.current().getGroup()) {
            case "Negro":
                vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_BLACK);
                break;
            case "Blanco":
                vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_WHITE);
                break;
            case "Azul":
                vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_BLUE);
                break;
            case "Verde":
                vPanelGame.getBoard().stateUpdateIcon(TexturesBank.STATUS_GREEN);
                break;
            default:
                System.out.println("[WARNIG] icon state out of switch: " + mState.listCycle.current().getGroup());
        }
    }

    private void initGameLoop() {
        int delay = 250;
        timer = new Timer(delay, (var e) -> {
            if (running) {
                vPanelGame.getCanvas().updateCord(mState.chipsP1);
                vPanelGame.getCanvas().updateCord(mState.chipsP2);
                updateIconStatusContainer();
            }
        });
    }

    private void start() {
        if (!running) {
            running = true;
            timer.start();
        }
    }

    public void stop() {
        running = false;
        timer.stop();
    }

}
