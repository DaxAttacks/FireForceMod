package net.mcreator.fireforce.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.item.FireArrowProjectileItem;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class FireArrorLevel0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure FireArrorLevel0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure FireArrorLevel0!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cooldown Activated"), (true));
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
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen <= (entity
								.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen * 0.05) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen > 0) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen
									- (entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen * 0.05);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FireOxygen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Arrow"), (true));
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
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 5, (int) 80, (false), (false)));
								{
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new FireArrowProjectileItem.ArrowCustomEntity(
														FireArrowProjectileItem.arrow, world);
												entityToSpawn.setShooter(shooter);
												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												entityToSpawn.setIsCritical(true);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 0, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
										projectileLevel.addEntity(_entityToSpawn);
									}
								}
								{
									double _setval = 1;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.cooldown1 = _setval;
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
												capability.firearrowactive = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cooldown is deactivated"), (false));
								}
								{
									double _setval = 0;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.cooldown1 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.firepowerxp0 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 169);
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel < 6) {
						{
							double _setval = 1;
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You are overheating"), (true));
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
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new FireArrowProjectileItem.ArrowCustomEntity(
														FireArrowProjectileItem.arrow, world);
												entityToSpawn.setShooter(shooter);
												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												entityToSpawn.setIsCritical(true);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 0, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
										projectileLevel.addEntity(_entityToSpawn);
									}
								}
								{
									double _setval = 1;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.cooldown1 = _setval;
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
												capability.firearrowactive = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cooldown is deactivated"), (false));
								}
								{
									double _setval = 0;
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.cooldown1 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 1);
									entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.firepowerxp0 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 169);
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOverheatlevel >= 6) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent("You have completely overheated and developed Tephrosis"), (false));
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
