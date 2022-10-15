package reptudn.revopl.inventory;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyInv{

    Player p;

    public LobbyInv(Player p) {
        this.p = p;
    }

    private void setLobbyInv(){

        p.getInventory().clear();

        //Team-up Sword
        p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));

    }
}
