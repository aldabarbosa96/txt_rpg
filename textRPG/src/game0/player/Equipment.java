package game0.player;

import game0.game.narrative.GameVoiceOver;

public class Equipment {
    private static String cabeza;
    private static String torso;
    private static String manoD;
    private static String manoI;
    private static String pantalones;
    private static String zapatos;
    private static String collar;

    public Equipment() {
        this.cabeza = "---";
        this.torso = "---";
        this.manoD = "---";
        this.manoI = "---";
        this.pantalones = "---";
        this.zapatos = "---";
        this.collar = "---";
    }

    public boolean equiparItem(String tipo, String item) {
        switch (tipo) {
            case "cabeza":
                if (cabeza.equals("---")) {
                    cabeza = item;
                    return true;
                }
                break;
            case "torso":
                if (torso.equals("---")) {
                    torso = item;
                    return true;
                }
                break;
            case "manoD":
                if (manoD.equals("---")) {
                    manoD = item;
                    return true;
                }
                break;
            case "manoI":
                if (manoI.equals("---")) {
                    manoI = item;
                    return true;
                }
                break;
            case "pantalones":
                if (pantalones.equals("---")) {
                    pantalones = item;
                    return true;
                }
                break;
            case "zapatos":
                if (zapatos.equals("---")) {
                    zapatos = item;
                    return true;
                }
                break;
            case "collar":
                if (collar.equals("---")) {
                    collar = item;
                    return true;
                }
                break;
            default:
                GameVoiceOver.dialogo(4, null);
                return false;
        }
        GameVoiceOver.dialogo(4, null); //slots llenos.
        return false;
    }

    @Override
    public String toString() {
        return "\n\n--------------EQUIPO--------------------\n\n" +
                "       Cabeza: \n       " + cabeza + "\n\n" +
                "       Torso: \n       " + torso + "\n\n" +
                "       Mano D: \n       " + manoD + "\n\n" +
                "       Mano I: \n       " + manoI + "\n\n" +
                "       Piernas: \n       " + pantalones + "\n\n" +
                "       Pies: \n       " + zapatos + "\n\n" +
                "       Amuleto: \n       " + collar + "\n" +
                "\n####################";
    }
}
