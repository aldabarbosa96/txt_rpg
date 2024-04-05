package playerInteractions;

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
    public void imprimirDado(int valor) {
        switch (valor) {
            case 1:
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   o   |");
                System.out.println("|       |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 1");
                break;
            case 2:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|       |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 2");
                break;
            case 3:
                System.out.println("+-------+");
                System.out.println("| o     |");
                System.out.println("|   o   |");
                System.out.println("|     o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 3");
                break;
            case 4:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|       |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 4");
                break;
            case 5:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("|   o   |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 5");
                break;
            case 6:
                System.out.println("+-------+");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("| o   o |");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 6");
                break;
            case 7:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 7");
                break;
            case 8:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 8");
                break;
            case 9:
                System.out.println("+-----+");
                System.out.println(" # # # ");
                System.out.println(" #   # ");
                System.out.println(" # # # ");
                System.out.println("     # ");
                System.out.println("     # ");
                System.out.println("+-----+");
                System.out.println("\nResultado ataque: 9");
                break;
            case 10:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #  #   #");
                System.out.println(" #  #   #");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 10");
                break;
            case 11:
                System.out.println("+-------+");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println(" #    #  ");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 11");
                break;
            case 12:
                System.out.println("+-------+");
                System.out.println(" #  # # #");
                System.out.println(" #      #");
                System.out.println(" #  # # #");
                System.out.println(" #  #    ");
                System.out.println(" #  # # #");
                System.out.println("+-------+");
                System.out.println("\nResultado ataque: 12");
                break;
            default:
                System.out.println("Valor fuera de rango.");
                break;
        }
    }
}
