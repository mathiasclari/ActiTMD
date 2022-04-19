package net.acticraft.plugins.acticrafttmd.MinableBlocks;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.List;

import static net.acticraft.plugins.acticrafttmd.MinableBlocks.BlockReplacementEngine.checkBlockReplace;

public class BlockBreakListener implements Listener {

    /** Do not use this example its made just to explain how to use the BlockReplacementEngine.
     * checkBlockReplace(
     *                 e, -> block break event passed through
     *                 Material.IRON_AXE, -> tool/item required to break block with, can be list of materials or air if you want them to be able to use anything
     *                 e.getBlock().getType() == Material.SPRUCE_WOOD && resourceWorlds.contains(e.getBlock().getWorld().getName()),  -> requirement for event to happen, in this case: block = iron ore
     *                 true, -> requirements for replacing block, checked when it's time to replace
     *                 Material.BEDROCK, -> block to replace with temporarily, null = no temporary replacement
     *                 Sound.UI_LOOM_TAKE_RESULT, -> sound to play on block break
     *                 300, -> delay before replacing block, in seconds
     *                 Material.SPRUCE_WOOD, -> block to replace with when time is up. If this isn't a block then it'll be replaced with air
     *                 null, -> extra block data for the final replacement block
     *                 null -> block/list of blocks the block has to be when it's time to replace. If this is null or empty list then it has to be the temporary replacement block
     *         );
     *
     *
     */

    //List of worlds where blocks can be mined
    List<String> resourceWorlds = Arrays.asList("farm_world", "forest_world", "mountain_world", "desert_world", "island_world", "skyblock_world","world");

    @EventHandler
    public void onResourceWorlds(BlockBreakEvent e) {

        if (e.getPlayer().getGameMode() == GameMode.CREATIVE) return; // creative mode bypass



        checkBlockReplace(
                e,
                Material.IRON_AXE,
                e.getBlock().getType() == Material.SPRUCE_WOOD && resourceWorlds.contains(e.getBlock().getWorld().getName()),
                true,
                Material.BEDROCK,
                Sound.UI_LOOM_TAKE_RESULT,
                300,
                Material.SPRUCE_WOOD,
                null,
                null
        );
        //Food
        checkBlockReplace(
                e,
                Material.AIR,
                e.getBlock().getType() == Material.WHEAT && resourceWorlds.contains(e.getBlock().getWorld().getName()),
                true,
                null,
                Sound.BLOCK_AMETHYST_BLOCK_BREAK,
                120,
                Material.WHEAT,
                e.getBlock().getBlockData(),
                Arrays.asList(Material.AIR, Material.WHEAT)
        );

    }
}
