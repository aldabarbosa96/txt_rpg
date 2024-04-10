package game0;

import game0.NPCs.Enemy;
import game0.NPCs.Npc;
import game0.events.Combat;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class GameLoop {
    public static void run(Scanner sc) {
        Player player = new Player();
        GameEnter enter = new GameEnter();
        PlayerStatistics ps = new PlayerStatistics();
        Npc npc = new Npc(); //todo-> debería cambiar el manejo de las instancias de los NPC's más adelante. ¡REVISAR!
        Dice d6 = new Dice(6); //dado diálogo
        Dice d12 = new Dice(12); //dado ataque
        Enemy enemigo = new Enemy("Narrador", 20, 3, 5);
        Combat combate = new Combat();
        Equipment equipment = new Equipment();

        GameStoryTeller.narrar(0, null);
        player.setName(sc.nextLine());
        enter.invalidName(player);
        GameStoryTeller.narrar(1, player);
        sc.nextLine();

        PlayerStatistics.statsPlayer(player, sc);
        GameStoryTeller.narrar(2, null);
        sc.nextLine();
        GameStoryTeller.narrar(3, player);
        sc.nextLine();

        Npc.interactuarNPC00(sc);
        sc.nextLine();

        String respuesta = player.opcionEscogida0(sc);
        sc.nextLine();
        npc.interactuarNPC01(respuesta);
        sc.nextLine();

        Npc.interactuarNPC02();
        player.escogerOpcion(sc, npc, player);
        System.out.println("\n");
        GameStoryTeller.narrar(8, player);
        sc.nextLine();

        GameStoryTeller.narrar(9, player);
        sc.nextLine();
        GameStoryTeller.narrar(10, null);
        sc.nextLine();

        if (player.ResPaz()) GameStoryTeller.narrar(11, null);

        Inventory.addToInventory("\"DADO\"");
        GameEnter.enterInv();
        sc.nextLine();

        GameStoryTeller.narrar(12, null);
        sc.nextLine();
        GameStoryTeller.narrar(13, null); sc.nextLine();
        GameStoryTeller.narrar(14, player);
        sc.nextLine();

        GameEnter.enterDadoAtaquePlayer(player); //lógica de lanzar dados mejorada pero se podría mejorar más
        sc.nextLine();

        GameStoryTeller.narrar(15, null);
        sc.nextLine();

        GameEvent.gestionEventos01(sc, player, enemigo, combate, ps, d12);
        //todo-> revisar lógica del daño del combate

        GameStoryTeller.narrar(22,player); sc.nextLine();
        GameStoryTeller.narrar(23, null); sc.nextLine();
        GameEvent.gestionEventos02(sc, player, enter, combate, enemigo, ps, d12,equipment);
        sc.nextLine();

        GameEvent.gestionEventos03(player,sc,equipment);

    }
}
