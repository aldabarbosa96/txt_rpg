package game0.player;

public class Equipment {
    private String cabeza;
    private String torso;
    private String manoD;
    private String manoI;
    private String pantalones;
    private String zapatos;
    private String collar;

    public Equipment() {
        this.cabeza = "     ---     ";
        this.torso = "     ---     ";
        this.manoD = "     ---     ";
        this.manoI = "     ---     ";
        this.pantalones = "     ---     ";
        this.zapatos = "     ---     r";
        this.collar = "     ---     ";
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

    public void mostrarEquipo() {
        System.out.println("--------------------EQUIPAMIENTO--------------------");
        System.out.println("Cabeza: " + this.cabeza);
        System.out.println("Torso: " + this.torso);
        System.out.println("Mano D: " + this.manoD);
        System.out.println("Mano I: " + this.manoI);
        System.out.println("Piernas: " + this.pantalones);
        System.out.println("Pies: " + this.zapatos);
        System.out.println("Amuleto: " + this.collar);
    }
}

