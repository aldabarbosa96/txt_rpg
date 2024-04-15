package game0.player;

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

    public Player( int hp, int energy, int attack,int deffense) {
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.deffense = deffense;
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
    public void setName(GuiInteraction gi) {
        gi.showMessage("Introduce tu nombre:"); //todo -> será útil en un futuro
    }
    public static void statsPlayer(Player player, GuiInteraction gi) { // todo -> reemplazar llamadas a este método por displayStats de ConsolePresentation
        gi.showMessage("---------------------------------------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        gi.pauseForUserInput();
    }
}

