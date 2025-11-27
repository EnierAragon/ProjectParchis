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
/**
 * Representa una casilla del tablero con coordenadas y posiciones internas para
 * colocar fichas (cuadrantes y casas).
 */
public class BoxPiece {
    
    public String colorType;

    // coordenadas: [x, y]
    private final double[] boxPoint1 = new double[2];
    private final double[] boxPoint2 = new double[2];

    // derivados
    private final double[] midCord = new double[2];
    private final double[] leftCord = new double[2];
    private final double[] rightCord = new double[2];

    //tamaños
    private int widh;
    private int high;

    // homeCords: [suLeftX, suLeftY, suRightX, suRightY, inLeftX, inLeftY, inRightX, inRightY]
    private final double[] homeCords = new double[8];

    // Flags de ocupación (encapsulados)
    private boolean specialBox = false;
    private boolean occupied = false;
    private boolean doubleOccupiedL = false;
    private boolean doubleOccupiedR = false;

    // esquinas y subdivisiones ocupadas
    private boolean occupiedUpL = false;
    private boolean occupiedUpR = false;
    private boolean occupiedBothL = false;
    private boolean occupiedBothR = false;
    
    private int id;
    
    private String currentOccupiedType = "";

    // ---------- Constructores ----------
    public BoxPiece() {
        this(50, 250, 50, 250, false, 500);
    }
    
    public BoxPiece(double cord1x, double cord1y, double cord2x, double cord2y, int id) {
        this(cord1x, cord1y, cord2x, cord2y, false, id);
    }
    
    public BoxPiece(double cord1x, double cord1y, double cord2x, double cord2y, boolean special, int id) {
        this.boxPoint1[0] = cord1x;
        this.boxPoint1[1] = cord1y;
        this.boxPoint2[0] = cord2x;
        this.boxPoint2[1] = cord2y;
        this.specialBox = special;
        this.id = id;
        recalcAll();
    }

    // ---------- Cálculos ----------
    private void recalcAll() {
        calcSize();
        calcMid();
        calcLeftPoint();
        calcRightPoint();
        calcHomeCords();
    }
    
    private void calcSize() {
        high = (int) Math.abs(boxPoint2[0] - boxPoint1[0]);
        widh = (int) (Math.abs(boxPoint2[1] - boxPoint1[1]));
    }
    
    private void calcMid() {
        midCord[0] = (boxPoint1[0] + widh / 2);
        midCord[1] = (boxPoint1[1] + high / 2);
    }
    
    private void calcLeftPoint() {
        leftCord[0] = midCord[0] - widh / 4;
        leftCord[1] = midCord[1];
    }
    
    private void calcRightPoint() {
        rightCord[0] = midCord[0] + widh / 4;
        rightCord[1] = midCord[1];
    }
    
    private void calcHomeCords() {
        // superior izquierda
        homeCords[0] = leftCord[0];
        homeCords[1] = midCord[1] - high / 4;
        // superior derecha
        homeCords[2] = rightCord[0];
        homeCords[3] = midCord[1] - high / 4;
        // inferior izquierda
        homeCords[4] = leftCord[0];
        homeCords[5] = midCord[1] + high / 4;
        // inferior derecha
        homeCords[6] = rightCord[0];
        homeCords[7] = midCord[1] + high / 4;
    }

    // ---------- Getters inmutables (devuelven copia para seguridad) ----------
    public int getId() {
        return id;
    }
    
    public boolean isSpecialBox() {
        return specialBox;
    }
    
    public String getCurrentOccupiedType() {
        return currentOccupiedType;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
    
    public boolean isDoubleOccupiedL() {
        return doubleOccupiedL;
    }
    
    public boolean isDoubleOccupiedR() {
        return doubleOccupiedR;
    }
    
    public double[] getMidCord() {
        return new double[]{midCord[0], midCord[1]};
    }
    
    public double[] getLeftCord() {
        return new double[]{leftCord[0], leftCord[1]};
    }
    
    public double[] getRightCord() {
        return new double[]{rightCord[0], rightCord[1]};
    }

    /**
     * Devuelven copias de las coordenadas de las cuatro subdivisiones (homes).
     */
    public double[] getSuLeft() {
        return new double[]{homeCords[0], homeCords[1]};
    }
    
    public double[] getSuRight() {
        return new double[]{homeCords[2], homeCords[3]};
    }
    
    public double[] getInLeft() {
        return new double[]{homeCords[4], homeCords[5]};
    }
    
    public double[] getInRight() {
        return new double[]{homeCords[6], homeCords[7]};
    }

    // ---------- Métodos para manipular ocupación ----------
    public void occupy() {
        this.occupied = true;
    }
    
    public void release() {
        this.occupied = false;
        this.doubleOccupiedL = false;
        this.doubleOccupiedR = false;
        this.currentOccupiedType = null;
    }
    
    public void setCurrentOccupiedType(String type) {
        this.currentOccupiedType = type;
    }
    
    public void setDoubleOccupiedL(boolean value) {
        this.doubleOccupiedL = value;
    }
    
    public void setDoubleOccupiedR(boolean value) {
        this.doubleOccupiedR = value;
    }

    // esquinas/subdivisiones
    public void occupyUpLeft() {
        this.occupiedUpL = true;
    }
    
    public void releaseUpLeft() {
        this.occupiedUpL = false;
    }
    
    public boolean isOccupiedUpLeft() {
        return this.occupiedUpL;
    }
    
    public void occupyUpRight() {
        this.occupiedUpR = true;
    }
    
    public void releaseUpRight() {
        this.occupiedUpR = false;
    }
    
    public boolean isOccupiedUpRight() {
        return this.occupiedUpR;
    }
    
    public void occupyBothLeft() {
        this.occupiedBothL = true;
    }
    
    public void releaseBothLeft() {
        this.occupiedBothL = false;
    }
    
    public boolean isOccupiedBothLeft() {
        return this.occupiedBothL;
    }
    
    public void occupyBothRight() {
        this.occupiedBothR = true;
    }
    
    public void releaseBothRight() {
        this.occupiedBothR = false;
    }
    
    public boolean isOccupiedBothRight() {
        return this.occupiedBothR;
    }

    // ---------- Setters mover la caja y recalcular ----------
    public void setBoxPoints(double x1, double y1, double x2, double y2) {
        this.boxPoint1[0] = x1;
        this.boxPoint1[1] = y1;
        this.boxPoint2[0] = x2;
        this.boxPoint2[1] = y2;
        recalcAll();
    }

    // Opcional: toString() para debug
    @Override
    public String toString() {
        return "BoxPiece{id=" + id + ", mid=(" + midCord[0] + "," + midCord[1] + ")}";
    }
    
}
