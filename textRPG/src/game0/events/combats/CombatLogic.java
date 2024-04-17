package game0.events.combats;

import game0.game.manager.GameContext;
import game0.game.narrative.GameVoiceOver;

public class CombatLogic {
     public String winnerMessage = "";
     public boolean playerWins = true;
    public void combatLogic(GameContext gc) {
        while (gc.getPlayer().getHp() > 0 && gc.getEnemy().getLifePoints() > 0) {
            gc.getAttacks().playerAttack(gc);
            if (gc.getEnemy().getLifePoints() <= 0) {
                GameVoiceOver.dialogo(9, null);
                break;
            }
            gc.getAttacks().enemyAttacks(gc.getPlayer(), gc.getEnemy(), gc.getGuiInteraction(), gc.getConsolePresentation());
            if (gc.getPlayer().getHp() <= 0 || gc.getPlayer().getEnergy() <= 0) {
                playerWins = false;
                GameVoiceOver.dialogo(9, null);
                break;
            }
            GameVoiceOver.dialogo(10, null);
            gc.getGuiInteraction().pauseForUserInput();
            GameVoiceOver.separador(gc.getGuiInteraction());
        }
    }
}
