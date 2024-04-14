package game0.game;

import game0.NPCs.Enemy;
import game0.NPCs.Npc;
import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameLoop { // todo -> modularizar esta clase en un futuro para manejabilidad y comprensión
    public static void run(GuiInteraction gi, ConsolePresentation cp) {
        Player player = new Player();
        PlayerStatistics ps = new PlayerStatistics();
        GameEnter ge = new GameEnter();
        Dice d12 = new Dice(12);
        Npc npc = new Npc(); // todo -> considerar manejar NPCs de una forma más dinámica en el futuro
        Enemy enemigo = new Enemy("Narrador", 15, 3, 5);
        Combat combate = new Combat();
        Equipment equipment = new Equipment();
        Attacks attack = new Attacks();
        GameContext gc = new GameContext(cp,gi,player,enemigo,combate,equipment,ps,d12,attack,ge);

        String playerName = "";
        do {
            player.setName(gi);
            playerName = gi.getInput();
        } while (playerName == null || playerName.trim().isEmpty());

        gi.continueGame();
        player.setName(playerName);

            //inicio del juego
            GameStoryTeller.narrar(0, null);
            GameStoryTeller.narrar(1, player);
            gi.pauseForUserInput();

            //estadísticas iniciales del jugador
            cp.displayStats(gi, player);
            GameStoryTeller.narrar(2, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(3, player);
            gi.pauseForUserInput();

            //interacción inicial con NPC
            Npc.interactuarNPC00(gi);
            gi.pauseForUserInput();
            String respuesta = player.opcionEscogida0(gi, player);
            npc.interactuarNPC01(respuesta);
            gi.pauseForUserInput();
            Npc.interactuarNPC02(player);

            //decisión del jugador y progreso del juego
            player.escogerOpcion(gi, npc, player);
            GameStoryTeller.narrar(8, player);
            gi.pauseForUserInput();

            //más narrativas y decisiones
            GameStoryTeller.narrar(9, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(10, null);
            gi.pauseForUserInput();
            if (player.ResPaz()) GameVoiceOver.separador(gi);

            //manejo del inventario y uso de objetos
            Inventory.addToInventory("Dado.12");
            GameEnter.enterInv(gi);
            GameStoryTeller.narrar(12, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(13, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(14, player);
            gi.pauseForUserInput();

            //simulación de combate, combate y otras acciones
            GameEnter.enterDadoAtaquePlayer(gi, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(15, null);
            gi.pauseForUserInput();
            GameEvent.gestionEventos01(gc,cp);
            GameStoryTeller.narrar(22, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(23, null);
            gi.pauseForUserInput();
            GameEvent.gestionEventos02(gc);
            gi.pauseForUserInput();

            //todo -> continuar la historia...
            GameEvent.gestionEventos03(player, gi);
    }
}
