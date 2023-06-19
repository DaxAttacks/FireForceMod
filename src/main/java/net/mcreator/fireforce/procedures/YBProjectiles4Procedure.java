package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

public class YBProjectiles4Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure YBProjectiles4!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure YBProjectiles4!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure YBProjectiles4!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure YBProjectiles4!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure YBProjectiles4!");
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
		double yknockback = 0;
		double zknockback = 0;
		double xknockback = 0;
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).YorubaBlacksmithactive == true) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).FirePower == 4) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).pressofdeath == false) {
					radius = (MathHelper.nextDouble(new Random(), -5, 5));
					X = (x + Math.sin(Math.toRadians(entity.rotationYaw + 180)) * 1 + Math.sin(Math.toRadians(entity.rotationYaw + 90)) * radius);
					Y = (y + 1.5 + Math.sin(Math.toRadians(entity.rotationPitch + MathHelper.nextDouble(new Random(), -15, 15))) * (-1));
					Z = (z + Math.cos(Math.toRadians(entity.rotationYaw)) * 1 + Math.cos(Math.toRadians(entity.rotationYaw + 90)) * radius);
					rad = Math.toRadians(entity.rotationYaw);
					dis = 0.1;
					rad_now = Math.toRadians(entity.rotationYaw);
					for (int index0 = 0; index0 < (int) (36); index0++) {
						xPos = (X + Math.cos(rad_now) * Math.cos(rad) * dis);
						yPos = (Y + Math.sin(rad_now) * dis);
						zPos = (Z + Math.cos(rad_now) * Math.sin(rad) * dis);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(xPos, yPos, zPos), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:flame ~ ~ ~");
						}
						rad_now = (rad_now + Math.toRadians(10));
					}
					dis = 0;
					for (int index1 = 0; index1 < (int) (100); index1++) {
						xPos = (X + Math.sin(Math.toRadians(entity.rotationYaw + 180)) * dis);
						yPos = (Y + Math.sin(Math.toRadians(entity.rotationPitch)) * dis * (-1));
						zPos = (Z + Math.cos(Math.toRadians(entity.rotationYaw)) * dis);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(xPos, yPos, zPos), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"particle minecraft:flame ~ ~ ~");
						}
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(xPos - (1 / 2d), yPos - (1 / 2d),
									zPos - (1 / 2d), xPos + (1 / 2d), yPos + (1 / 2d), zPos + (1 / 2d)), null).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(xPos, yPos, zPos)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entity == entityiterator)) {
									if (entityiterator instanceof LivingEntity) {
										entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 6.5);
										xknockback = (entityiterator.getPosX() - entity.getPosX());
										yknockback = (entityiterator.getPosY() - entity.getPosY());
										zknockback = (entityiterator.getPosZ() - entity.getPosZ());
										dis = (Math.abs(xknockback) + Math.abs(yknockback) + Math.abs(zknockback));
										if (dis != 0) {
											xknockback = ((xknockback / dis) * 3);
											yknockback = Math.min((yknockback / dis) * 3, 2);
											zknockback = ((zknockback / dis) * 3);
										} else {
											xknockback = 0;
											yknockback = 0;
											zknockback = 0;
										}
										entityiterator.setMotion(xknockback, yknockback, zknockback);
									}
								}
							}
						}
						dis = (dis + 0.5);
					}
				}
			}
		}
	}
}
