package game0;

import game0.NPCs.Enemy;
import game0.events.Combat;
import game0.events.Tutorial;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;

import java.util.Scanner;

public class GameEvent {
    public static void gestionEventos01(Scanner sc, Player player, Enemy enemy, Combat combate, PlayerStatistics ps, Dice dice){
        String respuesta ="";
        boolean esValida = false;

        while (!esValida){
        respuesta = player.opcionEscogida04(sc,player);
        if (respuesta.equalsIgnoreCase("a")){
            Tutorial.tutorialEvent(sc,player,enemy,combate,ps,dice);
            esValida = true;
        } else if (respuesta.equalsIgnoreCase("b") || respuesta.equalsIgnoreCase("c")) {
            GameStoryTeller.narrar(17,null);
            combate.combatFlow(player,enemy,sc,ps,dice);
            esValida = true;
        } else GameStoryTeller.narrar(26,null);
        }
    }
    public static void gestionEventos02(Scanner sc, Player player,GameEnter enter,Combat combat,Enemy enemy,PlayerStatistics ps,Dice dice,Equipment equipment) {
        PlayerOptions.opcion(6);
        String opcionEsc = sc.nextLine();

        while (true) {
            if (opcionEsc.equalsIgnoreCase("a")) {
                GameStoryTeller.narrar(24, player); sc.nextLine();
                GameStoryTeller.narrar(31,player); sc.nextLine();
                equipment.equiparManoD("Navaja Multiusos (+1 Fuerza)");
                GameStoryTeller.narrar(25, null);
                break;
            } else if (opcionEsc.equalsIgnoreCase("b")) {
                GameStoryTeller.narrar(27,null);
                sc.nextLine();
                Tutorial.tutorialEvent01(sc, player);
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
            } else if (opcionEsc.equalsIgnoreCase("e")) {
                combat.combatFlow(player,enemy,sc,ps,dice);
                break;
            }
            else {
                GameStoryTeller.narrar(26, null);
                opcionEsc=sc.nextLine();
            }
        }
        if (!opcionEsc.equalsIgnoreCase("a")) {
            GameStoryTeller.narrar(39, player);
            sc.nextLine();
            gestionEventos02(sc, player, enter, combat, enemy, ps, dice,equipment);
        }
    }
    public static void gestionEventos03(Player player,Scanner sc,Equipment equipment){
        GameVoiceOver.dialogo(13,player); sc.nextLine();
        PlayerOptions.opcion(7);

        boolean esValida = false;
        int opcion = sc.nextInt();

        while (!esValida){
            if (opcion == 1){
                GameEnter.enterInv(); //seguir por aquí
                break;
            } else if (opcion == 2) {
                equipment.mostrarEquipo();
            } else if (opcion == 3) {
                PlayerStatistics.statsPlayer(player,sc);
            }
            String opcion1 = sc.nextLine();
            if (opcion1.equalsIgnoreCase("a")){

            }
        }
    }
}

