package dev.mikael.nodrift;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoDriftClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("NoDrift");

	@Override
	public void onInitializeClient() {
		NoDriftConfig.load();
		LOGGER.info("NoDrift loaded - creative flight drift set to {}", NoDriftConfig.driftStrength());
	}
}
