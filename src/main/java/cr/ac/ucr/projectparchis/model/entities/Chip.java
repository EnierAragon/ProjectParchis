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

    static final int CENTER = 1;
    static final int LEFT = 2;
    static final int RINGHT = 3;

    static final int BLUE = 1;
    static final int GREEN = 2;
    static final int WHITE = 3;
    static final int BLACK = 4;

    private int position;
    private int grub;

    public Chip(int position, int color) {
        this.position = position;
        this.grub = color;
    
    }

}
