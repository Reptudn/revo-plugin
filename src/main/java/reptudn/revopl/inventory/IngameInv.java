package reptudn.revopl.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IngameInv{

    Player p;

    public IngameInv(Player p) {
        this.p = p;
    }

    private void setIngameInv(){
        p.getInventory().clear();
    }

}
