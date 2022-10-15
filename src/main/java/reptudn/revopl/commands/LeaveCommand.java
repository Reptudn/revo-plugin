package reptudn.revopl.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import reptudn.revopl.Console;
import reptudn.revopl.Core;
import reptudn.revopl.WorldManager;
import reptudn.revopl.inventory.InventoryManager;

import java.awt.*;

public class LeaveCommand implements CommandExecutor {

    Console console = new Console();
    InventoryManager im = new InventoryManager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            console.error("This can only be executed by a player!");
            return false;
        } else {
            Player p = ((Player) sender).getPlayer();

            if(p.getWorld().getName().equals("world")){
                sender.sendMessage(Core.PREFIX + "You are not in a game");
            } else {

                p.teleport(Bukkit.getWorld("world").getSpawnLocation());

                p.setDisplayName("§f" + p.getDisplayName());

                p.sendMessage(Core.PREFIX + "Game left!");

                im.setLobbyInventory(p);

            }

        }

        return true;
    }
}
