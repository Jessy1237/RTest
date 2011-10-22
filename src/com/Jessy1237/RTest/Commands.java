package com.Jessy1237.RTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class Commands implements CommandExecutor{
	
	static Properties prop = Main.prop;
	static File conf = Main.conf;
	static String message = Main.message;
	private Main plugin;
	
	public Commands(Main plugin){
		this.plugin = plugin;
	}
	
//Commands...Warning Many of them....!
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("RTest")){
				if(args.length == 0){
					Player player = (Player)sender;
					player.sendMessage(ChatColor.GOLD + "RTest");
					player.sendMessage(ChatColor.GOLD + "-----------------------------------");
					player.sendMessage(ChatColor.GOLD + "Basic Commands:");
					player.sendMessage(ChatColor.GOLD + "RTest - Displays This Page");
					player.sendMessage(ChatColor.GOLD + "RTest Admin - Displays all the Admin commands associated with RTest");
					player.sendMessage(ChatColor.GOLD + "RTest About - Displays General information about RTest");
					player.sendMessage(ChatColor.GOLD + "RTest Reward - Displays the Reward for the Reaction Tests");
				}else{
					String arg0 = args[0];
				if(arg0.equalsIgnoreCase("Admin")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						player.sendMessage(ChatColor.GOLD + "RTest");
						player.sendMessage(ChatColor.GOLD + "-----------------------------------");
						player.sendMessage(ChatColor.GOLD + "Admin Commands:");
						player.sendMessage(ChatColor.GOLD + "RTest Start - Starts the timer for Reaction Tests");
						player.sendMessage(ChatColor.GOLD + "RTest Stop - Stops the time for Reaction Tests");
						player.sendMessage(ChatColor.GOLD + "RTest Force - Forces a Reaction Test to take place");
						player.sendMessage(ChatColor.GOLD + "RTest Disable - Disables RTest");
						player.sendMessage(ChatColor.GOLD + "RTest RewardSet - Sets the Reward for the Reaction Test");
						player.sendMessage(ChatColor.GOLD + "RTest DelaySet - Sets the delay between each Reaction Test");
						player.sendMessage(ChatColor.GOLD + "RTest CharAmountSet - Sets the Amount of Characters in the Variable");
						player.sendMessage(ChatColor.GOLD + "RTest CurrencySet - Sets the name of the Currency for RTest!");
				}else{
						player.sendMessage(ChatColor.GOLD + "You Don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("About")){
					Player player = (Player)sender;
					player.sendMessage(ChatColor.GOLD + "RTest");
					player.sendMessage(ChatColor.GOLD + "-----------------------------------");
					player.sendMessage(ChatColor.GOLD + "Description:");
					player.sendMessage(ChatColor.GOLD + "RTest is a Plugin that displays a random aplanumerical variable");
					player.sendMessage(ChatColor.GOLD + "to all the online Players, first player to type in the variable wins");
					player.sendMessage(ChatColor.GOLD + "the reward that is set in the properties file.");
					player.sendMessage(ChatColor.GOLD + "-----------------------------------");
					player.sendMessage(ChatColor.GOLD + "Plugin Author: Jessy1237");
					player.sendMessage(ChatColor.GOLD + "Version: " + Main.vernum);
				}	
				if(arg0.equalsIgnoreCase("Reward")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Member")||player.hasPermission("RTest.Admin")){
						player.sendMessage(ChatColor.GOLD + "RTest");
						player.sendMessage(ChatColor.GOLD + "-----------------------------------");
						player.sendMessage(ChatColor.GOLD + "The Reward for winning a Reaction Test is: " + Main.reward() + " " + Main.Currency());
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("DelaySet")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						try {
							String arg = args[1].toString();
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("charAmount", Integer.toString(Main.charAmount()));
							prop.put("reward", Integer.toString(Main.reward()));
							prop.put("delay", arg);
							prop.put("Currency", Main.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(ChatColor.GOLD + "The delay is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(ChatColor.GOLD + "Unable to set the delay to: " + arg);
							player.sendMessage(ChatColor.GOLD + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("ChatAmountSet")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("charAmount", arg);
							prop.put("reward", Integer.toString(Main.reward()));
							prop.put("delay", Integer.toString(Main.delay()));
							prop.put("Currency", Main.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(ChatColor.GOLD + "The Character Amount is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(ChatColor.GOLD + "Unable to set the Character Amount to: " + arg);
							player.sendMessage(ChatColor.GOLD + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Disable")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						player.sendMessage(ChatColor.GOLD + "Disabling RTest...");
						PluginManager pm = plugin.getServer().getPluginManager();
						pm.disablePlugin(plugin);
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("RewardSet")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("charAmount", Integer.toString(Main.charAmount()));
							prop.put("reward", arg);
							prop.put("delay", Integer.toString(Main.delay()));
							prop.put("Currency", Main.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(ChatColor.GOLD + "The reward is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(ChatColor.GOLD + "Unable to set the reward to: " + arg);
							player.sendMessage(ChatColor.GOLD + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("CurrencySet")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("charAmount", Integer.toString(Main.charAmount()));
							prop.put("reward", Integer.toString(Main.reward()));
							prop.put("delay", Integer.toString(Main.delay()));
							prop.put("Currency", arg);
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(ChatColor.GOLD + "The Currency is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(ChatColor.GOLD + "Unable to set the Currency to: " + arg);
							player.sendMessage(ChatColor.GOLD + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Force")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						if(Main.t.isRunning()){
							Main.t.stop();
							Main.b = 1;
						}
						player.sendMessage(ChatColor.GOLD + "Forcing a Reaction Test!");
						try{
							loadRnum.dNum();
							loadRnum.dNum1();
							plugin.sendMessage(message);
							RTestPlayerListener.enable();
						}catch(IOException g){
							player.sendMessage(ChatColor.GOLD + "Unable to Force a Reaction Test");
							player.sendMessage(ChatColor.GOLD + "Check Server Log for more info!");
							g.printStackTrace();
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Stop")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						if(Main.t.isRunning()){
							RTestPlayerListener.disable();
							Main.t.stop();
							player.sendMessage(ChatColor.GOLD + "Reactions Tests are now disabled!");
						}else{
							player.sendMessage(ChatColor.GOLD + "Reactions Tests are already disabled!");
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Start")){
					Player player = (Player)sender;
					if(player.hasPermission("RTest.Admin")){
						if(Main.t.isRunning()){
							player.sendMessage(ChatColor.GOLD + "Reaction Tests are already enabled!");
						}else{
							Main.t.start();
							player.sendMessage(ChatColor.GOLD + "Reaction Tests are now enabled!");
						}
					}else{
						player.sendMessage(ChatColor.GOLD + "You don't have Permission to access this command.");	
					}
				}
			}
			return true;
		}
		return false;
	}
}