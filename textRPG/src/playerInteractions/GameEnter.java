package playerInteractions;

import game0.game.narrative.GameStoryTeller;
import game0.game.narrative.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Equipment;
import game0.player.Player;
import window.GuiInteraction;

public class GameEnter {
    static Dice d12 = new Dice(12);

    public void invalidName(GuiInteraction gi, Player player) {
        while (player.getName().isEmpty() || player.getName().length() >= 20) {
            GameStoryTeller.narrar(30, null);
            player.setName(gi.getInput());
        }
    }

    public static void enterInv(GuiInteraction gi) {
        GameVoiceOver.dialogo(0, null);
        gi.pauseForUserInput();
    }

    public static int enterDadoAtaquePlayer(GuiInteraction gi, Player player) {
        GameVoiceOver.separador(gi);
        GameVoiceOver.dialogo(1, null);
        gi.pauseForUserInput();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaquePlayer(resultadoAt0, player, gi);
        return resultadoAt0;
    }

    public static int enterDadoAtaqueEnemy(GuiInteraction gi, Enemy enemy) {
        GameVoiceOver.separador(gi);
        GameVoiceOver.dialogo(12, null);
        gi.pauseForUserInput();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaqueEnemy(resultadoAt0, enemy, gi);
        return resultadoAt0;
    }

    public static void enterAtaque(GuiInteraction gi) { //todo -> REVISAR
        GameVoiceOver.separador(gi);
        GameVoiceOver.dialogo(2, null);
        gi.pauseForUserInput();
    }

    public static void enterEquipo(GuiInteraction gi, Equipment equipment) {
        GameVoiceOver.separador(gi);
        GameVoiceOver.dialogo(14, null);
        gi.showMessage(equipment.toString());
        gi.pauseForUserInput();
    }

    public static void enterDadoDialogo(GuiInteraction gi) {
        GameVoiceOver.dialogo(3, null);
        gi.pauseForUserInput();
    }
}
