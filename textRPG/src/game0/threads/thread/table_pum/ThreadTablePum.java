package game0.threads.thread.table_pum;

import game0.NPCs.NpcNarration;
import game0.events.combats.CombatLogic;
import game0.game.manager.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.PlayerOptions;

public class ThreadTablePum extends CombatLogic {

    public void gestionEventosPumYTable( GameContext gc){
        String opcion = "";
            opcion = gc.getGuiInteraction().getInput().toLowerCase();

            switch (opcion){
                case "a":
                    dialogar(gc);
                    break;
                case "b":
                    attack(gc);
                    break;
                case "c":
                    tirarPedo(gc);
                    break;
                case "d":
                    pasarDeLargo(gc);
                    break;
            }
        }
    public static void dialogar(GameContext gc){ //todo -> interaccion con las opciones en otro método

            PlayerOptions.dialogo(4,gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();

            GameVoiceOver.separador(gc.getGuiInteraction());

            NpcNarration.dialogoPumYTable(0);
            gc.getGuiInteraction().pauseForUserInput();
            NpcNarration.dialogoPumYTable(1);
            gc.getGuiInteraction().pauseForUserInput();
            NpcNarration.dialogoPumYTable(2);
            gc.getGuiInteraction().pauseForUserInput();
            NpcNarration.dialogoPumYTable(3);
            GameVoiceOver.separador(gc.getGuiInteraction());
            PlayerOptions.dialogo(5,gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
            NpcNarration.dialogoPumYTable(4);
            gc.getGuiInteraction().pauseForUserInput();
            NpcNarration.dialogoPumYTable(5);
            gc.getGuiInteraction().pauseForUserInput();

            PlayerOptions.opcion(11,gc.getPlayer()); //todo -> seguir por aquí
        }

    public void attack(GameContext gc){
        GameVoiceOver.separador(gc.getGuiInteraction());
        gc.getctp().combatFlowTablePum(gc);
    }
    public static void tirarPedo(GameContext gc){
        GameVoiceOver.dialogo(21,null);
        gc.getGuiInteraction().pauseForUserInput();
        NpcNarration.dialogoPumYTable(8);
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.dialogo(22,null);
        gc.getEquipment().equiparItem("manoI","Mechero (+2 Vida)");
        gc.getGuiInteraction().pauseForUserInput();
        gc.getPlayer().setAttack(gc.getPlayer().getHp() + 2);
        GameVoiceOver.dialogo(23,gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();


    }
    public void pasarDeLargo(GameContext gc){
        GameVoiceOver.separador(gc.getGuiInteraction());
        GameVoiceOver.dialogo(25,null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(51,null);
    }
}
