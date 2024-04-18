package game0.events.combats;

import game0.console.ConsolePresentation;
import game0.game.manager.GameContext;
import game0.game.narrative.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class Attacks {
    public void playerAttack(GameContext gc) {
        int resultadoDado = GameEnter.enterDadoAtaquePlayer(gc.getGuiInteraction(), gc.getPlayer());

        gc.getPlayer().setEnergy(gc.getPlayer().getEnergy() - 1);

        if ((resultadoDado + gc.getPlayer().getAttack()) > gc.getEnemy().getDeffensePoints()) {
            float daño = (resultadoDado + gc.getPlayer().getAttack() - gc.getEnemy().getDeffensePoints());
            gc.getEnemy().setLifePoints((int) (gc.getEnemy().getLifePoints() - daño));
            gc.getGuiInteraction().showMessage("El ataque ha hecho " + daño + " de daño al enemigo.");
        } else if ((resultadoDado + gc.getPlayer().getAttack()) == gc.getEnemy().getDeffensePoints()) {
            GameVoiceOver.dialogo(6, null);
        } else {
            float daño = gc.getEnemy().getDeffensePoints() - (resultadoDado + gc.getPlayer().getAttack());
            gc.getPlayer().setHp((int) (gc.getPlayer().getHp() - daño));
            gc.getGuiInteraction().showMessage(gc.getPlayer().getName() + " se hirió " + daño + " a si mismo.");
        }
        set0ifNegative(gc.getEnemy(), gc.getPlayer());
        gc.getConsolePresentation().displayStats(gc.getGuiInteraction(), gc.getPlayer(), gc.getEnemy());
    }

    public void enemyAttacks(Player player, Enemy enemy, GuiInteraction gi, ConsolePresentation cp) {
        float resultadoDado = GameEnter.enterDadoAtaqueEnemy(gi, enemy) + enemy.getAttackPoints();
        float daño = resultadoDado - player.getDeffense();

        if (daño < 0) {
            daño *= -1;
        }
        if (resultadoDado > player.getDeffense()) {
            player.setHp((int) (player.getHp() - daño));
            gi.showMessage("El ataque te ha hecho " + daño + " de daño.");
        } else if (resultadoDado == player.getDeffense()) {
            GameVoiceOver.dialogo(8, null);
        } else if (resultadoDado < player.getDeffense()) {
            enemy.setLifePoints((int) (enemy.getLifePoints() - daño));
            gi.showMessage(enemy.getName() + " se hirió " + daño + " a si mismo.");
        }
        set0ifNegative(enemy, player);
        cp.displayStats(gi, player, enemy);
    }

    public void set0ifNegative(Enemy enemy, Player player) {
        if (enemy.getLifePoints() <= 0) {
            enemy.setLifePoints(0);
        } else if (player.getHp() <= 0) {
            player.setHp(0);
        }
    }
}


