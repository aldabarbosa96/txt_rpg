package game0;

import game0.NPCs.Enemy;
import game0.NPCs.Npc;
import game0.console.ConsolePresentation;
import game0.events.Combat;
import game0.interfaces.UserInteraction;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;

public class GameLoop {
    public static void run(UserInteraction ui, ConsolePresentation cp) {
        Player player = new Player();
        GameEnter enter = new GameEnter();
        PlayerStatistics ps = new PlayerStatistics();
        Npc npc = new Npc(); // Considerar manejar NPCs de una forma más dinámica en el futuro
        Dice d6 = new Dice(6); // Dado de diálogo
        Dice d12 = new Dice(12); // Dado de ataque
        Enemy enemigo = new Enemy("Narrador", 15, 3, 5);
        Combat combate = new Combat();
        Equipment equipment = new Equipment();

        // Inicio del juego
        GameStoryTeller.narrar(0, null);
        player.setName(ui.getInput());
        enter.invalidName(ui,player);
        GameStoryTeller.narrar(1, player);
        ui.pauseForUserInput();

        // Estadísticas iniciales del jugador
        PlayerStatistics.statsPlayer(player, ui);
        GameStoryTeller.narrar(2, null);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(3, player);
        ui.pauseForUserInput();

        // Interacción inicial con NPC
        Npc.interactuarNPC00(ui);
        ui.pauseForUserInput();
        String respuesta = player.opcionEscogida0(ui, player);
        npc.interactuarNPC01(respuesta);
        ui.pauseForUserInput();
        Npc.interactuarNPC02(player);

        // Decisión del jugador y progreso del juego
        player.escogerOpcion(ui, npc, player);
        GameStoryTeller.narrar(8, player);
        ui.pauseForUserInput();

        // Más narrativas y decisiones
        GameStoryTeller.narrar(9, player);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(10, null);
        ui.pauseForUserInput();
        if (player.ResPaz()) GameStoryTeller.narrar(11, null);

        // Manejo del inventario y uso de objetos
        Inventory.addToInventory("\"DADO\"");
        GameEnter.enterInv(ui);
        GameStoryTeller.narrar(12, null);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(13, null);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(14, player);
        ui.pauseForUserInput();

        // Simulación de combate, combate y otras acciones
        GameEnter.enterDadoAtaquePlayer(ui, player);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(15, null);
        ui.pauseForUserInput();
        GameEvent.gestionEventos01(cp, ui, player, enemigo, combate, ps, d12);
        GameStoryTeller.narrar(22, player);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(23, null);
        ui.pauseForUserInput();
        GameEvent.gestionEventos02(cp, ui, player, enter, combate, enemigo, ps, d12, equipment);
        ui.pauseForUserInput();

        //continua la historia..
        GameEvent.gestionEventos03(player, ui, equipment);
    }
}
