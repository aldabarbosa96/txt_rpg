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
    public void combatFlow(Player player, Enemy enemy, Scanner sc, PlayerStatistics ps, Dice dado){
        combatEvent(sc,enemy);
        sc.nextLine();
        PlayerStatistics.statsPlayer(player,sc);
        Enemy.statsEnemy(enemy,sc);

        while (player.getHp() > 0 && enemy.getLifePoints() > 0){
            sc.nextLine();

            ps.actEstPlayerEnCombate(player,sc,enemy);

            if (enemy.getLifePoints()<=0) {
                sc.nextLine();
                GameVoiceOver.dialogo(9,null);
                sc.nextLine();
                break;
            } else if (player.getHp()<=0 || player.getEnergy() <= 0) {
                ganaJugador = false;
                GameVoiceOver.dialogo(9,null);
                sc.nextLine();
                break;
            }

            ps.actEstEnemyEnCombate(player,sc,enemy,dado);

            if (enemy.getLifePoints() <= 0){
                GameVoiceOver.dialogo(9,null);
                sc.nextLine();
                break;
            }

            else if (player.getHp() <=0 || player.getEnergy() <= 0){
                ganaJugador = false;
                GameVoiceOver.dialogo(9,null);
                sc.nextLine();
                break;

            } else {sc.nextLine(); GameVoiceOver.dialogo(10,null);}

        }
        if (ganaJugador) ganador += "¡¡¡<<"+Player.getName()+">> es el ganador!!!";
            else ganador += "¡¡¡<<"+ enemy.getName()+">> es el ganador!!!";
        System.out.println(ganador);
        ganador(player,enemy); sc.nextLine();
    }
    public void ganador(Player player, Enemy enemy){
        if (ganaJugador){
            GameStoryTeller.narrar(19,player);
            GameStoryTeller.narrar(20,null);
        }
        else {
            GameStoryTeller.narrar(21, null);
            GameStoryTeller.narrar(40, player);
        }
        player.setEnergy(8);
        player.setHp(30);
        enemy.setLifePoints(20);
        GameStoryTeller.narrar(22,player);
    }
}
