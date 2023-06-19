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

public class FireXp2Procedure {
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
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure FireXp2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).adollacooldown == 0) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).devilsflightlevel == 0) {
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
											boolean _setval = (false);
											entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.firexpactive = _setval;
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
