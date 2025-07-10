package com.krousant.modernbedwars;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ModernBedWarsPlugin extends JavaPlugin
{
    private static Plugin PLUGIN;
    public static Plugin plugin() {return PLUGIN;}

    @Override
    public void onEnable()
    {
        PLUGIN = Bukkit.getPluginManager().getPlugin("ModernBedWars");
    }

    @Override
    public void onDisable()
    {}


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, String[] args)
    {
        return true;
    }


}
