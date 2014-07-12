package com.tenjava.entries.PaulamourJ.t3;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin implements Listener {
	
	World w = Bukkit.getWorld("world");
	
	public void onEnable(){
		if(Bukkit.getPlayer("Paulamourj") != null) test(w);
		//Inventory i = Bukkit.createInventory(null, InventoryType.HOPPER, "Mondes");
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new EmptyWorldGenerator(this);
	}
	
	public void test(World w){
		WorldCreator r = new WorldCreator("Vississitude");
		World a = r.createWorld();
		
		Bukkit.getPlayer("Paulamourj").teleport(new Location(a,0,128,0));
	}
	
}
