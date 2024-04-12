package game0.player;

import game0.GameVoiceOver;
import game0.interfaces.UserInteraction;

public class Inventory {
    private static String[] slots = new String[12];

    static {
        for (int i = 0; i< slots.length; i++){
            slots[i] = "Slot Vacío";
        }
    }
    public static boolean addToInventory(String item){
        for (int i=0; i< slots.length; i++) {
            if (slots[i].equals("Slot Vacío")) {
                slots[i] = item;
                return true;
            }
        }
        GameVoiceOver.dialogo(4,null);
            return false;
    }
    public static String getInventoryDisplay() {
        StringBuilder inventoryContents = new StringBuilder("INVENTARIO\n");
        for (int i = 0; i < slots.length; i++) {
            inventoryContents.append(i + 1).append(". ").append(slots[i]).append("\n");
        }
        return inventoryContents.toString();
    }
}

