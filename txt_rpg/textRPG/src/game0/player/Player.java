package game0.player;

import game0.GameStoryTeller;
import game0.NPCs.Npc;
import game0.NPCs.NpcOptions;

import java.util.Scanner;
public class Player {
    protected static String name;
    protected int hp = 30;
    protected int energy = 8;
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
    public static String getName() {
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

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttack(){return attack;}

    public void setName(String name) {
        this.name = name;
    }
    public void marcarPaz(){
        this.resPaz = true;
    }

    public String opcionEscogida0(Scanner sc) {
        String respuesta = "";
        boolean respuestaValida = false;
        PlayerOptions.opcion(0);

        while (!respuestaValida) {
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")) {
                PlayerOptions.dialogo(0);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                PlayerOptions.dialogo(1);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                PlayerOptions.dialogo(2);
                respuestaValida = true;
                marcarPaz();
            } else {
                GameStoryTeller.narrar(26,null);
            }
        }
        return respuesta;
    }

    public String opcionEscogida01(Scanner sc, Player player,Npc npc) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")) {
                NpcOptions.dialogo(5);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                NpcOptions.dialogo(6);
                respuestaValida = true;
                GameStoryTeller.narrar(32,player);
                System.exit(0);
            } else {
                GameStoryTeller.narrar(26,null);
            }
        }
        return respuesta;
    }

    public void opcionEscogida02(Scanner sc,Player player) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")){
                PlayerOptions.dialogo(3);
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
    public void opcionEscogida03(Scanner sc){
        Inventory.addToInventory("\"trozo de pan\"");
        NpcOptions.dialogo(7);
        GameStoryTeller.narrar(18,null);
    }
    public void escogerOpcion(Scanner sc, Npc npc, Player player){
        int respuestaNum0 = npc.getRespuestaNum0();

        switch (respuestaNum0){
            case 0:
                opcionEscogida01(sc,player,npc);
                break;
            case 1:
                opcionEscogida02(sc,player);
                break;
            case 2:
                opcionEscogida03(sc);
                break;
        }
    }
    public String opcionEscogida04(Scanner sc,Player player){
        PlayerOptions.opcion(4);
        String respuesta ="";
        boolean respuestaValida = false;
        while (!respuestaValida){
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("a")){
                GameStoryTeller.narrar(35, null);
                sc.nextLine();
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                GameStoryTeller.narrar(36,null);
                sc.nextLine();
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                GameStoryTeller.narrar(37,player);
                sc.nextLine();
                respuestaValida = true;
                System.exit(0);
            } else  GameStoryTeller.narrar(26,null);
        }
        return respuesta;
    }
}

