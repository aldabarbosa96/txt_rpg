package game0.game;

import game0.NPCs.Npc;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Inventory;
import playerInteractions.GameEnter;
public class GameLoop { // todo -> modularizar esta clase en un futuro para manejabilidad y comprensión
    public static void run(GameContext gc) {
        Npc npc = new Npc(); // todo -> considerar manejar NPCs de una forma más dinámica en el futuro

        String playerName = "";
        do {
            gc.getPlayer().setName(gc.getGuiInteraction());
            playerName = gc.getGuiInteraction().getInput();
        } while (playerName == null || playerName.trim().isEmpty());
        gc.getGuiInteraction().continueGame();
        gc.getPlayer().setName(playerName);
        gc.getGuiInteraction().showMessage(gc.getPlayer().getName());

            //inicio del juego
        GameStoryTeller.narrar(0, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(1, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(47,null);
        GameVoiceOver.dialogo(19,null);
        gc.getGuiInteraction().pauseForUserInput(); GameVoiceOver.separador(gc.getGuiInteraction());

            //estadísticas iniciales del jugador

        GameStoryTeller.narrar(2, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(3, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();

            //interacción inicial con NPC
        Npc.interactuarNPC00(gc.getGuiInteraction());
        gc.getGuiInteraction().pauseForUserInput();
        String respuesta = gc.getPlayer().opcionEscogida0(gc.getGuiInteraction(), gc.getPlayer());
        npc.interactuarNPC01(respuesta,gc.getGuiInteraction());
        gc.getGuiInteraction().pauseForUserInput();
        Npc.interactuarNPC02(gc.getPlayer());

            //decisión del jugador y progreso del juego
        gc.getPlayer().escogerOpcion(gc.getGuiInteraction(), npc, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(8, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
            //más narrativas y decisiones
        GameStoryTeller.narrar(9, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput(); GameVoiceOver.separador(gc.getGuiInteraction());
        GameStoryTeller.narrar(10, null);
        gc.getGuiInteraction().pauseForUserInput();
        if (gc.getPlayer().ResPaz()) GameVoiceOver.separador(gc.getGuiInteraction());

            //manejo del inventario y uso de objetos
        Inventory.addToInventory("Dado.12");
        GameEnter.enterInv(gc.getGuiInteraction()); GameVoiceOver.separador(gc.getGuiInteraction());
        GameStoryTeller.narrar(12, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(13, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(14, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput(); GameVoiceOver.separador(gc.getGuiInteraction());
        GameStoryTeller.narrar(46,gc.getPlayer());

            //simulación de combate, combate y otras acciones
        GameEnter.enterDadoAtaquePlayer(gc.getGuiInteraction(), gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(15, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameEvent.gestionEventos01(gc);
        GameStoryTeller.narrar(22, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(23, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameEvent.gestionEventos02(gc);
        gc.getGuiInteraction().pauseForUserInput();

        //todo -> continuar la historia...
        GameEvent.gestionEventos03(gc.getPlayer(), gc.getGuiInteraction());
    }
}
