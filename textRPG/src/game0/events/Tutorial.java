package game0.events;

import game0.GameStoryTeller;
import game0.NPCs.Enemy;
import game0.console.ConsolePresentation;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import game0.player.PlayerOptions;
import game0.player.PlayerStatistics;
import playerInteractions.Dice;

import java.util.Scanner;

public class Tutorial {

    public static void tutorialEvent(ConsolePresentation cp,UserInteraction ui, Player player, Enemy enemy, Combat combat, PlayerStatistics ps, Dice dice) { //TUTORIAL
        ui.showMessage("--------------------TUTORIAL--------------------");
        ui.pauseForUserInput();
        ui.showMessage("Narrador: Igual te pensabas que iba a ser otra cosa, pero la verdad es que soy yo de nuevo dándote la turra\n" +
                "porque eres t-o-n-t-i-t-@ y no puedes hacerte a la idea de como funciona un combate en un juego tan simple como este...");
        ui.pauseForUserInput();
        ui.showMessage("Jugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack()+"\nDefensa: "+player.getDeffense());
        ui.showMessage("\nEsto representa tus estadísticas básicas: Player: " + player.getName() + " --> ERES TÚ ... Por si no te habías percatado.\n\n" +
                "Vida: " + player.getHp() + " --> esto representa tus life points, tu vida, tu alma, tu salud.\n\n" +
                "Energía: " + player.getEnergy() + " --> esto representa tu energía para realizar cualquier acción de combate; se gastará 1 punto por cada acción que realices, por ahora.\n\n" +
                "Fuerza: " + player.getAttack() + " --> esto representa tu poder de ataque, que se sumará a tu tirada de dados para sumar el daño total del golpe.\n\n" +
                "Defensa: "+player.getDeffense()+ " --> esto representa tu \"armadura\", para resistir el ataque del enemigo.");
        ui.pauseForUserInput();
        ui.showMessage("El sistema de combate es muy simple: lanzas los dados de ataque, sumas tu fuerza al resultado y a eso le restas la defensa del enemigo; ese será el daño total que ejerzas.\n" +
                "En cristiano: si el guacho tiene 10 de defensa y tu tirada es 12(+1 de tu fuerza) = 13 --> le quitas 3 puntos de vida. En cambio, si tu tirada es de 8 perderías TÚ 1  punto de vida.\n" +
                "Esto se aplica igual a todo el mundo, por ahora.");
        ui.pauseForUserInput();
        ui.showMessage("Alguna duda más >>" + player.getName() + "<<?\n"); ui.getInput();

        PlayerOptions.opcion(5,player);
        boolean esTonto = false;

        while (!esTonto) {
            String respuesta = ui.getInput();
            if (respuesta.equalsIgnoreCase("a")) {
                GameStoryTeller.narrar(16, null);
                ui.pauseForUserInput();
                ui.showMessage("Narrador Enfadado: CASO 1:" +
                        " VIDA ENEMIGO = 10\n" +
                        "                           DEFENSA ENEMIGO: 5\n"+
                        "                           TU TIRADA = 12(+1)\n" +
                        "                           DAÑO = 3\n" +
                        "                           VIDA ENEMIGO = 7\n\n"); ui.pauseForUserInput();
                ui.showMessage("                   CASO 2:" +
                        " DEFENSA ENEMIGO = 10\n" +
                        "                           TU VIDA = 10\n" +
                        "                           TU TIRADA = 7(+1)\n" +
                        "                           DAÑO = -2\n" +
                        "                           TU VIDA = 8");
                ui.pauseForUserInput();
                ui.showMessage("¿¿¿¡¡¡TE HA QUEDADO YA CLARO PEDAZO DE ...  <<" + player.getName() + ">> !!!???\nNarrador del Narrador: La pregunta era retórica, pues el combate iba a comenzar.");
                esTonto = true;

            } else if (respuesta.equalsIgnoreCase("b")) {
                esTonto = true;
                System.out.println("Narrador: No, la hostia no eres porque si lo fueras no tendría que haber hecho la explicación, lumbreras.");
                combat.combatFlow(cp,player,enemy,ui,ps,dice);
            } else if (respuesta.equalsIgnoreCase("c")) {
                System.out.println("Narrador: Capullo tu padre. Te vas a enterar <<" + player.getName() + ">>");
                esTonto = true;
            } else {
                GameStoryTeller.narrar(26, null);

            }
        }
        ui.pauseForUserInput();
        combat.combatFlow(cp,player,enemy,ui,ps,dice);
    }

    public static void tutorialEvent01(UserInteraction ui, Player player) { //TUTORIAL2
        ui.showMessage("--------------------TUTORIAL--------------------");
        ui.pauseForUserInput();
        ui.showMessage("Narrador: Me cansas <<"+player.getName()+">>, deja de pedir el tutorial de un juego tan simple, mendrug@.\n\nToma a ver si te queda claro YA:");
        ui.pauseForUserInput();
        ui.showMessage("Jugador: " + player.getName() + "\nVida: " + player.getHp() + "\nEnergía: " + player.getEnergy() + "\nFuerza: " + player.getAttack()+"\nDefensa: "+player.getDeffense());
        ui.showMessage("\nEsto representa tus estadísticas básicas: Player: " + player.getName() + " --> ERES TÚ ... Por si no te habías percatado.\n\n" +
                "Vida: " + player.getHp() + " --> esto es lo que me falta a mí... Digo, esto representa tus life points, tu vida, tu alma, tu salud.\n\n" +
                "Energía: " + player.getEnergy() + " --> esto representa tu energía para realizar cualquier acción de combate; se gastará 1 punto por cada acción que realices, por ahora.\n\n" +
                "Fuerza: " + player.getAttack() + " --> esto representa tu poder de ataque, que se sumará a tu tirada de dados para sumar el daño total del golpe.\n\n" +
                "Defensa: "+player.getDeffense()+ " --> esto representa tu \"armadura\", si el atacante hace 5 de daño y tu defensa es de 1, el daño total es 4.");
        ui.pauseForUserInput();
        ui.showMessage("El sistema de combate es muy simple: lanzas los dados de ataque, sumas tu fuerza al resultado y a eso le restas la defensa del enemigo; ese será el daño total que ejerzas.\n" +
                "En cristiano: si el guacho tiene 10 de defensa y tu tirada es 12(+1 de tu fuerza) = 13 --> le quitas 3 puntos de vida. En cambio, si tu tirada es de 8 perderías TÚ 1  punto de vida.\n" +
                "Esto se aplica igual a todo el mundo, por ahora.");
        ui.pauseForUserInput();
    }
}
