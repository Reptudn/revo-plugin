package reptudn.revopl.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import reptudn.revopl.Core;

public class OnPlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        e.setJoinMessage(Core.PREFIX + p.getDisplayName() + " joined the Server!");
        p.setPlayerListName("[L] " + p.getDisplayName());

        p.teleport(Bukkit.getWorld("world").getSpawnLocation());

        p.setGameMode(GameMode.ADVENTURE);

        addLobbyItems(p);

    }

    private void addLobbyItems(Player p){

        p.getInventory().clear();

        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("Hit player to team up");

        p.getInventory().addItem(item);

    }

}
