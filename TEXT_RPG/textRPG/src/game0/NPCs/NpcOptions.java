package game0.NPCs;

import java.util.ArrayList;
import java.util.List;

public class NpcOptions {
    public static void dialogo(int index){
        String opcion = guardiArenas.get(index);
        System.out.println(opcion);
    }
    public static List<String> guardiArenas = new ArrayList<>();
    static {
        /*0*/guardiArenas.add("Guardia de las arenas: ¡ALTO MARICONNN!");
        /*1*/guardiArenas.add("Guardia de las arenas: Enséñame tus enseres o muere sucia puerca.");
        /*2*/guardiArenas.add("Guardia de las arenas: Me cago en todos tus santísimos cojones pedazo de basura.");
        /*3*/guardiArenas.add("Guardia de las arenas: Sucio bastardo, arrodíllate ahora mismo y lame mis botas para conservar la cabeza encima de los hombros.");
        /*4*/guardiArenas.add("Guardia de las arenas: Veamos...");
        /*5*/guardiArenas.add("Guardia de las arenas: Así me gusta siervo bastardo. ¡Ten! Te otorgo esta basurilla como obsequio por ser un buen sirviente.");
        /*6*/guardiArenas.add("Guardia de las arenas: ¡MUERE!");
        /*7*/guardiArenas.add("Guardia de las arenas: Ten anda, que me da lástima que no tengas ni un triste trozo de pan.");
    }

}
