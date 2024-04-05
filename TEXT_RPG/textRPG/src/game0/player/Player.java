package game0.player;

import game0.NPCs.NPC;

import java.util.Scanner;
public class Player {
    private static String name;
    private int hp = 10;
    private int energy = 5;
    private boolean resPaz;

    public boolean ResPaz() {
        return resPaz;
    }

    public Player() {
    }
    public static String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void marcarPaz(){
        this.resPaz = true;
    }

    public String opcionEscogida0(Scanner sc) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            PlayerStatus.opcion(0);
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")) {
                System.out.println(this.getName() + ": Aquí al único que le huele la boca a polla es a ti hermanito.");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                System.out.println(this.getName() + ": Procede a violentarle la mandíbula con los nudillos en un gesto rápido y efectivo.");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                System.out.println(this.getName() + ": Procede a enseñar su bolsa.");
                respuestaValida = true;
                marcarPaz();
            } else {
                System.out.println("Narrador: Prueba de nuevo lumbreras.");
            }
        }
        return respuesta;
    }

    public String opcionEscogida01(Scanner sc) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")) {
                System.out.println("Guardia de las arenas: Así me gusta siervo bastardo. ¡Ten! Te otorgo esta basurilla como obsequio por ser un buen sirviente.");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                System.out.println("Guardia de las arenas: ¡MUERE!");
                respuestaValida = true;
                System.out.println("Narrador: El Guardia de las Arenas golpea a "+this.getName()+" con su maza de tungsteno y lo mata ipsofacto\n--------------------GAME OVER--------------------");
                System.exit(0);
            } else {
                System.out.println("Narrador: Prueba de nuevo lumbreras.");
            }
        }
        return respuesta;
    }

    public String opcionEscogida02(Scanner sc) {
        String respuesta = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("a")){
                System.out.println(this.getName()+": ¡Coño! ¡¿Solo tiene una mierda de dado?!");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                System.out.println("Narrador: "+ this.getName() + " sale corriendo y tropieza con la sangre del guardia\nCon la cabeza en el frío suelo se percata de un objeto pequeño e insignificante (EL PUTO DADO).");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                System.out.println("Narrador: Saltan derechos de copyright y se cierra el juego por denuncias de derechos de autor.\n--------------------GAME OVER--------------------");
                System.exit(0);
            } else {
                System.out.println("Narrador: Prueba de nuevo lumbreras.");
            }
        }
        return respuesta;
    }
    public void opcionEscogida03(Scanner sc){
        Inventory.addToInventory("\"trozo de pan\"");
        System.out.println("Guardia de las arenas: Ten anda, que me da lástima que no tengas ni un trsite trozo de pan.");
    }
    public void escogerOpcion(Scanner sc, NPC npc){
        int respuestaNum0 = npc.getRespuestaNum0();

        switch (respuestaNum0){
            case 0:
                opcionEscogida01(sc);
                break;
            case 1:
                opcionEscogida02(sc);
                break;
            case 2:
                opcionEscogida03(sc);
                break;
        }
    }
    public void opcionEscogida04(Scanner sc){
        PlayerStatus.opcion(4);
        String respuesta ="";
        boolean respuestaValida = false;

        while (!respuestaValida){
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("a")){
                System.out.println("Narrador: Ya suponía.. Con ese nombre y ese careto que me llevas.\nEstá bien, te haré el t-u-t-o-r-i-a-l.");
                sc.nextLine();
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("b")) {
                System.out.println("Narrador: Así me gusta, dispuesto a todo (a sufrir, concretamente).");
                sc.nextLine();
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("c")) {
                System.out.println("Narrador: Eres gilipollas, digo nos vemos >>"+Player.getName()+"<<.\n--------------------GAME OVER--------------------");
                sc.nextLine();
                respuestaValida = true;
            }
            else System.out.println("Narrador: Prueba de nuevo lumbreras.");
        }
    }
}

