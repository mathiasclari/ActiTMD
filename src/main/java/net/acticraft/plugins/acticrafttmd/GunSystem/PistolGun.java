package net.acticraft.plugins.acticrafttmd.GunSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PistolGun {


    public static List<Material> GunAmmo = new ArrayList<Material>();
    ItemStack PistolGun = new ItemStack(Material.COAL);

    @EventHandler
    public void PlayerShoot(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(p.getItemInHand().getType() == Material.RED_DYE) {
                if(!p.getInventory().contains(Material.COAL)){
                    p.sendMessage("You need a Pistol Ammo to shoot!!");
                    for (Player p1 : Bukkit.getOnlinePlayers()) {
                        p1.playSound(p1.getLocation(), Sound.ITEM_SPYGLASS_USE, 1F, 1F);}
                }else{
                    Entity arrow = p.getWorld().spawn(p.getLocation().add(0, 1, 0), Arrow.class);
                    arrow.setVelocity(p.getLocation().getDirection().multiply(8));

                }
            }
        }
    }

}




}