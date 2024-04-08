package playerInteractions;

import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.player.Inventory;
import game0.player.Player;
import game0.player.PlayerOptions;

import java.util.Scanner;

public class GameEnter {
    static Dice d12 = new Dice(12);
    static Scanner sc = new Scanner(System.in);
    public void invalidName(Player player){
        while (Player.getName().isEmpty()){
            GameStoryTeller.narrar(30,null);
            player.setName(sc.nextLine());
        }
    }
    public  static void enterInv(){
        GameVoiceOver.dialogo(0);
        sc.nextLine();
        Inventory.mostrarInv();
    }
    public static int enterDadoAtaque(Player player){
        GameVoiceOver.dialogo(1);
        sc.nextLine();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaque(resultadoAt0,player);
        return  resultadoAt0;
    }
    public static void enterAtaque(){
        GameVoiceOver.dialogo(2);
        sc.nextLine();
    }
    public static void enterDadoDialogo(){
        GameVoiceOver.dialogo(3);
        sc.nextLine();
    }
}
