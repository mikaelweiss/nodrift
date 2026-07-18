package dev.mikael.nodrift;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class NoDriftConfig {
	private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("nodrift.json");
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final double DEFAULT_DRIFT = 0.4;

	private static double driftStrength = DEFAULT_DRIFT;

	private NoDriftConfig() {
	}

	public static double driftStrength() {
		return driftStrength;
	}

	public static void setDriftStrength(double value) {
		driftStrength = Math.clamp(value, 0.0, 1.0);
	}

	public static void load() {
		if (!Files.exists(PATH)) {
			save();
			return;
		}
		try {
			JsonObject json = GSON.fromJson(Files.readString(PATH), JsonObject.class);
			if (json != null && json.has("driftStrength")) {
				setDriftStrength(json.get("driftStrength").getAsDouble());
			}
		} catch (IOException | RuntimeException e) {
			NoDriftClient.LOGGER.warn("Could not read {}, using defaults", PATH, e);
		}
	}

	public static void save() {
		JsonObject json = new JsonObject();
		json.addProperty("driftStrength", driftStrength);
		try {
			Files.writeString(PATH, GSON.toJson(json));
		} catch (IOException e) {
			NoDriftClient.LOGGER.warn("Could not write {}", PATH, e);
		}
	}
}
