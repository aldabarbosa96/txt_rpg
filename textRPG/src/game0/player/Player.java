package game0.player;

import game0.game.GameStoryTeller;
import game0.NPCs.Npc;
import game0.NPCs.NpcOptions;
import window.GuiInteraction;

public class Player {
    private String name;
    protected int hp = 25;
    protected int energy = 10;
    protected int attack = 1;
    protected int deffense = 1;

    public int getDeffense() {
        return deffense;
    }
    private boolean resPaz;

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
    public int getHp0() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Player(String name, int hp, int energy, int attack) {
        this.name = name;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
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
    public void marcarPaz(){
        this.resPaz = true;
    }

    public String opcionEscogida0(GuiInteraction gi,Player player) { //todo -> mover todos los métodos a otra clase para que Player solo gestione la información del mismo
        String respuesta = "";
        boolean respuestaValida = false;
        PlayerOptions.opcion(0,this);

        while (!respuestaValida) {
            respuesta = gi.getInput();

            if (respuesta.equalsIgnoreCase("a")) {
                PlayerOptions.dialogo(0,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                PlayerOptions.dialogo(1,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                PlayerOptions.dialogo(2,player);
                respuestaValida = true;
                marcarPaz();
            } else {
                GameStoryTeller.narrar(26,null);
            }
        }
        return respuesta;
    }

    public String opcionEscogida01(GuiInteraction gi, Player player) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = gi.getInput();

            if (respuesta.equalsIgnoreCase("a")) {
                NpcOptions.dialogo(5);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                NpcOptions.dialogo(6);
                respuestaValida = true;
                GameStoryTeller.narrar(32,player);
                gi.pauseForUserInput();
                System.exit(0);
            } else {
                GameStoryTeller.narrar(26,null);
            }
        }
        return respuesta;
    }

    public void opcionEscogida02(GuiInteraction gi,Player player) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = gi.getInput();

            if (respuesta.equalsIgnoreCase("a")){
                PlayerOptions.dialogo(3,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                GameStoryTeller.narrar(33,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                GameStoryTeller.narrar(34,null);
                System.exit(0);
            } else {
               GameStoryTeller.narrar(26,null);
            }
        }
    }
    public void opcionEscogida03(){
        Inventory.addToInventory("Trozo de pan");
        NpcOptions.dialogo(7);
        GameStoryTeller.narrar(18,null);
    }
    public void escogerOpcion(GuiInteraction gi, Npc npc, Player player){
        int respuestaNum0 = npc.getRespuestaNum0();

        switch (respuestaNum0){
            case 0:
                opcionEscogida01(gi,player);
                break;
            case 1:
                opcionEscogida02(gi,player);
                break;
            case 2:
                opcionEscogida03();
                break;
        }
    }
}

