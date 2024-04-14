package game0.interfaces;

import game0.NPCs.Enemy;
import game0.player.Player;

public interface GamePresentation {
    String displayStats(UserInteraction ui, Object entity);
    void displayCombat(UserInteraction ui,Player player, Enemy enemy);
}
