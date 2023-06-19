package net.mcreator.fireforce.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class Flight0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Flight0!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Flight0!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Flight0!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Flight0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Flight0!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 20) {
			{
				double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FireOxygen = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 1;
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.devilsflightlevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 10, (int) 1, (false), (false)));
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fireforce:firestartflight")),
						SoundCategory.PLAYERS, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fireforce:firestartflight")),
						SoundCategory.PLAYERS, (float) 1, (float) 1, false);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen <= 20) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Oxygen"), (true));
			}
		}
	}
}
