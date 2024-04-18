package game0.game.manager;


import game0.NPCs.Npc;


public class GameTester { //TODO -> JODER ESTO HA FUNCIONADO

    public static void run2(GameContext gc){
        gc.getConsolePresentation().displayStats(gc.getGuiInteraction(),gc.getPlayer(),null);
        String playerName = "";
        do {
            gc.getPlayer().setName(gc.getGuiInteraction());
            playerName = gc.getGuiInteraction().getInput();
        } while (playerName == null || playerName.trim().isEmpty());
        gc.getGuiInteraction().continueGame();
        gc.getPlayer().setName(playerName);
        gc.getGuiInteraction().showMessage(gc.getPlayer().getName());
        GameEvent.gestionEventos03(gc);
    }
}
