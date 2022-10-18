package reptudn.revopl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import reptudn.revopl.Core;
import reptudn.revopl.WorldManager;

public class CreateWorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = ((Player) sender).getPlayer();

        if(!p.isOp()){
            p.sendMessage(Core.PREFIX + "You don't have to permission to create a world!");
        } else {
            WorldManager cw = new WorldManager();
            cw.createWorld();
        }
        return true;
    }
}
