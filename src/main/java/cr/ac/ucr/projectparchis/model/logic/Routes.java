/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.model.logic;

import java.util.ArrayList;

/**
 *
 * @author enier
 */
public class Routes {

    Table table;

    ArrayList<BoxPiece> routeBlack;
    ArrayList<BoxPiece> routeWithe;
    ArrayList<BoxPiece> routeGreen;
    ArrayList<BoxPiece> routeBlue;

    public Routes() {
        initComponets();
        fillListBlack();
        fillListWithe();
        fillListGreen();
        fillListBlue();
    }

    public Routes(Table table) {
        initComponets(table);
        fillListBlack();
        fillListWithe();
        fillListGreen();
        fillListBlue();
    }

    private void initComponets() {
        table = new Table();
        routeBlack = new ArrayList<>();
        routeWithe = new ArrayList<>();
        routeGreen = new ArrayList<>();
        routeBlue = new ArrayList<>();
    }

    private void initComponets(Table table) {
        this.table = table;
        routeBlack = new ArrayList<>();
        routeWithe = new ArrayList<>();
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
        routeWithe.add(table.searchIDBox(table.boxHomes, 110));
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (65 <= boxPiece.getId() && 68 >= boxPiece.getId()) {
                routeWithe.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxExternSpaces) {
            if (1 <= boxPiece.getId() && 60 >= boxPiece.getId()) {
                routeWithe.add(boxPiece);
            }
        }
        for (BoxPiece boxPiece : table.boxInternSpaces) {
            if (90 <= boxPiece.getId() && 96 >= boxPiece.getId()) {
                routeWithe.add(boxPiece);
            }
        }
        routeWithe.add(table.searchIDBox(table.boxGoal, 103));
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

}
