package game0.game;

import game0.NPCs.Enemy;
import game0.NPCs.NpcNarration;
import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.*;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GameFrame;
import window.GuiInteraction;
import javax.swing.*;
public class GameMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //inicializamos componentes
            Inventory inventory = new Inventory();
            Equipment equipment = new Equipment();
            Player player = new Player(30, 10, 1, 1);
            Enemy enemy = new Enemy();
            GameFrame frame = new GameFrame(inventory, equipment, player, enemy);
            GuiInteraction guiInteraction = frame.getGuiInteraction();
            ConsolePresentation consolePresentation = new ConsolePresentation();
            Combat combat = new Combat();
            Dice d12 = new Dice(12);
            Attacks attacks = new Attacks();
            GameEnter gameEnter = new GameEnter();
            PlayerInteractions pi = new PlayerInteractions(player, guiInteraction);

            //contexto del juego
            GameContext gc = new GameContext(consolePresentation, guiInteraction, player, enemy, combat, equipment, d12, attacks, gameEnter);

            //ejecución del bucle principal
            new Thread(() -> {
                GameStoryTeller.setUserInteraction(guiInteraction);
                NpcNarration.setUserInteraction(guiInteraction);
                PlayerOptions.setUserInteraction(guiInteraction);
                GameVoiceOver.setUserInteraction(guiInteraction);
                GameLoop.run(gc,pi);
            }).start();
        });
    }
}

