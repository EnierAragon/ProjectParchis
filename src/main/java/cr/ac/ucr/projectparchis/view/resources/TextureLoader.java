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
public final class TextureLoader {

    public static BufferedImage load(String resourcePath) {
        try {
            return ImageIO.read(TextureLoader.class.getResource(resourcePath));
        } catch (IOException e) {
            System.err.println("Error cargando textura: " + resourcePath);
            return null;
        }
    }

}
