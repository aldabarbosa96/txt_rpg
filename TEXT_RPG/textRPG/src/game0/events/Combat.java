package game0.events;

import game0.NPCs.Enemy;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;

import java.util.Scanner;

public class Combat {
    static Enemy narrador = new Enemy("Narrador",5,2);
    public static void combatEvent(Scanner sc, Enemy enemy){
        GameEnter.enterAtaque();
        System.out.println("--------------------FIGHT--------------------\n" +
                "\n"+
                "                  O        O\n" +
                "                 /|\\/     /|\\\\\n" +
                "                //\\   VS   |\\\\\n" +
                "               //  \\      /  \\\\\n" +
                "\n"+
              "     "+ Player.getName()+"   VS     "+enemy.getName()+"\n");
    }
    public static String combatFlow(Player player, Enemy enemy, Scanner sc,PlayerStatistics ps){
        boolean enCombate = true;
        String ganador = "";

        while (enCombate){
            sc.nextLine();

            ps.actEstEnCombate(player,sc,enemy);
            if (player.getHp() <=0 || player.getEnergy() == 0){
                enCombate = false;
                ganador = "¡"+ narrador.getName()+" es el ganador del combate!";
                System.out.println("¡Terminó el combate!");
                sc.nextLine();
            } else if (narrador.getLifePoints()<=0) {
                enCombate = false;
                ganador = "¡"+Player.getName()+" es el ganador del combate";

            } else System.out.println("Continúa el combate:");
        }
        return ganador;
    }
}
