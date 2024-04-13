package game0.player;

import game0.game.GameVoiceOver;

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
        StringBuilder inventoryContents = new StringBuilder("\n             INVENTARIO\n\n");
        for (int i = 0; i < slots.length; i++) {
            inventoryContents.append("  ").append(i + 1).append(".           ").append(slots[i]).append("\n\n");
        }
        return inventoryContents.toString();
    }
}

