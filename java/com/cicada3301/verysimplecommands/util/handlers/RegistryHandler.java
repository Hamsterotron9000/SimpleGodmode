package com.cicada3301.verysimplecommands.util.handlers;

import com.cicada3301.verysimplecommands.commands.CommandGodmode;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class RegistryHandler {

    public static void serverRegistries(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandGodmode());
    }

}
