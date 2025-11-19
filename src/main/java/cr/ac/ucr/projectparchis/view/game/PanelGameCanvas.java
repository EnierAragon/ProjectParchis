/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;

/**
 *
 * @author enier
 */
public class PanelGameCanvas extends CustPanel {

    private boolean running = false;
    private Timer timer;

    public PanelGameCanvas() {
        super("PanelGameCanvas", new Dimension(768, 768));
        initGameLoop();
        
        this.setBackground(Color.BLUE);
        this.setVisible(true);
    }

    private void initGameLoop() {
        // 16 ms ≈ 60 FPS
        int delay = 16;
        timer = new Timer(delay, (var e) -> {
            if (running) {
                updateSprites();
                repaint();
            }
        });
    }

    public void start() {
        if (!running) {
            running = true;
            timer.start();
        }
    }

    public void stop() {
        running = false;
        timer.stop();
    }

    private void updateSprites() {
        // Aquí se actualizan posiciones, animaciones, etc.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.dispose();
    }

}
