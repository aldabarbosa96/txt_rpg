package playerInteractions;

import game0.player.Inventory;
import game0.player.Player;

import java.util.Scanner;

public class GameEnter {
    static Dice d12 = new Dice(12);
    static Scanner sc = new Scanner(System.in);
    public  static void enterInv(){
        System.out.println("Pulsa ENTER para abrir tu inventario:");
        sc.nextLine();
        Inventory.mostrarInv();
    }
    public static int enterDadoAtaque(Player player){
        System.out.println("Pulsa ENTER para lanzar el dado de ataque:");
        sc.nextLine();
        int resultadoAt0 = d12.lanzar();
        d12.imprimirDadoAtaque(resultadoAt0,player);
        return  resultadoAt0;
    }
    public static void enterAtaque(){
        System.out.println("Pulsa ENTER para entrar en combate:");
        sc.nextLine();
    }
    public static void enterDadoDialogo(){
        System.out.println("Pulsa ENTER para lanzar el dado de diálogo:");
        sc.nextLine();
    }
}
