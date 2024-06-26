package game0.player;

import window.GuiInteraction;
import java.util.ArrayList;
import java.util.List;
public class PlayerOptions {
    private static GuiInteraction gi;

    public static void setUserInteraction(GuiInteraction guiInteraction) {
        gi = guiInteraction;
    }
    public static void opcion(int index,Player player){
        String escoger = opciones.get(index);
        if (player != null) {
            escoger = escoger.replace("{PlayerName}", player.getName());
        }
        gi.showMessage(escoger);
    }
    public static List<String> opciones = new ArrayList<>();

    static {
        /*0*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Aquí el único gilipollas que hay eres TÚ.\nB) Puñetazo directo al mentón.\nC) Enseñar tu bolsa.");
        /*1*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Lames sus botas.\nB) ¡Que te jodan puto guarro!");
        /*2*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Decides lootear el cuerpo.\nB) Sales por patas por si alguien te ha visto.\nC) Baile de Fortinite sobre el cadáver ;)");
        /*3*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>>  Deberías ser más considerado con los pobres como yo.");   //esto parece que no debería ir aquí /REVISAR/
        /*4*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Tutorial de tontitos, por favor\nB) Te reviento la cabeza\nC) Este juego es una mierda yo me voy");
        /*5*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Sí, aún tengo dudas porque soy un cubo de basura con manos\nB) No, soy hostia y lo he entendido todo\nC) Empecemos ya el combate, capullo");
        /*6*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Coger regalo y empezar aventurita\nB) ¡T-U-T-O-R-I-A-L! ¡T-U-T-O-R-I-A-L!\nC) Ahora sí, adiós\nD) Quiero cambiarme el nombre\nE) Quiero pelear otra vez");
        /*7*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Ir al Norte (\"Acantilados Riera Alta\")\nB) Ir al Sur (\"Selva Santa Rosa\")\nC) Ir al Este (\"Jungla Fondo\")\nD) Ir al Oeste (\"Montañas Singuerlín\")\nE) Explorar tu ubicación");
        /*8*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Hablar con entes raros\nB) Atacar entes raros\nC) Tirarte un pedo\nD) Pasar de largo");
        /*9*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Dialogar con anciana\nB) Atacar a anciana\nC) Dialogar con borracho\nD) Atacar a borracho\nE) Seguir tu camino");
        /*10*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Retroceder al \"Centro\"\nB) Entrar en la Singuerlín C.F\nC) Adoptar postura sigilosa\nD) Provocar al primero que veas");
        /*11*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Coger regalo sin hacer preguntas\nB) Preguntar qué es eso\nC) Intentar robar\nD) Pasar de ellos");
        /*12*/opciones.add("\n---------------------------------------------------\n<<{PlayerName}>> \nA) Lootear los cuerpos\nB) Salir corriendo\nC) Ocultar los cuerpos");
    }
    public static void dialogo(int index, Player player){
        String escoger = dialogar.get(index);
        if (player != null) {
            escoger = escoger.replace("{PlayerName}", player.getName());
        }
        gi.showMessage(escoger);
    }

    public static List<String> dialogar = new ArrayList<>();

     static {
        /*0*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : El único gilipollas que veo por aquí eres TÚ.");
        /*1*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : Procede a violentarle la mandíbula con los nudillos en un gesto rápido y efectivo.");
        /*2*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : Procede a enseñar su bolsa.");
        /*3*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : ¡Coño! ¡¿Solo tiene esto?! Menuda porquería.");
        /*4*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : Hola buenas, soy {PlayerName}, ya que veo que sois de por aquí cerca, sabéis algo acerca de los \"Acantilados Riera Alta\"?");
        /*5*/dialogar.add("\n---------------------------------------------------\n<<{PlayerName}>> : ¡Encantado, mis panas! ¿Algún consejo para poder llegar sano y salvo?");
    }
}
