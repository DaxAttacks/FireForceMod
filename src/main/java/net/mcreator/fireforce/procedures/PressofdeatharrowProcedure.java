package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class PressofdeatharrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Pressofdeatharrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Pressofdeatharrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Pressofdeatharrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Pressofdeatharrow!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				FireforceMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure Pressofdeatharrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		immediatesourceentity.setNoGravity((true));
		world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + immediatesourceentity.getLookVec().x), (y + immediatesourceentity.getLookVec().y),
				(z + immediatesourceentity.getLookVec().z), (immediatesourceentity.getLookVec().x), (immediatesourceentity.getLookVec().y),
				(immediatesourceentity.getLookVec().z));
	}
}
