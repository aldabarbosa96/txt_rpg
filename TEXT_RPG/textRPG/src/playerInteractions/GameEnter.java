package playerInteractions;

import java.util.Scanner;

public class GameEnter {
    static Scanner sc = new Scanner(System.in);
    public  static void enterInv(){
        System.out.println("Pulsa ENTER para abrir tu inventario:");
        sc.nextLine();
    }
    public static void enterDadoAtaque(){
        System.out.println("Pulsa ENTER para lanzar el dado de ataque:");
        sc.nextLine();
    }
    public static void enterDadoDialogo(){
        System.out.println("Pulsa ENTER para lanzar el dado de diálogo:");
        sc.nextLine();
    }
}
