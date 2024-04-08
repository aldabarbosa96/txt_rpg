package game0.events;

import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;
import playerInteractions.GameEnter;

import java.util.Scanner;

public class Combat {
    private String ganador = "";
    boolean ganaJugador = true;

    public boolean getGanaJugador() {
        return ganaJugador;
    }

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
    public  String combatFlow(Player player, Enemy enemy, Scanner sc,PlayerStatistics ps, Dice dado){
        sc.nextLine();


        PlayerStatistics.statsPlayer(player,sc);
        Enemy.statsEnemy(enemy,sc);

        while (player.getHp() > 0 && enemy.getLifePoints() > 0){
            sc.nextLine();

            ps.actEstPlayerEnCombate(player,sc,enemy);

            if (enemy.getLifePoints()<=0) {
                enemy.setLifePoints(0);
                System.out.println("¡FIN DEL COMBATE!");
                sc.nextLine();
                break;
            } else if (player.getHp()<=0 || player.getEnergy() <= 0) {
                ganaJugador = false;
                GameVoiceOver.dialogo(9);
                sc.nextLine();
                break;
            }

            ps.actEstEnemyEnCombate(player,sc,enemy,dado);

            if (enemy.getLifePoints() <= 0){
                GameVoiceOver.dialogo(9);
                sc.nextLine();
                break;
            }

            else if (player.getHp() <=0 || player.getEnergy() <= 0){
                ganaJugador = false;
                GameVoiceOver.dialogo(9);
                sc.nextLine();
                break;

            } else GameVoiceOver.dialogo(10);

        }
        if (ganaJugador){
            ganador += "¡¡¡<<"+Player.getName()+">> es el ganador!!!";
        } else ganador += "¡¡¡<<"+ enemy.getName()+">> es el ganador!!!";
        System.out.println(ganador);
        return ganador;
    }
    public void ganador(Player player, Enemy enemy){
        if (ganaJugador){
            GameStoryTeller.narrar(19,player);
            GameStoryTeller.narrar(20,null);
        }
        else GameStoryTeller.narrar(21,null);;
    }
}
