package game0;

import game0.NPCs.Enemy;
import game0.events.Combat;
import game0.events.Tutorial;
import game0.player.Player;
import java.util.Scanner;

public class GameEvent {
    public static String gestionEventos01(Scanner sc, Player player, Enemy enemy){
        String respuesta ="";
        boolean esValida = false;
        while (!esValida){
        respuesta = player.opcionEscogida04(sc);
        if (respuesta.equalsIgnoreCase("a")){
            Tutorial.tutorialEvent(sc,player);
            esValida = true;
        } else if (respuesta.equalsIgnoreCase("b") || respuesta.equalsIgnoreCase("c")) {
            GameStoryTeller.narrar(17,null);
            Combat.combatEvent(sc,enemy);
            esValida = true;
        } else System.out.println("Narrador: Prueba de nuevo lumbreras.");
        }
        return respuesta;
    }
}
