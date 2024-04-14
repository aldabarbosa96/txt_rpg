package game0.console;

import game0.interfaces.GamePresentation;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.NPCs.Enemy;

public class ConsolePresentation implements GamePresentation {
    @Override
    public String displayStats(UserInteraction ui, Object entity) {
        StringBuilder stats = new StringBuilder();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            ui.showMessage("\n---------------------------------------------------\n");
            ui.showMessage("Jugador: " + player.getName());
            ui.showMessage("Vida: " + player.getHp());
            ui.showMessage("Energía: " + player.getEnergy());
            ui.showMessage("Fuerza: " + player.getAttack());
            ui.showMessage("Defensa: " + player.getDeffense());
            ui.showMessage("\n---------------------------------------------------\n");
        } else if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            ui.showMessage("Enemigo: " + enemy.getName());
            ui.showMessage("Vida: " + enemy.getLifePoints());
            ui.showMessage("Fuerza: " + enemy.getAttackPoints());
            ui.showMessage("Defensa: " + enemy.getDeffensePoints());
            ui.showMessage("\n---------------------------------------------------\n");
        }
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
