/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enier
 * @param <T> Representa el tipo de la lista que sea ingresada
 */
public class TurnCycle<T> {

    private List<T> players;
    private int index = 0;

    public TurnCycle(List<T> players) {
        if (players.size() < 2 || players.size() > 4) {
            throw new IllegalArgumentException("TurnCycle requiere entre 2 y 4 jugadores.");
        }
        this.players = new ArrayList<>(players);
    }

    public T current() {
        System.out.println("press Current" + "current: " + players.get(index) + " index: " + index);
        return players.get(index);
    }

    public T next() {
        System.out.println("press Next" + "current: " + players.get(index) + " index: " + index);
        index = (index + 1) % players.size();
        return current();
    }

    public int size() {
        return players.size();
    }

    public void playersClear() {
        players.clear();
    }

}
