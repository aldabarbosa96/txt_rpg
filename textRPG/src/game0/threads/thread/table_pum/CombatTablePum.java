package game0.threads.thread.table_pum;

import game0.NPCs.Enemy;
import game0.NPCs.NpcNarration;
import game0.events.combats.CombatLogic;
import game0.game.manager.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Player;
import window.GuiInteraction;

public class CombatTablePum extends CombatLogic {
    public void combatFlowTablePum(GameContext gc) { //todo -> implementar una clase (o interfaz) que controle y estructure el combate de forma genérica y dinámica
        GuiInteraction gi = gc.getGuiInteraction();
        Player player = gc.getPlayer();
        Enemy enemy = gc.getEnemy();
        GameVoiceOver.separador(gi);
        NpcNarration.dialogoPumYTable(6);
        gi.pauseForUserInput();
        NpcNarration.dialogoPumYTable(7);
        gi.pauseForUserInput();

        enemy.setUpEnemy("Pum y Table", 20, 3, 1, 2);
        gc.getConsolePresentation().displayCombat(gi, player, enemy);
        gi.pauseForUserInput();

        combatLogic(gc);

        gi.pauseForUserInput();
        if (playerWins) {
            winnerMessage = "¡¡¡<<" + player.getName() + ">> es el ganador!!!";
            GameVoiceOver.separador(gi);

        } else {
            winnerMessage = "¡¡¡<<" + enemy.getName() + ">> es el ganador!!!";
            GameVoiceOver.separador(gi);
        }
        gi.showMessage(winnerMessage);
        resetParticipantsTablePum(gc);
        gc.getConsolePresentation().displayStats(gi, player, null);
    }

    private void resetParticipantsTablePum(GameContext gc) {
        float xpBase = playerWins ? 13.33f : 6.65f;
        float xpGanada = gc.getPlayer().calculateXP(gc.getEnemy()) + xpBase;
        gc.getPlayer().setXp(xpGanada);

        if (playerWins) {
            gc.getGuiInteraction().pauseForUserInput();
            GameStoryTeller.narrar(50, gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
            gc.getEnemy().setUpEnemy("", 0, 0, 0, 0);
            GameVoiceOver.dialogo(13, null);
        } else {
            GameStoryTeller.narrar(49, gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
            GameVoiceOver.dialogo(20, null);
            gc.getGuiInteraction().pauseForUserInput();
            GameVoiceOver.dialogo(24, null); // todo -> mensaje subliminal (hay q conseguir que se vea esto)
            System.exit(0);

        }
        gc.getPlayer().setEnergy(10);
        gc.getPlayer().setHp( gc.getPlayer().getHp());
        gc.getEnemy().setUpEnemy("", 0, 0, 0, 0);
    }

}
