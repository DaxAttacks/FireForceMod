package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;
import java.util.HashMap;

public class FlamingInkbuffProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure FlamingInkbuff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel == 6) {
			{
				double _setval = 0;
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cooldown1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tickspassed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FlamingInkActive == true) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1.5, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 1, (int) 1, (false), (false)));
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 100) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= (entity
								.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 100) {
							{
								double _setval = 0;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.tickspassed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen < (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20) {
						{
							boolean _setval = (false);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FlamingInkActive = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tickspassed = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tickspassedtattoshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
