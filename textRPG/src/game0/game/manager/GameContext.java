package game0.game.manager;

import game0.console.ConsolePresentation;
import game0.events.combats.Attacks;
import game0.events.combats.CombatLogic;
import game0.threads.thread.narrative.CombatNarrator;
import game0.threads.thread.table_pum.CombatTablePum;
import game0.player.Equipment;
import game0.player.Player;
import game0.NPCs.Enemy;
import game0.threads.thread.table_pum.ThreadTablePum;
import playerInteractions.Dice;
import playerInteractions.GameEnter;
import window.GuiInteraction;

public class GameContext {
    private ConsolePresentation consolePresentation;
    private GuiInteraction guiInteraction;
    private Player player;
    private Enemy enemy;
    private CombatNarrator combat;
    private Equipment equipment;
    private Attacks attacks;
    private GameEnter gameEnter;
    private Dice dice;
    private CombatLogic cl;
    private CombatTablePum ctp;
    private ThreadTablePum tpt;

    public GameContext(ConsolePresentation cp, GuiInteraction gi, Player player, Enemy enemy, CombatNarrator combat, Equipment equipment, Attacks attacks, GameEnter ge, CombatLogic cl, CombatTablePum ctp, ThreadTablePum tpt) {
        this.consolePresentation = cp;
        this.guiInteraction = gi;
        this.player = player;
        this.enemy = enemy;
        this.combat = combat;
        this.equipment = equipment;
        this.attacks = attacks;
        this.gameEnter = ge;
        this.cl = cl;
        this.ctp = ctp;
        this.tpt = tpt;
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

    public CombatNarrator getCombat() {
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

    public CombatLogic getCl() {
        return cl;
    }

    public CombatTablePum getctp() {
        return ctp;
    }

    public ThreadTablePum getTpt() {
        return tpt;
    }

}
