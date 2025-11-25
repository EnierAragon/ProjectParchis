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
public class Table {

    public ArrayList<BoxPiece> boxExternSpaces;
    public ArrayList<BoxPiece> boxInternSpaces;
    public ArrayList<BoxPiece> boxHomes;
    public ArrayList<BoxPiece> boxGoal;

    public Table() {
        boxExternSpaces = new ArrayList<>();
        boxInternSpaces = new ArrayList<>();
        boxHomes = new ArrayList<>();
        boxGoal = new ArrayList<>();
        initBox();
    }

    public BoxPiece searchIDBox(ArrayList<BoxPiece> list, int id) {
        BoxPiece box = new BoxPiece();
        for (BoxPiece boxPiece : list) {
            if (boxPiece.getId() == id) {
                box = boxPiece;
            }
        }
        return box;
    }

    private void initBox() {
        //External
        boxExternSpaces.add(new BoxPiece(300, 484, 333, 517, 1));
        boxExternSpaces.add(new BoxPiece(317, 518, 350, 551, 2));
        boxExternSpaces.add(new BoxPiece(317, 551, 350, 584, 3));
        boxExternSpaces.add(new BoxPiece(317, 585, 350, 618, true, 4));
        boxExternSpaces.add(new BoxPiece(317, 618, 350, 651, 5));
        boxExternSpaces.add(new BoxPiece(317, 652, 350, 685, 6));
        boxExternSpaces.add(new BoxPiece(317, 685, 350, 718, 7));
        boxExternSpaces.add(new BoxPiece(334, 719, 367, 752, 8));
        boxExternSpaces.add(new BoxPiece(367, 719, 400, 752, true, 9));
        boxExternSpaces.add(new BoxPiece(401, 719, 434, 752, 10));
        boxExternSpaces.add(new BoxPiece(417, 685, 450, 718, 11));
        boxExternSpaces.add(new BoxPiece(417, 652, 450, 685, 12));
        boxExternSpaces.add(new BoxPiece(417, 618, 450, 651, 13));
        boxExternSpaces.add(new BoxPiece(417, 585, 450, 618, 14));
        boxExternSpaces.add(new BoxPiece(417, 551, 450, 584, 15));
        boxExternSpaces.add(new BoxPiece(417, 518, 450, 551, 16));
        boxExternSpaces.add(new BoxPiece(434, 484, 467, 517, 17));
        boxExternSpaces.add(new BoxPiece(484, 434, 517, 467, 18));
        boxExternSpaces.add(new BoxPiece(518, 417, 551, 450, 19));
        boxExternSpaces.add(new BoxPiece(551, 417, 584, 450, 20));
        boxExternSpaces.add(new BoxPiece(585, 417, 618, 450, true, 21));
        boxExternSpaces.add(new BoxPiece(618, 417, 651, 450, 22));
        boxExternSpaces.add(new BoxPiece(652, 417, 685, 450, 23));
        boxExternSpaces.add(new BoxPiece(685, 417, 718, 450, 24));
        boxExternSpaces.add(new BoxPiece(719, 401, 752, 434, 25));
        boxExternSpaces.add(new BoxPiece(719, 367, 752, 400, true, 26));
        boxExternSpaces.add(new BoxPiece(719, 334, 752, 367, 27));
        boxExternSpaces.add(new BoxPiece(685, 317, 718, 350, 28));
        boxExternSpaces.add(new BoxPiece(652, 317, 685, 350, 29));
        boxExternSpaces.add(new BoxPiece(618, 317, 651, 350, 30));
        boxExternSpaces.add(new BoxPiece(585, 317, 618, 350, 31));
        boxExternSpaces.add(new BoxPiece(551, 317, 584, 350, 32));
        boxExternSpaces.add(new BoxPiece(518, 317, 551, 350, 33));
        boxExternSpaces.add(new BoxPiece(484, 300, 517, 333, 34));
        boxExternSpaces.add(new BoxPiece(434, 250, 467, 283, 35));
        boxExternSpaces.add(new BoxPiece(417, 217, 450, 250, 36));
        boxExternSpaces.add(new BoxPiece(417, 183, 450, 216, 37));
        boxExternSpaces.add(new BoxPiece(417, 150, 450, 183, true, 38));
        boxExternSpaces.add(new BoxPiece(417, 116, 450, 149, 39));
        boxExternSpaces.add(new BoxPiece(417, 83, 450, 116, 40));
        boxExternSpaces.add(new BoxPiece(417, 49, 450, 82, 41));
        boxExternSpaces.add(new BoxPiece(401, 16, 434, 49, 42));
        boxExternSpaces.add(new BoxPiece(367, 16, 400, 49, true, 43));
        boxExternSpaces.add(new BoxPiece(334, 16, 367, 49, 44));
        boxExternSpaces.add(new BoxPiece(317, 49, 350, 82, 45));
        boxExternSpaces.add(new BoxPiece(317, 83, 350, 116, 46));
        boxExternSpaces.add(new BoxPiece(317, 116, 350, 149, 47));
        boxExternSpaces.add(new BoxPiece(317, 150, 350, 183, 48));
        boxExternSpaces.add(new BoxPiece(317, 183, 350, 216, 49));
        boxExternSpaces.add(new BoxPiece(317, 217, 350, 250, 50));
        boxExternSpaces.add(new BoxPiece(300, 250, 333, 283, 51));
        boxExternSpaces.add(new BoxPiece(250, 300, 283, 333, 52));
        boxExternSpaces.add(new BoxPiece(217, 317, 250, 350, 53));
        boxExternSpaces.add(new BoxPiece(183, 317, 216, 350, 54));
        boxExternSpaces.add(new BoxPiece(150, 317, 183, 350, true, 55));
        boxExternSpaces.add(new BoxPiece(116, 317, 149, 350, 56));
        boxExternSpaces.add(new BoxPiece(83, 317, 116, 350, 57));
        boxExternSpaces.add(new BoxPiece(49, 317, 82, 350, 58));
        boxExternSpaces.add(new BoxPiece(16, 334, 49, 367, 59));
        boxExternSpaces.add(new BoxPiece(16, 367, 49, 400, true, 60));
        boxExternSpaces.add(new BoxPiece(16, 401, 49, 434, 61));
        boxExternSpaces.add(new BoxPiece(49, 417, 82, 450, 62));
        boxExternSpaces.add(new BoxPiece(83, 417, 116, 450, 63));
        boxExternSpaces.add(new BoxPiece(116, 417, 149, 450, 64));
        boxExternSpaces.add(new BoxPiece(150, 417, 183, 450, 65));
        boxExternSpaces.add(new BoxPiece(183, 417, 216, 450, 66));
        boxExternSpaces.add(new BoxPiece(217, 417, 250, 450, 67));
        boxExternSpaces.add(new BoxPiece(250, 434, 283, 467, 68));
        //Internal
        boxInternSpaces.add(new BoxPiece(367, 685, 400, 718, 69));
        boxInternSpaces.add(new BoxPiece(367, 652, 400, 685, 70));
        boxInternSpaces.add(new BoxPiece(367, 618, 400, 651, 71));
        boxInternSpaces.add(new BoxPiece(367, 585, 400, 618, 72));
        boxInternSpaces.add(new BoxPiece(367, 551, 400, 584, 73));
        boxInternSpaces.add(new BoxPiece(367, 518, 400, 551, 74));
        boxInternSpaces.add(new BoxPiece(367, 484, 400, 517, 75));
        boxInternSpaces.add(new BoxPiece(685, 367, 718, 400, 76));
        boxInternSpaces.add(new BoxPiece(652, 367, 685, 400, 77));
        boxInternSpaces.add(new BoxPiece(618, 367, 651, 400, 78));
        boxInternSpaces.add(new BoxPiece(585, 367, 618, 400, 79));
        boxInternSpaces.add(new BoxPiece(551, 367, 584, 400, 80));
        boxInternSpaces.add(new BoxPiece(518, 367, 551, 400, 81));
        boxInternSpaces.add(new BoxPiece(484, 367, 517, 400, 82));
        boxInternSpaces.add(new BoxPiece(367, 49, 400, 82, 83));
        boxInternSpaces.add(new BoxPiece(367, 83, 400, 116, 84));
        boxInternSpaces.add(new BoxPiece(367, 116, 400, 149, 85));
        boxInternSpaces.add(new BoxPiece(367, 150, 400, 183, 86));
        boxInternSpaces.add(new BoxPiece(367, 183, 400, 216, 87));
        boxInternSpaces.add(new BoxPiece(367, 217, 400, 250, 88));
        boxInternSpaces.add(new BoxPiece(367, 250, 400, 283, 89));
        boxInternSpaces.add(new BoxPiece(49, 367, 82, 400, 90));
        boxInternSpaces.add(new BoxPiece(83, 367, 116, 400, 91));
        boxInternSpaces.add(new BoxPiece(116, 367, 149, 400, 92));
        boxInternSpaces.add(new BoxPiece(150, 367, 183, 400, 93));
        boxInternSpaces.add(new BoxPiece(183, 367, 216, 400, 94));
        boxInternSpaces.add(new BoxPiece(217, 367, 250, 400, 95));
        boxInternSpaces.add(new BoxPiece(250, 367, 283, 400, 96));
        //goals
        boxGoal.add(new BoxPiece(351, 417, 417, 483, 100));
        boxGoal.add(new BoxPiece(417, 351, 483, 417, 101));
        boxGoal.add(new BoxPiece(351, 284, 417, 350, 102));
        boxGoal.add(new BoxPiece(284, 351, 350, 417, 103));
        //homes
        boxHomes.add(new BoxPiece(91, 526, 241, 676, 110));
        boxHomes.add(new BoxPiece(526, 526, 676, 676, 111));
        boxHomes.add(new BoxPiece(526, 91, 676, 241, 112));
        boxHomes.add(new BoxPiece(91, 91, 241, 241, 113));
    }

}
