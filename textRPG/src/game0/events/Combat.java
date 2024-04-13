package game0.events;

import game0.GameContext;
import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import window.GuiInteraction;

public class Combat {
    private String winnerMessage = "";
    boolean playerWins = true;

    public void combatFlow(GameContext gc) {
        GuiInteraction gi = gc.getGuiInteraction();
        Player player = gc.getPlayer();
        Enemy enemy = gc.getEnemy();
        Attacks attacks = new Attacks();


        gc.getConsolePresentation().displayCombat(gi, player, enemy);
        gi.pauseForUserInput();
        gc.getConsolePresentation().displayStats(gi, player);
        gc.getConsolePresentation().displayStats(gi, enemy);

        while (player.getHp() > 0 && enemy.getLifePoints() > 0) {
            attacks.playerAttack(player, enemy, gi);

            if (enemy.getLifePoints() <= 0) {
                GameVoiceOver.dialogo(9, null);
                break;
            } else if (player.getHp() <= 0 || player.getEnergy() <= 0) {
                playerWins = false;
                GameVoiceOver.dialogo(9, null);
                break;
            }

            attacks.enemyAttacks(player, enemy, gi);

            if (enemy.getLifePoints() <= 0) {
                GameVoiceOver.dialogo(9, null);
                break;
            } else if (player.getHp() <= 0 || player.getEnergy() <= 0) {
                playerWins = false;
                GameVoiceOver.dialogo(9, null);
                break;
            } else {
                gi.pauseForUserInput();
                GameVoiceOver.dialogo(10, null);
            }
        }

        if (playerWins) {
            winnerMessage = "¡¡¡<<"+player.getName()+">> es el ganador!!!";
        } else {
            winnerMessage = "¡¡¡<<"+ enemy.getName()+">> es el ganador!!!";
        }
        gi.showMessage(winnerMessage);
        resetParticipants(player, enemy);
    }

    private void resetParticipants(Player player, Enemy enemy) {
        if (playerWins) {
            GameStoryTeller.narrar(19, player);
            GameStoryTeller.narrar(20, null);
        } else {
            GameStoryTeller.narrar(21, null);
            GameStoryTeller.narrar(40, player);
        }
        player.setEnergy(8);
        player.setHp(30);
        enemy.setLifePoints(20);
    }
}
