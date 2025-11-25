/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources.textures;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author enier
 */
public final class TexturesBank {
    // public static BufferedImage NAME

    public static BufferedImage CHIP_BLACK;
    public static BufferedImage CHIP_WHITE;
    public static BufferedImage CHIP_GREEN;
    public static BufferedImage CHIP_BLUE;

    static {
        CHIP_BLACK = load("/textures/chips/ChipNegro.png");
        CHIP_WHITE = load("/textures/chips/ChipBlanco.png");
        CHIP_GREEN = load("/textures/chips/ChipVerde.png");
        CHIP_BLUE = load("/textures/chips/ChipAzul.png");

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
