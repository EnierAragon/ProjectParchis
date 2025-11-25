/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.logic;

/**
 *
 * @author enier
 * @version 1.0
 * @since 1.0
 */
public class BoxPiece {

    /**
     * Cordenada de la esquina superior izquierda de la casilla Las cordenadas
     * siguen el orden X,Y.
     *
     * @since 1.0
     */
    private double[] boxPoint1 = new double[2];

    /**
     * Cordenada de la esquina inferior derecha de la casilla Las cordenadas
     * siguen el orden X,Y.
     *
     * @since 1.0
     */
    private double[] boxPoint2 = new double[2];

    /**
     * Cordenada de el centro de la casilla Las cordenadas siguen el orden X,Y.
     *
     * @since 1.0
     */
    private double[] midCord = new double[2];

    /**
     * Cordenada de la seccion izquieda de la casilla Las cordenadas siguen el
     * orden X,Y.
     *
     * @since 1.0
     */
    private double[] leftCord = new double[2];

    /**
     * Cordenada de la seccion derecha de la casilla Las cordenadas siguen el
     * orden X,Y.
     *
     * @since 1.0
     */
    private double[] rightCord = new double[2];

    /**
     * Cordenadas que representan cuatro puntos de las casas de colores
     *
     * Superior izquierda x[0], y[1]
     *
     * Superior derecha x[2], y[3]
     *
     * Inferior izquierda x[4], y[5]
     *
     * Inferior derecha x[6], y[7]
     */
    private double[] homeCords = new double[8];

    /**
     * Negro: 0
     *
     * Blanco: 1
     *
     * Verde: 2
     *
     * Azul: 3
     */
    public final String[] Types = new String[4];

    /**
     * @see #Types
     */
    private String currentOcupedType = "None";

    /**
     * Este Parametro determina si la casilla tiene que tener un comportamiento
     * Especial.
     *
     * @since 1.0
     */
    private boolean specialBox = false;

    /**
     * Determina si hay una ficha aqui, Solo se usa en casillas de paso, no para
     * casas ni la meta
     */
    private boolean ocuped = false;

    /**
     * Determina si hay dos ficha aqui, Solo se usa en casillas de paso, no para
     * casas ni la meta
     */
    private boolean dobleOcuped = false;

    /**
     * Determina que espacios estan ocupados.
     */
    private boolean homePos1, homePos2, homePos3, homePos4 = false;

    private int id = 0;

    public BoxPiece() {
        this.boxPoint1[0] = 50;
        this.boxPoint1[1] = 250;
        this.boxPoint2[0] = 50;
        this.boxPoint2[1] = 250;
        this.id = 500;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
        calcHomeCords();
        initComponets();
    }

    public BoxPiece(double cord1x, double cord1y, double cord2x, double cord2y, int id) {
        this.boxPoint1[0] = cord1x;
        this.boxPoint1[1] = cord1y;
        this.boxPoint2[0] = cord2x;
        this.boxPoint2[1] = cord2y;
        this.id = id;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
        calcHomeCords();
        initComponets();
    }

    public BoxPiece(double cord1x, double cord1y, double cord2x, double cord2y, boolean special, int id) {
        this.boxPoint1[0] = cord1x;
        this.boxPoint1[1] = cord1y;
        this.boxPoint2[0] = cord2x;
        this.boxPoint2[1] = cord2y;
        this.specialBox = special;
        this.id = id;
        calcMid();
        calcLeftPoint();
        calcRightPoint();
        calcHomeCords();
        initComponets();
    }

    private void initComponets() {
        Types[0] = "Negro";
        Types[1] = "Blanco";
        Types[2] = "Verde";
        Types[3] = "Azul";
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

    private void calcHomeCords() {

        double distY = Math.abs(midCord[1] - boxPoint1[1]);

        //superior izquierda
        homeCords[0] = leftCord[0];
        homeCords[1] = midCord[1] - distY / 2;

        //superior derecha
        homeCords[2] = rightCord[0];
        homeCords[3] = midCord[1] - distY / 2;

        //inferior izquierda
        homeCords[4] = leftCord[0];
        homeCords[5] = midCord[1] + distY / 2;

        //inferior derecha
        homeCords[6] = rightCord[0];
        homeCords[7] = midCord[1] + distY / 2;
    }

    public int getId() {
        return id;
    }

    public String getCurrentType() {
        return currentOcupedType;
    }

    public boolean isSpecialBox() {
        return specialBox;
    }

    public void setOcuped(boolean ocuped) {
        this.ocuped = ocuped;
    }

    public boolean isOcuped() {
        return ocuped;
    }

    public void setDobleOcuped(boolean dobleOcuped) {
        this.dobleOcuped = dobleOcuped;
    }

    public boolean isDobleOcuped() {
        return dobleOcuped;
    }

    public double[] getMidCord() {
        return midCord;
    }

    public double[] getLeftCord() {
        return leftCord;
    }

    public double[] getRightCord() {
        return rightCord;
    }

    public boolean isHomePos1() {
        return homePos1;
    }

    public void setHomePos1(boolean homePos1) {
        this.homePos1 = homePos1;
    }

    public boolean isHomePos2() {
        return homePos2;
    }

    public void setHomePos2(boolean homePos2) {
        this.homePos2 = homePos2;
    }

    public boolean isHomePos3() {
        return homePos3;
    }

    public void setHomePos3(boolean homePos3) {
        this.homePos3 = homePos3;
    }

    public boolean isHomePos4() {
        return homePos4;
    }

    public void setHomePos4(boolean homePos4) {
        this.homePos4 = homePos4;
    }

    public double[] nexHomeCords() {
        double[] cords = new double[2];

        if (!homePos1) {
            cords[0] = homeCords[0];
            cords[1] = homeCords[1];
        } else if (!homePos2) {
            cords[0] = homeCords[2];
            cords[1] = homeCords[3];
        } else if (!homePos3) {
            cords[0] = homeCords[4];
            cords[1] = homeCords[5];
        } else if (!homePos4) {
            cords[0] = homeCords[6];
            cords[1] = homeCords[7];
        } else {
            cords[0] = homeCords[6];
            cords[1] = homeCords[7];
        }

        return cords;
    }

}
