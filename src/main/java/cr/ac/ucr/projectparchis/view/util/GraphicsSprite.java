/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.util;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * Clase abstracta que permite crear objetos Graphics dibujables en paneles y
 * proporcionar algunos metodos comunes
 *
 * @author enier
 */
public abstract class GraphicsSprite {

    protected int x, y;
    protected int width, height;
    protected boolean visible = true;
    protected Image sprite;

    public GraphicsSprite(Image texture, int x, int y) {
        this.sprite = texture;
        if (texture != null) {
            this.width = texture.getWidth(null);
            this.height = texture.getHeight(null);
        }

        setPositionCentered(x, y);

    }

    public void setPositionCentered(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public void draw(Graphics2D g) {
        if (visible && sprite != null) {
            g.drawImage(sprite, x, y, null);
        }
    }

    public abstract void update();

}
