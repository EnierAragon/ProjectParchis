/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.test;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author enier
 */
public class PanelTest extends JPanel {

    public PanelTest() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Coordenadas del polígono (un rectángulo)
        int[] xPoints = {50, 250, 250, 50};
        int[] yPoints = {50, 50, 200, 200};
        int nPoints = 4;

        // Configurar color y dibujar
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

}
