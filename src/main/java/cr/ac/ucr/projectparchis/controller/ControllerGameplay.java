/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.controller;

import cr.ac.ucr.projectparchis.view.FrameGUI;
import cr.ac.ucr.projectparchis.view.game.PanelGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 *
 * @author enier
 */
public class ControllerGameplay implements ActionListener {

    FrameGUI vFrameGUI;
    PanelGame vPanelGame;

    public ControllerGameplay(FrameGUI vFrameGUI, PanelGame vPanelGame) {
        initComponets(vFrameGUI, vPanelGame);
        vPanelGame.heyListenActions(this);
        callMotionAdapterMouse();
        callAdapterMouse();
    }

    private void initComponets(FrameGUI vFrameGUI, PanelGame vPanelGame) {
        this.vFrameGUI = vFrameGUI;
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
                break;
            default:
                System.out.println("[LOG] OutOfSwitch: " + e.getActionCommand());
        }
    }

    private void callAdapterMouse() {
        vPanelGame.heyListenMouse(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("[LOG] Mouse Pressed: x " + e.getX() + ", y " + e.getY());
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

}
