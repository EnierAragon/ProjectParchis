/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources.sound;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.*;

/**
 *
 * @author enier
 */
public class SoundBank {

    private static final Map<String, Clip> clips = new HashMap<>();

    // Volumen global (0.0 = silencio, 1.0 = máximo)
    private static float volume = 1.0f;

    // --- Se cargan todos los sonidos una sola vez ---
    static {
        load("click", "/sounds/sfx/PopUI.wav");
        load("move", "/sounds/sfx/WoodTap.wav");
        load("error", "/sounds/sfx/BadMarimba.wav");
        load("win", "/sounds/sfx/SuccesPiano.wav");
    }

    // Cargar clip
    private static void load(String name, String path) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(
                    SoundBank.class.getResource(path)
            );
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clips.put(name, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("[SoundBank] Error cargando " + name + ": " + e.getMessage());
        }
    }

    // Reproducir y aplicar volumen
    private static void play(String name) {
        Clip clip = clips.get(name);
        if (clip != null) {
            applyVolume(clip);
            clip.setFramePosition(0);
            clip.start();
        }
    }

    // ---- Métodos públicos para reproducir sonidos ----
    public static void click() {
        play("click");
    }

    public static void move() {
        play("move");
    }

    public static void error() {
        play("error");
    }

    public static void win() {
        play("win");
    }

    // ---- Control de volumen ----
    public static void setVolume(float newVolume) {
        if (newVolume < 0f) {
            newVolume = 0f;
        }
        if (newVolume > 1f) {
            newVolume = 1f;
        }
        volume = newVolume;

        // Actualizar todos los clips ya cargados
        for (Clip c : clips.values()) {
            applyVolume(c);
        }
    }

    public static float getVolume() {
        return volume;
    }

    // Aplica MASTER_GAIN basado en volumen 0–1
    private static void applyVolume(Clip clip) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            float min = gain.getMinimum(); // típicamente ~ -80 dB
            float max = gain.getMaximum(); // típicamente ~ +6 dB

            // Interpolar entre min y max
            float dB = min + (max - min) * volume;
            gain.setValue(dB);
        }
    }

}
