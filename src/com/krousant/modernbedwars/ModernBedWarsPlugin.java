package com.krousant.modernbedwars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ModernBedWarsPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {}

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
