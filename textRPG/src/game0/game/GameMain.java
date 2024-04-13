package game0.game;

import game0.NPCs.NpcOptions;
import game0.console.ConsolePresentation;
import game0.player.PlayerOptions;
import window.GameFrame;
import window.GuiInteraction;

import javax.swing.*;
public class GameMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            GuiInteraction guiInteraction = frame.getGuiInteraction();

            new Thread(() -> {
                ConsolePresentation cp = new ConsolePresentation();

                GameStoryTeller.setUserInteraction(guiInteraction);
                NpcOptions.setUserInteraction(guiInteraction);
                PlayerOptions.setUserInteraction(guiInteraction);
                GameVoiceOver.setUserInteraction(guiInteraction);
                GameLoop.run(guiInteraction, cp);

            }).start();
        });
    }
}
