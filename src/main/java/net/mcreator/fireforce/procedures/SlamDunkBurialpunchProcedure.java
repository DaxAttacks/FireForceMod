package net.mcreator.fireforce.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;
import java.util.HashMap;

public class SlamDunkBurialpunchProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure SlamDunkBurialpunch!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure SlamDunkBurialpunch!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure SlamDunkBurialpunch!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure SlamDunkBurialpunch!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure SlamDunkBurialpunch!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireforceMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SlamDunkBurialpunch!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 0) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 13);
				}
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.setFire((int) 5);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 1) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 15);
				}
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.setFire((int) 5);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 2) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 17);
				}
				entity.setFire((int) 5);
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 3) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 19);
				}
				entity.setFire((int) 5);
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 4) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 23);
				}
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.setFire((int) 5);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 5) {
			if ((sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).SlamDunkBurialActive == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("Slam Dunk Burial").setDamageBypassesArmor(), (float) 26);
				}
				{
					boolean _setval = (false);
					sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SlamDunkBurialActive = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				entity.setFire((int) 5);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
							SoundCategory.PLAYERS, (float) 1, (float) 1, false);
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
							double _setval = 0;
							sourceentity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.cooldown3 = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 400);
			}
		}
	}
}
