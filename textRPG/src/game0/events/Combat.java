package game0.events;

import game0.game.GameContext;
import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import playerInteractions.Dice;
import window.GuiInteraction;

public class Combat {
    private String winnerMessage = "";
    boolean playerWins = true;

    public void combatFlowNarrator(GameContext gc) { //todo -> implementar una clase (o interfaz) que controle y estructure el combate de forma genérica
        GuiInteraction gi = gc.getGuiInteraction();
        Player player = gc.getPlayer();
        Enemy enemy = gc.getEnemy();
        Dice d8 = new Dice(8);
        enemy.setUpEnemy("Narrador",15,3,5,1);

        gc.getConsolePresentation().displayCombat(gi, player, enemy);
        gi.pauseForUserInput();

        combatLogic(gc); //gestiona la lógica de la pelea

        gi.pauseForUserInput();
        if (playerWins) {
            winnerMessage = "¡¡¡<<" + player.getName() + ">> es el ganador!!!";
        } else {
            winnerMessage = "¡¡¡<<" + enemy.getName() + ">> es el ganador!!!";
        }
        gi.showMessage(winnerMessage);
        gc.getConsolePresentation().displayStats(gi,player,null);
        gi.pauseForUserInput();
        resetParticipantsNarrador(player, enemy,d8);
    }

    private void resetParticipantsNarrador(Player player, Enemy enemy, Dice d8) {
        if (playerWins) {
            GameStoryTeller.narrar(19, player);
            GameStoryTeller.narrar(20, null);
        } else {
            GameStoryTeller.narrar(21, null);
            GameStoryTeller.narrar(40, player);
        }
        player.setXp(enemy,d8);
        player.setEnergy(10);
        player.setHp(30);
        enemy.setUpEnemy("",0,0,0,0);
    }

    public void combatLogic(GameContext gc) {

        while (gc.getPlayer().getHp() > 0 && gc.getEnemy().getLifePoints() > 0) {
            gc.getAttacks().playerAttack(gc.getPlayer(), gc.getEnemy(), gc.getGuiInteraction(), gc.getConsolePresentation());
            gc.getAttacks().enemyAttacks(gc.getPlayer(), gc.getEnemy(), gc.getGuiInteraction(), gc.getConsolePresentation());

            while (gc.getPlayer().getHp() > 0 && gc.getEnemy().getLifePoints() > 0) {

                gc.getAttacks().playerAttack(gc.getPlayer(), gc.getEnemy(), gc.getGuiInteraction(), gc.getConsolePresentation());
                if (gc.getEnemy().getLifePoints() <= 0) {
                    GameVoiceOver.dialogo(9, null);
                    break;
                }
                gc.getAttacks().enemyAttacks(gc.getPlayer(), gc.getEnemy(), gc.getGuiInteraction(), gc.getConsolePresentation());
                if (gc.getPlayer().getHp() <= 0 || gc.getPlayer().getEnergy() <= 0) {
                    playerWins = false;
                    GameVoiceOver.dialogo(9, null);
                    break;
                }
                GameVoiceOver.dialogo(10, null);
                gc.getGuiInteraction().pauseForUserInput();
                GameVoiceOver.separador(gc.getGuiInteraction());
            }
        }
    }
}
