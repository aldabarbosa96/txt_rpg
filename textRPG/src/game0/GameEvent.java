package game0;

import game0.console.ConsolePresentation;
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

public class GameEvent {
    public static void gestionEventos01(ConsolePresentation cp, UserInteraction ui, Player player, Enemy enemy, Combat combate, PlayerStatistics ps, Dice dice) {
        boolean esValida = false;
        PlayerOptions.opcion(4, player);
        do {
            String respuesta = ui.getInput().toLowerCase();
            esValida = handleInputOption(respuesta, cp, ui, player, enemy, combate, ps, dice);
        } while (!esValida);
    }

    private static boolean handleInputOption(String option, ConsolePresentation cp, UserInteraction ui, Player player, Enemy enemy, Combat combate, PlayerStatistics ps, Dice dice) {
        switch (option) {
            case "a":
                Tutorial.tutorialEvent(cp, ui, player, enemy, combate, ps, dice);
                return true;
            case "b":
            case "c":
                GameStoryTeller.narrar(17, null);
                combate.combatFlow(cp, player, enemy, ui, ps, dice);
                return true;
            default:
                GameStoryTeller.narrar(26, null);
                return false;
        }
    }

    public static void gestionEventos02(ConsolePresentation cp, UserInteraction ui, Player player, GameEnter enter, Combat combat, Enemy enemy, PlayerStatistics ps, Dice dice, Equipment equipment) {
        String opcionEsc = "";
        do {
            PlayerOptions.opcion(6, player);
            opcionEsc = ui.getInput().toLowerCase();

            switch (opcionEsc) {
                case "a":
                    manageOptionA(ui, player, equipment);
                    break;
                case "c":
                    manageOptionC();
                    break;
                case "b":
                    manageOptionB(ui, player);
                    break;
                case "d":
                    manageOptionD(ui, player, enter);
                    break;
                case "e":
                    manageOptionE(cp, player, enemy, ui, ps, dice, combat);
                    break;
                default:
                    GameStoryTeller.narrar(26, null);
                    ui.showMessage("\n");
            }
        } while (!opcionEsc.equals("a") && !opcionEsc.equals("c"));
    }

    public static String gestionEventos03(Player player, UserInteraction ui, Equipment equipment) {
        while (true) {
            GameVoiceOver.dialogo(13, player);
            ui.pauseForUserInput();
            PlayerOptions.opcion(7, player);

            String opcion = ui.getInput().toLowerCase();
            switch (opcion) {
                case "1":
                    GameEnter.enterInv(ui);
                    break;
                case "2":
                    GameEnter.enterEquipo(ui, equipment);
                    break;
                case "3":
                    PlayerStatistics.statsPlayer(player, ui);
                    break;
                case "d":
                    GameVoiceOver.dialogo(18, null);
                    ui.pauseForUserInput();
                    GameStoryTeller.narrar(45, null);
                    ui.pauseForUserInput();
                    break;
                case "a": //acabar esto
                case "b":
                case "c":
                case "e":
                    return opcion;
                default:
                    GameStoryTeller.narrar(26, null);
                    ui.showMessage("\n");
            }
        }
    }

    private static void manageOptionA(UserInteraction ui, Player player, Equipment equipment) {
        GameStoryTeller.narrar(24, player);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(31, player);
        ui.pauseForUserInput();
        equipment.equiparManoD("Navaja Multiusos (+1 Fuerza)");
        GameStoryTeller.narrar(25, null);
    }

    private static void manageOptionB(UserInteraction ui, Player player) {
        GameStoryTeller.narrar(27, null);
        ui.pauseForUserInput();
        Tutorial.tutorialEvent01(ui, player);
    }

    private static void manageOptionC() {
        GameStoryTeller.narrar(28, null);
        System.exit(0);
    }

    private static void manageOptionD(UserInteraction ui, Player player, GameEnter enter) {
        GameStoryTeller.narrar(29, null);
        player.setName(ui.getInput());
        enter.invalidName(ui, player);
        PlayerStatistics.statsPlayer(player, ui);
    }

    private static void manageOptionE(ConsolePresentation cp, Player player, Enemy enemy, UserInteraction ui, PlayerStatistics ps, Dice dice, Combat combat) {
        combat.combatFlow(cp, player, enemy, ui, ps, dice);
    }
}
