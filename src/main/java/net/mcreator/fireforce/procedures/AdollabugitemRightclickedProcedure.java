package net.mcreator.fireforce.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.item.AdollabugitemItem;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class AdollabugitemRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure AdollabugitemRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure AdollabugitemRightclicked!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireforceMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AdollabugitemRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FireforceMod.LOGGER.warn("Failed to load dependency itemstack for procedure AdollabugitemRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (AdollabugitemItem.block == ((sourceentity instanceof LivingEntity)
				? ((LivingEntity) sourceentity).getHeldItemMainhand()
				: ItemStack.EMPTY).getItem()) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).Generation == 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 200, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("custom").setDamageBypassesArmor(), (float) 3);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 100, (int) 2, (false), (false)));
				GenerationRandomizerProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).Generation > 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 200, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("custom").setDamageBypassesArmor(), (float) 3);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 200, (int) 2, (false), (false)));
			}
		}
	}
}
