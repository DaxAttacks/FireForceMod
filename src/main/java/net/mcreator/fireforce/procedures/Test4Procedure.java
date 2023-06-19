package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class Test4Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure Test4!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure Test4!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure Test4!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure Test4!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure Test4!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double zPos = 0;
		double yPos = 0;
		double rad = 0;
		double rad_now = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double xPos = 0;
		double radius = 0;
		double dis = 0;
		double floatR = 0;
		double loop = 0;
		double floatX = 0;
		double floatY = 0;
		double floatZ = 0;
		if (((Entity) world
				.getEntitiesWithinAABB(MobEntity.class,
						new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) {
			if (entity.getPosZ() <= ((Entity) world
					.getEntitiesWithinAABB(MobEntity.class,
							new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosZ()) {
				entity.rotationYaw = (float) ((Math.toDegrees(Math.atan((((Entity) world
						.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosX() - entity.getPosX())
						/ (((Entity) world.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosZ() - entity.getPosZ())))
						* (-1)));
				entity.setRenderYawOffset(entity.rotationYaw);
				entity.prevRotationYaw = entity.rotationYaw;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
					((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
					((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
				}
				entity.rotationPitch = (float) ((Math.toDegrees(Math.atan(((((Entity) world
						.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y,
								z))
						.findFirst().orElse(null)).getPosY() - entity
								.getPosY())
						- 1)
						/ Math.sqrt(Math.pow(((Entity) world.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y,
										z))
								.findFirst().orElse(null)).getPosX() - entity
										.getPosX(),
								2)
								+ Math.pow(((Entity) world.getEntitiesWithinAABB(MobEntity.class,
										new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosZ() - entity.getPosZ(), 2))))
						* (-1)));
			} else {
				entity.rotationYaw = (float) (((Math.toDegrees(Math.atan((((Entity) world
						.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosX() - entity.getPosX())
						/ (((Entity) world.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosZ() - entity.getPosZ())))
						+ 180) * (-1)));
				entity.setRenderYawOffset(entity.rotationYaw);
				entity.prevRotationYaw = entity.rotationYaw;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
					((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
					((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
				}
				entity.rotationPitch = (float) ((Math.toDegrees(Math.atan(((((Entity) world
						.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y,
								z))
						.findFirst().orElse(null)).getPosY() - entity
								.getPosY())
						- 1)
						/ Math.sqrt(Math.pow(((Entity) world.getEntitiesWithinAABB(MobEntity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y,
										z))
								.findFirst().orElse(null)).getPosX() - entity
										.getPosX(),
								2)
								+ Math.pow(((Entity) world.getEntitiesWithinAABB(MobEntity.class,
										new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPosZ() - entity.getPosZ(), 2))))
						* (-1)));
			}
		}
	}
}
