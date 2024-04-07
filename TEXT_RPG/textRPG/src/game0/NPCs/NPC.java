package game0.NPCs;

import game0.GameStoryTeller;
import game0.player.PlayerOptions;

import java.util.Scanner;

public class NPC {
    protected String name;

    protected static int respuestaNum0 = 0;

    public int getRespuestaNum0() {
        return respuestaNum0;
    }

    public NPC(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public NPC(){}
    public static void interactuarNPC00(Scanner sc) {
        GameStoryTeller.narrar(4,null); sc.nextLine();
        System.out.println("Guardia de las arenas: ¡ALTO MARICONNN!");
        System.out.println("Narrador: A pesar de lo que parece, no, no nos está dando el alto...");
        System.out.println("Guardia de las arenas: Enséñame tus enseres o muere sucia puerca.");
    }
    public void interactuarNPC01(String respuesta) {
        while (respuestaNum0 <= 3) {
            if (respuesta.equalsIgnoreCase("a")) {
                respuestaNum0 = 0;
                System.out.println("Guardia de las arenas: Me cago en todos tus santísimos cojones pedazo de basura.");
                GameStoryTeller.narrar(5,null);
                System.out.println("Guardia de las arenas: Sucio bastardo, arrodíllate ahora mismo y lame mis botas para conservar la cabeza " +
                        "encima de los hombros.");
                break;
            } else if (respuesta.equalsIgnoreCase("b")) {
                respuestaNum0 = 1;
                GameStoryTeller.narrar(6,null);
                break;
            } else if (respuesta.equalsIgnoreCase("c")) {
                respuestaNum0 = 2;
                System.out.println("Guardia de las arenas: Veamos...");
                GameStoryTeller.narrar(7,null);
                break;
            } else {
                respuestaNum0 = 3;
            }
        }
    }
    public static void interactuarNPC02() {
        while (respuestaNum0 <= 3) {
            if (respuestaNum0 == 0) {
                PlayerOptions.opcion(1);
                break;
            } else if (respuestaNum0 == 1) {
                PlayerOptions.opcion(2);
                break;
            } else if (respuestaNum0 == 2) {
                PlayerOptions.opcion(3);
                break;
            } else System.out.println("Esta opción no existe lumbreras.");
        }
    }
    public void interactuarNPC03(){

        }
    }