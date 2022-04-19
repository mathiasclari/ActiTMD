package net.acticraft.plugins.acticrafttmd.Drops;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobDrops implements Listener {

    @EventHandler
    public void ZombieDeath(EntityDeathEvent e) {
        if (e.getEntity().getType() == EntityType.ZOMBIE) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(org.bukkit.Material.ROTTEN_FLESH, 1));
            e.getEntity().getWorld().spawnParticle(Particle.FALLING_HONEY, e.getEntity().getLocation(), 50, 0, 0.9, 0, 0.1);
        }
    }
}
