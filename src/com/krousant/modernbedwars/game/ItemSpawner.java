package com.krousant.modernbedwars.game;

import com.krousant.modernbedwars.ModernBedWarsPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class ItemSpawner
{

    private final LinkedList<SpawnableItem> SPAWNABLE_ITEMS = new LinkedList<>();
    private World world;
    private Location location;
    private boolean isActive;

    private BukkitTask spawnerBukkitTask;
    private final Runnable SPAWNER_RUNNABLE = ()->
    {
        for(SpawnableItem spawnableItem : SPAWNABLE_ITEMS)
        {
            if(spawnableItem.ticksUntilSpawn == 0)
            {
                spawnItem(spawnableItem);
                spawnableItem.ticksUntilSpawn = spawnableItem.spawnInterval;
            }
            else --spawnableItem.ticksUntilSpawn;
        }
    };

    public ItemSpawner(@NotNull World world, @NotNull Location location)
    {
        this.world = world;
        this.location = location;
    }


    public void addItem(@NotNull ItemStack item, int spawnIntervalInTicks)
    {
        SPAWNABLE_ITEMS.add(new SpawnableItem(item, spawnIntervalInTicks));
    }

    public void addItem(@NotNull SpawnableItem spawnableItem)
    {
        SPAWNABLE_ITEMS.add(spawnableItem);
    }

    public void removeItem(@NotNull SpawnableItem spawnableItem)
    {
        SPAWNABLE_ITEMS.remove(spawnableItem);
    }

    public void activate()
    {
        this.isActive = true;
        spawnerBukkitTask = Bukkit.getScheduler()
                .runTaskTimer(ModernBedWarsPlugin.plugin(), SPAWNER_RUNNABLE, 0, 0);
    }

    public void deactivate()
    {
        if(!isActive) return;

        isActive = false;
        spawnerBukkitTask.cancel();
        spawnerBukkitTask = null;
    }

    //TODO Make items not de-spawn
    public void spawnItem(@NotNull SpawnableItem spawnableItem)
    {
        Item item = this.world.dropItem(this.location, spawnableItem.ITEM);
        item.setInvulnerable(true);
    }


    public static class SpawnableItem
    {
        public static final int DEFAULT_SPAWN_INTERVAL = 20;

        private final ItemStack ITEM;
        //Spawn Rate is in ticks
        private int spawnInterval;
        private int ticksUntilSpawn;

        public SpawnableItem(@NotNull ItemStack item, int spawnInterval)
        {
            ITEM = item;
            this.spawnInterval = (spawnInterval < 1) ? 1 : spawnInterval;
            ticksUntilSpawn = this.spawnInterval;
        }

        public ItemStack item()
        {
            return this.ITEM;
        }
    }
}
