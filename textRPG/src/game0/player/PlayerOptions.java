package game0.player;

import java.util.ArrayList;
import java.util.List;
import game0.player.Player;
public class PlayerOptions {

    public static void opcion(int index){
        String escoger = opciones.get(index);
        System.out.println(escoger);
    }
    public static List<String> opciones = new ArrayList<>();

    static {
        Player player = new Player();
        /*0*/opciones.add(player.getName() + ":\nA) Aquí el único gilipollas que hay eres TÚ.\nB) Puñetazo directo al mentón.\nC) Enseñar tu bolsa.");
        /*1*/opciones.add(player.getName() + ":\nA) Lames sus botas.\nB) ¡Que te jodan puto guarro!");
        /*2*/opciones.add(player.getName() + ":\nA) Decides lootear el cuerpo.\nB) Sales por patas por si alguien te ha visto.\nC) Baile de Fortinite sobre el cadáver ;)");
        /*3*/opciones.add(player.getName() + ": Deberías ser más considerado con los pobres como yo.");   //esto parece que no debería ir aquí /REVISAR/
        /*4*/opciones.add(player.getName() + ":\nA) Tutorial de tontitos, por favor\nB) Te reviento la cabeza\nC) Este juego es una mierda yo me voy");
        /*5*/opciones.add(player.getName() + ":\nA) Sí, aún tengo dudas porque soy un cubo de basura con manos\nB) No, soy hostia y lo he entendido todo\nC) Empecemos ya el combate, capullo");
        /*6*/opciones.add(player.getName() + ":\nA) Coger regalo y empezar aventurita\nB) ¡T-U-T-O-R-I-A-L! ¡T-U-T-O-R-I-A-L!\nC) Ahora sí, adiós\nD) Quiero cambiarme el nombre\nE) Quiero pelear otra vez");
        /*7*/opciones.add(player.getName() + ":\n1) Abrir inventario\n2) Ver equipamiento\n3) Ver estadísticas\nA) Ir al Norte (\"Acantilados Riera Alta\")\nB) Ir al Sur (\"Selva Santa Rosa\")\nC) Ir al Este (\"Jungla Fondo\")\nD) Ir al Oeste (\"Montañas Singuerlín\")\nE) Explorar tu ubicación");
        /*8*/opciones.add(player.getName() + ":\nA) Hablar con el ente raro\nB) Atacar al ente raro\nC) Tirarte un pedo\nD) Pasar de largo");
        /*9*/opciones.add(player.getName() + ":\nA) Dialogar con anciana\nB) Atacar a anciana\nC) Dialogar con borracho\nD) Atacar a borracho\nE) Seguir tu camino");
        /*10*/opciones.add(player.getName() + ":\nA) Retroceder al \"Centro\"\nB) Entrar en la Singuerlín C.F\nC) Adoptar postura sigilosa\nD) Provocar al primero que veas");
    }
    public static void dialogo(int index){
        String escoger = dialogar.get(index);
        System.out.println(escoger);
    }

    public static List<String> dialogar = new ArrayList<>();

    static {
        Player player = new Player();
        /*0*/dialogar.add(player.getName() +": El único gilipollas que veo por aquí eres TÚ.");
        /*1*/dialogar.add(player.getName() +": Procede a violentarle la mandíbula con los nudillos en un gesto rápido y efectivo.");
        /*2*/dialogar.add(player.getName() +": Procede a enseñar su bolsa.");
        /*3*/dialogar.add(player.getName() +": ¡Coño! ¡¿Solo tiene esto?! Menuda porquería.");
    }
}
