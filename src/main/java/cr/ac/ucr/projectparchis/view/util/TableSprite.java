/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.util;

import java.awt.Image;

/**
 *
 * @author enier
 */
public class TableSprite extends GraphicsSprite {

    public TableSprite(Image texture, int x, int y, int id) {
        super(texture, x, y, id, false);
    }

    @Override
    public void update(Image texture) {
        this.sprite = utilConvertToBufferedImage(texture);
    }

}
