package game0.threads.thread.table_pum;

import game0.NPCs.NpcNarration;
import game0.events.combats.CombatLogic;
import game0.game.manager.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.PlayerOptions;

public class ThreadTablePum extends CombatLogic {
    public void gestionEventosPumYTable(GameContext gc) {
        String opcion = "";
        opcion = gc.getGuiInteraction().getInput().toLowerCase();

        switch (opcion) {
            case "a":
                dialogar(gc);
                break;
            case "b":
                gc.getctp().combatFlowTablePum(gc);
                this.afterCombat(gc);
                break;
            case "c":
                tirarPedo(gc);
                break;
            case "d":
                pasarDeLargo(gc);
                break;
            default:
                GameStoryTeller.narrar(26,null);
                gestionEventosPumYTable(gc);
                break;
        }
    }

    public void dialogar(GameContext gc) {
        PlayerOptions.dialogo(4, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();

        GameVoiceOver.separador(gc.getGuiInteraction());

        NpcNarration.dialogoPumYTable(0);
        gc.getGuiInteraction().pauseForUserInput();
        NpcNarration.dialogoPumYTable(1);
        gc.getGuiInteraction().pauseForUserInput();
        NpcNarration.dialogoPumYTable(2);
        gc.getGuiInteraction().pauseForUserInput();
        NpcNarration.dialogoPumYTable(3);
        PlayerOptions.dialogo(5, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.separador(gc.getGuiInteraction());
        NpcNarration.dialogoPumYTable(4);
        gc.getGuiInteraction().pauseForUserInput();
        NpcNarration.dialogoPumYTable(5);
        gc.getGuiInteraction().pauseForUserInput();

        PlayerOptions.opcion(11, gc.getPlayer());
        this.gestionarRegalo(gc);
    }

    public void gestionarRegalo(GameContext gc) {
        String opcion = "";
        opcion = gc.getGuiInteraction().getInput();

        switch (opcion) {
            case "a":
                GameVoiceOver.separador(gc.getGuiInteraction());
                GameVoiceOver.dialogo(26, null);
                gc.getGuiInteraction().pauseForUserInput();
                GameVoiceOver.dialogo(27, null);
                gc.getPlayer().setHp(gc.getPlayer().getHp() - 1);
                gc.getPlayer().setEnergy(gc.getPlayer().getEnergy() + 2);
                gc.getGuiInteraction().pauseForUserInput();
                NpcNarration.dialogoPumYTable(10);
                gc.getGuiInteraction().pauseForUserInput();
                NpcNarration.dialogoPumYTable(11);
                gc.getGuiInteraction().pauseForUserInput();
                NpcNarration.dialogoPumYTable(12);
                gc.getGuiInteraction().pauseForUserInput();
                NpcNarration.dialogoPumYTable(13);
                gc.getGuiInteraction().pauseForUserInput();
                PlayerOptions.dialogo(6, gc.getPlayer());
                PlayerOptions.dialogo(7, gc.getPlayer());
                break;
            case "b":
                NpcNarration.dialogoPumYTable(14);
                gc.getGuiInteraction().pauseForUserInput();
                NpcNarration.dialogoPumYTable(15);
                gc.getGuiInteraction().pauseForUserInput();
                PlayerOptions.opcion(13, gc.getPlayer()); // todo -> seguir por aquí
                break;
            case "c":
                gc.getctp().combatFlowTablePum(gc);
                this.afterCombat(gc);

                break;
            case "d":
                pasarDeLargo(gc);
            default:
                GameStoryTeller.narrar(26,null);
                gestionarRegalo(gc);
        }
    }

    public static void tirarPedo(GameContext gc) {
        GameVoiceOver.dialogo(21, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.separador(gc.getGuiInteraction());
        NpcNarration.dialogoPumYTable(8);
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.dialogo(22, null);
        gc.getEquipment().equiparItem("manoI", "Mechero (+2 Vida)");
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.separador(gc.getGuiInteraction());
        gc.getPlayer().setHp(gc.getPlayer().getHp() + 2);
        GameVoiceOver.dialogo(23, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        PlayerOptions.dialogo(8, gc.getPlayer()); // todo -> seguir por aquí

    }

    public static void pasarDeLargo(GameContext gc) {
        GameVoiceOver.separador(gc.getGuiInteraction());
        GameVoiceOver.dialogo(25, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(51, null);
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.dialogo(35,null);
    }

    public void afterCombat(GameContext gc) {
        if (playerWins) {
            PlayerOptions.opcion(12, gc.getPlayer());
            String opcion = gc.getGuiInteraction().getInput();
            switch (opcion) {
                case "a":
                    lootearCuerpos(gc);
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(30, null);
                    gc.getGuiInteraction().pauseForUserInput();
                    PlayerOptions.opcion(14, gc.getPlayer());
                    break;
                case "b":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(31, null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(54, gc.getPlayer());
                    gc.getGuiInteraction().pauseForUserInput();
                    GameVoiceOver.dialogo(32, null);
                    break;
                case "c":
                    GameVoiceOver.separador(gc.getGuiInteraction());
                    GameVoiceOver.dialogo(33, null);
                    gc.getGuiInteraction().pauseForUserInput();
                    GameStoryTeller.narrar(55, gc.getPlayer());
                    gc.getGuiInteraction().pauseForUserInput();
                    PlayerOptions.opcion(15, gc.getPlayer());
                    opcionDespuesEsconderCuerpos(gc);
            }
        }
    }

    public void lootearCuerpos(GameContext gc) {
        GameVoiceOver.separador(gc.getGuiInteraction());
        GameVoiceOver.dialogo(28, null);
        GameVoiceOver.separador(gc.getGuiInteraction());
        gc.getGuiInteraction().pauseForUserInput();
        GameStoryTeller.narrar(52, gc.getPlayer());
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.separador(gc.getGuiInteraction());
        GameVoiceOver.dialogo(29, null);
        gc.getEquipment().equiparItem("manoI", "Mechero (+2 Vida)");
        gc.getEquipment().equiparItem("collar", "Collar feo (+2 Defensa)");
        gc.getPlayer().setHp(gc.getPlayer().getHp() + 2);
        gc.getPlayer().setHp(gc.getPlayer().getDeffense() + 2);
        gc.getGuiInteraction().pauseForUserInput();
        GameVoiceOver.separador(gc.getGuiInteraction());
        GameStoryTeller.narrar(53, null);
        gc.getGuiInteraction().pauseForUserInput();
    }

    public void opcionDespuesEsconderCuerpos(GameContext gc) {
        String opcion2 = gc.getGuiInteraction().getInput();

        if (opcion2.equalsIgnoreCase("a")) {
            lootearCuerpos(gc);

        } else if (opcion2.equalsIgnoreCase("b")) {
            GameVoiceOver.separador(gc.getGuiInteraction());
            GameStoryTeller.narrar(56, null);
            gc.getGuiInteraction().pauseForUserInput();
            GameVoiceOver.dialogo(34, null);

        } else if (opcion2.equalsIgnoreCase("c")) {
            GameVoiceOver.separador(gc.getGuiInteraction());
            GameStoryTeller.narrar(57, null);
            gc.getGuiInteraction().pauseForUserInput();
            afterCombat(gc);

        } else {
            GameStoryTeller.narrar(26, null);
            opcionDespuesEsconderCuerpos(gc);
        }
    }
}
