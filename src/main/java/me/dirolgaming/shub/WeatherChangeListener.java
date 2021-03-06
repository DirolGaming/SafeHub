package me.dirolgaming.shub;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener
        implements Listener
{
    private main plugin;

    public WeatherChangeListener(main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event)
    {
        if ((event.getWorld().equals(Bukkit.getWorld(this.plugin.getConfig().getString("world.name")))) &&
                (this.plugin.getConfig().getBoolean("disable-weather")) && (event.toWeatherState())) {
            event.setCancelled(true);
        }
    }
}