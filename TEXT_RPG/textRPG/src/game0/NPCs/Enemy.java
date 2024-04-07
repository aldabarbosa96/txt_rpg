package game0.NPCs;

public class Enemy extends NPC {
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
}

