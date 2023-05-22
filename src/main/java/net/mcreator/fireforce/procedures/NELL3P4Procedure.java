package net.mcreator.fireforce.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class NELL3P4Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure NELL3P4!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).attackEntityFrom(new DamageSource("Nova Expel").setDamageBypassesArmor(), (float) 15.5);
		}
	}
}
