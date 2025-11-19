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
public class ChipSprite extends GraphicsSprite {

    public ChipSprite(Image texture, int x, int y, int id) {
        super(texture, x, y, id, true);
    }

    @Override
    public void update(Image texture) {
        this.sprite = utilConvertToBufferedImage(texture);
    }

}
