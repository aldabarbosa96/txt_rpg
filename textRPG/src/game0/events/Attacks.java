package game0.events;

import game0.console.ConsolePresentation;
import game0.game.narrative.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class Attacks {
    public void playerAttack(Player player, Enemy enemy, GuiInteraction gi,ConsolePresentation cp){
        int resultadoDado = GameEnter.enterDadoAtaquePlayer(gi,player);

        player.setEnergy(player.getEnergy() - 1);

        if ((resultadoDado + player.getAttack()) > enemy.getDeffensePoints()) {
            float daño = (resultadoDado + player.getAttack() - enemy.getDeffensePoints());
            enemy.setLifePoints(enemy.getLifePoints() - daño);
            gi.showMessage("El ataque ha hecho " + daño + " de daño al enemigo.");
        } else if ((resultadoDado + player.getAttack()) == enemy.getDeffensePoints()) {
            GameVoiceOver.dialogo(6,null);
        } else {
            float daño = enemy.getDeffensePoints() - (resultadoDado+player.getAttack());
            player.setHp((int) (player.getHp() - daño));
            gi.showMessage(player.getName() + " se hirió " + daño + " a si mismo.");
        }
        set0ifNegative(enemy, player);
        cp.displayStats(gi,player,enemy);
    }
    public void enemyAttacks(Player player,Enemy enemy,GuiInteraction gi,ConsolePresentation cp){
        float resultadoDado = GameEnter.enterDadoAtaqueEnemy(gi,enemy)+enemy.getAttackPoints();
        float daño = resultadoDado - player.getDeffense();

        if (daño<0){
            daño *= -1;
        }
        if (resultadoDado > player.getDeffense()) {
            player.setHp((int) (player.getHp() - daño));
            gi.showMessage("El ataque te ha hecho " + daño + " de daño.");
        } else if (resultadoDado == player.getDeffense()) {
            GameVoiceOver.dialogo(8,null);
        } else if (resultadoDado < player.getDeffense()){
            enemy.setLifePoints(enemy.getLifePoints() - daño);
            gi.showMessage(enemy.getName() + " se hirió " + daño + " a si mismo.");
        }
        set0ifNegative(enemy, player);
        cp.displayStats(gi,player,enemy);
    }
    public void set0ifNegative(Enemy enemy, Player player){
        if (enemy.getLifePoints()<=0){
            enemy.setLifePoints(0);
        } else if (player.getHp()<=0) {
            player.setHp(0);
        }
    }
}


