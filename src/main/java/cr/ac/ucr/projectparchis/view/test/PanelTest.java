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

    int[] xPoints = new int[4];
    int[] yPoints = new int[4];
    int nPoints = 4;

    public PanelTest() {
    }

    /**
     *
     * Este metodo se encarga de combertir dos arreglo de 2 espacios tipo double
     * en dos de 4 espacios tipo int esto para usarse en la vercion final como
     * metodo separado.
     *
     * El metodo de combercion de dos puntos en cuatro es posible ya que este
     * esta diseñado para gestionar rectangulos en orden de procesado fijo
     * siendo este {x1, x2, x2, x1} y {y1, y1, y2, y2} siendo que 1 es el array
     * {@code cords1} y 2 el array {@code cords2} tener en cuenta que se
     * presupone que el primer indice del arreglo sea las cordenadas Y y el
     * segundo las Y.
     * 
     * 
     * En cordenadas de puntos (2,1)(8,5) el resultado seria las cordenadas de puntos siguiente:
     * 
     * 
     *
     * @param cords1 punto superior derecho del rectangulo
     * @param cords2 punto inferior izquierdo del rectangulo
     */
    public void setCords(double[] cords1, double[] cords2) {

        xPoints[0] = (int) cords1[0];
        xPoints[1] = (int) cords2[0];
        xPoints[2] = (int) cords2[0];
        xPoints[3] = (int) cords1[0];

        for (int i = 0; i + 1 <= xPoints.length; i++) {
            System.out.println("Cords x:" + i + " = " + xPoints[i]);
        }

        yPoints[0] = (int) cords1[1];
        yPoints[1] = (int) cords1[1];
        yPoints[2] = (int) cords2[1];
        yPoints[3] = (int) cords2[1];

        for (int i = 0; i + 1 <= yPoints.length; i++) {
            System.out.println("Cords y:" + i + " = " + yPoints[i]);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

}
