/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model;

import cr.ac.ucr.projectparchis.model.entities.Chip;
import cr.ac.ucr.projectparchis.model.entities.Player;
import cr.ac.ucr.projectparchis.model.entities.TurnCycle;
import cr.ac.ucr.projectparchis.model.logic.BoxPiece;
import cr.ac.ucr.projectparchis.model.logic.Routes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author enier
 */
public class GameState {

    private final Map<String, String> invertPlayer = new HashMap<>();

    public TurnCycle<Player> listCycle;

    private int lastID;
    private int lastDice = 0;

    private String group = "";

    public Player playerManual;
    public Player playerCPU;

    public ArrayList<Chip> chipsP1;
    private Chip chip1P1, chip2P1, chip3P1, chip4P1;

    public ArrayList<Chip> chipsP2;
    private Chip chip1P2, chip2P2, chip3P2, chip4P2;

    private Routes routes;

    public GameState(Routes rute) {
        this.routes = rute;
        initMap();
        lastID = 0;
    }

    private void initMap() {
        invertPlayer.put("Negro", "Blanco");
        invertPlayer.put("Blanco", "Negro");
        invertPlayer.put("Verde", "Azul");
        invertPlayer.put("Azul", "Verde");
    }

    public void setGroup(String group) {
        lastID = 0;

        playerManual = new Player(group);
        playerCPU = new Player(invertPlayer.get(group));

        setChipGrupP1(group);
        setChipGrupP2(invertPlayer.get(group));

        initTurnCycle(playerManual, playerCPU);

        chipUpdate();
    }

    private void setChipGrupP1(String group) {
        System.out.println("[log] setcGrup: " + group);
        chip1P1 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip2P1 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip3P1 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip4P1 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chipsP1 = new ArrayList<>(Arrays.asList(chip1P1, chip2P1, chip3P1, chip4P1));
        for (Chip chip : chipsP1) {
            chip.id = lastID++;
        }
    }

    private void setChipGrupP2(String group) {
        System.out.println("[log] setcGrup: " + group);
        chip1P2 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip2P2 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip3P2 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chip4P2 = new Chip(routes.routesMap.get(group).get(0).getId(), group);
        chipsP2 = new ArrayList<>(Arrays.asList(chip1P2, chip2P2, chip3P2, chip4P2));
        for (Chip chip : chipsP2) {
            chip.id = lastID++;
        }
    }

    private void initTurnCycle(Player p1, Player p2) {
        listCycle = new TurnCycle<>(new ArrayList<>(List.of(p1, p2)));
    }

    public void nexBox(Chip chip, Player p) {
        ArrayList<BoxPiece> route = routes.routesMap.get(p.getGroup());
        BoxPiece current = routes.getBoxPiece(route, chip.getBoxID());
        int index = routes.routesMap.get(p.getGroup()).indexOf(current);

        // --- liberar estado actual dependiendo del tipo de ocupación ---
        if (index == 0) {
            // Estamos en la casilla inicial (usa subdivisiones)
            if (current.isOccupiedBothLeft()) {
                current.releaseBothLeft();
            }
            if (current.isOccupiedBothRight()) {
                current.releaseBothRight();
            }
            if (current.isOccupiedUpLeft()) {
                current.releaseUpLeft();
            }
            if (current.isOccupiedUpRight()) {
                current.releaseUpRight();
            }

            chipUpdate();
        } else {
            // Casillas normales (usa occupied / doubleOccupied)
            if (current.isDoubleOccupiedL()) {
                current.setDoubleOccupiedL(false);
                current.occupy();
                chipUpdate();

            } else if (current.isDoubleOccupiedR()) {
                current.setDoubleOccupiedR(false);
                current.occupy();
                chipUpdate();

            } else if (current.isOccupied()) {
                current.release(); // deja la casilla completamente libre
            }
        }

        // --- mover ficha a la siguiente casilla ---
        BoxPiece next = routes.nexBoxPiece(route, chip.getBoxID());
        chip.setBoxID(next.getId());

        // Llamar al método que se encarga de ocupar la casilla correcta
        currentBox(chip, p);

    }

    public void nextBoxNumber(int diceNumber, Chip chip, Player p) {
        ArrayList<BoxPiece> route = routes.routesMap.get(p.getGroup());
        BoxPiece current = routes.getBoxPiece(route, chip.getBoxID());
        int index = routes.routesMap.get(p.getGroup()).indexOf(current);

        // --- liberar estado actual dependiendo del tipo de ocupación ---
        if (index == 0) {
            // Estamos en la casilla inicial (usa subdivisiones)
            if (current.isOccupiedBothLeft()) {
                current.releaseBothLeft();
            }
            if (current.isOccupiedBothRight()) {
                current.releaseBothRight();
            }
            if (current.isOccupiedUpLeft()) {
                current.releaseUpLeft();
            }
            if (current.isOccupiedUpRight()) {
                current.releaseUpRight();
            }

            chipUpdate();
        } else {
            // Casillas normales (usa occupied / doubleOccupied)
            if (current.isDoubleOccupiedL()) {
                current.setDoubleOccupiedL(false);
                current.occupy();
                chipUpdate();

            } else if (current.isDoubleOccupiedR()) {
                current.setDoubleOccupiedR(false);
                current.occupy();
                chipUpdate();

            } else if (current.isOccupied()) {
                current.release(); // deja la casilla completamente libre
            }
        }

        // --- mover ficha a la siguiente casilla ---
        BoxPiece next = routes.getBoxPieceIndex(route, index + diceNumber);
        chip.setBoxID(next.getId());

        // Llamar al método que se encarga de ocupar la casilla correcta
        currentBox(chip, p);

    }

