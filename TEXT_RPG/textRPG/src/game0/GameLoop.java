package game0;

import game0.NPCs.NPC;
import game0.player.Inventory;
import game0.player.Player;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class GameLoop {
    public static void run(Scanner sc){
        Player player = new Player();
        NPC npc = new NPC(); //creo q habrá q cambiar la manera de manejar las instancias d los NPC's más adelante..
        Dice d6 = new Dice(6);
        Dice d12 = new Dice(12);

        GameStoryTeller.narrar(0,null);
        player.setName(sc.nextLine());
        GameStoryTeller.narrar(1,player);
        sc.nextLine();

        /**
         * crear una clase para manejar la lógica (y dejar constancia quí) de las actualizaciones del siguiente bloque
         * además de añadir algún parámetro más (ataque,..)
         */
        System.out.println("Player: " + Player.getName()+"\nLifePoints: " + player.getHp()+"\nEnergy: "+player.getEnergy()); //debo manejarlo desde una clase independiente
        sc.nextLine();

        GameStoryTeller.narrar(2,null); sc.nextLine();
        GameStoryTeller.narrar(3,player); sc.nextLine();

        NPC.interactuarNPC00(); sc.nextLine();

        System.out.println(Player.getName()+":");
        String respuesta = player.opcionEscogida0(sc); sc.nextLine();
        npc.interactuarNPC01(respuesta);
        sc.nextLine();

        NPC.interactuarNPC02();
        player.escogerOpcion(sc, npc);
        GameStoryTeller.narrar(8,player);
        sc.nextLine();

        GameStoryTeller.narrar(9,player); sc.nextLine();
        GameStoryTeller.narrar(10,null); sc.nextLine();

        if (player.ResPaz()) GameStoryTeller.narrar(11,null);

        GameEnter.enterInv();
        Inventory.addToInventory("\"DADO\"");
        Inventory.mostrarInv();
        sc.nextLine();

        GameStoryTeller.narrar(12,null); sc.nextLine();
        GameStoryTeller.narrar(13,null);
        GameStoryTeller.narrar(14,player);
        sc.nextLine();

        GameEnter.enterDadoAtaque(); //revisar lógica implementación DADO
        int resultadoD12 = d12.lanzar();
        d12.imprimirDado(resultadoD12);
        sc.nextLine();

        GameStoryTeller.narrar(15,null); sc.nextLine();

        player.opcionEscogida04(sc);
        GameEvent.tutorialEvent(sc,player);

        /*GameEnter.enterDadoDialogo();
        int resultadoD6 = d6.lanzar();
        d6.imprimirDado(resultadoD6);
        sc.nextLine();*/

        /*System.out.println("Pulsa ENTER para lanzar el dado de diálogo:"); sc.nextLine();
        d6.lanzarD6();*/
    }
}
