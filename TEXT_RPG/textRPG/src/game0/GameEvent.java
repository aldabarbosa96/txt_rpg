package game0;

import game0.player.Player;
import game0.player.PlayerStatus;

import java.util.Scanner;

public class GameEvent {
    public static void tutorialEvent(Scanner sc,Player player){
        boolean esTonto = true;
        while (esTonto) {
            System.out.println("--------------------TUTORIAL--------------------");
            sc.nextLine();
            System.out.println("Narrador: Igual te pensabas que iba a ser otra cosa, pero la verdad es que soy yo de nuevo dándote la turra\n" +
                    "porque eres t-o-n-t-i-t-@ y no puedes hacerte a la idea de como funciona un combate en un juego tan simple como este...");
            sc.nextLine();
            System.out.println("Player: " + Player.getName() + "\nLifePoints: " + player.getHp() + "\nEnergy: " + player.getEnergy());
            System.out.println("\nEsto representa tus estadísticas básicas: Player: " + Player.getName() + " --> ERES TÚ ... Por si no te habías percatado.\n" +
                    "LifePoints: " + player.getHp() + " --> por si no sabes una mierda de inglés, representa tus PUNTOS de VIDA.\n" +
                    "Energy: " + player.getEnergy() + " --> esto representa tu energía para realizar cualquier acción de combate; se gastará 1 punto por cada acción que realices, por ahora.");
            sc.nextLine();
            System.out.println("El sistema de combate es muy simple: lanzas los dados de ataque y haces daño respecto a la diferencia del resultado de tu tirada y la vida de tu oponente.\n" +
                    "En cristiano: si el guacho tiene 10 LifePoints y tu tirada es 12 le quitas 2. En cambio, si tu tirada es de 8 se te quitarán esos 2 LifePoints a ti.\n" +
                    "Esto se aplica igual a todo el mundo, por ahora.");
            sc.nextLine();
            System.out.println("Alguna duda más >>" + Player.getName() + "<<?\n");

            PlayerStatus.opcion(5);

            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")) {
                esTonto = false;
                System.out.println("Narrador Enfadado: CASO 1:" +
                        "                   VIDA ENEMIGO = 10\n" +
                        "                   TU TIRADA = 12\n" +
                        "                   VIDA ENEMIGO = 8\n\n"+
                        "                   CASO 2:" +
                        "                   VIDA ENEMIGO = 10\n"+
                        "                   TU TIRADA = 7\n" +
                        "                   TU VIDA = (se le resta a tu vida la diferencia de tu tirada y la vida del enemigo, es decir, -3 para ti :)");
            } else if (respuesta.equalsIgnoreCase("b")) {
                esTonto = false;
                System.out.println("Narrador: No, la hostia no eres porque si lo fueras no tendría que haber hecho la explicación, lumbreras.");
            } else if (respuesta.equalsIgnoreCase("c")){
                System.out.println("Narrador: no te quito la razón... CIAO PERRA!\n" +
                        "--------------------GAME OVER--------------------");
            } //seguir por aquí
        }
    }
}
