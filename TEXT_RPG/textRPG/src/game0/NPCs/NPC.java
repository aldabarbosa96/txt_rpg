package game0.NPCs;

import game0.GameStoryTeller;
import game0.player.PlayerOptions;

import java.util.Scanner;

public class Npc {
    protected String name;

    protected static int respuestaNum0 = 0;

    public int getRespuestaNum0() {
        return respuestaNum0;
    }

    public Npc(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Npc(){}
    public static void interactuarNPC00(Scanner sc) {
        GameStoryTeller.narrar(4,null); sc.nextLine();
        NpcOptions.dialogo(0);
        GameStoryTeller.narrar(38,null);
        NpcOptions.dialogo(1);
    }
    public void interactuarNPC01(String respuesta) {
        while (respuestaNum0 <= 3) {
            if (respuesta.equalsIgnoreCase("a")) {
                respuestaNum0 = 0;
                NpcOptions.dialogo(2);
                GameStoryTeller.narrar(5,null);
                NpcOptions.dialogo(3);
                break;
            } else if (respuesta.equalsIgnoreCase("b")) {
                respuestaNum0 = 1;
                GameStoryTeller.narrar(6,null);
                break;
            } else if (respuesta.equalsIgnoreCase("c")) {
                respuestaNum0 = 2;
                NpcOptions.dialogo(4);
                GameStoryTeller.narrar(7,null);
                break;
            } else {
                respuestaNum0 = 3;
            }
        }
    }
    public static void interactuarNPC02() {
        while (respuestaNum0 <= 3) {
            if (respuestaNum0 == 0) {
                PlayerOptions.opcion(1);
                break;
            } else if (respuestaNum0 == 1) {
                PlayerOptions.opcion(2);
                break;
            } else if (respuestaNum0 == 2) {
                PlayerOptions.opcion(3);
                break;
            } else GameStoryTeller.narrar(26,null);
        }
    }
    public void interactuarNPC03(){
        }
    }