package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Genwhenjoined40percentProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Genwhenjoined40percent!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Genwhenjoined40percent!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double Random = 0;
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).joinworldfirsttime == false) {
			if (Math.random() <= 0.4) {
				GenerationRandomizerProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if (Math.random() > 0.4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(""), (true));
				}
			}
		}
	}
}
