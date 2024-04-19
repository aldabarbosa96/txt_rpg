package game0.game.narrative;

import game0.player.Player;
import window.GuiInteraction;
import java.util.ArrayList;
import java.util.List;

public class GameStoryTeller {
    private static GuiInteraction gi;

    public static void setUserInteraction(GuiInteraction guiInteraction) {
        gi = guiInteraction;
    }

    public static void narrar(int index, Player player) {
        String narraciones = narracion.get(index);
        if (player != null) {
            narraciones = narraciones.replace("{PlayerName}", player.getName());
        }
        gi.showMessage(narraciones);
    }

    public static List<String> narracion = new ArrayList<>();

    static {
        /*0*/narracion.add("---------------------------------------------------\n");
        /*1*/narracion.add("Narrador: Mmm con que <<{PlayerName}>> ... Menuda mierda de nombre pero si es el que te ha tocado...");
        /*2*/narracion.add("Presiona \"Continuar\" para empezar tu aventurita :)");
        /*3*/narracion.add("\nNarrador : Has aparecido en un mitad del desierto, <<{PlayerName}>> .\nPor suerte para ti estás también en el centro de un oasis con un mercado y multitud de personas.");
        /*4*/narracion.add("Narrador: Se te acerca un guardia de las arenas:");
        /*5*/narracion.add("Narrador: El guardia se pone en guardia (valga la redundancia) y se dispone a pelear, pero antes te da una última oportunidad para redimirte.");
        /*6*/narracion.add("Narrador: El guardia cae redondo al suelo y se desnuca con una botella rota que había por ahí.");
        /*7*/narracion.add("Narrador: El guardia comprueba que no llevas nada raro. Bueno realmente no llevas NADA.");
        /*8*/narracion.add("\nNarrador: <<{PlayerName}>> ha obtenido ¡EL DADO!");
        /*9*/narracion.add("Narrador: Este DAAADO sirve para que el jodido videojuego sea puro azar; cuando tengas un combate, un diálogo, etc.\nEs posible que se te obligue a decidir tu suerte tirando LOS dados (efectivamente, tienes más de uno) para que jamás sepas tu destino.\nMe sigues <<Caradeculo>> ? Digo <<{PlayerName}>> ?");
        /*10*/narracion.add("Narrador: Te mostraré tu inventario para que vayas viendo el espacio que tienes y \"tus items\"\n");
        /*11*/narracion.add("PD: por haber sido bueno y pacífico además del \"DADO\" has obtenido un roñoso pero comestible \"trozo de pan.\"");
        /*12*/narracion.add("Narrador: Como habrás visto ya dispones de un DADO en tu inventario.");
        /*13*/narracion.add("Narrador: ¡Vamos a probar ese DADO! Primero que sepas que es un DADO algo mágico; puede tener diversas caras.");
        /*14*/narracion.add("Narrador: Hay una amplia variedad de DADOS por descubrir... Ahora, centrémonos en el DADO de ataque y simulemos un ataque.");
        /*15*/narracion.add("Narrador: Bien, ahora que ya has visto el \"complejo\" sistema de lanzamiento de dados, quieres que te parta la boca ya o prefieres \n\nel T-U-T-O-R-I-A-L para T-O-N-T-I-T-O-S ?");
        /*16*/narracion.add("Narrador del Narrador: El Narrador se enfada.");
        /*17*/narracion.add("Narrador: Se han acabado ya las mamarrachadas, a partirse la boca YA:");
        /*18*/narracion.add("Narrador: El guardia se saca un trozo de pan del ano y se lo entrega al jugador; también le regala un dado raro.");
        /*19*/narracion.add("Narrador: ¡Enhorabuena <<{PlayerName}>>! Aunque para tu información me he dejado ganar, para que puedas proseguir tu aventurita.\nMenudo coñazo sería el GAME OVER contra el Narrador...\n");
        /*20*/narracion.add("Narrador del Narrador: En realidad no se había dejado, solo era un paco.");
        /*21*/narracion.add("Narrador: Hay que ser pringao para perder contra mí JA JA JA...\n");
        /*22*/narracion.add("Narrador: Llegados a este punto, si te ves preparad@ para emprender tu viaje <<{PlayerName}>> tengo algo para ti.\n");
        /*23*/narracion.add("Narrador: Por el contrario, si prefieres practicar un poco más con el combate, ver el T-U-T-O-R-I-A-L o prefieres abandonar aquí, ahora es el momento:");
        /*24*/narracion.add("Narrador: Lo vas a flipar <<{PlayerName}>>\n\n¡QUE EMPIECE EL JUEGO!\n---------------------------------------------------\n");
        /*25*/narracion.add("Narrador: Estás en el centro del oasis \"Centro\", un peculiar, maravilloso y peligroso lugar en el corazón del desierto del \"Santako\".");
        /*26*/narracion.add("Narrador: Prueba de nuevo, lumbreras.");
        /*27*/narracion.add("Narrador: La santa puta virgen del señor...");
        /*28*/narracion.add("Narrador: Era la mejor opción de todas.");
        /*29*/narracion.add("Introduzca nombre del Jugador:"); //esto debería ir en GameVoiceOver
        /*30*/narracion.add("Introudce un nombre válido:"); //esto debería ir en GameVoiceOver
        /*31*/narracion.add("Narrador: Ah, se me olvidaba, toma, te entrego esto:\n<<{PlayerName}>> ha recibido \"navaja\".");
        /*32*/narracion.add("Narrador: El Guardia de las Arenas golpea a <<{PlayerName}>> con su maza de tungsteno y lo mata ipsofacto\n--------------------GAME OVER--------------------");
        /*33*/narracion.add("Narrador: <<{PlayerName}>> sale corriendo y tropieza con la sangre del guardia\nCon la cabeza en el frío suelo se percata de un objeto pequeño e insignificante (EL PUTO DADO).");
        /*34*/narracion.add("Narrador: Saltan derechos de copyright y se cierra el juego por denuncias de derechos de autor.\n--------------------GAME OVER--------------------");
        /*35*/narracion.add("Narrador: Ya suponía.. Con ese nombre y ese careto que me llevas.\nEstá bien, te haré el t-u-t-o-r-i-a-l.");
        /*36*/narracion.add("Narrador: Así me gusta, dispuesto a todo (a sufrir, concretamente).");
        /*37*/narracion.add("Narrador: No te falta razón, digo nos vemos <<{PlayerName}>>.\n--------------------GAME OVER--------------------");
        /*38*/narracion.add("Narrador: A pesar de lo que parece, no, no nos está dando el alto...");
        /*39*/narracion.add("Narrador: Venga, te lo volveré a preguntar {PlayerName}: ");
        /*40*/narracion.add("Narrador: No se yo si estás muy bien preparado para este basto mundo de violad..Digo, de peligros que acenchan.\n");
        /*41*/narracion.add("Narrador: <<{PlayerName}>> se ecnontraba subiendo los empinados acantilados, cuando, de repente, unos curiosos personajes aparecieron.");
        /*42*/narracion.add("Narrador: ¿Parece que vas en tod@ regalad@ o no <<{PlayerName}>> ? Anda mira, en el vehículo este raro hay bastante muchedumbre.\nYo probaría a interactuar con alguno de estos paletos...");
        /*43*/narracion.add("Narrador: Muy atrevido por tu parte <<{PlayerName}>> ; buena suerte en la Jungla de los \"Horrores\", je je je...");
        /*44*/narracion.add("Narrador: Te recomendaría pasar desapercibid@. Esta zona es bastante peliaguda.");
        /*45*/narracion.add("Narrador: Para tu información, toda la zona de Singuerlín está bajo los dominios de la S.C.F (Singuerlín Clan Fentanílico) y no son muy amigables que digamos...");
        /*46*/narracion.add("Narrador: Tú contra mí: ¡El pringao de <<{PlayerName}>> contra el maravilloso, el magnífico, el omnipotente y omnipresente NARRADOOORRRRRR!\"");
        /*47*/narracion.add("Narrador: Te daré 30 puntos de salud para que no te mueras, por ahora, y unos 10 de energía para realizar tus ataques.\n");
        /*48*/narracion.add("Narrador: Muy bien, <<{PlayerName}>> , te he regalado un nivel, bravo! Has descubierto un pequeño e intencionado glitch, pero hasta aquí llegó tu grindeo gratis amigo.");
        /*49*/narracion.add("Narrador: ¡Enhorabuena <<{PlayerName}>> ! Has muerto nada más empezar la aventura, maravilloso. Venga hasta luego parguelas ;)");
        /*50*/narracion.add("Narrador: ¡Enhorabuena <<{PlayerName}>> ! Has ganado tu primer combate real, ¡WOW!");
        /*51*/narracion.add("Narrador: Pues a mí me parecieron amistosos... Igual podrías haberles dado una oportunidad.");
        /*52*/narracion.add("Narrador: Madre mía con el buitre carroñero, <<{PlayerName}>> es un asesino y un buitre... Qué orgulloso estoy de ti... <3 ");
        /*53*/narracion.add("Narrador: ¡Joder macho! Si lo llego a saber antes los hubiera matado yo mismo.");
        /*54*/narracion.add("Narrador: Sí, sí, mejor date el piro <<{PlayerName}>> que seguro que alguien accaba echando de menos a esos dos.");
        /*55*/narracion.add("Narrador: Esa es la buena <<{PlayerName}>>. La del listo, ahora puedes foll.. digo lootearlos sin que nadie te vea...");
        /*56*/narracion.add("Narrador: Bueno, supongo que es porque eres idiota, pero bueno, yo los hubiera registrado.. por si acaso... ");
        /*57*/narracion.add("Narrador: ¡¡¡HERMANOO!!! Ni la voz en off ha dicha nada, la has horrorizado... Debes estar de coña, va te lo volvere a preguntar:");
    }
}
