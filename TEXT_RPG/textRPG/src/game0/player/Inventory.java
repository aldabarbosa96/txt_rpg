package game0.player;

public class Inventory {
    private static String[] slots = new String[12];

    static {
        for (int i = 0; i< slots.length; i++){
            slots[i] = "Slot Vacío";
        }
    }
    public static String[] getSlots(){
        return slots;
    }
    public static boolean addToInventory(String item){
        for (int i=0; i< slots.length; i++) {
            if (slots[i].equals("Slot Vacío")) {
                slots[i] = item;
                return true;
            }
        }
        System.out.println("Inventario lleno. Tira algo Diógenes.");
            return false;

    }
    public static void mostrarInv(){
        System.out.println("INVENTARIO:");
        for (int i=0;i< slots.length;i++){
            System.out.println(slots[i]);
        }
    }
}

