package playerInteractions;

import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.interfaces.UserInteraction;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;

import java.util.Scanner;

public class GameEnter {
    static Dice d12 = new Dice(12);
    public void invalidName(UserInteraction ui,Player player){
        while (player.getName().isEmpty()){
            GameStoryTeller.narrar(30,null);
            player.setName(ui.getInput());
        }
    }
    public static void enterInv(UserInteraction ui){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(0,null);
        ui.pauseForUserInput();
        Inventory.mostrarInv();
        ui.pauseForUserInput();
    }
    public static int enterDadoAtaquePlayer(UserInteraction ui,Player player){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(1,null);
        ui.pauseForUserInput();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaquePlayer(resultadoAt0,player,ui);
        return  resultadoAt0;
    }
    public static int enterDadoAtaqueEnemy(UserInteraction ui,Enemy enemy){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(12,null);
        ui.pauseForUserInput();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaqueEnemy(resultadoAt0,enemy,ui);
        return  resultadoAt0;
    }

    public static void enterAtaque(UserInteraction ui){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(2,null);
        ui.pauseForUserInput();
    }
    public static void enterEquipo(UserInteraction ui,Equipment equipment){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(14,null);
        equipment.mostrarEquipo();
        ui.pauseForUserInput();
    }
    public static void enterDadoDialogo(UserInteraction ui){
        GameVoiceOver.dialogo(3,null);
        ui.pauseForUserInput();
    }
}
