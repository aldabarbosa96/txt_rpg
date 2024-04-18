package game0.player;

import game0.game.narrative.GameVoiceOver;

public class Inventory {
    private static String[] slots = new String[15];

    static {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = "---";
        }
    }

    public static boolean addToInventory(String item) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].equals("---")) {
                slots[i] = item;
                return true;
            }
        }
        GameVoiceOver.dialogo(4, null);
        return false;
    }

    public String getInventoryDisplay() {
        StringBuilder inventoryContents = new StringBuilder("\n\n----------------INVENTARIO-------\n\n\n");
        for (int i = 0; i < slots.length; i++) {
            if (i <= 8) {
                inventoryContents.append("                    0").append(i + 1).append(".   ").append(slots[i]).append("\n");
            } else {
                inventoryContents.append("                    ").append(i + 1).append(".   ").append(slots[i]).append("\n");
            }
        }
        inventoryContents.append("\n\n\n\n\n#######################");
        return inventoryContents.toString();
    }
}

