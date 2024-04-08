package game0.player;

import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class PlayerStatistics extends Player {
    public PlayerStatistics() {
    }

    public static void statsPlayer(Player player, Scanner sc) {
        System.out.println("--------------------\nJugador: " + Player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack());
        sc.nextLine();
    }

    public void actEstPlayerEnCombate(Player player, Scanner sc, Enemy enemigo) {
        GameVoiceOver.dialogo(5);
        int resultadoDado = GameEnter.enterDadoAtaque(player);

        player.setEnergy(player.getEnergy() - 1);

        if ((resultadoDado + player.getAttack()) > enemigo.getLifePoints()) {
            int daño = (resultadoDado + player.getAttack()) - enemigo.getLifePoints();
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            System.out.println("El ataque ha hecho " + daño + " de daño al enemigo.");
            sc.nextLine();
        } else if ((resultadoDado + player.getAttack()) == enemigo.getLifePoints()) {
            GameVoiceOver.dialogo(6);
            sc.nextLine();
        } else {
            int daño = enemigo.getLifePoints() - resultadoDado;
            player.setHp(player.getHp() - daño);
            System.out.println(Player.getName() + " se hirió " + daño + " a si mismo.");
            sc.nextLine();
        }
        statsPlayer(player,sc);
        Enemy.statsEnemy(enemigo,sc);
    }

    public void actEstEnemyEnCombate(Player player, Scanner sc, Enemy enemigo, Dice dado) {
        sc.nextLine();
        GameVoiceOver.dialogo(7) ; sc.nextLine();
        int resultadoDado = dado.lanzar()+enemigo.getAttackPoints();
        System.out.println("Resultado del ataque: "+resultadoDado);
        int daño = resultadoDado - player.getHp(); sc.nextLine();

        if (daño<0){
            daño *= -1;
        }
        if (resultadoDado > player.getHp()) {
            player.setHp(player.getHp() - daño);
            System.out.println("El ataque te ha hecho " + daño + " de daño.");
            sc.nextLine();
        } else if (resultadoDado == player.getHp()) {
            GameVoiceOver.dialogo(8);
            sc.nextLine();
        } else if (resultadoDado < player.getHp()){
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            System.out.println(enemigo.getName() + " se hirió " + daño + " a si mismo.");
            sc.nextLine();
        }

        statsPlayer(player,sc);
        Enemy.statsEnemy(enemigo,sc);
    }
}


