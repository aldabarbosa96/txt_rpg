package game0.NPCs;

import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Player;
import game0.player.PlayerOptions;
import window.GuiInteraction;

public class Npc { //todo -> separar la clase NPC de la lógica de sus interacciones
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

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
    public static void interactuarNPC00(GuiInteraction gi) {
        GameStoryTeller.narrar(4,null); gi.pauseForUserInput();
        GameVoiceOver.separador(gi);
        NpcNarration.dialogoGuardiaArenas(0);
        GameStoryTeller.narrar(38,null);
        NpcNarration.dialogoGuardiaArenas(1);
    }
    public void interactuarNPC01(String respuesta) {
        while (respuestaNum0 <= 3) {
            if (respuesta.equalsIgnoreCase("a")) {
                respuestaNum0 = 0;
                NpcNarration.dialogoGuardiaArenas(2);
                GameStoryTeller.narrar(5,null);
                NpcNarration.dialogoGuardiaArenas(3);
                break;
            } else if (respuesta.equalsIgnoreCase("b")) {
                respuestaNum0 = 1;
                GameStoryTeller.narrar(6,null);
                break;
            } else if (respuesta.equalsIgnoreCase("c")) {
                respuestaNum0 = 2;
                NpcNarration.dialogoGuardiaArenas(4);
                GameStoryTeller.narrar(7,null);
                break;
            } else {
                respuestaNum0 = 3;
            }
        }
    }
    public static void interactuarNPC02(Player player) {
        while (respuestaNum0 <= 3) {
            if (respuestaNum0 == 0) {
                PlayerOptions.opcion(1,player);
                break;
            } else if (respuestaNum0 == 1) {
                PlayerOptions.opcion(2,player);
                break;
            } else if (respuestaNum0 == 2) {
                PlayerOptions.opcion(3,player);
                break;
            } else GameStoryTeller.narrar(26,null);
        }
    }
    public void interactuarNPC03(){
        }
    }