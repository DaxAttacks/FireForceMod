package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

public class Test1Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
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

	}
}
