package game0.player;

import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.events.Attacks;
import game0.interfaces.UserInteraction;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import java.util.Scanner;
public class PlayerStatistics {
    public PlayerStatistics() {
    }

    public static void statsPlayer(Player player, UserInteraction ui) {
        ui.showMessage("--------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        ui.pauseForUserInput();
    }

    public void actEstPlayerEnCombate(Player player, UserInteraction ui, Enemy enemigo, Attacks attack) {
        GameVoiceOver.dialogo(5, player);
        attack.playerAttack(player, enemigo, ui);
    }

    public void actEstEnemyEnCombate(Player player, UserInteraction ui, Enemy enemigo, Attacks attack) {
        ui.pauseForUserInput();
        GameVoiceOver.dialogo(7, null);
        ui.pauseForUserInput();
        attack.enemyAttacks(player, enemigo, ui);

    }
}


