/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model;

/**
 *
 * @author enier
 * @version 1.0
 * @since 1.0
 */
public class Box {

    /**
     * Cordenada de la esquina superior izquierda de la casilla Las cordenadas
     * siguen el orden X,Y,Z.
     *
     * @since 1.0
     */
    private double[] boxPoint1 = new double[2];

    /**
     * Cordenada de la esquina inferior derecha de la casilla Las cordenadas
     * siguen el orden X,Y,Z.
     *
     * @since 1.0
     */
    private double[] boxPoint2 = new double[2];

    /**
     * Cordenada de el centro de la casilla Las cordenadas siguen el orden
     * X,Y,Z.
     *
     * @since 1.0
     */
    private double[] midCord = new double[2];

    /**
     * Cordenada de la seccion izquieda de la casilla Las cordenadas siguen el
     * orden X,Y,Z.
     *
     * @since 1.0
     */
    private double[] leftCord = new double[2];

    /**
     * Cordenada de la seccion derecha de la casilla Las cordenadas siguen el
     * orden X,Y,Z.
     *
     * @since 1.0
     */
    private double[] rightCord = new double[2];

    /**
     * Este Parametro determina si la casilla tiene que tener un comportamiento
     * Especial.
     *
     * @since 1.0
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

    /**
     * Este metodo calcula el centro de los puntos de caja 1 y 2 con formula
     * p2-+(p1 - p2)/2 este metodo puede calcular puntos negativos sin problemas
     * almenos de forma. Esto se guarda en {@code midCord[]}
     *
     * @see midCord
     * @since 1.0
     */
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

    /**
     * Este metodo calcula el punto medio entre punto de Caja 1 y Cordenada Mid
     * manteniendo la posicion Y, con la misma formula que {@code calcMid()}.
     * Este metodo guarda los datos en {@code leftCord[]}
     *
     * @see calcMid()
     * @see leftCord
     */
    private void calcLeftPoint() {

        double distX = Math.abs(boxPoint1[0] - midCord[0]);

        if (midCord[0] >= 0) {
            leftCord[0] -= distX / 2;
        } else {
            leftCord[0] += distX / 2;
        }

        leftCord[1] = midCord[1];

    }

    /**
     * Este metodo calcula el punto medio entre Cordenada Mid y punto de Caja 2
     * manteniendo la posicion Y, con la misma formula que {code calcMid()}.
     * Este metodo guarda los datos en {@code rightCord[]}.
     *
     * @see calcMid()
     * @see rightCord
     */
    private void calcRightPoint() {

        double distX = Math.abs(midCord[0] - boxPoint2[0]);

        if (boxPoint2[0] >= 0) {
            rightCord[0] -= distX / 2;
        } else {
            rightCord[0] += distX / 2;
        }

        rightCord[1] = midCord[1];

    }

    /**
     * Metodo para conseguir la referencia de la cordenada superior izquierda de
     * la casilla
     *
     * @return Referencia a el array primitivo double {@code boxPoint1}
     * @see boxPoint1
     */
    public double[] getBoxCord1() {
        return boxPoint1;
    }

    /**
     * Establece la cordenada superior izquierda **Este metodo es solo para
     * pruebas**
     *
     * @param bCord1 referencia que copiara {@code boxPoint1}
     * @see boxPoint1
     */
    public void setBoxCord1(double[] bCord1) {
        this.boxPoint1 = bCord1;
    }

    /**
     * Metodo para conseguir la referencia de la cordenada inferior derecha del panel
     * @return 
     */
    public double[] getBoxCord2() {
        return boxPoint2;
    }

    public void setBoxCord2(double[] bCord2) {
        this.boxPoint2 = bCord2;
    }

    public double[] getMidCord() {
        return midCord;
    }

    public double[] getGrubCord1() {
        return leftCord;
    }

    public double[] getGrubCord2() {
        return rightCord;
    }

}
