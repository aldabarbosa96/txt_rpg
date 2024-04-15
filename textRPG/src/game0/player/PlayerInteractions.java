package game0.player;

import game0.NPCs.Npc;
import game0.NPCs.NpcNarration;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import window.GuiInteraction;

public class PlayerInteractions extends Player{
    private Player player;
    private GuiInteraction gi;
    private boolean resPaz;
    public boolean ResPaz() {
        return resPaz;
    }
    public void marcarPaz(){
        this.resPaz = true;
    }

    public PlayerInteractions(Player player,GuiInteraction gi){
        this.player = player;
        this.gi = gi;
    }

    public String opcionEscogida0(GuiInteraction gi,Player player) { //todo -> mover todos los métodos a otra clase para que Player solo gestione la información del mismo
        String respuesta = "";
        boolean respuestaValida = false;
        PlayerOptions.opcion(0,player);

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
                NpcNarration.dialogo(5);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                NpcNarration.dialogo(6);
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
                GameVoiceOver.separador(gi);
                PlayerOptions.dialogo(3,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                GameVoiceOver.separador(gi);
                GameStoryTeller.narrar(33,player);
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                GameVoiceOver.separador(gi);
                GameStoryTeller.narrar(34,null);
                System.exit(0);
            } else {
                GameStoryTeller.narrar(26,null);
            }
        }
    }
    public void opcionEscogida03(){
        Inventory.addToInventory("Trozo de pan");
        NpcNarration.dialogo(7);
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
