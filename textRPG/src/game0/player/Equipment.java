package game0.player;

import game0.game.GameVoiceOver;

public class Equipment {
    private  String cabeza;
    private String torso;
    private String manoD;
    private String manoI;
    private String pantalones;
    private String zapatos;
    private String collar;

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
                if (this.cabeza.equals("---")) {
                    this.cabeza = item;
                    return true;
                }
                break;
            case "torso":
                if (this.torso.equals("---")) {
                    this.torso = item;
                    return true;
                }
                break;
            case "manoD":
                if (this.manoD.equals("---")) {
                    this.manoD = item;
                    System.out.println("Item equipado: " + item);//depuración
                    return true;
                }
                break;
            case "manoI":
                if (this.manoI.equals("---")) {
                    this.manoI = item;
                    return true;
                }
                break;
            case "pantalones":
                if (this.pantalones.equals("---")) {
                    this.pantalones = item;
                    return true;
                }
                break;
            case "zapatos":
                if (this.zapatos.equals("---")) {
                    this.zapatos = item;
                    return true;
                }
                break;
            case "collar":
                if (this.collar.equals("---")) {
                    this.collar = item;
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
        return "\n\n----------EQUIPO--------------------\n\n" +
                "   Cabeza: " + cabeza + "\n\n" +
                "   Torso: " + torso + "\n\n" +
                "   Mano D: " + manoD + "\n\n" +
                "   Mano I: " + manoI + "\n\n" +
                "   Piernas: " + pantalones + "\n\n" +
                "   Pies: " + zapatos + "\n\n" +
                "   Amuleto: " + collar + "\n\n" +
                "------------------------------";
    }
}
