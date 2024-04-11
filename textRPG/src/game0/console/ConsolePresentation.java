package game0.console;

import game0.interfaces.GamePresentation;
import game0.player.Player;
import game0.NPCs.Enemy;

public class ConsolePresentation implements GamePresentation {
    @Override
    public void displayStats(Object entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            System.out.println("--------------------");
            System.out.println("Jugador: " + player.getName());
            System.out.println("Vida: " + player.getHp());
            System.out.println("Energía: " + player.getEnergy());
            System.out.println("Fuerza: " + player.getAttack());
            System.out.println("Defensa: " + player.getDeffense());
            System.out.println("--------------------");
        } else if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            System.out.println("--------------------");
            System.out.println("Enemigo: " + enemy.getName());
            System.out.println("Vida: " + enemy.getLifePoints());
            System.out.println("Fuerza: " + enemy.getAttackPoints());
            System.out.println("Defensa: " + enemy.getDeffensePoints());
            System.out.println("--------------------");
        }
    }

    @Override
    public void displayCombat(Player player, Enemy enemy) {
        System.out.println("--------------------FIGHT--------------------\n" +
                "\n"+
                "                  O        O\n" +
                "                 /|\\/     /|\\\\\n" +
                "                //\\   VS   |\\\\\n" +
                "               //  \\      /  \\\\\n" +
                "\n"+
                "     "+ player.getName()+"   VS     "+enemy.getName()+"\n");
    }
}
