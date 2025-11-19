/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * Clase abstracta que permite crear objetos Graphics dibujables en paneles y
 * proporcionar algunos metodos comunes
 *
 * @author enier
 */
public abstract class GraphicsSprite {

    protected int id;
    protected int x, y;
    protected int width, height;
    protected boolean visible = true;
    protected BufferedImage sprite;

    public GraphicsSprite(Image texture, int x, int y, int id, boolean centered) {
        this.id = id;
        this.sprite = convertToBufferedImage(texture);

        if (sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        } else {
            this.width = this.height = 0;
        }

        if (centered) {
            setPositionCentered(x, y);
        } else {
            this.x = x;
            this.y = y;
        }

    }

    public GraphicsSprite(Color color, int width, int height, int x, int y, int id) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = sprite.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        setPositionCentered(x, y);
    }

    private BufferedImage convertToBufferedImage(Image img) {
        if (img instanceof BufferedImage bufferedImage) {
            return bufferedImage;
        }

        // Esperar a que la imagen cargue completamente
        img = new javax.swing.ImageIcon(img).getImage();

        BufferedImage buffered = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2d = buffered.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        return buffered;
    }

    protected BufferedImage utilConvertToBufferedImage(Image img) {
        if (img instanceof BufferedImage bufferedImage) {
            return bufferedImage;
        }

        // Esperar a que la imagen cargue completamente
        img = new javax.swing.ImageIcon(img).getImage();

        BufferedImage buffered = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2d = buffered.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        return buffered;
    }

    private void setPositionCentered(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public void draw(Graphics2D g) {
        if (visible && sprite != null) {
            g.drawImage(sprite, x, y, null);
        }
    }

    public abstract void update(Image texture);

}
