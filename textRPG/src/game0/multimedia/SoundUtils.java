package game0.multimedia;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundUtils {
    private static Clip typingClip;
    private static Clip startGameClip;

    public static void loadTypingSound(URL soundFile) {
        try {
            if (typingClip != null && typingClip.isOpen()) {
                typingClip.close();
            }
            typingClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            typingClip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playTypingSound() {
        if (typingClip != null) {
            typingClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void stopTypingSound() {
        if (typingClip != null && typingClip.isRunning()) {
            typingClip.stop();
        }
    }
    public static void loadStartGameSound(URL soundFile) {
        try {
            if (startGameClip != null && startGameClip.isOpen()) {
                startGameClip.close();
            }
            startGameClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            startGameClip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playStartGameSound() {
        if (startGameClip != null) {
            startGameClip.start();
        }
    }
}
