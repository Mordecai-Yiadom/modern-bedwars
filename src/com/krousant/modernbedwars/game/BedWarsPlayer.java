package com.krousant.modernbedwars.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class BedWarsPlayer
{
    private UUID playerID;
    private BedWarsTeam team;
    private boolean isEliminated;
    private boolean isAlive;

    protected BedWarsPlayer(@NotNull Player player, @NotNull BedWarsTeam team)
    {
        this.playerID = player.getUniqueId();
    }

    public Player player()
    {
        return Bukkit.getPlayer(playerID);
    }

}