    public void currentBox(Chip chip, Player p) {
        ArrayList<BoxPiece> route = routes.routesMap.get(chip.getGroup());
        BoxPiece box = routes.getBoxPiece(route, chip.getBoxID());
        int index = routes.routesMap.get(p.getGroup()).indexOf(box);

        String color = chip.getGroup(); // para guardar quién ocupa

        // ===============================
        //   CASILLAS NORMALES (index != 0)
        // ===============================
        if (index != 0) {

            // Slot 1 vacío → ocuparlo
            if (!box.isOccupied()) {
                box.occupy();
                box.setCurrentOccupiedType(color);
                updateCordsChip(chip, p, 0);
                return;
            }

            // Slot 2 vacío → marcar doubleOccupied
            if (!box.isDoubleOccupiedL()) {
                box.setDoubleOccupiedL(true);
                updateCordsChip(chip, p, 1);
                return;
            }

            // Ya está llena → slot 3 (fallback)
            if (box.isDoubleOccupiedR()) {
                box.setDoubleOccupiedR(true);
                updateCordsChip(chip, p, 2);
                return;
            }

            return; // redundante
        }

        // ===============================
        //     CASILLA INICIAL (index == 0)
        //     Usa 4 subdivisiones
        // ===============================
        if (index == 0) {

            if (!box.isOccupiedUpLeft()) {
                updateCordsChip(chip, p, 3);
                box.occupyUpLeft();
                return;
            }

            if (!box.isOccupiedBothLeft()) {
                updateCordsChip(chip, p, 4);
                box.occupyBothLeft();
                return;
            }

            if (!box.isOccupiedUpRight()) {
                updateCordsChip(chip, p, 5);
                box.occupyUpRight();
                return;
            }

            if (!box.isOccupiedBothRight()) {
                updateCordsChip(chip, p, 6);
                box.occupyBothRight();
                return;
            }
        }
    }

    /**
     * Uso de Type: {@code 0: Centro , 1: Centro Izquierda, 2; Centro Derecha,
     *  3: Superior Izquierda, 4: Superior Derecha,
     *  5: Inferior Izquierda, 6: Inferior Derecha}
     *
     * @param chip ficha a actualizar
     * @param p jugador padre se usa para determinar el team
     * @param type determina en que posicion se actualiza
     */
    private void updateCordsChip(Chip chip, Player p, int type) {
        ArrayList<BoxPiece> route = routes.routesMap.get(p.getGroup());
        BoxPiece box = routes.getBoxPiece(route, chip.getBoxID());

        // Tabla de posibles coordenadas según "type"
        double[][] coords = new double[][]{
            box.getMidCord(), // 0: Centro
            box.getLeftCord(), // 1: Centro Izquierda
            box.getRightCord(), // 2: Centro Derecha
            box.getSuLeft(), // 3: Superior Izquierda
            box.getSuRight(), // 4:  Superior Derecha
            box.getInLeft(), // 5:Inferior Izquierda
            box.getInRight() // 6: Inferior Derecha
        };

        if (type < 0 || type >= coords.length) {
            System.out.println("[WARNING] updateCordsChip: invalid type " + type);
            return;
        }

        double[] c = coords[type];
        chip.setCords((int) c[0], (int) c[1]);
        System.out.println("[LOD] chipBoxID: " + chip.getBoxID());
        System.out.println("[LOD] boxID: " + box.getId());
        System.out.println("[LOG] game state update cords c[] Type: " + type);
        System.out.println("[LOG] game state update cords c[]: " + c[0] + "  " + c[1]);
        System.out.println("[LOG] game state update cords chip: " + chip.getX() + "  " + chip.getY());
    }

    private void chipUpdate() {
        for (Chip chip : chipsP1) {
            currentBox(chip, playerManual);
        }
        for (Chip chip : chipsP2) {
            currentBox(chip, playerCPU);
        }
    }

    /**
     * @return un numero del 1 al 5.
     */
    public int diceRoll() {
        lastDice = ThreadLocalRandom.current().nextInt(1, 6);
        return lastDice;
    }

    public int getLastDice() {
        return lastDice;
    }

    public String getLastDiceString() {
        return "" + lastDice;
    }

    public Chip getChipInCords(int x, int y) {
        final int SIZE = 18;

        Player current = listCycle.current();
        ArrayList<Chip> chips
                = current.getGroup().equals(chipsP1.getFirst().getGroup()) ? chipsP1 : chipsP2;

        for (Chip chip : chips) {
            int cx = chip.getX();
            int cy = chip.getY();

            if (x >= cx && x <= cx + SIZE
                    && y >= cy && y <= cy + SIZE) {
                return chip;
            }
        }

        return null;
    }

}
