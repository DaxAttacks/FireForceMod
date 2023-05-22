package net.mcreator.fireforce.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class CustomeyesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Customeyes!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getDisplayName().getString()).equals("Ozmenos_Xarmenos")) {
			{
				boolean _setval = (true);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customeyesactive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getDisplayName().getString()).equals("_Foily")) {
			{
				boolean _setval = (true);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customeyesactive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getDisplayName().getString()).equals("Dev")) {
			{
				boolean _setval = (true);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customeyesactive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getDisplayName().getString()).equals("DarknessDxD")) {
			{
				boolean _setval = (true);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customeyesactive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
