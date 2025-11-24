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
     * Blanco: 0
     *
     * Negro: 1
     *
     * Azul: 2
     *
     * Verde: 3
     */
    public final String[] ocupedType = new String[4];

    private String currentType = "None";

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
        ocupedType[0] = "Blanco";
        ocupedType[1] = "Negro";
        ocupedType[2] = "Azul";
        ocupedType[3] = "Verde";
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
     * Metodo para conseguir la referencia de la cordenada inferior derecha del
     * panel
     *
     * @return
     */
    public double[] getBoxCord2() {
        return boxPoint2;
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

    public boolean isSpecialBox() {
        return specialBox;
    }

    public boolean isOcuped() {
        return ocuped;
    }

    public boolean isDobleOcuped() {
        return dobleOcuped;
    }

    public int getId() {
        return id;
    }

    public String getCurrentType() {
        return currentType;
    }

    public double[] getHomeCords() {
        return homeCords;
    }

}
