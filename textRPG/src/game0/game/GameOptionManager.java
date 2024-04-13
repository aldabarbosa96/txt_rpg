package game0.game;

import game0.events.Tutorial;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameOptionManager {
    protected static boolean manageOption01(String option, GameContext gc) {
        switch (option) {
            case "a":
                Tutorial.tutorialEvent(gc);
                return true;
            case "b":
            case "c":
                GameStoryTeller.narrar(17, null);
                gc.getCombat().combatFlow(gc);
                return true;
            default:
                GameStoryTeller.narrar(26, null);
                return false;
        }
    }
    protected static void manageOption02A(GuiInteraction gi, Player player, Equipment equipment) {
        GameStoryTeller.narrar(24, player);
        gi.pauseForUserInput();
        GameStoryTeller.narrar(31, player);
        gi.pauseForUserInput();
        equipment.equiparManoD("Navaja Multiusos (+1 Fuerza)");
        GameStoryTeller.narrar(25, null);
    }

    protected static void manageOption02B(GuiInteraction gi, Player player) {
        GameStoryTeller.narrar(27, null);
        gi.pauseForUserInput();
        Tutorial.tutorialEvent01(gi, player);
    }

    protected static void manageOption02C() {
        GameStoryTeller.narrar(28, null);
        System.exit(0);
    }

    protected static void manageOption02D(GuiInteraction gi, Player player, GameEnter enter) {
        GameStoryTeller.narrar(29, null);
        player.setName(gi.getInput());
        enter.invalidName(gi, player);
        PlayerStatistics.statsPlayer(player, gi);
    }

    protected static void manageOption02E(GameContext gc) {
        gc.getCombat().combatFlow(gc);
    }
}
