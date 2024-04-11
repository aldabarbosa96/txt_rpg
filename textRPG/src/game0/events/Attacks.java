package game0.events;

import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.GameEnter;

public class Attacks {
    public void playerAttack(Player player, Enemy enemigo, UserInteraction ui){
        int resultadoDado = GameEnter.enterDadoAtaquePlayer(ui,player);

        player.setEnergy(player.getEnergy() - 1);

        if ((resultadoDado + player.getAttack()) > enemigo.getDeffensePoints()) {
            int daño = (resultadoDado + player.getAttack() - enemigo.getDeffensePoints());
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            ui.showMessage("El ataque ha hecho " + daño + " de daño al enemigo.");
            ui.pauseForUserInput();
        } else if ((resultadoDado + player.getAttack()) == enemigo.getDeffensePoints()) {
            GameVoiceOver.dialogo(6,null);
            ui.pauseForUserInput();
        } else {
            int daño = enemigo.getDeffensePoints() - (resultadoDado+player.getAttack());
            player.setHp(player.getHp() - daño);
            ui.showMessage(player.getName() + " se hirió " + daño + " a si mismo.");
            ui.pauseForUserInput();
        }
        PlayerStatistics.statsPlayer(player,ui);
        Enemy.statsEnemy(ui,enemigo);
    }
    public void enemyAttacks(Player player,Enemy enemigo,UserInteraction ui){
        int resultadoDado = GameEnter.enterDadoAtaqueEnemy(ui,enemigo)+enemigo.getAttackPoints();
        ui.showMessage("Resultado del ataque: "+resultadoDado);
        int daño = resultadoDado - player.getDeffense(); ui.pauseForUserInput();

        if (daño<0){
            daño *= -1;
        }
        if (resultadoDado > player.getDeffense()) {
            player.setHp(player.getHp() - daño);
            ui.showMessage("El ataque te ha hecho " + daño + " de daño.");
            ui.pauseForUserInput();
        } else if (resultadoDado == player.getDeffense()) {
            GameVoiceOver.dialogo(8,null);
            ui.pauseForUserInput();
        } else if (resultadoDado < player.getDeffense()){
            enemigo.setLifePoints(enemigo.getLifePoints() - daño);
            ui.showMessage(enemigo.getName() + " se hirió " + daño + " a si mismo.");
            ui.pauseForUserInput();
        }

        if (enemigo.getLifePoints()<=0){
            enemigo.setLifePoints(0);
        } else if (player.getHp()<=0) {
            player.setHp(0);
        }
        PlayerStatistics.statsPlayer(player,ui);
        Enemy.statsEnemy(ui,enemigo);
    }
}


