package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;
import java.util.HashMap;

public class TIckspassed9Procedure {
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
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure TIckspassed9!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel == 0) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).hastephrosis == false) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).cooldown1 == 0) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).coolsdown2 == 0) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).cooldown3 == 0) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).cooldown4 == 0) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).cooldown5 == 0) {
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).cooldown6 == 0) {
										if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 0) {
											if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new FireforceModVariables.PlayerVariables())).FlamingInkActive == false) {
												if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen < (entity
																.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new FireforceModVariables.PlayerVariables())).FireOxygenMax) {
													{
														double _setval = ((entity
																.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new FireforceModVariables.PlayerVariables())).staminatickspassed + 1);
														entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.ifPresent(capability -> {
																	capability.staminatickspassed = _setval;
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
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel > 0) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen == 0) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).hastephrosis == false) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).cooldown1 == 0) {
							if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).coolsdown2 == 0) {
								if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).cooldown3 == 0) {
									if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).cooldown4 == 0) {
										if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).cooldown5 == 0) {
											if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new FireforceModVariables.PlayerVariables())).cooldown6 == 0) {
												{
													double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new FireforceModVariables.PlayerVariables())).overheatstaminatickspassed + 1);
													entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.overheatstaminatickspassed = _setval;
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
				}
			}
		}
	}
}
