package game0;

import game0.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStoryTeller { //NARRADOR
    public static void narrar(int index, Player player){
        String narraciones = narracion.get(index);
        if (player != null) {
            narraciones = narraciones.replace("{PlayerName}",player.getName());
        }
        System.out.println(narraciones);
    }
    public static List<String> narracion = new ArrayList<>();

    static {
        /*0*/narracion.add("-----------------------------------------------------------------------------\nNarrador: Bienvenid@ a la aventura de tu vida compai; ¿Estás list@ para ponerte de metadona y desnudarte?\n\n¡EMPECEMOS PUES!\n\nPrimero de todo, dime tu nombre, así podremos comenzar\nNombre y apellido: ");
        /*1*/narracion.add("Narrador: Mmm con que >>{PlayerName}<< ... Menuda mierda de nombre pero si es el que te ha tocado...\nTe daré 10 puntos de salud para que no te mueras, por ahora, y unos 5 de energía para tus ataques (la fuerza es la que tienes sorry).");
        /*2*/narracion.add("Presiona ENTER para empezar tu aventurita :)");
        /*3*/narracion.add("-----------------------------------------------------------------------------\n<Narrador> : Has aparecido en un mitad del desierto, >>{PlayerName}<<.\nPor suerte para ti estás también en el centro de un oasis con un mercado y multitud de personas.");
        /*4*/narracion.add("Narrador: Se te acerca un guardia de las arenas:");
        /*5*/narracion.add("Narrador: El guardia se pone en guardia (valga la redundancia) y se dispone a pelear, pero antes te da una última oportunidad para redimirte.");
        /*6*/narracion.add("Narrador: El guardia cae redondo al suelo y se desnuca con una botella rota que había por ahí.");
        /*7*/narracion.add("Narrador: El guardia comprueba que no llevas nada raro. Bueno realmente no llevas NADA.");
        /*8*/narracion.add("Narrador: >>{PlayerName}<< ha obtenido ¡EL DADO!");
        /*9*/narracion.add("Narrador: Este DAAADO sirve para que el jodido videojuego sea puro azar; es decir, cuando tengas un combate, un diálogo, o cualquier interacción con el mundo\nes posible que se te obligue a decidir tu suerte tirando LOS dados (efectivamente, tienes más de uno) para que jamás sepas tu destino.\nMe sigues >>Caradeculo<< ? Digo >>{PlayerName}<< ?");
        /*10*/narracion.add("Narrador: Te mostraré tu inventario para que vayas viendo el espacio que tienes y \"tus items\"\n");
        /*11*/narracion.add("PD: por haber sido bueno y pacífico además del \"DADO\" has obtenido un roñoso pero comestible \"trozo de pan.\"");
        /*12*/narracion.add("Como habrás visto ya dispones de un DADO (en realidad son 2) en tu inventario.");
        /*13*/narracion.add("¡Vamos a probar ese DADO! Primero que sepas que es un DADO algo mágico; puede tener 6 ó 12 caras.");
        /*14*/narracion.add("El DADO de 6 caras es para los diálogos. Ya verás su funcionamiento más adelante... Por ahora centrémonos en el DADO de ataque (el de 12 caras) y simulemos un ataque.\nTú contra mí: ¡El pringao de >>{PlayerName}<< contra el maravilloso, el magnífico, el omnipotente y omnipresente NARRADOOORRRRRR!");
        /*15*/narracion.add("Bien, ahora que ya has visto el \"complejo\" sistema de lanzamiento de dados, quieres que te parta la boca ya o prefieres el t-u-t-o-r-i-a-l para t-o-n-t-i-t-@-s ?");
        /*16*/narracion.add("Narrador del Narrador: El Narrador se enfada.");
        /*17*/narracion.add("Narrador: Se han acabado ya las mamarrachadas, a partirse la boca YA:");
        /*18*/narracion.add("Narrador: El guardia se saca un trozo de pan del ano y se lo entrega al jugador; también le regala un dado raro.");
    }
}
