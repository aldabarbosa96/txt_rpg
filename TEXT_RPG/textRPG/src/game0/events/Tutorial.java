package game0.events;

import game0.GameStoryTeller;
import game0.player.Player;
import game0.player.PlayerOptions;

import java.util.Scanner;

public class Tutorial {

    public static void tutorialEvent(Scanner sc, Player player) { //TUTORIAL
            System.out.println("--------------------TUTORIAL--------------------"); sc.nextLine();
            System.out.println("Narrador: Igual te pensabas que iba a ser otra cosa, pero la verdad es que soy yo de nuevo dándote la turra\n" +
                    "porque eres t-o-n-t-i-t-@ y no puedes hacerte a la idea de como funciona un combate en un juego tan simple como este...");
            sc.nextLine();
            System.out.println("Jugador: " + Player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy()+"\nFuerza: "+player.getAttack());
            System.out.println("\nEsto representa tus estadísticas básicas: Player: " + Player.getName() + " --> ERES TÚ ... Por si no te habías percatado.\n\n" +
                    "Vida: " + player.getHp() + " --> esto es lo que me falta a mí... Digo, esto representa tus life points, tu vida, tu alma, tu salud.\n\n" +
                    "Energía: " + player.getEnergy() + " --> esto representa tu energía para realizar cualquier acción de combate; se gastará 1 punto por cada acción que realices, por ahora.\n\n" +
                    "Fuerza: "+player.getAttack()+" --> esto representa tu poder de ataque, que se sumará a tu tirada de dados para sumar el daño total del golpe.");
            sc.nextLine();
            System.out.println("El sistema de combate es muy simple: lanzas los dados de ataque y haces daño respecto a la diferencia del resultado de tu tirada y la vida de tu oponente.\n" +
                    "En cristiano: si el guacho tiene 10 LifePoints y tu tirada es 12(+1 de tu fuerza) = 13 --> le quitas 3 puntos de vida. En cambio, si tu tirada es de 8 perderías 1 punto de vida.\n" +
                    "Esto se aplica igual a todo el mundo, por ahora.");
            sc.nextLine();
            System.out.println("Alguna duda más >>" + Player.getName() + "<<?\n");



            PlayerOptions.opcion(5);
            boolean esTonto = false;

            while (!esTonto) {
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("a")) {
                GameStoryTeller.narrar(16, null);
                sc.nextLine();
                System.out.println("Narrador Enfadado: CASO 1:" +
                        " VIDA ENEMIGO = 10\n" +
                        "                           TU TIRADA = 12(+1)\n" +
                        "                           DAÑO = 3\n"+
                        "                           VIDA ENEMIGO = 7\n\n" +
                        "                   CASO 2:" +
                        " VIDA ENEMIGO = 10\n" +
                        "                           TU VIDA = 10\n"+
                        "                           TU TIRADA = 7(+1)\n" +
                        "                           DAÑO = -2\n"+
                        "                           TU VIDA = 8");
                sc.nextLine();
                System.out.println("¿¿¿¡¡¡TE HA QUEDADO YA CLARO PEDAZO DE ...  >>" + Player.getName() + "<< !!!???\nNarrador del Narrador: La pregunta era retórica, pues el combate iba a comenzar.");
                esTonto = true;

            } else if (respuesta.equalsIgnoreCase("b")) {
                esTonto = true;
                System.out.println("Narrador: No, la hostia no eres porque si lo fueras no tendría que haber hecho la explicación, lumbreras.");
            } else if (respuesta.equalsIgnoreCase("c")) {
                System.out.println("Narrador: Capullo tu padre. Te vas a enterar >>"+Player.getName()+"<<") ;
                esTonto = true;
            } else {
                System.out.println("Narrador: Prueba de nuevo lumbreras.");
            }
        }
    }
}
