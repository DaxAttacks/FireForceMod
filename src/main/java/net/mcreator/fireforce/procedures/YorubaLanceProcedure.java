package net.mcreator.fireforce.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class YorubaLanceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure YorubaLance!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).IgnitionAbilityTHIRDtype == 3) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).cooldown3 == 0) {
			}
		}
	}
}
