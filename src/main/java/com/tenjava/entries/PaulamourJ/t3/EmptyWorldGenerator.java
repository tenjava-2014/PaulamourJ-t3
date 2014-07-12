package com.tenjava.entries.PaulamourJ.t3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class EmptyWorldGenerator extends ChunkGenerator {

	TenJava plugin;
	
	public EmptyWorldGenerator(TenJava plugin){
		this.plugin = plugin;
	}
	
	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world,0,64,0);
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return new ArrayList<BlockPopulator>();
	}
	
	
	public byte[][] generateBlockSections(World world, Random random, int chunkX, int chunkZ, ChunkGenerator.BiomeGrid biomeGrid) {
	    byte[][] result = new byte[256 / 16][];
		
	    int x,y,z;
	    
	    for(x = 0; x < 16; x++){
	    	for(z = 0; z < 16; z++){
	    		setBlock(result, x, 0, z, (byte) Material.WATER.getId());
		    }
	    }
	    
	    return result;
	}
	
	@Override
	public short[][] generateExtBlockSections(World world, Random random, int chunkX, int chunkZ, ChunkGenerator.BiomeGrid biomeGrid) {
		short[][] result = new short[256 / 16][];
		
	    int x,y,z;
	    
	    for(x = 0; x < 16; x++){
	    	for(z = 0; z < 16; z++){
	    		setBlockS(result, x, 0, z, (short) Material.WATER.getId());
		    }
	    }
	    
	    return result;
	}
	
	private void setBlock(byte[][] result, int x, int y, int z, byte blockID) {
		if(result[y >> 4] == null) {
			result[y >> 4] = new byte[4096];
		}
		result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blockID;
	}
	
	private void setBlockS(short[][] result, int x, int y, int z, short blockID) {
		if(result[y >> 4] == null) {
			result[y >> 4] = new short[4096];
		}
		result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blockID;
	}
}
