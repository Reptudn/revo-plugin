 package reptudn.revopl.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import reptudn.revopl.Core;
import reptudn.revopl.WorldManager;
import reptudn.revopl.inventory.InventoryManager;

 public class ResetWorldCommand implements CommandExecutor {

    InventoryManager im = new InventoryManager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = ((Player) sender).getPlayer();

        if(!p.isOp()){
            p.sendMessage(Core.PREFIX + "You don't have to permission to create a world!");
        } else {
            WorldManager cw = new WorldManager();

            if(Bukkit.getServer().getWorld("revo") == null){

                p.sendMessage(Core.PREFIX + "There is no world to reset! Use /join to join and create a world!");

            } else {

                p.sendMessage(Core.PREFIX + "Teleporting all players back to Lobby");

                for(Player player : Bukkit.getServer().getWorld("revo").getPlayers()){
                    player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
                    im.setLobbyInventory(p);
                    player.sendMessage(Core.PREFIX + "World is being resetted (can cause server lag!)");
                    player.setPlayerListName("[L]" + p.getDisplayName());
                    player.kickPlayer("Game World is resetting... wait a bit and then reconnect :)");
                }

                cw.deleteWorld();
                p.sendMessage(Core.PREFIX + "World deleted!");
                cw.createWorld();
                p.sendMessage(Core.PREFIX + "World resetted!");
            }

        }

        return true;

    }
}
