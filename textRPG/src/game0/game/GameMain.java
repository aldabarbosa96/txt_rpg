package game0.game;

import game0.NPCs.Enemy;
import game0.NPCs.NpcNarration;
import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.combats.CombatLogic;
import game0.events.combats.CombatNarrator;
import game0.events.combats.CombatTablePum;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.*;
import game0.threads.thread.ThreadPonYTable;
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
            Player player = new Player(1,0, 30, 5, 1,1);
            Enemy enemy = new Enemy();
            GameFrame frame = new GameFrame(inventory, equipment, player, enemy);
            GuiInteraction guiInteraction = frame.getGuiInteraction();
            ConsolePresentation consolePresentation = new ConsolePresentation();
            CombatNarrator combat = new CombatNarrator();
            Attacks attacks = new Attacks();
            GameEnter gameEnter = new GameEnter();
            PlayerInteractions pi = new PlayerInteractions(player, guiInteraction);
            CombatLogic cl = new CombatLogic();
            CombatTablePum ctp = new CombatTablePum();
            ThreadPonYTable tpt = new ThreadPonYTable();

            //contexto del juego
            GameContext gc = new GameContext(consolePresentation, guiInteraction, player, enemy, combat, equipment, attacks, gameEnter, cl,ctp,tpt);

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

