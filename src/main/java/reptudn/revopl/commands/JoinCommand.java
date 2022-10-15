package reptudn.revopl.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import reptudn.revopl.Console;
import reptudn.revopl.Core;
import reptudn.revopl.WorldManager;
import reptudn.revopl.inventory.InventoryManager;

public class JoinCommand implements CommandExecutor {

    Console console = new Console();
    InventoryManager im = new InventoryManager();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            console.error("This can only be executed by a player!");
            return false;
        } else {
            Player p = ((Player) sender).getPlayer();

            if(Bukkit.getServer().getWorld("revo") == null){
                p.sendMessage(Core.PREFIX + "There is no game yet... creating one...");
                WorldManager cw = new WorldManager();
                cw.createWorld();
                p.sendMessage(Core.PREFIX + "Game created! Joining...");
            }

            if(p.getWorld().getName().equals("revo")){
                sender.sendMessage(Core.PREFIX + "You already joined the Game!");
            } else {

                p.teleport(Bukkit.getWorld("revo").getSpawnLocation());

                p.setDisplayName("§a" + p.getDisplayName());

                p.sendMessage(Core.PREFIX + "Game joined!");

                p.setGameMode(GameMode.SURVIVAL);

                im.setIngameInventory(p);

                p.setPlayerListName("[IG] " + p.getDisplayName());

                setSpawnBox(p);

            }

        }
        return true;
    }

    private void setSpawnBox(Player p){

        Location inGameLoc = p.getLocation();

        while(true){
            if(!(inGameLoc.getBlock().equals(Material.AIR))) break;
            inGameLoc.setY(inGameLoc.getY() - 1);
        }


        Location headLocation = inGameLoc;
        headLocation.setY(headLocation.getY() + 1);
        Block headBlock = headLocation.getBlock();
        headBlock.setType(Material.AIR);

        Location underPlayer = inGameLoc;
        underPlayer.setY(underPlayer.getY() - 1);

        Location[] slaps = new Location[4];
        for(int i = 0; i < slaps.length; i++){
            slaps[i] = inGameLoc;
        }
        slaps[0].setX(inGameLoc.getX() + 1);
        slaps[1].setX(inGameLoc.getX() - 1);
        slaps[2].setZ(inGameLoc.getZ() + 1);
        slaps[3].setZ(inGameLoc.getZ() - 1);

        for(int i = 0; i < slaps.length; i++){
            Block a = slaps[i].getBlock();
            a.setType(Material.ACACIA_SLAB);
        }

        Block block = underPlayer.getBlock();

        block.setType(Material.GOLD_BLOCK);

        p.sendBlockChange(inGameLoc, Material.DIAMOND_BLOCK, (byte) 1);

        p.teleport(inGameLoc);

    }


}
