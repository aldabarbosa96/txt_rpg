package game0.player;

import window.GuiInteraction;

public class Equipment {
    private String cabeza;
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

    public void equiparCabeza(String item) {
        this.cabeza = item;
    }

    public void equiparTorso(String item) {
        this.torso = item;
    }
    public void equiparManoD(String item){
        this.manoD = item;
    }

    public void equiparManoI(String item){
        this.manoI = item;
    }

    public void equiparPantalones(String item) {
        this.pantalones = item;
    }

    public void equiparZapatos(String item) {
        this.zapatos = item;
    }

    public void equiparCollar(String item) {
        this.collar = item;
    }

    public void mostrarEquipo(GuiInteraction gi) {
        gi.showMessage("--------------------EQUIPAMIENTO--------------------\n");
        gi.showMessage("Cabeza: " + this.cabeza);
        gi.showMessage("Torso: " + this.torso);
        gi.showMessage("Mano D: " + this.manoD);
        gi.showMessage("Mano I: " + this.manoI);
        gi.showMessage("Piernas: " + this.pantalones);
        gi.showMessage("Pies: " + this.zapatos);
        gi.showMessage("Amuleto: " + this.collar);
    }
}

