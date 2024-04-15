package game0.game;

import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.*;
import window.GuiInteraction;

public class GameEvent {
    public static void gestionEventos01(GameContext gc) {
        boolean esValida;
        PlayerOptions.opcion(4, gc.getPlayer());
        do {
            String respuesta = gc.getGuiInteraction().getInput().toLowerCase();
            esValida = GameOptionManager.manageOption01(respuesta, gc);
        } while (!esValida);
    }
    public static void gestionEventos02(GameContext gc) {
        String opcionEsc = "";
        do {
            PlayerOptions.opcion(6, gc.getPlayer());
            opcionEsc = gc.getGuiInteraction().getInput().toLowerCase();

            switch (opcionEsc) {
                case "a":
                    GameOptionManager.manageOption02A(gc.getGuiInteraction(), gc.getPlayer(),gc.getEquipment());
                    break;
                case "c":
                    GameOptionManager.manageOption02C();
                    break;
                case "b":
                    GameOptionManager.manageOption02B(gc.getGuiInteraction(), gc.getPlayer());
                    break;
                case "d":
                    GameOptionManager.manageOption02D(gc.getGuiInteraction(), gc.getPlayer(), gc.getGameEnter());
                    break;
                case "e":
                    GameOptionManager.manageOption02E(gc);
                    break;
                default:
                    GameStoryTeller.narrar(26, null);
                    gc.getGuiInteraction().showMessage("\n");
            }
        } while (!opcionEsc.equals("a") && !opcionEsc.equals("c"));
    }

    public static String gestionEventos03(Player player, GuiInteraction gi) {
        while (true) {
            GameVoiceOver.dialogo(13, player);
            gi.pauseForUserInput();
            PlayerOptions.opcion(7, player);

            String opcion = gi.getInput().toLowerCase();
            switch (opcion) {
                case "1":
                    Player.statsPlayer(player, gi);
                    break;
                case "d":
                    GameVoiceOver.dialogo(18, null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(45, null);
                    gi.pauseForUserInput();
                    break;
                case "a": //todo -> SEGUIR POR AQUÍ!!!
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
}