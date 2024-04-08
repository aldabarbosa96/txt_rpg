package game0;

import game0.NPCs.Enemy;
import game0.events.Combat;
import game0.events.Tutorial;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;

import java.util.Scanner;

public class GameEvent {
    public static String gestionEventos01(Scanner sc, Player player, Enemy enemy){
        String respuesta ="";
        boolean esValida = false;

        while (!esValida){
        respuesta = player.opcionEscogida04(sc,player);
        if (respuesta.equalsIgnoreCase("a")){
            Tutorial.tutorialEvent(sc,player);
            esValida = true;
        } else if (respuesta.equalsIgnoreCase("b") || respuesta.equalsIgnoreCase("c")) {
            GameStoryTeller.narrar(17,null);
            Combat.combatEvent(sc,enemy);
            esValida = true;
        } else GameStoryTeller.narrar(26,null);
        }
        return respuesta;
    }
    public static void gestionEventos02(Scanner sc, Player player,GameEnter enter) {
        PlayerOptions.opcion(6);

        String opcionEsc = sc.nextLine();

        while (true) {
            if (opcionEsc.equalsIgnoreCase("a")) {
                GameStoryTeller.narrar(24, player);
                GameStoryTeller.narrar(25, null);
                break;
            } else if (opcionEsc.equalsIgnoreCase("b")) {
                GameStoryTeller.narrar(27,null);
                sc.nextLine();
                Tutorial.tutorialEvent01(sc, player);
                gestionEventos02(sc,player,enter);
                break;
            } else if (opcionEsc.equalsIgnoreCase("c")) {
                GameStoryTeller.narrar(28,null);
                System.exit(0);
                break;
            } else if (opcionEsc.equalsIgnoreCase("d")) {
                GameStoryTeller.narrar(29,null);
                player.setName(sc.nextLine());
                enter.invalidName(player);
                PlayerStatistics.statsPlayer(player,sc);
                break;
            } else {
                GameStoryTeller.narrar(26, null);
                opcionEsc=sc.nextLine();
            }
        }
    }
}
