package game0.threads.thread.table_pum;

import game0.NPCs.Enemy;
import game0.NPCs.NpcNarration;
import game0.events.combats.CombatLogic;
import game0.game.manager.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.player.Player;
import game0.player.PlayerOptions;
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

        enemy.setUpEnemy("Pum y Table",24,4,4,2);
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
        resetParticipantsTablePum(player, enemy,gi);
        gc.getConsolePresentation().displayStats(gi,player,null);
        gi.pauseForUserInput();
    }
    private void resetParticipantsTablePum(Player player, Enemy enemy, GuiInteraction gi) {
        float xpBase = playerWins ? 13.33f : 6.65f;
        float xpGanada = player.calculateXP(enemy) + xpBase;
        player.setXp(xpGanada);

        if (playerWins) {
            gi.pauseForUserInput();
            GameStoryTeller.narrar(50,player);
            gi.pauseForUserInput();
            enemy.setUpEnemy("",0,0,0,0);
            GameVoiceOver.dialogo(13,null);
            PlayerOptions.opcion(12,player);
        } else {
            GameStoryTeller.narrar(49,player);
            gi.pauseForUserInput();
            GameVoiceOver.dialogo(20,null);
            gi.pauseForUserInput();
            GameVoiceOver.dialogo(24,null); // todo -> mensaje subliminal (hay q conseguir que se vea esto)
            System.exit(0);

        }
        player.setEnergy(10);
        player.setHp(player.getHp());
        enemy.setUpEnemy("",0,0,0,0);
    }

}
