/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author enier
 */
public final class TexturesBank {
    // public static BufferedImage NAME

    static {
        // NAME = load("/textures/...");
        
        
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
