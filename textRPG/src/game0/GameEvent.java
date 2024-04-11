package game0;

import game0.NPCs.Enemy;
import game0.console.ConsolePresentation;
import game0.events.Combat;
import game0.events.Tutorial;
import game0.interfaces.UserInteraction;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;

public class GameEvent {
    public static void gestionEventos01(ConsolePresentation cp, UserInteraction ui, Player player, Enemy enemy, Combat combate, PlayerStatistics ps, Dice dice) {
        boolean esValida = false;
        String respuesta;
        PlayerOptions.opcion(4, player);
        do {
            respuesta = ui.getInput().toLowerCase();

            switch (respuesta) {
                case "a":
                    Tutorial.tutorialEvent(cp, ui, player, enemy, combate, ps, dice);
                    esValida = true;
                    break;
                case "b":
                case "c":
                    GameStoryTeller.narrar(17, null);
                    combate.combatFlow(cp, player, enemy, ui, ps, dice);
                    esValida = true;
                    break;
                default:
                    GameStoryTeller.narrar(26, null);
            }
        } while (!esValida);
    }

    public static void gestionEventos02(ConsolePresentation cp, UserInteraction ui, Player player, GameEnter enter, Combat combat, Enemy enemy, PlayerStatistics ps, Dice dice, Equipment equipment) {
        String opcionEsc = "";
        do {
            PlayerOptions.opcion(6, player);
            opcionEsc = ui.getInput().toLowerCase();

            switch (opcionEsc) {
                case "a":
                    GameStoryTeller.narrar(24, player);
                    ui.pauseForUserInput();
                    GameStoryTeller.narrar(31, player);
                    ui.pauseForUserInput();
                    equipment.equiparManoD("Navaja Multiusos (+1 Fuerza)");
                    GameStoryTeller.narrar(25, null);
                    break;
                case "c":
                    GameStoryTeller.narrar(28, null);
                    System.exit(0);
                    break;
                case "b":
                    GameStoryTeller.narrar(27, null);
                    ui.pauseForUserInput();
                    Tutorial.tutorialEvent01(ui, player);
                    break;
                case "d":
                    GameStoryTeller.narrar(29, null);
                    player.setName(ui.getInput());
                    enter.invalidName(ui, player);
                    PlayerStatistics.statsPlayer(player, ui);
                    break;
                case "e":
                    combat.combatFlow(cp, player, enemy, ui, ps, dice);
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
            PlayerOptions.opcion(7,player);
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
                case "a":

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

    public static void gestionEventos04(UserInteraction ui, Player player, Equipment equipment) {
        if (gestionEventos03(player, ui, equipment).equalsIgnoreCase("a")) {
            //implemetar caso "a"
        }
        // falta añadir lógica adicional
    }
}
