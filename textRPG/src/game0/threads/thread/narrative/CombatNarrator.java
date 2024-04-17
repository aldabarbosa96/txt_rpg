package game0.threads.thread.narrative;

import game0.events.combats.CombatLogic;
import game0.game.manager.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;

public class CombatNarrator extends CombatLogic {
    public void combatFlowNarrator(GameContext gc) { //todo -> implementar una clase (o interfaz) que controle y estructure el combate de forma genérica
        if (gc.getPlayer().getLvl() >= 2) {
            GameVoiceOver.separador(gc.getGuiInteraction());
            GameStoryTeller.narrar(48, gc.getPlayer());
            gc.getGuiInteraction().pauseForUserInput();
            return;
        }

        gc.getEnemy().setUpEnemy("Narrador",15,3,5,1);
        gc.getConsolePresentation().displayCombat(gc.getGuiInteraction(), gc.getPlayer(), gc.getEnemy());
        gc.getGuiInteraction().pauseForUserInput();

        combatLogic(gc); //gestiona la lógica del combate
        gc.getGuiInteraction().pauseForUserInput();

        if (playerWins) {
            winnerMessage = "¡¡¡<<" + gc.getPlayer().getName() + ">> es el ganador!!!";
            GameVoiceOver.separador(gc.getGuiInteraction());

        } else {
            winnerMessage = "¡¡¡<<" + gc.getEnemy().getName() + ">> es el ganador!!!";
            GameVoiceOver.separador(gc.getGuiInteraction());
        }
        gc.getGuiInteraction().showMessage(winnerMessage);
        resetParticipantsNarrador(gc.getPlayer(), gc.getEnemy());
        gc.getConsolePresentation().displayStats(gc.getGuiInteraction(),gc.getPlayer(),null);
        gc.getGuiInteraction().pauseForUserInput();
    }

    private void resetParticipantsNarrador(Player player, Enemy enemy) {
        float xpBase = playerWins ? 13.33f : 6.65f;
        float xpGanada = player.calculateXP(enemy) + xpBase;
        player.setXp(xpGanada);

        if (playerWins) {
            GameStoryTeller.narrar(19, player);
            GameStoryTeller.narrar(20, null);
        } else {
            GameStoryTeller.narrar(21, null);
            GameStoryTeller.narrar(40, player);
        }
        player.setEnergy(10);
        player.setHp(30);
        enemy.setUpEnemy("",0,0,0,0);
    }


}
