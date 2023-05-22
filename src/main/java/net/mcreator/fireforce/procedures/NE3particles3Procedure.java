package net.mcreator.fireforce.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;

import net.mcreator.fireforce.FireforceMod;

import java.util.Map;

public class NE3particles3Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireforceMod.LOGGER.warn("Failed to load dependency world for procedure NE3particles3!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				FireforceMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure NE3particles3!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		if ((immediatesourceentity.getHorizontalFacing()) == Direction.WEST) {
			immediatesourceentity.setNoGravity((true));
			{
				Entity _ent = immediatesourceentity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"particle minecraft:flame ^ ^2 ^ 3 0.6 0.5 999 999 force");
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
					if (!immediatesourceentity.world.isRemote())
						immediatesourceentity.remove();
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 80);
		} else if ((immediatesourceentity.getHorizontalFacing()) == Direction.EAST) {
			immediatesourceentity.setNoGravity((true));
			{
				Entity _ent = immediatesourceentity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"particle minecraft:flame ^ ^2 ^ 3 0.6 0.5 999 999 force");
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
					if (!immediatesourceentity.world.isRemote())
						immediatesourceentity.remove();
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 80);
		} else if ((immediatesourceentity.getHorizontalFacing()) == Direction.NORTH) {
			immediatesourceentity.setNoGravity((true));
			{
				Entity _ent = immediatesourceentity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"particle minecraft:flame ^ ^2 ^ 0.5 0.6 3 999 999 force");
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
					if (!immediatesourceentity.world.isRemote())
						immediatesourceentity.remove();
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 80);
		} else if ((immediatesourceentity.getHorizontalFacing()) == Direction.SOUTH) {
			immediatesourceentity.setNoGravity((true));
			{
				Entity _ent = immediatesourceentity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"particle minecraft:flame ^ ^2 ^ 0.5 0.6 3 999 999 force");
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
					if (!immediatesourceentity.world.isRemote())
						immediatesourceentity.remove();
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 80);
		}
	}
}
