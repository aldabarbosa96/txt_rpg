package game0.threads.thread;

import game0.NPCs.NpcNarration;
import game0.events.combats.CombatLogic;
import game0.game.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Player;
import game0.player.PlayerOptions;
import window.GuiInteraction;

public class ThreadPonYTable extends CombatLogic {

    public void gestionEventosPumYTable(Player player, GuiInteraction gi, GameContext gc){
        String opcion = "";

        while (true){
            opcion = gi.getInput().toLowerCase();

            switch (opcion){
                case "a":
                    dialogar(player,gi);
                    break;
                case "b":
                    attack(gc);
                    break;
                case "c":

            }
        }
    }
    public static void dialogar(Player player, GuiInteraction gi){ //todo -> interaccion con las opciones en otro método

            PlayerOptions.dialogo(4,player);
            gi.pauseForUserInput();

            GameVoiceOver.separador(gi);

            NpcNarration.dialogoPumYTable(0);
            gi.pauseForUserInput();
            NpcNarration.dialogoPumYTable(1);
            gi.pauseForUserInput();
            NpcNarration.dialogoPumYTable(2);
            gi.pauseForUserInput();
            NpcNarration.dialogoPumYTable(3);
            PlayerOptions.dialogo(5,player);
            gi.pauseForUserInput();
            NpcNarration.dialogoPumYTable(4);
            gi.pauseForUserInput();
            NpcNarration.dialogoPumYTable(5);
            gi.pauseForUserInput();

            PlayerOptions.opcion(11,player); //todo -> seguir por aquí
        }

    public void attack(GameContext gc){
        gc.getctp().combatFlowTablePum(gc);
    }
    public static void tirarPedo(){

    }
}
