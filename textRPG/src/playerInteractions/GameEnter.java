package playerInteractions;

import game0.GameStoryTeller;
import game0.GameVoiceOver;
import game0.NPCs.Enemy;
import game0.player.Equipment;
import game0.player.Inventory;
import game0.player.Player;

import java.util.Scanner;

public class GameEnter {
    static Dice d12 = new Dice(12);
    static Scanner sc = new Scanner(System.in);
    public void invalidName(Player player){
        while (player.getName().isEmpty()){
            GameStoryTeller.narrar(30,null);
            player.setName(sc.nextLine());
        }
    }
    public  static void enterInv(){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(0,null);
        sc.nextLine();
        Inventory.mostrarInv();
        sc.nextLine();
    }
    public static int enterDadoAtaquePlayer(Player player){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(1,null);
        sc.nextLine();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaquePlayer(resultadoAt0,player);
        return  resultadoAt0;
    }
    public static int enterDadoAtaqueEnemy(Enemy enemy){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(12,null);
        sc.nextLine();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaqueEnemy(resultadoAt0,enemy);
        return  resultadoAt0;
    }

    public static void enterAtaque(){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(2,null);
        sc.nextLine();
    }
    public static void enterEquipo(Equipment equipment){
        GameVoiceOver.dialogo(11,null);
        GameVoiceOver.dialogo(14,null);
        equipment.mostrarEquipo();
        sc.nextLine();
    }
    public static void enterDadoDialogo(){
        GameVoiceOver.dialogo(3,null);
        sc.nextLine();
    }
}
