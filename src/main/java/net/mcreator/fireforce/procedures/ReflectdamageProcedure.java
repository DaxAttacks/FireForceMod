package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ReflectdamageProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Reflectdamage!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Reflectdamage!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Reflectdamage!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Reflectdamage!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Reflectdamage!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 1) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 4);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 2) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 6);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 3) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 8);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 4) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 10);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 5) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 12);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 6) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 15);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 7) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 17);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 8) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 19);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).reflect == 9) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).reflectactive == false) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Heat Reflect").setDamageBypassesArmor(), (float) 20);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		}
	}
}
