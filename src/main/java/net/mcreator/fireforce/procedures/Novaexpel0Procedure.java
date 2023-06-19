package net.mcreator.fireforce.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.item.VoltagaNovaExpelItem;
import net.mcreator.fireforce.item.NovaExpelstage2Item;
import net.mcreator.fireforce.item.NE5EntityItem;
import net.mcreator.fireforce.item.NE4EntityItem;
import net.mcreator.fireforce.item.NE3EntityItem;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class Novaexpel0Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Novaexpel0!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Novaexpel0!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Novaexpel0!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Novaexpel0!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Novaexpel0!");
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
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 1) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 5) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 5);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nova Expel"), (true));
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
													AbstractArrowEntity entityToSpawn = new VoltagaNovaExpelItem.ArrowCustomEntity(
															VoltagaNovaExpelItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setIsCritical(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 0, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1, false);
									}
									{
										double _setval = 1;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.coolsdown2 = _setval;
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
									{
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovaactive = _setval;
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
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.novaexpel = _setval;
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
											capability.coolsdown2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 5);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firepowerxp0 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
						}
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 2) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 10) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 10);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nova Expel"), (true));
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
													AbstractArrowEntity entityToSpawn = new NovaExpelstage2Item.ArrowCustomEntity(
															NovaExpelstage2Item.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setIsCritical(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 0, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1, false);
									}
									{
										double _setval = 1;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.coolsdown2 = _setval;
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
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.novaexpel = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												boolean _setval = (false);
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.voltagenovaactive = _setval;
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
											capability.coolsdown2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 5);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firepowerxp0 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
						}
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 3) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 15) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 15);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nova Expel"), (true));
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
													AbstractArrowEntity entityToSpawn = new NE3EntityItem.ArrowCustomEntity(NE3EntityItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setIsCritical(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 0, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 4,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1, false);
									}
									{
										double _setval = 1;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.coolsdown2 = _setval;
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
									{
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovaactive = _setval;
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
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.novaexpel = _setval;
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
											capability.coolsdown2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 5);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firepowerxp0 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
						}
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 4) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 20) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 20);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nova Expel"), (true));
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
													AbstractArrowEntity entityToSpawn = new NE4EntityItem.ArrowCustomEntity(NE4EntityItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setIsCritical(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 0, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1, false);
									}
									{
										double _setval = 1;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.coolsdown2 = _setval;
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
									{
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovaactive = _setval;
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
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.novaexpel = _setval;
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
											capability.coolsdown2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 5);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firepowerxp0 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
						}
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).voltagenovastage == 5) {
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 25) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 0) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen - 25);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FireOxygen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nova Expel"), (true));
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
													AbstractArrowEntity entityToSpawn = new NE5EntityItem.ArrowCustomEntity(NE5EntityItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setIsCritical(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 0, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
													(float) 5.5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("fireforce:novaexpelsound")),
												SoundCategory.PLAYERS, (float) 1, (float) 1, false);
									}
									{
										double _setval = 1;
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.coolsdown2 = _setval;
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
									{
										boolean _setval = (false);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.voltagenovaactive = _setval;
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
												entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.novaexpel = _setval;
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
											capability.coolsdown2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireforceModVariables.PlayerVariables())).firepowerxp0 + 5);
										entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firepowerxp0 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
