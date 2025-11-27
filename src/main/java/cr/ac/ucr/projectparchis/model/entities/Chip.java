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

    public int id;
    private int boxID;
    private String group;

    private int x;
    private int y;

    /**
     *
     *
     * @param plaze indica en que punto del tablero esta de su ruta
     * {@link cr.ac.ucr.projectparchis.model.logic.Routes}
     * @param grup usar {@link #TYPES}
     */
    public Chip(int plaze, String grup) {
        this.boxID = plaze;
        this.group = grup;
    }

    public void setBoxID(int boxID) {
        this.boxID = boxID;
    }

    public void setGrub(String grub) {
        this.group = grub;
    }

    public void setCords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getBoxID() {
        return boxID;
    }

    public String getGroup() {
        return group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
