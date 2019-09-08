package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandWeather extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "weather";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.weather.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 1 || array.length > 2) {
            throw new ExceptionUsage("commands.weather.usage", new Object[0]);
        }
        int thunderDuration = (300 + new Random().nextInt(600)) * 20;
        if (array.length >= 2) {
            thunderDuration = CommandAbstract.a(commandListener, array[1], 1, 1000000) * 20;
        }
        final WorldData worldData = MinecraftServer.getServer().worldServer[0].getWorldData();
        if ("clear".equalsIgnoreCase(array[0])) {
            worldData.setWeatherDuration(0);
            worldData.setThunderDuration(0);
            worldData.setStorm(false);
            worldData.setThundering(false);
            CommandAbstract.a(commandListener, this, "commands.weather.clear", new Object[0]);
        }
        else if ("rain".equalsIgnoreCase(array[0])) {
            worldData.setWeatherDuration(thunderDuration);
            worldData.setStorm(true);
            worldData.setThundering(false);
            CommandAbstract.a(commandListener, this, "commands.weather.rain", new Object[0]);
        }
        else {
            if (!"thunder".equalsIgnoreCase(array[0])) {
                throw new ExceptionUsage("commands.weather.usage", new Object[0]);
            }
            worldData.setWeatherDuration(thunderDuration);
            worldData.setThunderDuration(thunderDuration);
            worldData.setStorm(true);
            worldData.setThundering(true);
            CommandAbstract.a(commandListener, this, "commands.weather.thunder", new Object[0]);
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "clear", "rain", "thunder");
        }
        return null;
    }
}
