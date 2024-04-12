package game0.player;

import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.events.Attacks;
import game0.interfaces.UserInteraction;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

import java.util.Scanner;
public class PlayerStatistics {
    public PlayerStatistics() {
    }

    public static void statsPlayer(Player player, GuiInteraction gi) {
        gi.showMessage("--------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        gi.pauseForUserInput();
    }

    public void actEstPlayerEnCombate(Player player, GuiInteraction gi, Enemy enemigo, Attacks attack) {
        GameVoiceOver.dialogo(5, player);
        attack.playerAttack(player, enemigo, gi);
    }

    public void actEstEnemyEnCombate(Player player, GuiInteraction gi, Enemy enemigo, Attacks attack) {
        gi.pauseForUserInput();
        GameVoiceOver.dialogo(7, null);
        gi.pauseForUserInput();
        attack.enemyAttacks(player, enemigo, gi);

    }
}


