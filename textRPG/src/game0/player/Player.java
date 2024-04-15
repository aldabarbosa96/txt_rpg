package game0.player;

import game0.NPCs.Enemy;
import playerInteractions.Dice;
import window.GuiInteraction;

public class Player {
    private String name;
    protected float hp;
    protected int energy;
    protected float attack;
    protected float deffense;
    protected int lvl;
    protected float xp;
    private boolean resPaz;
    public float getDeffense() {
        return deffense;
    }

    public int getLvl() {
        return lvl;
    }

    public float getXp() {
        return xp;
    }

    public boolean ResPaz() {
        return resPaz;
    }
    public Player() {
    }
    public  String getName() {
        return name;
    }

    public float getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public Player(int lvl, float xp, float hp, int energy, float attack,float deffense) {
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.deffense = deffense;
        this.lvl = lvl;
        this.xp = xp;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public float getAttack(){return attack;}

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setXp(Enemy enemy,Dice d8){
        this.xp = getXp() + calculateXP(enemy, d8);
    }
    public void setName(GuiInteraction gi) {
        gi.showMessage("Introduce tu nombre:"); //todo -> será útil en un futuro
    }
    public static void statsPlayer(Player player, GuiInteraction gi) { // todo -> reemplazar llamadas a este método por displayStats de ConsolePresentation
        gi.showMessage("---------------------------------------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        gi.pauseForUserInput();
    }
    public float calculateXP(Enemy enemy, Dice d8){
        new Dice(8);
        float expGanada;
        if (lvl <= 3){
            expGanada = (d8.lanzar()*1.8f) + enemy.getLvl();
        } else if (lvl > 3 && lvl <= 8) {
            expGanada = (d8.lanzar()*1.5f) + enemy.getLvl();
        } else if (lvl > 8 && lvl <=15) {
            expGanada = (d8.lanzar()*1.2f) + enemy.getLvl();
        } else expGanada = d8.lanzar() + enemy.getLvl();

        return expGanada;
    }
}

