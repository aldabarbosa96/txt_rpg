package game0.events;

import game0.console.ConsolePresentation;
import game0.game.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class Attacks {
    public void playerAttack(Player player, Enemy enemigo, GuiInteraction gi,ConsolePresentation cp){
        int resultadoDado = GameEnter.enterDadoAtaquePlayer(gi,player);

        player.setEnergy(player.getEnergy() - 1);

        if ((resultadoDado + player.getAttack()) > enemigo.getDeffensePoints()) {
            int daño = (resultadoDado + player.getAttack() - enemigo.getDeffensePoints());
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            gi.showMessage("El ataque ha hecho " + daño + " de daño al enemigo.");
            gi.pauseForUserInput();
        } else if ((resultadoDado + player.getAttack()) == enemigo.getDeffensePoints()) {
            GameVoiceOver.dialogo(6,null);
            gi.pauseForUserInput();
        } else {
            int daño = enemigo.getDeffensePoints() - (resultadoDado+player.getAttack());
            player.setHp(player.getHp() - daño);
            gi.showMessage(player.getName() + " se hirió " + daño + " a si mismo.");
            gi.pauseForUserInput();
        }
        cp.displayStats(gi,player);
        gi.pauseForUserInput();
        cp.displayStats(gi,player);
    }
    public void enemyAttacks(Player player,Enemy enemigo,GuiInteraction gi,ConsolePresentation cp){
        int resultadoDado = GameEnter.enterDadoAtaqueEnemy(gi,enemigo)+enemigo.getAttackPoints();
        gi.showMessage("Resultado del ataque: "+resultadoDado);
        int daño = resultadoDado - player.getDeffense(); gi.pauseForUserInput();

        if (daño<0){
            daño *= -1;
        }
        if (resultadoDado > player.getDeffense()) {
            player.setHp(player.getHp() - daño);
            gi.showMessage("El ataque te ha hecho " + daño + " de daño.");
            gi.pauseForUserInput();
        } else if (resultadoDado == player.getDeffense()) {
            GameVoiceOver.dialogo(8,null);
            gi.pauseForUserInput();
        } else if (resultadoDado < player.getDeffense()){
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            gi.showMessage(enemigo.getName() + " se hirió " + daño + " a si mismo.");
            gi.pauseForUserInput();
        }

        if (enemigo.getLifePoints()<=0){
            enemigo.setLifePoints(0);
        } else if (player.getHp()<=0) {
            player.setHp(0);
        }
        cp.displayStats(gi,player);
        gi.pauseForUserInput();
        cp.displayStats(gi,enemigo);
    }
}


