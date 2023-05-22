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

public class VoltagenovaPlayerTickProcedure {
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
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure VoltagenovaPlayerTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 == 0) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel == 6) {
				{
					double _setval = 0;
					entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.voltagenovastage = _setval;
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
						capability.voltagenovatime = _setval;
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
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 1) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 1, (false), (false)));
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 100) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 10) {
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
											.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 10);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FireOxygen = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.voltagenovatime = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
									{
										double _setval = 2;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovastage = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 200) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.FireOxygen = _setval;
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
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
										{
											double _setval = 0;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovatime = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = 2;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovastage = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 2) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 2, (false), (false)));
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 200) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen <= (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygenMax) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= (entity
										.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 200) {
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
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.voltagenovatime = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
									{
										double _setval = 3;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovastage = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 200) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.FireOxygen = _setval;
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
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
										{
											double _setval = 3;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovastage = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = 0;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovatime = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 3) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 2, (false), (false)));
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 300) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 30) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 300) {
								{
									double _setval = 0;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.tickspassed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 30);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FireOxygen = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.voltagenovatime = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
									{
										double _setval = 4;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovastage = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 300) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.FireOxygen = _setval;
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
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
										{
											double _setval = 0;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovatime = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = 4;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovastage = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 4) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 4, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 3, (false), (false)));
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 400) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 40) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 400) {
								{
									double _setval = 0;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.tickspassed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 40);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FireOxygen = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.voltagenovatime = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
									{
										double _setval = 5;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovastage = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 400) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.FireOxygen = _setval;
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
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
										{
											double _setval = 5;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovastage = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = 0;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovatime = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 5) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 5, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 3, (false), (false)));
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 500) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= (entity
									.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen * 0.15) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 500) {
								{
									double _setval = 0;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.tickspassed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen
											- (entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen * 0.15);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FireOxygen = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.voltagenovatime = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).tickspassed >= 500) {
									{
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.FireOxygen = _setval;
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
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime + 1);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovatime = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).voltagenovatime >= 4) {
										{
											double _setval = 0;
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.voltagenovatime = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedforfirexp >= 340) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage >= 1) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 0) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp0 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 1) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp1 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 2) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp2 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 3) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp3 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp3 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 4) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp4 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp4 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 5) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp5 + 1);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp5 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
