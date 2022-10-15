package reptudn.revopl.inventory;

import org.bukkit.entity.Player;

public class InventoryManager {

    public void setLobbyInventory(Player p){
        LobbyInv lv = new LobbyInv(p);
    }

    public void setIngameInventory(Player p){
        IngameInv iv = new IngameInv(p);
    }

}
