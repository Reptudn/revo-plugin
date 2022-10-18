package reptudn.revopl;

import org.bukkit.Bukkit;
import org.bukkit.Color;

public class Console {

    public static void log(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§b" + message);
    }

    public static void error(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§c" + message);
    }

    public static void info(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§e" + message);
    }

}
