package game0.NPCs;

import java.util.Scanner;

public class Enemy extends Npc {
    private int lifePoints;
    private int attackPoints;
    public Enemy(String name, int vida, int ataque){
        super(name);
        this.lifePoints = vida;
        this.attackPoints = ataque;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public static void statsEnemy(Enemy enemy, Scanner sc) {
        System.out.println("--------------------\nEnemigo: " + enemy.getName() + "\nVida: " + enemy.getLifePoints() + "\nFuerza: " + enemy.getAttackPoints());
        sc.nextLine();
    }
}

