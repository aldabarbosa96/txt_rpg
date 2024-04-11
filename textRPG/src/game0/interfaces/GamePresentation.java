package game0.interfaces;

import game0.NPCs.Enemy;
import game0.player.Player;

public interface GamePresentation {
    void displayStats(Object entity);
    void displayCombat(Player player, Enemy enemy);
}
