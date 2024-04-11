package game0;

import game0.NPCs.Enemy;
import game0.NPCs.Npc;
import game0.console.ConsoleInteraction;
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
        Npc npc = new Npc(); //todo-> debería cambiar el manejo de las instancias de los NPC's más adelante. ¡REVISAR!
        Dice d6 = new Dice(6); //dado diálogo
        Dice d12 = new Dice(12); //dado ataque
        Enemy enemigo = new Enemy("Narrador", 15, 3, 5);
        Combat combate = new Combat();
        Equipment equipment = new Equipment();

        GameStoryTeller.narrar(0, null);
        player.setName(ui.getInput());
        enter.invalidName(ui,player);
        GameStoryTeller.narrar(1, player);
        ui.pauseForUserInput();

        PlayerStatistics.statsPlayer(player, ui);
        GameStoryTeller.narrar(2, null);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(3, player);
        ui.pauseForUserInput();

        Npc.interactuarNPC00(ui);
        ui.pauseForUserInput();

        String respuesta = player.opcionEscogida0(ui,player);
        ui.pauseForUserInput();
        npc.interactuarNPC01(respuesta);
        ui.pauseForUserInput();

        Npc.interactuarNPC02(player);
        player.escogerOpcion(ui, npc, player);
        GameStoryTeller.narrar(8, player);
        ui.pauseForUserInput();

        GameStoryTeller.narrar(9, player);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(10, null);
        ui.pauseForUserInput();

        if (player.ResPaz()) GameStoryTeller.narrar(11, null);

        Inventory.addToInventory("\"DADO\"");
        GameEnter.enterInv(ui);
        GameStoryTeller.narrar(12, null);
        ui.pauseForUserInput();
        GameStoryTeller.narrar(13, null); ui.pauseForUserInput();
        GameStoryTeller.narrar(14, player);
        ui.pauseForUserInput();

        GameEnter.enterDadoAtaquePlayer(ui,player); //lógica de lanzar dados mejorada pero se podría mejorar más
        ui.pauseForUserInput();

        GameStoryTeller.narrar(15, null);
        ui.pauseForUserInput();

        GameEvent.gestionEventos01(cp,ui, player, enemigo, combate, ps, d12);
        //todo-> revisar lógica del daño del combate

        GameStoryTeller.narrar(22,player); ui.pauseForUserInput();
        GameStoryTeller.narrar(23, null); ui.pauseForUserInput();
        GameEvent.gestionEventos02(cp,ui, player, enter, combate, enemigo, ps, d12,equipment);
        ui.pauseForUserInput();

        GameEvent.gestionEventos03(player,ui,equipment);

    }
}
