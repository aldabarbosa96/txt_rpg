package game0.console;

import game0.interfaces.GamePresentation;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.NPCs.Enemy;

public class ConsolePresentation implements GamePresentation {
    @Override
    public String displayStats(UserInteraction ui, Player player, Enemy enemy) {
        StringBuilder stats = new StringBuilder();
        stats.append("\n-----ESTADÍSTICAS--------------------\n\n");
        if (player != null) {
            stats.append("  Nivel: ").append(player.getLvl()).append("\n\n");
            stats.append("  Nombre: ").append(player.getName()).append("\n\n");
            stats.append("  Vida: ").append(player.getHp()).append("\n\n");
            stats.append("  Energía: ").append(player.getEnergy()).append("\n\n");
            stats.append("  Fuerza: ").append(player.getAttack()).append("\n\n");
            stats.append("  Defensa: ").append(player.getDeffense()).append("\n\n");
            stats.append("  XP: ").append(player.getXp()).append(" %").append("\n");
            stats.append("\n###################################################");
        }
        if (enemy != null && enemy.getLifePoints() > 0) {
            stats.append("\n                  VS\n");
            stats.append("###################################################\n\n");
            stats.append("  Nivel: ").append(enemy.getLvl()).append("\n\n");
            stats.append("  Nombre: ").append(enemy.getName()).append("\n\n");
            stats.append("  Vida: ").append(enemy.getLifePoints()).append("\n\n");
            stats.append("  Fuerza: ").append(enemy.getAttackPoints()).append("\n\n");
            stats.append("  Defensa: ").append(enemy.getDeffensePoints()).append("\n");
        }
        stats.append("\n###################################################\n\n");
        return stats.toString();
    }

    @Override
    public void displayCombat(UserInteraction ui, Player player, Enemy enemy) {
        ui.showMessage("\n--------------------FIGHT--------------------\n" +
                "\n" +
                "                  O             O\n" +
                "                 /|\\/         /|\\\\\n" +
                "                //\\    VS     |\\\\\n" +
                "               //  \\          /  \\\\\n" +
                "\n" +
                "     " + player.getName() + "    VS    " + enemy.getName() + "\n");
    }

}
