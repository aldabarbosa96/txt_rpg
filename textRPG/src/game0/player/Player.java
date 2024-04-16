package game0.player;

import game0.NPCs.Enemy;
import playerInteractions.Dice;
import window.GuiInteraction;

public class Player {
    private String name;
    protected int hp;
    protected int energy;
    protected int attack;
    protected int deffense;
    protected int lvl;
    protected float xp;
    private boolean resPaz;
    public int getDeffense() {
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

    public int getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Player(int lvl, float xp, int hp, int energy, int attack,int deffense) {
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

    public int getAttack(){return attack;}

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setXp(float xpGanada){
        xp += xpGanada;
        lvlUp();
    }
    public void setName(GuiInteraction gi) {
        gi.showMessage("Introduce tu nombre:"); //todo -> será útil en un futuro
    }
    public static void statsPlayer(Player player, GuiInteraction gi) { // todo -> reemplazar llamadas a este método por displayStats de ConsolePresentation
        gi.showMessage("---------------------------------------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        gi.pauseForUserInput();
    }
    public float calculateXP(Enemy enemy) {
        Dice d8 = new Dice(8);
        float expGanada;
        if (lvl <= 3){
            expGanada = (d8.lanzar()*1.8f) + enemy.getLvl();
        } else if (lvl > 3 && lvl <= 8) {
            expGanada = (d8.lanzar()*1.5f) + enemy.getLvl();
        } else if (lvl > 8 && lvl <= 15) {
            expGanada = (d8.lanzar()*1.2f) + enemy.getLvl();
        } else {
            expGanada = d8.lanzar() + enemy.getLvl();
        }
        return expGanada;
    }

    public void lvlUp(){
        while (xp >= 100) {
            xp -= 100;
            lvl++;
            attack += 1;
            deffense += 1;
        }
        xp = Math.round(xp * 100) / 100f;
    }


}

