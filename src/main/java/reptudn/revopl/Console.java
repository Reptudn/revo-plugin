package reptudn.revopl;

import org.bukkit.Bukkit;
import org.bukkit.Color;

public class Console {

    public Console(){

    }

    public void log(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§b" + message);
    }

    public void error(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§c" + message);
    }

    public void info(String message){
        Bukkit.getConsoleSender().sendMessage(Core.PREFIX + "§e" + message);
    }

}
