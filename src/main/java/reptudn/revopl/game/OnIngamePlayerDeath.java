package reptudn.revopl.game;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class OnIngamePlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDieIngame(PlayerDeathEvent e){

        Player p = e.getPlayer();
        Player killer = e.getEntity().getKiller();

        if (p.getWorld().equals(Bukkit.getServer().getWorld("revo"))){

            p.setGameMode(GameMode.SPECTATOR);
            e.setDeathMessage(ChatColor.AQUA + p.getDisplayName() + ChatColor.RED + " got wrecked!");
            p.getInventory().clear();
            p.setPlayerListName(ChatColor.GRAY + "[Dead] " + p.getDisplayName());
            killer.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));


        } else
            return;
    }

}
