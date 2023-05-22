package net.mcreator.fireforce.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class FireArrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure FireArrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure FireArrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure FireArrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure FireArrow!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure FireArrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).IgnitionAbilityTHIRDtype == 1) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).cooldown1 == 0) {
				{
					double _setval = 1;
					entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cooldown1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firearrowactive = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).pressofdeath == true) {
					FireArrowPressofDeathPProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 0) {
					FireArrorLevel0Procedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 1) {
					FireArrowLevel1PProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 2) {
					FireArrowLevel2PProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 3) {
					FireArrowLevel3PProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 4) {
					FireArrowLevel4PProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 5) {
					FireArrowLevel5PProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"effect give @s minecraft:slowness 1 20 true");
						}
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("fireforce:firearrowsound")),
										SoundCategory.PLAYERS, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				}
			}
		}
	}
}
