package net.mcreator.fireforce.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.entity.SbEntity;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class YorubaLance0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure YorubaLance0!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure YorubaLance0!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure YorubaLance0!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure YorubaLance0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure YorubaLance0!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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
				{
					boolean _setval = (true);
					entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.YorubaBlacksmithactive = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getRidingEntity()) == ((Entity) world
						.getEntitiesWithinAABB(SbEntity.CustomEntity.class,
								new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 60) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 60);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Yoruba Lance"), (true));
							}
							{
								double _setval = 1;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.cooldown3 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
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
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel + 1);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOverheatlevel = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 1;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.cooldown3 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You are overheating"), (true));
							}
						} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel >= 6) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("You have completely overheated and developed Tephrosis"), (false));
							}
						}
					}
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 0) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 4);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp0 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 1) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp1 + 6);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 2) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp2 + 7);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 3) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp3 + 9);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp3 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 4) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp4 + 11);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp4 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 5) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp5 + 13);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firepowerxp5 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
