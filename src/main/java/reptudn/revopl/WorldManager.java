package reptudn.revopl;

import org.bukkit.*;
import org.bukkit.block.Biome;

import java.io.File;
import java.util.ArrayList;

public class WorldManager {

    public String worldName = "revo";
    Console console = new Console();

    public void createWorld(){

        if(Bukkit.getServer().getWorld("revo") != null){

            //World already exists
            console.info("World with name "+ worldName + " already exists!");
            console.info("Not creating a new world.");
            return;

        } else {

            //World doesnt exist

            WorldCreator wc = new WorldCreator(worldName);
            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.NORMAL);

            try{

                console.info("Creating World...");
                wc.createWorld();

                World world = Bukkit.getWorld(worldName);

                Biome spawnBiome = Biome.PLAINS;
                Location pos = world.locateNearestBiome(world.getSpawnLocation(), spawnBiome, 10000);

                WorldBorder border = world.getWorldBorder();
                border.setCenter(pos);
                border.setSize(300.0);

                //Set Spawn Location
                world.setSpawnLocation(pos);

                //preload chunks
                for(int t = -5; t < 5; t++){
                    world.loadChunk((int)pos.getX() + t, (int)pos.getY() + t, true);
                    console.info("Loaded Chunk: " + world.getChunkAt((int)pos.getX() + t, (int)pos.getY() + t).toString());
                }
                console.log("Spawn Chunks loaded");

                //setSpawnCircle(pos, world);

                Thread.sleep(3000);

                console.info("Done!");

            } catch (Exception e){
                console.error("World creation failed!");
            }

        }


    }

    public void setSpawnCircle(Location loc, World wold){

        int radius = 10;

        ArrayList<Location> spawnCircle = new ArrayList<Location>();

        spawnCircle.add(loc.add(0, 0, radius));

    }

    public void deleteWorld(){

        if(Bukkit.getServer().getWorld("revo") == null) {
            console.error("World doesnt exist");

        } else {

            World delete = Bukkit.getWorld("revo");
            Bukkit.getServer().unloadWorld("revo", true);
            File deleteFolder = delete.getWorldFolder();
            deleteWorld(deleteFolder);
            console.log("World deleted!");

        }

    }

    public boolean deleteWorld(File path) {
        if(path.exists()) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return(path.delete());
    }

}
