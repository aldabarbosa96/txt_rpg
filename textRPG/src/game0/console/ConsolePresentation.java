package game0.console;

import game0.interfaces.GamePresentation;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.NPCs.Enemy;

public class ConsolePresentation implements GamePresentation {
    @Override
    public String displayStats(UserInteraction ui, Object entity) {
        StringBuilder stats = new StringBuilder();
        stats.append("\n\n-----ESTADÍSTICAS--------------------\n\n");
        if (entity instanceof Player player) {
            stats.append("  Jugador: ").append(player.getName()).append("\n\n");
            stats.append("  Vida: ").append(player.getHp()).append("\n\n");
            stats.append("  Energía: ").append(player.getEnergy()).append("\n\n");
            stats.append("  Fuerza: ").append(player.getAttack()).append("\n\n");
            stats.append("  Defensa: ").append(player.getDeffense()).append("\n");
        } if (entity instanceof Enemy enemy) {
            stats.append("          VS");
            stats.append("\n\n---------------------------------------------------");
            stats.append("Enemigo: ").append(enemy.getName()).append("\n\n");
            stats.append("Vida: ").append(enemy.getLifePoints()).append("\n\n");
            stats.append("Fuerza: ").append(enemy.getAttackPoints()).append("\n\n");
            stats.append("Defensa: ").append(enemy.getDeffensePoints()).append("\n\n");
        }
        stats.append("\n\n---------------------------------------------------\n\n");
        return stats.toString();
    }


    @Override
    public void displayCombat(UserInteraction ui,Player player, Enemy enemy) {
        ui.showMessage("\n--------------------FIGHT--------------------\n" +
                "\n"+
                "                  O          O\n" +
                "                 /|\\/         /|\\\\\n" +
                "                //\\    VS   |\\\\\n" +
                "               //  \\         /  \\\\\n" +
                "\n"+
                "     "+ player.getName()+"    VS    "+enemy.getName()+"\n");
    }
}
