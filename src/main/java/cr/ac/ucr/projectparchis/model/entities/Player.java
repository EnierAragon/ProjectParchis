/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.entities;

/**
 *
 * @author enier
 */
public class Player {

    private String group;
    private int points = 0;

    public Player(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

}
