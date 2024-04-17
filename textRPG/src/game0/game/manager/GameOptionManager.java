package game0.game.manager;

import game0.game.narrative.Tutorial;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Equipment;
import game0.player.Player;
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
                gc.getCombat().combatFlowNarrator(gc);
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
        gi.pauseForUserInput(); GameVoiceOver.separador(gi);
        GameVoiceOver.dialogo(14,null);
        gi.pauseForUserInput(); GameVoiceOver.separador(gi);
        equipment.equiparItem("manoD", "Navaja (+1 Fuerza)"); //todo -> esto hay que manejarlo de forma dinámica
        player.setAttack((player.getAttack()+1));
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
        Player.statsPlayer(player, gi);
    }

    protected static void manageOption02E(GameContext gc) {
        if (gc.getPlayer().getXp() <= 100){
            gc.getCombat().combatFlowNarrator(gc);
        } else {
            GameVoiceOver.separador(gc.getGuiInteraction());
            GameStoryTeller.narrar(48,gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
        }
    }

}
