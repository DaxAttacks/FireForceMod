package net.mcreator.fireforce.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class Slamdunkburial0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Slamdunkburial0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Slamdunkburial0!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == false) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 75) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 75);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FireOxygen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SlamDunkBurialActive = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Slam Dunk Burial"), (true));
						}
						{
							double _setval = 1;
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen < 75) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Oxygen"), (true));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
