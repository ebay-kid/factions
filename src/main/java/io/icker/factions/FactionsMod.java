package io.icker.factions;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.icker.factions.config.Config;
import net.fabricmc.api.ModInitializer;

import io.icker.factions.command.AutoClaimCommand;

public class FactionsMod implements ModInitializer {
	public static Logger LOGGER = LogManager.getLogger("Factions");




	@Override
	public void onInitialize() {
		LOGGER.info("Initalized Factions Mod for Minecraft v1.17");
		Config.init();

		ServerTickEvents.START_SERVER_TICK.register((startTick) -> {
			AutoClaimCommand.autoClaimLoop();
		});

	}
}
