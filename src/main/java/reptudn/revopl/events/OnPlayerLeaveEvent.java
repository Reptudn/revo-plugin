package reptudn.revopl.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import reptudn.revopl.Core;

public class OnPlayerLeaveEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent e){

        Player p = e.getPlayer();
        e.setQuitMessage(Core.PREFIX + p.getDisplayName() + " left the Server!");

    }

}
