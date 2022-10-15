package reptudn.revopl;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import reptudn.revopl.commands.CreateWorldCommand;
import reptudn.revopl.commands.JoinCommand;
import reptudn.revopl.commands.LeaveCommand;
import reptudn.revopl.commands.ResetWorldCommand;
import reptudn.revopl.events.ChatEvent;
import reptudn.revopl.events.OnPlayerJoinEvent;
import reptudn.revopl.events.OnPlayerLeaveEvent;
import reptudn.revopl.events.PingOnTab;
import reptudn.revopl.game.OnIngamePlayerDeath;

public final class Core extends JavaPlugin {

    public static String PREFIX = "§5[VEYRO] §f";
    PluginManager pm = Bukkit.getServer().getPluginManager();
    Console console = new Console();

    public static boolean gameRunning = false;

    @Override
    public void onEnable() {

        try{
            console.info("Loading Plugin...");
            registerCommands();
            registerEvents();
        } catch (Exception e){
            console.error("Loading FAILED!");
        } finally {
            console.log("Done!");
        }

    }

    @Override
    public void onDisable() {

        //delete game world
        WorldManager wm = new WorldManager();
        wm.deleteWorld();

    }

    private void registerCommands(){
        this.getCommand("join").setExecutor(new JoinCommand());
        this.getCommand("create").setExecutor(new CreateWorldCommand());
        this.getCommand("reset").setExecutor(new ResetWorldCommand());
        this.getCommand("leave").setExecutor(new LeaveCommand());
    }

    private void registerEvents(){

        pm.registerEvents(new OnPlayerJoinEvent(), this);
        pm.registerEvents(new OnPlayerLeaveEvent(), this);
        pm.registerEvents(new ChatEvent(), this);
        pm.registerEvents(new PingOnTab(), this);
        pm.registerEvents(new OnIngamePlayerDeath(), this);

    }

}
