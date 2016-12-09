package net.whiteWolfdoge.relux;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class ReluxPlugin extends JavaPlugin{
	// @formatter:off
	private TabExecutor tex;
	public static final int
		MIN_RADIUS =	1,
		MAX_RADIUS = 	15;
	public static final String
		CMD_MAIN =						"relux",
		PERMISSION_USE =				"relux.use",
		MSG_PREFIX =					ChatColor.LIGHT_PURPLE + "[Relux] " + ChatColor.YELLOW,
		MSG_INFO =						MSG_PREFIX + "Relux allows manual chunk relighting. Written by WhiteWolfdoge (Emily White)",
		MSG_USAGE =						MSG_PREFIX + "Usage: " + ChatColor.ITALIC + "/relux <radius> [<xPos> <zPos>]",
		
		MSG_EX_PREFIX =					MSG_PREFIX + ChatColor.RED,
		MSG_EX_PERMISSION_DENIED =		MSG_EX_PREFIX + "You were denied permission to use this plugin.",
		MSG_EX_ARGS_INVALID_QTY =		MSG_EX_PREFIX + "Invalid quantity of arguments!",
		MSG_EX_ARGS_INVALID_RADIUS =	MSG_EX_PREFIX + "The radius must be an integer in the range of " + MIN_RADIUS + " through " + MAX_RADIUS,
		MSG_EX_INVALID_SOURCE =			MSG_EX_PREFIX + "You must use this command from within a world.";
	// @formatter:on
	
	// TODO write doc
	@Override
	public void onLoad(){
		tex = new InputAnalyzer();
		// TODO
	}
	
	// TODO write doc
	@Override
	public void onEnable(){
		getCommand(CMD_MAIN).setExecutor(tex);
		getCommand(CMD_MAIN).setTabCompleter(tex);
		
		
		// Ensure that natives are available before continuing.		
		ClassLoader cl = getServer().getClass().getClassLoader();
		String nativesFound = null;
		
		/*
		 * NMS_v1_8_R3
		 * (Minecraft 1.8.7 / CraftBukkit 1.8.7 / Spigot 1.8.7)
		 * (Minecraft 1.8.8 / CraftBukkit 1.8.8 / Spigot 1.8.8)
		 */
		try{
			Class.forName("net.minecraft.server.v1_8_R3.WorldServer", false, cl);
			nativesFound = "Minecraft 1.8.7 / 1.8.8";
		}
		catch(ClassNotFoundException cnfex){
			// Continue
		}
		
		/*
		 * NMS v1_9_R1
		 * Minecraft 1.9.2 / CraftBukkit 1.9.2 / Spigot 1.9.2)
		 */
		try{
			Class.forName("net.minecraft.server.v1_9_R1.WorldServer", false, cl);
			nativesFound = "Minecraft 1.9.2";
		}
		catch(ClassNotFoundException cnfex){
			// Continue
		}
		
		if(nativesFound == null){
			getServer().getLogger().warning(ChatColor.stripColor(ReluxPlugin.MSG_EX_PREFIX + "Natives were not found, we can't live like this!."));
			getPluginLoader().disablePlugin(this);
		}
		else{
			getServer().getLogger().info(ChatColor.stripColor(ReluxPlugin.MSG_EX_PREFIX + "Found natives: [" + nativesFound + ']'));
		}
	}
	
	// TODO write doc
	@Override
	public void onDisable(){
		//
	}
	
	/**
	 * 
	 * @param centerChunk	The chunk in the center of the area
	 * @param radius		The range
	 */
	public boolean relightChunks(Chunk centerChunk, int radius){
		// TODO
		return false;
	}
	
	// TODO write doc
	public boolean relightChunk(Chunk chunk, int radius){
		// TODO
		return false;
	}
	
	// TODO write doc
	public boolean relightBlock(Chunk block, int radius){
		// TODO
		return false;
	}
}
