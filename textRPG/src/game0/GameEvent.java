package game0;

import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.events.Tutorial;
import game0.interfaces.UserInteraction;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import game0.NPCs.Enemy;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameEvent {
    public static void gestionEventos01(ConsolePresentation cp, GuiInteraction gi, Player player, Enemy enemy, Combat combate, Object entity,PlayerStatistics ps, Dice dado,Attacks attack) {
        boolean esValida = false;
        PlayerOptions.opcion(4, player);
        do {
            String respuesta = gi.getInput().toLowerCase();
            esValida = handleInputOption(respuesta, cp, gi, player, enemy, combate, ps,attack);
        } while (!esValida);
    }

    private static boolean handleInputOption(String option, ConsolePresentation cp, GuiInteraction gi, Player player, Enemy enemy, Combat combate, PlayerStatistics ps, Attacks attack) {
        switch (option) {
            case "a":
                Tutorial.tutorialEvent(cp, gi, player, enemy, combate, ps,attack);
                return true;
            case "b":
            case "c":
                GameStoryTeller.narrar(17, null);
                combate.combatFlow(cp, player, enemy,ps,gi,attack);
                return true;
            default:
                GameStoryTeller.narrar(26, null);
                return false;
        }
    }

    public static void gestionEventos02(ConsolePresentation cp, GuiInteraction gi, Player player, GameEnter enter, Combat combat, Enemy enemy, Equipment equipment,PlayerStatistics ps, Dice dado,Attacks attack) {
        String opcionEsc = "";
        do {
            PlayerOptions.opcion(6, player);
            opcionEsc = gi.getInput().toLowerCase();

            switch (opcionEsc) {
                case "a":
                    manageOptionA(gi, player, equipment);
                    break;
                case "c":
                    manageOptionC();
                    break;
                case "b":
                    manageOptionB(gi, player);
                    break;
                case "d":
                    manageOptionD(gi, player, enter);
                    break;
                case "e":
                    manageOptionE(cp, player, enemy, combat, ps, gi, attack);
                    break;
                default:
                    GameStoryTeller.narrar(26, null);
                    gi.showMessage("\n");
            }
        } while (!opcionEsc.equals("a") && !opcionEsc.equals("c"));
    }

    public static String gestionEventos03(Player player, GuiInteraction gi, Equipment equipment) {
        while (true) {
            GameVoiceOver.dialogo(13, player);
            gi.pauseForUserInput();
            PlayerOptions.opcion(7, player);

            String opcion = gi.getInput().toLowerCase();
            switch (opcion) {
                case "1":
                    GameEnter.enterInv(gi);
                    break;
                case "2":
                    GameEnter.enterEquipo(gi, equipment);
                    break;
                case "3":
                    PlayerStatistics.statsPlayer(player, gi);
                    break;
                case "d":
                    GameVoiceOver.dialogo(18, null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(45, null);
                    gi.pauseForUserInput();
                    break;
                case "a": //todo -> acabar esto!!!
                case "b":
                case "c":
                case "e":
                    return opcion;
                default:
                    GameStoryTeller.narrar(26, null);
                    gi.showMessage("\n");
            }
        }
    }
    private static void manageOptionA(GuiInteraction gi, Player player, Equipment equipment) {
        GameStoryTeller.narrar(24, player);
        gi.pauseForUserInput();
        GameStoryTeller.narrar(31, player);
        gi.pauseForUserInput();
        equipment.equiparManoD("Navaja Multiusos (+1 Fuerza)");
        GameStoryTeller.narrar(25, null);
    }

    private static void manageOptionB(GuiInteraction gi, Player player) {
        GameStoryTeller.narrar(27, null);
        gi.pauseForUserInput();
        Tutorial.tutorialEvent01(gi, player);
    }

    private static void manageOptionC() {
        GameStoryTeller.narrar(28, null);
        System.exit(0);
    }

    private static void manageOptionD(GuiInteraction gi, Player player, GameEnter enter) {
        GameStoryTeller.narrar(29, null);
        player.setName(gi.getInput());
        enter.invalidName(gi, player);
        PlayerStatistics.statsPlayer(player, gi);
    }

    private static void manageOptionE(ConsolePresentation cp, Player player, Enemy enemy, Combat combat, PlayerStatistics ps, GuiInteraction gi, Attacks attack) {
        combat.combatFlow(cp, player, enemy,ps,gi,attack);
    }
}
