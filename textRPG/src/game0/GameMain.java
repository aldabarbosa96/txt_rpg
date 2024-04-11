package game0;

import game0.NPCs.NpcOptions;
import game0.console.ConsoleInteraction;
import game0.console.ConsolePresentation;
import game0.player.PlayerOptions;
import window.GameFrame;
import javax.swing.*;
import java.util.Locale;


public class GameMain {
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });*///todo --> esto implementa una GUI básica que extenderemos e implementaremos en un futuro

        ConsoleInteraction ui = new ConsoleInteraction();
        ConsolePresentation cp = new ConsolePresentation();
        GameStoryTeller.setUserInteraction(ui);
        NpcOptions.setUserInteraction(ui);
        PlayerOptions.setUserInteraction(ui);
        GameVoiceOver.setUserInteraction(ui);
        GameLoop.run(ui,cp);
    }
}
