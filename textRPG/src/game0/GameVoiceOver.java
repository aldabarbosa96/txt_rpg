package game0;

import game0.NPCs.Npc;
import game0.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameVoiceOver {
    public static void dialogo(int index,Player player){
        String voz = vozEnOff.get(index);
        if (player != null) {
            voz = voz.replace("{PlayerName}",Player.getName());
        }
        System.out.println(voz);
    }
    public static List<String> vozEnOff = new ArrayList<>();

    static {
        /*0*/vozEnOff.add("Pulsa ENTER para abrir tu inventario:");
        /*1*/vozEnOff.add("Pulsa ENTER para lanzar el dado de ataque:");
        /*2*/vozEnOff.add("Pulsa ENTER para entrar en combate:");
        /*3*/vozEnOff.add("Pulsa ENTER para lanzar el dado de diálogo:");
        /*4*/vozEnOff.add("Inventario lleno. Tira algo Diógenes.");
        /*5*/vozEnOff.add("Turno de <<{PlayerName}>>.");
        /*6*/vozEnOff.add("El ataque no tuvo efecto en el enemigo");
        /*7*/vozEnOff.add("Turno del enemigo:");
        /*8*/vozEnOff.add("El ataque no tuvo efecto sobre ti");
        /*9*/vozEnOff.add("\n--------------------¡FIN DEL COMBATE!--------------------");
        /*10*/vozEnOff.add("Continúa el combate:");
        /*11*/vozEnOff.add("---------------------------------------------------");
        /*12*/vozEnOff.add("Pulsa ENTER para lanzar el dado de ataque: del enemigo:");
    }
}

