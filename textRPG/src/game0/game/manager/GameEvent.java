package game0.game.manager;

import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.*;
import game0.threads.thread.table_pum.ThreadTablePum;
import window.GuiInteraction;

public class GameEvent {
    public static void gestionEventos01(GameContext gc) {
        boolean esValida;
        gc.getGuiInteraction();
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

    public static String gestionEventos03(GameContext gc) {
        String opcion = "";
        while (true) {
            GameVoiceOver.dialogo(13, gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
            PlayerOptions.opcion(7, gc.getPlayer());

            opcion = gc.getGuiInteraction().getInput().toLowerCase();
            switch (opcion) {
                case "d":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(18, null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(45, null);
                    gc.getGuiInteraction().pauseForUserInput();
                    PlayerOptions.opcion(10,gc.getPlayer());
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "a":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(15,null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(41,gc.getPlayer());
                    gc.getGuiInteraction().pauseForUserInput();
                    PlayerOptions.opcion(8,gc.getPlayer());
                    gc.getTpt().gestionEventosPumYTable(gc);
                    break;
                case "b":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(16,null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(42,gc.getPlayer());
                    gc.getGuiInteraction().pauseForUserInput();
                    PlayerOptions.opcion(9,gc.getPlayer());
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "c":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(17,null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(43,gc.getPlayer());
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(44,gc.getPlayer());
                    //todo -> SEGUIR POR AQUÍ!!!
                    break;
                case "e":
                    return opcion;
                default:
                    GameStoryTeller.narrar(26, null);
                    gc.getGuiInteraction().showMessage("\n");
            }
            break;
        }
        return opcion;
    }
}