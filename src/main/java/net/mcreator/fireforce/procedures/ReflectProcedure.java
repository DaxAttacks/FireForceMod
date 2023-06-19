package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class ReflectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Reflect!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Reflect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Reflect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Reflect!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Reflect!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).IgnitionAbilitySECONDtype == 1) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).coolsdown2 == 0) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen >= 25) {
					{
						double _setval = 0;
						entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tickspassed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 5000) {
						{
							double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 5000);
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.heatabsorbed = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 9;
							entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.reflect = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						Reflect0Procedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 2500) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 5000) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 2500);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 8;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 1200) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 2500) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 1200);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 7;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 700) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 1200) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 700);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 6;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 320) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 700) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 320);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 5;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 160) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 320) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 160);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 4;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 80) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 160) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 80);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 3;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 40) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 80) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 40);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 2;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed >= 20) {
						if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 40) {
							{
								double _setval = ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed - 20);
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.heatabsorbed = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 1;
								entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.reflect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							Reflect0Procedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).heatabsorbed < 20) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Heat Absorb"), (false));
						}
					}
				} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen < 25) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Oxygen"), (false));
					}
				}
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).coolsdown2 == 1) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cooldown Active"), (false));
				}
			}
		}
	}
}
