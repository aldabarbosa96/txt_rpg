package game0.game;

import game0.events.combats.CombatLogic;
import game0.events.combats.CombatTablePum;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.*;
import game0.threads.thread.ThreadPonYTable;
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

    public static String gestionEventos03(Player player, GuiInteraction gi, GameContext gc, ThreadPonYTable tpt) {
        String opcion = "";
        while (true) {
            GameVoiceOver.dialogo(13, player);
            gi.pauseForUserInput();
            PlayerOptions.opcion(7, player);

            opcion = gi.getInput().toLowerCase();
            switch (opcion) {
                case "d":
                    GameVoiceOver.separador(gi);
                    GameVoiceOver.dialogo(18, null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(45, null);
                    gi.pauseForUserInput();
                    PlayerOptions.opcion(10,player);
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "a":
                    GameVoiceOver.separador(gi);
                    GameVoiceOver.dialogo(15,null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(41,player);
                    gi.pauseForUserInput();
                    PlayerOptions.opcion(8,player);
                    tpt.gestionEventosPumYTable(player,gi,gc);
                    break;
                case "b":
                    GameVoiceOver.separador(gi);
                    GameVoiceOver.dialogo(16,null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(42,player);
                    gi.pauseForUserInput();
                    PlayerOptions.opcion(9,player);
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "c":
                    GameVoiceOver.separador(gi);
                    GameVoiceOver.dialogo(17,null);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(43,player);
                    gi.pauseForUserInput();
                    GameStoryTeller.narrar(44,player);
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "e":
                    return opcion;
                default:
                    GameStoryTeller.narrar(26, null);
                    gi.showMessage("\n");
            }
            break;
        }
        return opcion;
    }
}