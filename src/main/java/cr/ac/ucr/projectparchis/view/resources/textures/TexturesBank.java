/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources.textures;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * Banco de texturas Costantes de un tamaño concreto
 *
 * @author enier
 */
public final class TexturesBank {
    // public static BufferedImage NAME

    public static BufferedImage BOARD_D;
    public static BufferedImage BOARD_W;

    public static BufferedImage CHIP_BLACK;
    public static BufferedImage CHIP_WHITE;
    public static BufferedImage CHIP_GREEN;
    public static BufferedImage CHIP_BLUE;

    public static ImageIcon STATUS_NONE;
    public static ImageIcon STATUS_BLACK;
    public static ImageIcon STATUS_WHITE;
    public static ImageIcon STATUS_GREEN;
    public static ImageIcon STATUS_BLUE;

    public static ImageIcon DICE1;
    public static ImageIcon DICE2;
    public static ImageIcon DICE3;
    public static ImageIcon DICE4;
    public static ImageIcon DICE5;

    static {

        BOARD_D = load("/textures/boardD.png");
        BOARD_W = load("/textures/boardW.png");

        CHIP_BLACK = load("/textures/chips/ChipNegro.png");
        CHIP_WHITE = load("/textures/chips/ChipBlanco.png");
        CHIP_GREEN = load("/textures/chips/ChipVerde.png");
        CHIP_BLUE = load("/textures/chips/ChipAzul.png");

        STATUS_NONE = new ImageIcon(load("/textures/UI/icons/Status/StatusIcon_none.png"));
        STATUS_BLACK = new ImageIcon(load("/textures/UI/icons/Status/StatusIcon_black.png"));
        STATUS_WHITE = new ImageIcon(load("/textures/UI/icons/Status/StatusIcon_white.png"));
        STATUS_GREEN = new ImageIcon(load("/textures/UI/icons/Status/StatusIcon_green.png"));
        STATUS_BLUE = new ImageIcon(load("/textures/UI/icons/Status/StatusIcon_blue.png"));

        DICE1 = new ImageIcon(load("/textures/UI/icons/Dice/DiceIcon1.png"));
        DICE2 = new ImageIcon(load("/textures/UI/icons/Dice/DiceIcon2.png"));
        DICE3 = new ImageIcon(load("/textures/UI/icons/Dice/DiceIcon3.png"));
        DICE4 = new ImageIcon(load("/textures/UI/icons/Dice/DiceIcon4.png"));
        DICE5 = new ImageIcon(load("/textures/UI/icons/Dice/DiceIcon5.png"));

    }

    private static BufferedImage load(String path) {
        try {
            return ImageIO.read(TexturesBank.class.getResource(path));
        } catch (IOException e) {
            System.err.println("No se pudo cargar textura: " + path);
            return null;
        }
    }

}
