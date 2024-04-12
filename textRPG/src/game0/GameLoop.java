package game0;

import game0.NPCs.Enemy;
import game0.NPCs.Npc;
import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.interfaces.UserInteraction;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameLoop {
    public static void run(GuiInteraction gi, ConsolePresentation cp) {
        Player player = new Player();
        PlayerStatistics ps = new PlayerStatistics();
        GameEnter enter = new GameEnter();
        Npc npc = new Npc(); // todo -> considerar manejar NPCs de una forma más dinámica en el futuro
        Dice d6 = new Dice(6); // Dado de diálogo
        Dice d12 = new Dice(12); // Dado de ataque
        Enemy enemigo = new Enemy("Narrador", 15, 3, 5);
        Combat combate = new Combat();
        Equipment equipment = new Equipment();
        Object entity = new Object();
        Attacks attack = new Attacks();

        String playerName = "";
        do {
            gi.showMessage("Introduce tu nombre:");
            playerName = gi.getInput();
        } while (playerName == null || playerName.trim().isEmpty());

        gi.continueGame();
        player.setName(playerName);
        gi.showMessage("Bienvenido, " + player.getName() + "!"); // Confirmación visual inmediata

            // Inicio del juego
            GameStoryTeller.narrar(0, null); // Esta narración debería ajustarse para no requerir entrada inmediatamente
            GameStoryTeller.narrar(1, player); // Asegúrate que esta función utiliza player.getName()
            gi.pauseForUserInput();

            // Estadísticas iniciales del jugador
            cp.displayStats(gi, player);
            GameStoryTeller.narrar(2, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(3, player);
            gi.pauseForUserInput();

            // Interacción inicial con NPC
            Npc.interactuarNPC00(gi);
            gi.pauseForUserInput();
            String respuesta = player.opcionEscogida0(gi, player);
            npc.interactuarNPC01(respuesta);
            gi.pauseForUserInput();
            Npc.interactuarNPC02(player);

            // Decisión del jugador y progreso del juego
            player.escogerOpcion(gi, npc, player);
            GameStoryTeller.narrar(8, player);
            gi.pauseForUserInput();

            // Más narrativas y decisiones
            GameStoryTeller.narrar(9, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(10, null);
            gi.pauseForUserInput();
            if (player.ResPaz()) GameStoryTeller.narrar(11, null);

            // Manejo del inventario y uso de objetos
            Inventory.addToInventory("\"DADO\"");
            GameEnter.enterInv(gi);
            GameStoryTeller.narrar(12, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(13, null);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(14, player);
            gi.pauseForUserInput();

            // Simulación de combate, combate y otras acciones
            GameEnter.enterDadoAtaquePlayer(gi, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(15, null);
            gi.pauseForUserInput();
            GameEvent.gestionEventos01(cp, gi, player, enemigo, combate, entity, ps, d12, attack);
            GameStoryTeller.narrar(22, player);
            gi.pauseForUserInput();
            GameStoryTeller.narrar(23, null);
            gi.pauseForUserInput();
            GameEvent.gestionEventos02(cp, gi, player, enter, combate, enemigo, equipment, ps, d12, attack);
            gi.pauseForUserInput();

            //continua la historia..
            GameEvent.gestionEventos03(player, gi, equipment);
    }
}
