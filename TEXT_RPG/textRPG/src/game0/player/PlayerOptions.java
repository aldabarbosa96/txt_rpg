package game0.player;

import java.util.ArrayList;
import java.util.List;
public class PlayerOptions {
    public static void opcion(int index){
        String escoger = opciones.get(index);
        System.out.println(escoger);
    }
    public static void dialogo(int index){
        String escoger = dialogar.get(index);
        System.out.println(escoger);
    }
    public static List<String> opciones = new ArrayList<>();

    static {
        /*0*/opciones.add("A) Aquí el único maricón que hay eres TÚ.\nB) Puñetazo directo al mentón.\nC) Enseñar tu bolsa.");
        /*1*/opciones.add("A) Lames sus botas.\nB) ¡Que te jodan puto guarro!");
        /*2*/opciones.add("A) Decides lootear el cuerpo.\nB) Sales por patas por si alguien te ha visto.\nC) Baile de Fortinite sobre el cadáver ;)");
        /*3*/opciones.add(Player.getName()+": Deberías ser más considerado con los pobres como yo.");   //esto parece que no debería ir aquí /REVISAR/
        /*4*/opciones.add("A) Tutorial de tontitos, por favor\nB) Te reviento la cabeza\nC) Este juego es una mierda yo me voy");
        /*5*/opciones.add("A) Sí, aún tengo dudas porque soy un cubo de basura con manos\nB) No, soy hostia y lo he entendido todo\nC) Empecemos ya el combate, capullo");
        /*6*/opciones.add("A) Coger regalo y empezar aventurita\nB) ¡T-U-T-O-R-I-A-L! ¡T-U-T-O-R-I-A-L!\nC) Ahora sí, adiós\nD) Quiero cambiarme el nombre");
    }
    public static List<String> dialogar = new ArrayList<>();

    static {
        /*0*/dialogar.add(Player.getName() + ": Aquí al único que le huele la boca a polla es a ti hermanito.");
        /*1*/dialogar.add(Player.getName() +": Procede a violentarle la mandíbula con los nudillos en un gesto rápido y efectivo.");
        /*2*/dialogar.add(Player.getName() +": Procede a enseñar su bolsa.");
        /*3*/dialogar.add(Player.getName() +": ¡Coño! ¡¿Solo tiene una mierda de dado?! Menuda porquería.");
    }
}
