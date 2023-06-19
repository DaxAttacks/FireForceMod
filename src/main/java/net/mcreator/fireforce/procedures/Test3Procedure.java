package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class Test3Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Test3!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Test3!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Test3!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Test3!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Test3!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double zPos = 0;
		double yPos = 0;
		double rad = 0;
		double rad_now = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double xPos = 0;
		double radius = 0;
		double dis = 0;
		double floatR = 0;
		double loop = 0;
		double floatX = 0;
		double floatY = 0;
		double floatZ = 0;
		double Line = 0;
		boolean NegativeZ = false;
		boolean NegativeX = false;
		if (Blocks.GOLD_BLOCK.asItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem()) {
			NegativeZ = (true);
			NegativeZ = (true);
			NegativeZ = (true);
			NegativeX = (true);
			zPos = 1;
			Line = 10;
			while (zPos < Line) {
				if (NegativeZ == true) {
					world.addParticle(ParticleTypes.FLAME, x, (y + 0.5), (z + zPos), 0, 0.5, 0);
				}
				if (NegativeZ == true) {
					world.addParticle(ParticleTypes.FLAME, x, (y + 0.5), (z - zPos), 0, 0.5, 0);
				}
				if (NegativeZ == true) {
					world.addParticle(ParticleTypes.FLAME, (x + zPos), (y + 0.5), z, 0, 0.5, 0);
				}
				if (NegativeX == true) {
					world.addParticle(ParticleTypes.FLAME, (x - zPos), (y + 0.5), z, 0, 0.5, 0);
					zPos = (zPos + 1);
				}
			}
		}
	}
}
