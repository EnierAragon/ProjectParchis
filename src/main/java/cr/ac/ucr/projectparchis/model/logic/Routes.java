/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author enier
 */
public class Routes {

    Table table;

    public Map<String, ArrayList<BoxPiece>> routesMap = new HashMap<>();

    public ArrayList<BoxPiece> routeBlack;
    public ArrayList<BoxPiece> routeWhite;
    public ArrayList<BoxPiece> routeGreen;
    public ArrayList<BoxPiece> routeBlue;

    public Routes() {
        initComponets();
        fillListBlack();
        fillListWithe();
        fillListGreen();
        fillListBlue();
        initMap();
    }

    public Routes(Table table) {
        initComponets(table);
        fillListBlack();
        fillListWithe();
        fillListGreen();
        fillListBlue();
        initMap();
    }

    private void initComponets() {
        table = new Table();
        routeBlack = new ArrayList<>();
        routeWhite = new ArrayList<>();
        routeGreen = new ArrayList<>();
        routeBlue = new ArrayList<>();
    }

    private void initComponets(Table table) {
        this.table = table;
        routeBlack = new ArrayList<>();
        routeWhite = new ArrayList<>();
        routeGreen = new ArrayList<>();
        routeBlue = new ArrayList<>();
    }

    private void fillListBlack() {
        routeBlack.add(table.searchIDBox(table.boxHomes, 112));
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (31 <= boxPiece.getId() && 68 >= boxPiece.getId()) {
                routeBlack.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (1 <= boxPiece.getId() && 26 >= boxPiece.getId()) {
                routeBlack.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxInternSpaces) {
            if (76 <= boxPiece.getId() && 82 >= boxPiece.getId()) {
                routeBlack.add(boxPiece);
            }
        }
        routeBlack.add(table.searchIDBox(table.boxGoal, 101));
    }

    private void fillListWithe() {
        routeWhite.add(table.searchIDBox(table.boxHomes, 110));
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (65 <= boxPiece.getId() && 68 >= boxPiece.getId()) {
                routeWhite.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (1 <= boxPiece.getId() && 60 >= boxPiece.getId()) {
                routeWhite.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxInternSpaces) {
            if (90 <= boxPiece.getId() && 96 >= boxPiece.getId()) {
                routeWhite.add(boxPiece);
            }
        }
        routeWhite.add(table.searchIDBox(table.boxGoal, 103));
    }

    private void fillListGreen() {
        routeGreen.add(table.searchIDBox(table.boxHomes, 111));
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (14 <= boxPiece.getId() && 68 >= boxPiece.getId()) {
                routeGreen.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (1 <= boxPiece.getId() && 9 >= boxPiece.getId()) {
                routeGreen.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxInternSpaces) {
            if (69 <= boxPiece.getId() && 75 >= boxPiece.getId()) {
                routeGreen.add(boxPiece);
            }
        }
        routeGreen.add(table.searchIDBox(table.boxGoal, 100));
    }

    private void fillListBlue() {
        routeBlue.add(table.searchIDBox(table.boxHomes, 113));
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (48 <= boxPiece.getId() && 68 >= boxPiece.getId()) {
                routeBlue.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (1 <= boxPiece.getId() && 43 >= boxPiece.getId()) {
                routeBlue.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxInternSpaces) {
            if (83 <= boxPiece.getId() && 89 >= boxPiece.getId()) {
                routeBlue.add(boxPiece);
            }
        }
        routeBlue.add(table.searchIDBox(table.boxGoal, 102));
    }

    private void initMap() {
        routesMap.put("Azul", routeBlue);
        routesMap.put("Verde", routeGreen);
        routesMap.put("Negro", routeBlack);
        routesMap.put("Blanco", routeWhite);
    }

    /**
     * @param boxPieces array a comparar
     * @param id id a buscar
     * @return regresa el BoxPiece que sea igual al id sino null
     */
    public BoxPiece getBoxPiece(ArrayList<BoxPiece> boxPieces, int id) {
        for (BoxPiece boxPiece : boxPieces) {
            if (boxPiece.getId() == id) {
                return boxPiece;
            }
        }
        return null;
    }

    public BoxPiece nexBoxPiece(ArrayList<BoxPiece> boxPieces, int id) {
        int index;
        index = boxPieces.indexOf(getBoxPiece(boxPieces, id));
        if (index == -1) {
            return null;
        } else if (index + 1 > boxPieces.size()) {
            return boxPieces.get(index);
        } else {
            return boxPieces.get(index + 1);
        }
    }

    public int getIndex(ArrayList<BoxPiece> boxPieces, int id) {
        int index;
        index = boxPieces.indexOf(getBoxPiece(boxPieces, id));
        return index;
    }

}
