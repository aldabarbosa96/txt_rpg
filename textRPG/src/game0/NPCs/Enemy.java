package game0.NPCs;

public class Enemy extends Npc {
    private float lifePoints;
    private float attackPoints;
    private float deffensePoints;
    private int lvl;

    public Enemy(String name, int vida, int ataque, int defensa, int lvl){
        super("");
        this.lifePoints = 0;
        this.attackPoints = 0;
        this.deffensePoints = 0;
        this.lvl = 0;
    }
    public Enemy() {}
    public void setUpEnemy(String name, int lifePoints, int attackPoints, int deffensePoints,int lvl){
        setName(name);
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.deffensePoints = deffensePoints;
        this.lvl = lvl;
   }
    public float getDeffensePoints() {
        return deffensePoints;
    }
    public float getLifePoints() {
        return lifePoints;
    }
    public float getAttackPoints() {
        return attackPoints;
    }
    public int getLvl() {return lvl;}
    public void setLifePoints(float lifePoints) {
        this.lifePoints = lifePoints;
    }
}

