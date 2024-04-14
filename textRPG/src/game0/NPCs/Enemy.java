package game0.NPCs;

import window.GuiInteraction;

public class Enemy extends Npc {
    private int lifePoints;
    private int attackPoints;
    private int deffensePoints;

    public Enemy(String name, int vida, int ataque, int defensa){
        super(name);
        this.lifePoints = vida;
        this.attackPoints = ataque;
        this.deffensePoints = defensa;
    }
    public int getDeffensePoints() {
        return deffensePoints;
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
}

