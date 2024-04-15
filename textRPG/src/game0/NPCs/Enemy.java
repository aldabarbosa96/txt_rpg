package game0.NPCs;

public class Enemy extends Npc {
    private int lifePoints;
    private int attackPoints;
    private int deffensePoints;

    public Enemy(String name, int vida, int ataque, int defensa){
        super("");
        this.lifePoints = 0;
        this.attackPoints = 0;
        this.deffensePoints = 0;
    }

    public Enemy() {

    }

    public void setUpEnemy(String name, int lifePoints, int attackPoints, int deffensePoints){
        setName(name);
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.deffensePoints = deffensePoints;

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

