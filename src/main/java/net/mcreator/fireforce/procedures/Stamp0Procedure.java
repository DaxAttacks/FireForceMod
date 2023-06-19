package net.mcreator.fireforce.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fireforce.item.Stamp1Item;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class Stamp0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Stamp0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Stamp0!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 60) {
			{
				double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 60);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FireOxygen = _setval;
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
			{
				boolean _setval = (true);
				entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.STAMP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("STAMP"), (false));
			}
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(Stamp1Item.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
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
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager()
									.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tp @s ^ ^1 ^5");
						}
					}
					{
						boolean _setval = (false);
						entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.STAMP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
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
									capability.STAMP2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
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
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.STAMP2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 40);
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
										double _setval = 0;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.stamp = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.STAMP = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof LivingEntity) {
										ItemStack _setstack = new ItemStack(Blocks.AIR);
										_setstack.setCount((int) 1);
										((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
										if (entity instanceof ServerPlayerEntity)
											((ServerPlayerEntity) entity).inventory.markDirty();
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 40);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 40);
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
						double _setval = 0;
						entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cooldown3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stamp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cooldown Deactivated"), (true));
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 400);
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen < 60) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Oxygen"), (true));
			}
		}
	}
}
