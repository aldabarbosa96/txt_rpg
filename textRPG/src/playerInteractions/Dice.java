package playerInteractions;

import game0.NPCs.Enemy;
import game0.interfaces.UserInteraction;
import game0.player.Player;
import window.GuiInteraction;

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
    public void imprimirDadoAtaquePlayer(int valor, Player player, GuiInteraction gi) {
        switch (valor) {
            case 1:
                gi.showMessage("+-------+");
                gi.showMessage("|          |");
                gi.showMessage("|    o    |");
                gi.showMessage("|          |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 1 + ("+ player.getAttack()+")");
                break;
            case 2:
                gi.showMessage("+-------+");
                gi.showMessage("| o       |");
                gi.showMessage("|          |");
                gi.showMessage("|       o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 2 + ("+ player.getAttack()+")");
                break;
            case 3:
                gi.showMessage("+-------+");
                gi.showMessage("|  o     |");
                gi.showMessage("|    o   |");
                gi.showMessage("|      o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 3 + ("+ player.getAttack()+")");
                break;
            case 4:
                gi.showMessage("+-------+");
                gi.showMessage("| o   o |");
                gi.showMessage("|         |");
                gi.showMessage("| o   o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 4 + ("+ player.getAttack()+")");
                break;
            case 5:
                gi.showMessage("+-------+");
                gi.showMessage("| o    o |");
                gi.showMessage("|    o    |");
                gi.showMessage("| o    o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 5 + ("+ player.getAttack()+")");
                break;
            case 6:
                gi.showMessage("+-------+");
                gi.showMessage("| o    o |");
                gi.showMessage("| o    o |");
                gi.showMessage("| o    o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 6 + ("+ player.getAttack()+")");
                break;
            case 7:
                gi.showMessage("+-----+");
                gi.showMessage(" # # # #");
                gi.showMessage("       # ");
                gi.showMessage("       # ");
                gi.showMessage("       # ");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 7 + ("+ player.getAttack()+")");
                break;
            case 8:
                gi.showMessage("+-----+");
                gi.showMessage(" # # # #");
                gi.showMessage(" #       #");
                gi.showMessage(" # # # #");
                gi.showMessage(" #       #");
                gi.showMessage(" # # # # ");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 8 + ("+ player.getAttack()+")");
                break;
            case 9:
                gi.showMessage("+-----+");
                gi.showMessage(" # # #  ");
                gi.showMessage(" #     #");
                gi.showMessage(" # # #  ");
                gi.showMessage("       #");
                gi.showMessage("       #");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 9 + ("+ player.getAttack()+")");
                break;
            case 10:
                gi.showMessage("+-------+");
                gi.showMessage(" #  # # #");
                gi.showMessage(" # #     #");
                gi.showMessage(" # #     #");
                gi.showMessage(" #  # # #");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 10 + ("+ player.getAttack()+")");
                break;
            case 11:
                gi.showMessage("+-------+");
                gi.showMessage(" #      #");
                gi.showMessage(" #      #");
                gi.showMessage(" #      #");
                gi.showMessage(" #      #");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 11 + ("+ player.getAttack()+")");
                break;
            case 12:
                gi.showMessage("+-------+");
                gi.showMessage(" #   # # #");
                gi.showMessage(" #         #");
                gi.showMessage(" #   # # #");
                gi.showMessage(" #   #    ");
                gi.showMessage(" #   # # #");
                gi.showMessage("+-------+");
                gi.showMessage("\n>>>GOLPE CRÍTICO<<<\n");
                gi.showMessage("\nResultado ataque: 12 + ("+ player.getAttack()+")");
                break;
            default:
                gi.showMessage("Esto es imposible LOLAZO");
                break;
        }
    }


    public void imprimirDadoAtaqueEnemy(int valor, Enemy enemy, GuiInteraction gi) {
        switch (valor) {
            case 1:
                gi.showMessage("+-------+");
                gi.showMessage("|          |");
                gi.showMessage("|    o    |");
                gi.showMessage("|          |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 1 + (" + enemy.getAttackPoints() + ")");
                break;
            case 2:
                gi.showMessage("+-------+");
                gi.showMessage("| o       |");
                gi.showMessage("|          |");
                gi.showMessage("|      o  |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 2 + (" + enemy.getAttackPoints() + ")");
                break;
            case 3:
                gi.showMessage("+-------+");
                gi.showMessage("| o      |");
                gi.showMessage("|   o    |");
                gi.showMessage("|      o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 3 + (" + enemy.getAttackPoints() + ")");
                break;
            case 4:
                gi.showMessage("+-------+");
                gi.showMessage("| o    o |");
                gi.showMessage("|          |");
                gi.showMessage("| o    o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 4 + (" + enemy.getAttackPoints() + ")");
                break;
            case 5:
                gi.showMessage("+-------+");
                gi.showMessage("| o    o |");
                gi.showMessage("|    o    |");
                gi.showMessage("| o    o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 5 + (" + enemy.getAttackPoints() + ")");
                break;
            case 6:
                gi.showMessage("+-------+");
                gi.showMessage("| o   o |");
                gi.showMessage("| o   o |");
                gi.showMessage("| o   o |");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 6 + (" + enemy.getAttackPoints() + ")");
                break;
            case 7:
                gi.showMessage("+-----+");
                gi.showMessage(" # # # #");
                gi.showMessage("       # ");
                gi.showMessage("       # ");
                gi.showMessage("       # ");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 7 + (" + enemy.getAttackPoints() + ")");
                break;
            case 8:
                gi.showMessage("+-----+");
                gi.showMessage(" # # # #");
                gi.showMessage("#       #");
                gi.showMessage(" # # # #");
                gi.showMessage("#       #");
                gi.showMessage(" # # # # ");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 8 + (" + enemy.getAttackPoints() + ")");
                break;
            case 9:
                gi.showMessage("+-----+");
                gi.showMessage(" # # # #");
                gi.showMessage(" #     #");
                gi.showMessage(" # # # #");
                gi.showMessage("       #");
                gi.showMessage("       #");
                gi.showMessage("+-----+");
                gi.showMessage("\nResultado ataque: 9 + (" + enemy.getAttackPoints() + ")");
                break;
            case 10:
                gi.showMessage("+-------+");
                gi.showMessage(" #  # # #");
                gi.showMessage(" # #     #");
                gi.showMessage(" # #     #");
                gi.showMessage(" #  # # #");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 10 + (" + enemy.getAttackPoints() + ")");
                break;
            case 11:
                gi.showMessage("+-------+");
                gi.showMessage(" #     #");
                gi.showMessage(" #     #");
                gi.showMessage(" #     #");
                gi.showMessage(" #     #");
                gi.showMessage("+-------+");
                gi.showMessage("\nResultado ataque: 11 + (" + enemy.getAttackPoints() + ")");
                break;
            case 12:
                gi.showMessage("+-------+");
                gi.showMessage(" #  # # #");
                gi.showMessage(" #        #");
                gi.showMessage(" #  # # #");
                gi.showMessage(" #  #    ");
                gi.showMessage(" #  # # #");
                gi.showMessage("+-------+");
                gi.showMessage("\n>>>GOLPE CRÍTICO<<<\n");
                gi.showMessage("\nResultado ataque: 12 + (" + enemy.getAttackPoints() + ")");
                break;
            default:
                gi.showMessage("Esto es imposible LOLAZO");
                break;
        }
    }
}
