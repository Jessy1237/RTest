package com.Jessy1237.RTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class Commands implements CommandExecutor{
	
	static Properties prop = RTest.prop;
	static File conf = RTest.conf;
	static String message = RTest.message;
	private RTest plugin;
	public Permission perms;
	public static String arg1;
	
	public Commands(RTest plugin){
		this.plugin = plugin;
	}
	
//Commands...Warning Many of them....!
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		perms = plugin.perms;
		if(label.equalsIgnoreCase("RTest")){
				if(args.length == 0){
					Player player = (Player)sender;
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Basic Commands:");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest - Displays This Page");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Admin - Displays all the Admin commands associated with RTest");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest About - Displays General information about RTest");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Reward - Displays the Reward for the Reaction Tests");
				}else{
					String arg0 = args[0];
				if(arg0.equalsIgnoreCase("Admin")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try{
							arg1 = args[1].toString();
						}catch(Exception e){
							arg1 = "";
						}
						 if(arg1.equals("1") || arg1.equals(null) || arg1.equals("")){
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Admin Commands 1 of 3:");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Start - Starts the timer for Reaction Tests");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Stop - Stops the time for Reaction Tests");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Force - Forces a Reaction Test to take place");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Disable - Disables RTest");
						}
						else if(arg1.equals("2")){
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Admin Commands 2 of 3:");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest CharAmountSet - Sets the Amount of Characters for the Variable");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest CurrencySet - Sets the name of the Currency for RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest ChatColorSet - Sets the color of Chat responses for RTest");
						}
						else if(arg1.equals("3")){
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Admin Commands 3 of 3:");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest CommandColorSet - Sets the color of Command responses for RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest DelaySet - Sets the delay between each Reaction Test");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest RewardSet - Sets the Reward for the Reaction Test");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest Colours - Shows the possible colours for responses!");
						}else{
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "No such Page for Admin Commands!");
						}
				}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You Don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Colours") || arg0.equalsIgnoreCase("Colors")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						int i = 0;
						String message = "";
						while(i != 16){
							message = message + ChatColor.getByCode(i) + " " + i;
								i++;
						}
						player.sendMessage(arg0 +":" + message);
					}
				}
				if(arg0.equalsIgnoreCase("About")){
					Player player = (Player)sender;
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Description:");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest is a Plugin that displays a random aplanumerical variable");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "to all the online Players, first player to type in the variable wins");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "the reward that is set in the properties file.");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Plugin Author: Jessy1237");
					player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Version: " + RTest.vernum);
				}	
				if(arg0.equalsIgnoreCase("Reward")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Member")||perms.playerHas(player, "RTest.Admin")){
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "RTest");
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "-----------------------------------");
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The Reward for winning a Reaction Test is: " + RTest.reward() + " " + RTest.Currency());
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("DelaySet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try {
							String arg = args[1].toString();
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("CommandColor", RTest.CommandColor());
							prop.put("ChatColor", RTest.ChatColor());
							prop.put("charAmount", Integer.toString(RTest.charAmount()));
							prop.put("reward", Double.toString(RTest.reward()));
							prop.put("delay", arg);
							prop.put("Currency", RTest.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The delay is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Unable to set the delay to: " + arg);
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("ChatAmountSet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("charAmount", arg);
							prop.put("reward", Double.toString(RTest.reward()));
							prop.put("delay", Integer.toString(RTest.delay()));
							prop.put("Currency", RTest.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The Character Amount is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Unable to set the Character Amount to: " + arg);
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Disable")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Disabling RTest...");
						PluginManager pm = plugin.getServer().getPluginManager();
						pm.disablePlugin(plugin);
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("CommandColorSet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try{
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("CommandColor", arg);
							prop.put("ChatColor", RTest.ChatColor());
							prop.put("charAmount", Integer.toString(RTest.charAmount()));
							prop.put("reward", Double.toString(RTest.reward()));
							prop.put("delay", Integer.toString(RTest.delay()));
							prop.put("Currency", RTest.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The Command Color is now set to: " + arg);
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
				if(arg0.equalsIgnoreCase("ChatColorSet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try{
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("CommandColor", RTest.CommandColor());
							prop.put("ChatColor", arg);
							prop.put("charAmount", Integer.toString(RTest.charAmount()));
							prop.put("reward", Double.toString(RTest.reward()));
							prop.put("delay", Integer.toString(RTest.delay()));
							prop.put("Currency", RTest.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The Chat Color is now set to: " + arg);
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
				if(arg0.equalsIgnoreCase("RewardSet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("CommandColor", RTest.CommandColor());
							prop.put("ChatColor", RTest.ChatColor());
							prop.put("charAmount", Integer.toString(RTest.charAmount()));
							prop.put("reward", arg);
							prop.put("delay", Integer.toString(RTest.delay()));
							prop.put("Currency", RTest.Currency());
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The reward is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Unable to set the reward to: " + arg);
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("CurrencySet")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						try {
							String arg = args[1];
							FileOutputStream out = new FileOutputStream(conf);
							prop.put("CommandColor", RTest.CommandColor());
							prop.put("ChatColor", RTest.ChatColor());
							prop.put("charAmount", Integer.toString(RTest.charAmount()));
							prop.put("reward", Double.toString(RTest.reward()));
							prop.put("delay", Integer.toString(RTest.delay()));
							prop.put("Currency", arg);
							prop.store(out, "delay is in milliseconds, Reward is the amount of money the winner is payed, CharAmount is the amount of characters the player has to type and Currency is the Name of the Currency of your server.");
							out.flush();
							out.close();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "The Currency is now set to: " + arg);
						} catch (IOException e) {
							String arg = args[1];
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Unable to set the Currency to: " + arg);
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Check Server Log for more info!");
							e.printStackTrace();
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Force")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						if(RTest.t.isRunning()){
							RTest.t.stop();
							RTest.b = 1;
						}
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Forcing a Reaction Test!");
						try{
							loadRnum.dNum();
							loadRnum.dNum1();
							plugin.sendMessage(message);
							RTestPlayerListener.enable();
						}catch(IOException g){
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Unable to Force a Reaction Test");
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Check Server Log for more info!");
							g.printStackTrace();
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Stop")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						if(RTest.t.isRunning()){
							RTestPlayerListener.disable();
							RTest.t.stop();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Reactions Tests are now disabled!");
						}else{
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Reactions Tests are already disabled!");
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");
					}
				}
				if(arg0.equalsIgnoreCase("Start")){
					Player player = (Player)sender;
					if(perms.playerHas(player, "RTest.Admin")){
						if(RTest.t.isRunning()){
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Reaction Tests are already enabled!");
						}else{
							RTest.t.start();
							player.sendMessage(plugin.getColour(RTest.CommandColor()) + "Reaction Tests are now enabled!");
						}
					}else{
						player.sendMessage(plugin.getColour(RTest.CommandColor()) + "You don't have Permission to access this command.");	
					}
				}
			}
			return true;
		}
		return false;
	}
}