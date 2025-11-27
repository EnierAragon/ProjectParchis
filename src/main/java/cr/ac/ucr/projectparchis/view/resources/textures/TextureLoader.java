/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources.textures;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * Clase creada para cargar texturas de distintos tipos de forma eficiente y con
 * opcion de cargar la textura con o sin escalado segun el metodo usado
 *
 * @see Textures
 *
 * @author enier
 */
public final class TextureLoader {

    // Cache para imágenes originales
    private static final Map<String, BufferedImage> ORIGINAL_CACHE = new ConcurrentHashMap<>();

    // Cache para imágenes escaladas -> key combinada: "ruta:WIDTHxHEIGHT"
    private static final Map<String, BufferedImage> SCALED_CACHE = new ConcurrentHashMap<>();

    // Cache para Giff
    private static final Map<String, ImageIcon> gifCache = new ConcurrentHashMap<>();

    private TextureLoader() {
    }

    /**
     * Carga una textura desde resources.
     *
     * @param resourcePath ruta en /resources (ej: "/textures/chips/red.png")
     * @return BufferedImage original, o null si falla
     */
    public static BufferedImage load(String resourcePath) {

        // Revisa si ya está en cache
        if (ORIGINAL_CACHE.containsKey(resourcePath)) {
            return ORIGINAL_CACHE.get(resourcePath);
        }

        try {
            BufferedImage img = ImageIO.read(TextureLoader.class.getResource(resourcePath));

            //guarda en cache
            if (img != null) {
                ORIGINAL_CACHE.put(resourcePath, img);
            }

            return img;

        } catch (IOException e) {
            System.err.println("[TextureLoader] Error cargando: " + resourcePath + " -> " + e.getMessage());
            return null;
        }
    }

    /**
     *
     * Carga un gif desde resources
     *
     * @param resourcePath ruta en /resources (ej: "/textures/chips/red.png")
     * @return Gif en formato ImageIcon, o null si falla
     */
    public static ImageIcon loadGIF(String resourcePath) {
        if (gifCache.containsKey(resourcePath)) {
            return gifCache.get(resourcePath);
        }

        URL url = TextureLoader.class.getResource(resourcePath);
        if (url == null) {
            System.err.println("Error: GIF no encontrado: " + resourcePath);
            return null;
        }

        ImageIcon icon = new ImageIcon(url);
        gifCache.put(resourcePath, icon);
        return icon;
    }

    /**
     * Carga y reescala una textura al tamaño indicado. este suavisa la textura.
     *
     *
     * @param resourcePath ruta en /resources
     * @param width ancho deseado
     * @param height alto deseado
     * @return BufferedImage escalado, o null si falla
     */
    public static BufferedImage loadScaled(String resourcePath, int width, int height) {

        String key = resourcePath + ":" + width + "x" + height + ":smooth";

        if (SCALED_CACHE.containsKey(key)) {
            return SCALED_CACHE.get(key);
        }

        BufferedImage original = load(resourcePath);
        if (original == null) {
            return null;
        }

        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        SCALED_CACHE.put(key, resized);
        return resized;
    }

    /**
     * Carga y reescala una textura al tamaño indicado. este suavisa la textura.
     *
     *
     * @param resourcePath ruta en /resources
     * @param size tamaño al que se escalara la imagen
     * @return BufferedImage escalado, o null si falla
     */
    public static BufferedImage loadScaled(String resourcePath, Dimension size) {
        return loadScaled(resourcePath, size.width, size.height);
    }

    /**
     * Carga y reescala una textura al tamaño indicado. este NO suavisa la
     * textura.
     *
     *
     * @param resourcePath ruta en /resources
     * @param width ancho deseado
     * @param height alto deseado
     * @return BufferedImage escalado, o null si falla
     */
    public static BufferedImage loadScaledPixel(String resourcePath, int width, int height) {

        String key = resourcePath + ":" + width + "x" + height + ":pixel";

        if (SCALED_CACHE.containsKey(key)) {
            return SCALED_CACHE.get(key);
        }

        BufferedImage original = load(resourcePath);
        if (original == null) {
            return null;
        }

        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        SCALED_CACHE.put(key, resized);
        return resized;
    }

    /**
     * Carga y reescala una textura al tamaño indicado. este NO suavisa la
     * textura.
     *
     *
     * @param resourcePath ruta en /resources
     * @param size tamaño al que se escalara la imagen
     * @return BufferedImage escalado, o null si falla
     */
    public static BufferedImage loadScaledPixel(String resourcePath, Dimension size) {
        return loadScaledPixel(resourcePath, size.width, size.height);
    }

    public static void clearCache() {
        ORIGINAL_CACHE.clear();
        SCALED_CACHE.clear();
        System.out.println("[TextureLoader] Cache limpiado.");
    }

}
