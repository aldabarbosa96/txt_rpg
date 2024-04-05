package game0.player;

import java.util.ArrayList;
import java.util.List;
public class PlayerStatus {
    public static List<String> opciones = new ArrayList<>();

    static {
        /*0*/opciones.add("A) Aquí el único maricón que hay eres TÚ.\nB) Puñetazo directo al mentón.\nC) Enseñar tu bolsa.");
        /*1*/opciones.add("A) Lames sus botas.\nB) ¡Que te jodan puto guarro!");
        /*2*/opciones.add("A) Decides lootear el cuerpo.\nB) Sales por patas por si alguien te ha visto.\nC) Baile de Fortinite sobre el cadáver ;)");
        /*3*/opciones.add("Deberías ser más considerado con los pobres como yo.");   //esto no debería ir aquí
        /*4*/opciones.add("A) La verdad que preferiría el tutorial de tontitos\nB) Te reviento la cabeza\nC) Este juego es una mierda yo me voy");
        /*5*/opciones.add("A) Sí, aún tengo dudas porque soy un cubo de basura con manos\nB) No, soy hostia y lo he entendido todo\nC) Empecemos ya el combate, capullo");
    }
    public static void opcion(int index){
        String escoger = opciones.get(index);
        System.out.println(escoger);
    }
}
