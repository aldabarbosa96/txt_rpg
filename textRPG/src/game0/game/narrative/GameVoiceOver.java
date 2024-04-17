package game0.game.narrative;

import game0.interfaces.UserInteraction;
import game0.player.Player;
import window.GuiInteraction;

import java.util.ArrayList;
import java.util.List;

public class GameVoiceOver {
    private static GuiInteraction gi;

    public static void setUserInteraction(GuiInteraction guiInteraction) {
        gi = guiInteraction;
    }
    public static void dialogo(int index,Player player){
        String voz = vozEnOff.get(index);
        if (player != null) {
            voz = voz.replace("{PlayerName}",player.getName());
        }
        gi.showMessage(voz);
    }
    public static void separador(GuiInteraction gi){
        gi.showMessage("---------------------------------------------------");
    }
    public static List<String> vozEnOff = new ArrayList<>();
    static {
        /*0*/vozEnOff.add("Pulsa \"I\" para abrir tu inventario:");
        /*1*/vozEnOff.add("Pulsa \"Continuar\" para lanzar el dado de ataque:");
        /*2*/vozEnOff.add("Pulsa \"Continuar\" para entrar en combate:");
        /*3*/vozEnOff.add("Pulsa ENTER para lanzar el dado de diálogo:"); //modificar
        /*4*/vozEnOff.add("Inventario lleno. Tira algo Diógenes.");
        /*5*/vozEnOff.add("Turno de <<{PlayerName}>>.");
        /*6*/vozEnOff.add("El ataque no tuvo efecto en el enemigo");
        /*7*/vozEnOff.add("Turno del enemigo:");
        /*8*/vozEnOff.add("El ataque no tuvo efecto sobre ti");
        /*9*/vozEnOff.add("\n--------------------¡FIN DEL COMBATE!--------------------\n");
        /*10*/vozEnOff.add("Continúa el combate:");
        /*11*/vozEnOff.add("---------------------------------------------------");
        /*12*/vozEnOff.add("Pulsa \"Continuar\" para lanzar el dado de ataque del enemigo:");
        /*13*/vozEnOff.add("¿Qué quieres hacer <<{PlayerName}>> ?");
        /*14*/vozEnOff.add("Pulsa \"E\" para ver tu equipamiento:");
        /*15*/vozEnOff.add("Comienzas a subir hacia \"Los Acantilados de Riera Alta\".");
        /*16*/vozEnOff.add("Coges un extraño transporte dirección \"La Selva Santa Rosa\".");
        /*17*/vozEnOff.add("Te adentras en las profundidades de \"La Jungla de Fondo\".");
        /*18*/vozEnOff.add("Desciendes hacia la valle de \"Las Montañas Singuerlín\".");
        /*19*/vozEnOff.add("Pulsa \"S\" para abrir tus estadísticas:");
        /*20*/vozEnOff.add("\n--------------------GAME OVER--------------------");
        /*21*/vozEnOff.add("Te crujes el ano turbo fuerte; un pedo descomunal que resuena por toda la valle del acantilado.");
        /*22*/vozEnOff.add("Los entes extraños te otorgan un objeto extraño.");
        /*23*/vozEnOff.add("<<{PlayerName}>> ha recibido \"Mechero\"");
        /*24*/vozEnOff.add("PRINGAO");
        /*25*/vozEnOff.add("Ignoras por completo a los entes extraños.");
    }
}

