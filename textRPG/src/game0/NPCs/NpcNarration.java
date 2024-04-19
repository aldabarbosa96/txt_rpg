package game0.NPCs;

import window.GuiInteraction;

import java.util.ArrayList;
import java.util.List;

public class NpcNarration {
    private static GuiInteraction gi;
    public static void setUserInteraction(GuiInteraction guiInteraction) {
        gi = guiInteraction ;
    }
    public static void dialogoGuardiaArenas(int index){
        String opcion = guardiArenas.get(index);
        gi.showMessage(opcion);
    }
    public static List<String> guardiArenas = new ArrayList<>();
    static {
        /*0*/guardiArenas.add("Guardia de las arenas: ¡ALTO GILIPOLLAS!");
        /*1*/guardiArenas.add("Guardia de las arenas: Enséñame tus enseres o muere suci@ cerd@.");
        /*2*/guardiArenas.add("Guardia de las arenas: Me cago en todos tus santísimos cojones pedazo de basura.");
        /*3*/guardiArenas.add("Guardia de las arenas: Suci@ bastard@, arrodíllate ahora mismo y lame mis botas para conservar la cabeza encima de los hombros.");
        /*4*/guardiArenas.add("Guardia de las arenas: Veamos...");
        /*5*/guardiArenas.add("Guardia de las arenas: Así me gusta sierv@ bastard@. ¡Ten! Te otorgo esta basurilla como obsequio por ser buen sirviente.");
        /*6*/guardiArenas.add("Guardia de las arenas: ¡MUERE!");
        /*7*/guardiArenas.add("Guardia de las arenas: Ten anda, que me da lástima que no tengas ni un triste trozo de pan.");
    }
    public static void dialogoPumYTable(int index){
        String opcion = pumYtable.get(index);
        gi.showMessage(opcion);
    }
    public static List<String> pumYtable = new ArrayList<>();
    static {
        /*0*/pumYtable.add("Entes extraños: ¡Ey! ¿!Que pasa bro!? ¡Somos los famosos Pum y Table! ¡You know?");
        /*1*/pumYtable.add("Pum: Claro, pum.");
        /*2*/pumYtable.add("Table: Pues la verdad es que sabemos poco, en general, pero podemos decirte que subir ahí... Es difícil y peligroso.");
        /*3*/pumYtable.add("Pum: Bastante, pum.");
        /*4*/pumYtable.add("Table: Tenemos algo que podría ayudarte... Algo un poco ilegal... Ya sabes...");
        /*5*/pumYtable.add("Pum: Ya sabes, pum.");
        /*6*/pumYtable.add("Table: ¡Será pedazo de mierdas..!");
        /*7*/pumYtable.add("Pum: ¡Pedazo de mierdas, pum!");
        /*8*/pumYtable.add("Entes extraños: ¡La hostia! ¡Qué bien suena eso bro! JAJAJAJAJAJA");
        /*9*/pumYtable.add("Entes extraños: ¡Toma! Me has caído de puta madre, la verdunch.");
        /*10*/pumYtable.add("Table: Joder bro, se te ha metido bien hasta el fondo.");
        /*11*/pumYtable.add("Pum: Hasta el fondo, pum.");
        /*12*/pumYtable.add("Table: ¡Espero que lo disfrutes! Y si alguna vez necesitas vernos, solo tienes que volver por aquí...");
        /*13*/pumYtable.add("Pum: Ha sido un verdadero placer tener la oportunidad de encontrarme con usted, aunque brevemente. \nEste corto tiempo juntos ha sido increíblemente fructífero y enriquecedor. Aprecio profundamente la sabiduría y las perspectivas que compartió,\nlas cuales han dejado una huella indeleble en mi trayectoria. Le agradezco sinceramente por la generosidad de su tiempo y por la inspiración que me ha brindado.\nEspero que en un futuro tengamos la fortuna de reencontrarnos y continuar esta conversación. Hasta entonces, le deseo lo mejor en todos sus proyectos y emprendimientos.\nCon el mayor respeto y un cordial saludo, me despido agradecido por este valioso intercambio.\nPum.");
        /*14*/pumYtable.add("\nTable: Pues verás, es una especie de estimulante mágico. Son unos polvitos blancos que te darán un chute de energía a costa de un poquito de tu vida :)\n¿Qué me dices?");
        /*15*/pumYtable.add("Pum: Un chutazo, pum.");

    }
}
