/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.projectparchis.view.resources.sound;

import java.io.IOException;
import javax.sound.sampled.*;

/**
 *
 * @author enier
 */
public class MusicPlayer {

    private Clip clip;
    private FloatControl volumeControl;

    public static final String BGM = "/sounds/music/LoopDreamingStarsSilent.wav";

    /**
     * Reproduce una música en loop continuo.
     *
     * @param path ruta del archivo dentro de resources (ej:
     * "/sounds/music/main.wav")
     */
    public void playLoop(String path) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                    getClass().getResource(path)
            );

            clip = AudioSystem.getClip();
            clip.open(audio);

            // Intentar obtener control de volumen
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("[MusicPlayer] Error cargando " + path + " : " + e.getMessage());
        }
    }

    /**
     * Ajusta el volumen.
     *
     * @param volume valor entre 0.0 (mute) y 1.0 (máximo)
     */
    public void setVolume(float volume) {
        if (volumeControl == null) {
            return;
        }

        // Limitar rango porque MASTER_GAIN usa decibelios negativos
        float min = volumeControl.getMinimum(); // aprox -80 dB
        float max = volumeControl.getMaximum(); // aprox +6 dB

        // Transformación lineal volumen(0–1) → dB real
        float gain = min + (max - min) * volume;
        volumeControl.setValue(gain);
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

}
