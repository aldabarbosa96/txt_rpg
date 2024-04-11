package game0.events;

import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.console.ConsolePresentation;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;

public class Combat {
    private String ganador = "";
    boolean ganaJugador = true;

    public boolean getGanaJugador() {
        return ganaJugador;
    }

    public void combatFlow(ConsolePresentation cp, Player player, Enemy enemy, UserInteraction ui,PlayerStatistics ps,Dice dado,Attacks attack){
        cp.displayCombat(ui,player,enemy);
        ui.pauseForUserInput();
        cp.displayStats(ui,player);
        cp.displayStats(ui,enemy);

        while (player.getHp() > 0 && enemy.getLifePoints() > 0){
            ps.actEstPlayerEnCombate(player,ui,enemy,attack);

            if (enemy.getLifePoints()<=0) {
                ui.pauseForUserInput();
                GameVoiceOver.dialogo(9,null);
                ui.pauseForUserInput();
                break;
            } else if (player.getHp()<=0 || player.getEnergy() <= 0) {
                ganaJugador = false;
                GameVoiceOver.dialogo(9,null);
                ui.pauseForUserInput();
                break;
            }

            ps.actEstEnemyEnCombate(player,ui,enemy,attack);

            if (enemy.getLifePoints() <= 0){
                GameVoiceOver.dialogo(9,null);
                ui.pauseForUserInput();
                break;
            }

            else if (player.getHp() <=0 || player.getEnergy() <= 0){
                ganaJugador = false;
                GameVoiceOver.dialogo(9,null);
                ui.pauseForUserInput();
                break;

            } else {ui.pauseForUserInput(); GameVoiceOver.dialogo(10,null);}

        }
        if (ganaJugador) ganador += "¡¡¡<<"+player.getName()+">> es el ganador!!!";
            else ganador += "¡¡¡<<"+ enemy.getName()+">> es el ganador!!!";
        ui.showMessage(ganador);
        ganador(player,enemy); ui.pauseForUserInput();
    }
    public void ganador(Player player, Enemy enemy){
        if (ganaJugador){
            GameStoryTeller.narrar(19,player);
            GameStoryTeller.narrar(20,null);
        }
        else {
            GameStoryTeller.narrar(21, null);
            GameStoryTeller.narrar(40, player);
        }
        player.setEnergy(8);
        player.setHp(30);
        enemy.setLifePoints(20);
    }
}
