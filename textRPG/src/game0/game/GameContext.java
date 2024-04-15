package game0.game;

import game0.console.ConsolePresentation;
import game0.events.Attacks;
import game0.events.Combat;
import game0.player.Equipment;
import game0.player.Player;
import game0.player.PlayerStatistics;
import game0.NPCs.Enemy;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameContext { //esta clase encapsula muchas otras clases y la puedo usar como parámetro para ahorrar parámetros
    private ConsolePresentation consolePresentation;
    private GuiInteraction guiInteraction;
    private Player player;
    private Enemy enemy;
    private Combat combat;
    private Equipment equipment;
    private PlayerStatistics playerStatistics;
    private Attacks attacks;
    private GameEnter gameEnter;
    private Dice diceForAttack;

    public GameContext(ConsolePresentation cp, GuiInteraction gi, Player player, Enemy enemy, Combat combat, Equipment equipment, PlayerStatistics ps,Dice diceForAttack, Attacks attacks,GameEnter ge) {
        this.consolePresentation = cp;
        this.guiInteraction = gi;
        this.player = player;
        this.enemy = enemy;
        this.combat = combat;
        this.equipment = equipment;
        this.playerStatistics = ps;
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

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    public void setAttacks(Attacks attacks) {
        this.attacks = attacks;
    }
    public Dice getDiceForAttack() {
        return diceForAttack;
    }

    public void setDiceForAttack(Dice diceForAttack) {
        this.diceForAttack = diceForAttack;
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

    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public Attacks getAttacks() {
        return attacks;
    }

    public GameEnter getGameEnter() {
        return gameEnter;
    }

}
