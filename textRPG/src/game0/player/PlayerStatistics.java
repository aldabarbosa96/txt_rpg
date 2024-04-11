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
        System.out.println("--------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack()+"\nDefensa: "+player.getDeffense());
        sc.nextLine();
    }

    public void actEstPlayerEnCombate(Player player, Scanner sc, Enemy enemigo) {
        GameVoiceOver.dialogo(5,player);
        int resultadoDado = GameEnter.enterDadoAtaquePlayer(player);

        player.setEnergy(player.getEnergy() - 1);

        if ((resultadoDado + player.getAttack()) > enemigo.getDeffensePoints()) {
            int daño = (resultadoDado + player.getAttack() - enemigo.getDeffensePoints());
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            System.out.println("El ataque ha hecho " + daño + " de daño al enemigo.");
            sc.nextLine();
        } else if ((resultadoDado + player.getAttack()) == enemigo.getDeffensePoints()) {
            GameVoiceOver.dialogo(6,null);
            sc.nextLine();
        } else {
            int daño = enemigo.getDeffensePoints() - (resultadoDado+player.getAttack());
            player.setHp(player.getHp() - daño);
            System.out.println(player.getName() + " se hirió " + daño + " a si mismo.");
            sc.nextLine();
        }
        statsPlayer(player,sc);
        Enemy.statsEnemy(enemigo,sc);
    }

    public void actEstEnemyEnCombate(Player player, Scanner sc, Enemy enemigo, Dice dado) {
        sc.nextLine();
        GameVoiceOver.dialogo(7,null) ; sc.nextLine();
        int resultadoDado = GameEnter.enterDadoAtaqueEnemy(enemigo)+enemigo.getAttackPoints();
        System.out.println("Resultado del ataque: "+resultadoDado);
        int daño = resultadoDado - player.getDeffense(); sc.nextLine();

        if (daño<0){
            daño *= -1;
        }
        if (resultadoDado > player.getDeffense()) {
            player.setHp(player.getHp() - daño);
            System.out.println("El ataque te ha hecho " + daño + " de daño.");
            sc.nextLine();
        } else if (resultadoDado == player.getDeffense()) {
            GameVoiceOver.dialogo(8,null);
            sc.nextLine();
        } else if (resultadoDado < player.getDeffense()){
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            System.out.println(enemigo.getName() + " se hirió " + daño + " a si mismo.");
            sc.nextLine();
        }

        if (enemigo.getLifePoints()<=0){
            enemigo.setLifePoints(0);
        } else if (player.getHp()<=0) {
            player.setHp(0);
        }
        statsPlayer(player,sc);
        Enemy.statsEnemy(enemigo,sc);
    }
}


