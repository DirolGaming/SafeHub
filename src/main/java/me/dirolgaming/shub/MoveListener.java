package me.dirolgaming.shub;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener
        implements Listener
{
    private main plugin;

    public MoveListener(main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        if (Bukkit.getWorld(plugin.getConfig().getString("world.name")).getTime() != plugin.getConfig().getInt("time")) {
        if (plugin.getConfig().getBoolean("lock-time")) {
            Bukkit.getWorld(plugin.getConfig().getString("world.name")).setTime(plugin.getConfig().getInt("time"));
        }
    }
        if ((player.getLocation().getWorld().equals(Bukkit.getWorld(this.plugin.getConfig().getString("world.name")))) &&
                (player.getGameMode() != GameMode.CREATIVE) &&
                (player.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR) &&
                (!player.isFlying())) {
            player.setAllowFlight(true);
        }
    }

    @EventHandler
    public void onMoveTP(PlayerMoveEvent t)
    {
        Player p = t.getPlayer();
        World world = Bukkit.getWorld(plugin.getConfig().getString("world.name"));
        if ((this.plugin.getConfig().getBoolean("enable-movementYtp")) && (p.getLocation().getWorld().equals(Bukkit.getWorld(this.plugin.getConfig().getString("world.name")))) &&
                (p.getLocation().getY() == this.plugin.getConfig().getInt("cordinate-y"))) {
            p.teleport(world.getSpawnLocation());
        }
    }
}