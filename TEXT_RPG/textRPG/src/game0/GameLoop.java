package game0;

import game0.NPCs.Enemy;
import game0.NPCs.NPC;
import game0.events.Combat;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class GameLoop {
    public static void run(Scanner sc){
        Player player = new Player();
        PlayerStatistics ps = new PlayerStatistics();
        NPC npc = new NPC(); //todo-> debería cambiar el manejo de las instancias de los NPC's más adelante..
        Dice d6 = new Dice(6);
        Dice d12 = new Dice(12);
        Enemy enemigo = new Enemy("Narrador",5,2);

        GameStoryTeller.narrar(0,null);
        player.setName(sc.nextLine());
        GameStoryTeller.narrar(1,player);
        sc.nextLine();

        PlayerStatistics.statsPlayer(player);
        sc.nextLine();

        GameStoryTeller.narrar(2,null); sc.nextLine();
        GameStoryTeller.narrar(3,player); sc.nextLine();

        NPC.interactuarNPC00(sc); sc.nextLine();

        System.out.println(Player.getName()+":");
        String respuesta = player.opcionEscogida0(sc); sc.nextLine();
        npc.interactuarNPC01(respuesta);
        sc.nextLine();

        NPC.interactuarNPC02();
        player.escogerOpcion(sc, npc);
        System.out.println("\n");
        GameStoryTeller.narrar(8,player);
        sc.nextLine();

        GameStoryTeller.narrar(9,player); sc.nextLine();
        GameStoryTeller.narrar(10,null); sc.nextLine();

        if (player.ResPaz()) GameStoryTeller.narrar(11,null);

        Inventory.addToInventory("\"DADO\"");
        GameEnter.enterInv();
        sc.nextLine();

        GameStoryTeller.narrar(12,null); sc.nextLine();
        GameStoryTeller.narrar(13,null);
        GameStoryTeller.narrar(14,player);
        sc.nextLine();

        GameEnter.enterDadoAtaque(player); //lógica de lanzar dados mejorada pero se podría mejorar más
        sc.nextLine();

        GameStoryTeller.narrar(15,null); sc.nextLine();

        if (GameEvent.gestionEventos01(sc,player,enemigo).equalsIgnoreCase("a")){
            Combat.combatEvent(sc,enemigo);}

        Combat.combatFlow(player,enemigo,sc,ps);    //todo-> método que maneja toda la lógica y desarrollo del combate (habrá que cambiarlo)
    }
}
