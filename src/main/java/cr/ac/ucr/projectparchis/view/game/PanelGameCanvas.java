/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.game;

import cr.ac.ucr.projectparchis.model.entities.Chip;
import cr.ac.ucr.projectparchis.view.cust.CustPalette;
import cr.ac.ucr.projectparchis.view.cust.CustPanel;
import cr.ac.ucr.projectparchis.view.resources.textures.TexturesBank;
import cr.ac.ucr.projectparchis.view.util.ChipSprite;
import cr.ac.ucr.projectparchis.view.util.GraphicsSprite;
import cr.ac.ucr.projectparchis.view.util.TableSprite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author enier
 */
public class PanelGameCanvas extends CustPanel {

    private ChipSprite chip1P1, chip2P1, chip3P1, chip4P1;
    private ArrayList<ChipSprite> chipSpritesP1;

    private ChipSprite chip1P2, chip2P2, chip3P2, chip4P2;
    private ArrayList<ChipSprite> chipSpritesP2;

    private List<ChipSprite> sprites;
    TableSprite table;

    private boolean running = false;
    private Timer timer;

    public PanelGameCanvas() {
        super("PanelGameCanvas", new Dimension(768, 768), new Dimension(768, 768));
        this.chipSpritesP1 = new ArrayList<>();
        this.chipSpritesP2 = new ArrayList<>();

        initComponets();
        initGameLoop();

        this.setBackground(CustPalette.GRAY);
        this.setVisible(true);
    }

    private void initComponets() {
        this.sprites = new ArrayList<>();
        table = new TableSprite(TexturesBank.BOARD_D, 0, 0, 0);
    }

    public void modSincP1(ArrayList<Chip> al, Image texture) {
        // Limpia la lista solo UNA vez
        chipSpritesP1.clear();

        for (Chip chip : al) {
            System.out.println("[Log] carga a canvas: " + chip.getX() + "  " + chip.getY());
            chipSpritesP1.add(new ChipSprite(texture, chip.getX(), chip.getY(), chip.id));
        }

        // Limpia referencias viejas
        sprites.removeIf(s -> s instanceof ChipSprite && al.stream().noneMatch(c -> c.id == s.id));

        sprites.addAll(chipSpritesP1);
    }

    public void modSincP2(ArrayList<Chip> al, Image texture) {
        chipSpritesP2.clear();

        for (Chip chip : al) {
            System.out.println("[Log] carga a canvas: " + chip.getX() + "  " + chip.getY());
            chipSpritesP2.add(new ChipSprite(texture, chip.getX(), chip.getY(), chip.id));
        }

        sprites.addAll(chipSpritesP2);
    }

    public void updateCord(int x, int y, int id) {
        for (ChipSprite sprite : sprites) {
            if (sprite.id == id) {
                System.out.println("[LOG] updateCordsCanvas: " + x + "  " + y + "  " + sprite.id);
                sprite.updateCords(x, y);
            }
        }
    }

    public void updateCord(ArrayList<Chip> al) {

        for (Chip chip : al) {
            int cid = chip.id;
            int cx = chip.getX();
            int cy = chip.getY();

            for (ChipSprite sprite : sprites) {
                if (sprite.id == cid) {
                    sprite.updateCords(cx, cy);
                    System.out.println("{Flood} Se actualizo una textura");
                    break; // no sigas buscando.
                }
            }
        }
    }

    public void addSprite(ChipSprite sprite) {
        sprites.add(sprite);
    }

    public void removeSprite(ChipSprite sprite) {
        sprites.remove(sprite);
    }

    public void removeSprite(int id) {
        for (int i = 0; i < sprites.size(); i++) {
            if (sprites.get(i).id == id) {
                sprites.remove(i);
                break;
            }
        }
    }

    private void initGameLoop() {
        // 16 ms ≈ 60 FPS
        int delay = 16;
        timer = new Timer(delay, (var e) -> {
            if (running) {
                repaint();
            }
        });
    }

    public void start() {
        if (!running) {
            running = true;
            timer.start();
        }
    }

    public void stop() {
        running = false;
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        table.draw(g2d);

        for (GraphicsSprite sprite : sprites) {
            sprite.draw(g2d);
        }

        g2d.dispose();
    }

    public void setChipsSprite() {

    }

}
