/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model;

/**
 *
 * @author enier
 */
public class Box {

    /**
     * Cordenada de la esquina superior izquierda de la casilla Las cordenadas
     * siguen el orden X,Y,Z.
     *
     */
    private double[] boxPoint1 = new double[2];

    /**
     * Cordenada de la esquina inferior derecha de la casilla Las cordenadas
     * siguen el orden X,Y,Z.
     */
    private double[] boxPoint2 = new double[2];

    /**
     * Cordenada de el centro de la casilla Las cordenadas siguen el orden
     * X,Y,Z.
     */
    private double[] midCord = new double[2];

    /**
     * Cordenada de la seccion izquieda de la casilla Las cordenadas siguen el
     * orden X,Y,Z.
     */
    private double[] leftCord = new double[2];

    /**
     * Cordenada de la seccion derecha de la casilla Las cordenadas siguen el
     * orden X,Y,Z.
     */
    private double[] rightCord = new double[2];

    /**
     * Este Parametro determina si la casilla tiene que tener un comportamiento
     * Especial.
     */
    private boolean specialBox = false;

    public Box() {
        this.boxPoint1[0] = 1;
        this.boxPoint2[1] = 2;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
    }

    public Box(double cord1, double cord2) {
        this.boxPoint1[0] = cord1;
        this.boxPoint2[1] = cord2;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
    }

    public Box(double cord1, double cord2, boolean special) {
        this.boxPoint1[0] = cord1;
        this.boxPoint2[1] = cord2;
        this.specialBox = special;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
    }

    private void calcMid() {

        double distX = Math.abs(boxPoint1[0] - boxPoint2[0]);
        double distY = Math.abs(boxPoint1[1] - boxPoint2[1]);

        if (boxPoint2[0] >= 0) {
            midCord[0] -= distX / 2;
        } else {
            midCord[0] += distX / 2;
        }

        if (boxPoint2[1] >= 0) {
            midCord[1] -= distY / 2;
        } else {
            midCord[1] += distY / 2;
        }

    }

    private void calcLeftPoint() {

        double distX = Math.abs(boxPoint1[0] - midCord[0]);

        if (midCord[0] >= 0) {
            leftCord[0] -= distX / 2;
        } else {
            leftCord[0] += distX / 2;
        }

        leftCord[1] = midCord[1];

    }

    private void calcRightPoint() {

        double distX = Math.abs(midCord[0] - boxPoint2[0]);

        if (boxPoint2[0] >= 0) {
            rightCord[0] -= distX / 2;
        } else {
            rightCord[0] += distX / 2;
        }

        rightCord[1] = midCord[1];

    }

    public double[] getBoxCord1() {
        return boxPoint1;
    }

    public void setBoxCord1(double[] bCord1) {
        this.boxPoint1 = bCord1;
    }

    public double[] getBoxCord2() {
        return boxPoint2;
    }

    public void setBoxCord2(double[] bCord2) {
        this.boxPoint2 = bCord2;
    }

    public double[] getSingleCord() {
        return midCord;
    }

    public double[] getGrubCord1() {
        return leftCord;
    }

    public double[] getGrubCord2() {
        return rightCord;
    }

}
