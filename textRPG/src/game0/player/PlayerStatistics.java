package game0.player;

import game0.game.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.events.Attacks;
import window.GuiInteraction;

public class PlayerStatistics { // todo -> Esta clase se eliminará en un futuro
    public PlayerStatistics() {
    }

    public static void statsPlayer(Player player, GuiInteraction gi) { // todo -> reemplazar llamadas a este método por displayStats de ConsolePresentation
        gi.showMessage("---------------------------------------------------\nJugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack() + "\nDefensa: " + player.getDeffense());
        gi.pauseForUserInput();
    }

    /*public void actEstPlayerEnCombate(Player player, GuiInteraction gi, Enemy enemigo, Attacks attack) {
        GameVoiceOver.dialogo(5, player);
        attack.playerAttack(player, enemigo, gi,cp);
    }

    public void actEstEnemyEnCombate(Player player, GuiInteraction gi, Enemy enemigo, Attacks attack) {
        gi.pauseForUserInput();
        GameVoiceOver.dialogo(7, null);
        gi.pauseForUserInput();
        attack.enemyAttacks(player, enemigo, gi);

    }*/
}


