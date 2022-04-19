package net.acticraft.plugins.acticrafttmd;

import net.acticraft.plugins.acticrafttmd.Drops.MobDrops;
import net.acticraft.plugins.acticrafttmd.MinableBlocks.BlockBreakListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class ActiCraftTMD extends JavaPlugin {

    public static ActiCraftTMD instance;

    @Override
    public void onEnable() {


        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new MobDrops(), this);

    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static ActiCraftTMD getInstance() {
        return instance;
    }
}
