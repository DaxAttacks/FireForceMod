package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.item.HellfireitemItem;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

public class HellfireEOnEntityTickUpdateProcedure {
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
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure HellfireEOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FireforceMod.LOGGER.warn("Failed to load dependency x for procedure HellfireEOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FireforceMod.LOGGER.warn("Failed to load dependency y for procedure HellfireEOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FireforceMod.LOGGER.warn("Failed to load dependency z for procedure HellfireEOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure HellfireEOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).devilsflightlevel == 6) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(HellfireitemItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (7 / 2d), y - (7 / 2d), z - (7 / 2d), x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FireforceModVariables.PlayerVariables())).devilsflightlevel < 6) {
						if (entityiterator instanceof LivingEntity) {
							((LivingEntity) entityiterator).attackEntityFrom(new DamageSource("Hellfire").setDamageBypassesArmor(), (float) 17);
						}
						entityiterator.setFire((int) 5);
					}
				}
			}
		}
	}
}
