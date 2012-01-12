package com.Jessy1237.RTest;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class RTestPlayerListener extends PlayerListener{
	
	static String message = "";
	static int EorD = 0;
	static int seconds = 0;
	public static RTest plugin;
	public static Economy econ;
	public Permission perms;
		
	public RTestPlayerListener(RTest instance){
		plugin = instance;
	}
	
	public static void enable(){
		EorD = 1;
	}
	
	public static void disable(){
		EorD = 0;
	}

	public void onPlayerChat(PlayerChatEvent event){
		perms = plugin.perms;
		econ = RTest.econ;
		Player player = event.getPlayer();
		String name = player.getDisplayName();
		if(perms.playerHas(player, "RTest.Member") || perms.playerHas(player, "RTest.Admin")){
			Player players[] = plugin.getServer().getOnlinePlayers();
			if((event.getMessage()).equals((loadRnum.dNum1))  && EorD == 1){
				econ.depositPlayer(name, RTest.reward());
				for(int i = 0; i <players.length; i++)
					players[i].sendMessage((new StringBuilder()).append(plugin.getColour(RTest.ChatColor())).append("The Winner is: " + name + ".").append(message).toString());
				RTest.log.info("[RTest] Displaying Winner to Players...");
				disable();
				if((RTest.b) == 1){
					RTest.t.start();
					RTest.b = 0;
				}
			}
		}else{
			if((event.getMessage()).equals((loadRnum.dNum1)) && EorD == 1){
				player.sendMessage(plugin.getColour(RTest.ChatColor()) + "You don't have permission to win a Reaction Test");
				player.sendMessage(plugin.getColour(RTest.ChatColor()) + "Congratulations Though for Getting it right!");
			}else{
				if(EorD == 1){
					player.sendMessage(plugin.getColour(RTest.ChatColor()) + "You don't have permission to win a Reaction Test");
				}
			}
		}
	}
}