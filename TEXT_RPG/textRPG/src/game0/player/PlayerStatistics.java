package game0.player;

import game0.NPCs.Enemy;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class PlayerStatistics extends Player {
    public PlayerStatistics() {
    }
    public static void statsPlayer(Player player){
        System.out.println("Jugador: " + Player.getName()+"\nVida: " + player.getHp()+"\nEnergía: "+player.getEnergy()+"\nFuerza: "+player.getAttack());
    }
    public void actEstEnCombate(Player player, Scanner sc, Enemy enemigo){
        int resultadoDado = GameEnter.enterDadoAtaque(player);

        player.setEnergy(player.getEnergy() -1);

        if ((resultadoDado+player.getAttack()) > enemigo.getLifePoints()){
            int daño = (resultadoDado + player.getAttack()) - enemigo.getLifePoints();
            enemigo.setLifePoints(enemigo.getLifePoints()-daño);
            System.out.println("El ataque ha hecho "+daño+" de daño al enemigo.");
            sc.nextLine();
        } else if ((resultadoDado+player.getAttack()) == enemigo.getLifePoints()) {
            System.out.println("El ataque no tuvo efecto en el enemigo");
            sc.nextLine();
        } else {
            int daño = enemigo.getLifePoints() - resultadoDado;
            player.setHp(player.getHp() - daño);
            System.out.println(Player.getName()+" se hirió "+daño+"a si mismo.");
            sc.nextLine();
        }
        System.out.println("--------------------\nJugador: " + Player.getName()+"\nVida: " + player.getHp()+"\nEnergía: "+player.getEnergy()+"\nFuerza: "+player.getAttack());
        System.out.println("--------------------\nEnemigo: " + enemigo.getName()+"\nVida: " + enemigo.getLifePoints()+"\nFuerza: "+enemigo.getAttackPoints()+"\n");
    }
}

