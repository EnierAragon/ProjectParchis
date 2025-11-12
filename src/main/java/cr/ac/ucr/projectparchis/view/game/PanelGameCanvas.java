/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author enier
 */
public class PanelCanvas extends CustPanel implements Runnable {

    private Thread gameLoop;
    private boolean running = false;

    public PanelCanvas() {
    }

    public void start() {
        if (gameLoop == null || !running) {
            running = true;
            gameLoop = new Thread(this);
            gameLoop.start();
        }
    }

    @Override
    public void run() {

        while (running) {
            updateSprites();
            repaint();
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    private void updateSprites() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.dispose();
    }

}
