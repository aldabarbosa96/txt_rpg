package game0.game;

import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.player.Equipment;
import game0.player.Player;
import game0.NPCs.Enemy;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameContext { //esta clase encapsula muchas otras clases
    private ConsolePresentation consolePresentation;
    private GuiInteraction guiInteraction;
    private Player player;
    private Enemy enemy;
    private Combat combat;
    private Equipment equipment;
    private Attacks attacks;
    private GameEnter gameEnter;
    private Dice dice;

    public GameContext(ConsolePresentation cp, GuiInteraction gi, Player player, Enemy enemy, Combat combat, Equipment equipment,Dice diceForAttack, Attacks attacks,GameEnter ge) {
        this.consolePresentation = cp;
        this.guiInteraction = gi;
        this.player = player;
        this.enemy = enemy;
        this.combat = combat;
        this.equipment = equipment;
        this.attacks = attacks;
        this.gameEnter = ge;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setAttacks(Attacks attacks) {
        this.attacks = attacks;
    }
    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public ConsolePresentation getConsolePresentation() {
        return consolePresentation;
    }

    public GuiInteraction getGuiInteraction() {
        return guiInteraction;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Combat getCombat() {
        return combat;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Attacks getAttacks() {
        return attacks;
    }

    public GameEnter getGameEnter() {
        return gameEnter;
    }

}
