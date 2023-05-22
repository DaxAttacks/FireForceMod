package net.mcreator.fireforce.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class PressofdeatharrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Pressofdeatharrow!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				FireforceMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure Pressofdeatharrow!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		immediatesourceentity.setNoGravity((true));
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"particle minecraft:flame ~ ~ ~ 0 0 0.4 9999 1500 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"particle minecraft:soul_fire_flame ~ ~ ~ 0 0 0.4 9999 1500 force");
			}
		}
		entity.getPersistentData().putBoolean("firearrow", (true));
	}
}
