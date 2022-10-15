package reptudn.revopl.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import reptudn.revopl.Core;

public class ChatEvent implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent e){

        Player p = e.getPlayer();

        String message = e.getMessage();

        if(p.getWorld().getName().equals("revo")){
            if(Core.gameRunning){
                e.setFormat(ChatColor.YELLOW + "[PLAYING] " + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GREEN + " >> "+ ChatColor.GRAY + message);
            } else {
                e.setFormat(ChatColor.YELLOW + "[INGAME] " + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GREEN + " >> "+ ChatColor.GRAY + message);
            }
        } else {
            e.setFormat(ChatColor.YELLOW + "[LOBBY] " + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GREEN + " >> "+ ChatColor.GRAY + message);
        }

    }


}
