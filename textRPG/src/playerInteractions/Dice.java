package playerInteractions;

import game0.NPCs.Enemy;
import game0.player.Player;

import java.util.Random;

public class Dice {
    private  int caras;
    private Random random;
    public Dice(int caras){
        this.caras = caras;
        this.random = new Random();
    }
    public int lanzar(){
        return random.nextInt(caras) + 1;
    }
    public void imprimirDadoAtaquePlayer(int valor, Player player) {
        switch (valor) {
            case 1:
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   o   |");
                System.out.println("|       |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 1 + ("+ player.getAttack()+")");
                break;
            case 2:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|       |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 2 + ("+ player.getAttack()+")");
                break;
            case 3:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|   o   |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 3 + ("+ player.getAttack()+")");
                break;
            case 4:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|       |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 4 + ("+ player.getAttack()+")");
                break;
            case 5:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|   o   |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 5 + ("+ player.getAttack()+")");
                break;
            case 6:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 6 + ("+ player.getAttack()+")");
                break;
            case 7:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 7 + ("+ player.getAttack()+")");
                break;
            case 8:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 8 + ("+ player.getAttack()+")");
                break;
            case 9:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 9 + ("+ player.getAttack()+")");
                break;
            case 10:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #  #   #");
                System.out.println(" #  #   #");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 10 + ("+ player.getAttack()+")");
                break;
            case 11:
                System.out.println("+-------+");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 11 + ("+ player.getAttack()+")");
                break;
            case 12:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #      #");
                System.out.println(" #  # # #");
                System.out.println(" #  #    ");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\n>>>GOLPE CRÍTICO<<<\n");
                System.out.println("\nResultado ataque: 12 + ("+ player.getAttack()+")");
                break;
            default:
                System.out.println("Esto es imposible LOLAZO");
                break;
        }
    }

    public void imprimirDadoAtaqueEnemy(int valor, Enemy enemy) {
        switch (valor) {
            case 1:
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   o   |");
                System.out.println("|       |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 1 + ("+ enemy.getAttackPoints()+")");
                break;
            case 2:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|       |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 2 + ("+ enemy.getAttackPoints()+")");
                break;
            case 3:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|   o   |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 3 + ("+ enemy.getAttackPoints()+")");
                break;
            case 4:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|       |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 4 + ("+ enemy.getAttackPoints()+")");
                break;
            case 5:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|   o   |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 5 + ("+ enemy.getAttackPoints()+")");
                break;
            case 6:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 6 + ("+ enemy.getAttackPoints()+")");
                break;
            case 7:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 7 + ("+ enemy.getAttackPoints()+")");
                break;
            case 8:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 8 + ("+ enemy.getAttackPoints()+")");
                break;
            case 9:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 9 + ("+ enemy.getAttackPoints()+")");
                break;
            case 10:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #  #   #");
                System.out.println(" #  #   #");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 10 + ("+ enemy.getAttackPoints()+")");
                break;
            case 11:
                System.out.println("+-------+");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 11 + ("+ enemy.getAttackPoints()+")");
                break;
            case 12:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #      #");
                System.out.println(" #  # # #");
                System.out.println(" #  #    ");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\n>>>GOLPE CRÍTICO<<<\n");
                System.out.println("\nResultado ataque: 12 + ("+ enemy.getAttackPoints()+")");
                break;
            default:
                System.out.println("Esto es imposible LOLAZO");
                break;
        }
    }
}
