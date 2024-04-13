package game0;

import game0.events.Tutorial;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameEvent {
    public static void gestionEventos01(GameContext gc) {
        boolean esValida = false;
        PlayerOptions.opcion(4, gc.getPlayer());
        do {
            String respuesta = gc.getGuiInteraction().getInput().toLowerCase();
            esValida = handleInputOption(respuesta, gc);
        } while (!esValida);
    }

    private static boolean handleInputOption(String option, GameContext gc) {
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

    public static void gestionEventos02(GameContext gc) {
        String opcionEsc = "";
        do {
            PlayerOptions.opcion(6, gc.getPlayer());
            opcionEsc = gc.getGuiInteraction().getInput().toLowerCase();

            switch (opcionEsc) {
                case "a":
                    manageOptionA(gc.getGuiInteraction(), gc.getPlayer(), gc.getEquipment());
                    break;
                case "c":
                    manageOptionC();
                    break;
                case "b":
                    manageOptionB(gc.getGuiInteraction(), gc.getPlayer());
                    break;
                case "d":
                    manageOptionD(gc.getGuiInteraction(), gc.getPlayer(), gc.getGameEnter());
                    break;
                case "e":
                    manageOptionE(gc);
                    break;
                default:
                    GameStoryTeller.narrar(26, null);
                    gc.getGuiInteraction().showMessage("\n");
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

    private static void manageOptionE(GameContext gc) {
        gc.getCombat().combatFlow(gc);
    }
}