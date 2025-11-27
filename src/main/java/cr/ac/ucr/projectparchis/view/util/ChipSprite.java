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

    private int antX;
    private int anty;

    public ChipSprite(Image texture, int x, int y, int id) {
        super(texture, x, y, id, true);
        initComponets();
    }

    private void initComponets() {
        antX = x;
        anty = y;
    }

    public void updateCords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param cords requiere x[0], y[1]
     */
    public void updateCords(double[] cords) {
        x = (int) cords[0];
        y = (int) cords[1];
    }

    public void saveCords() {
        antX = x;
        anty = y;
    }

    public void returnCords() {
        x = antX;
        y = anty;
    }

    @Override
    public void update(Image texture) {
        this.sprite = utilConvertToBufferedImage(texture);
    }

}
