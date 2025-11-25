/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.entities;

/**
 *
 * @author enier
 */
public class Chip {

    public static final int CENTER = 1;
    public static final int LEFT = 2;
    public static final int RINGHT = 3;

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

    private int id;
    private int plaze;
    private String grub;

    /**
     *
     *
     * @param plaze indica en que punto del tablero esta de su ruta
     * {@link cr.ac.ucr.projectparchis.model.logic.Routes}
     * @param grup usar {@link #Types}
     */
    public Chip(int plaze, String grup) {
        initComponets();
        this.plaze = plaze;
        this.grub = grup;

    }

    private void initComponets() {
        Types[0] = "Negro";
        Types[1] = "Blanco";
        Types[2] = "Verde";
        Types[3] = "Azul";
    }

}
