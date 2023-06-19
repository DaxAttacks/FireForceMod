package net.mcreator.fireforce.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;

import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.Map;
import java.util.HashMap;

public class FlamingInkTattosProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void KleidersRenderEvent(RenderLivingEvent event) {
			Entity entity = event.getEntity();
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

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireforceMod.LOGGER.warn("Failed to load dependency entity for procedure FlamingInkTattos!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");

		// Enter the FTL code here
		Object _obj = dependencies.get("event");
		RenderLivingEvent _evt = (RenderLivingEvent) _obj;
		if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FlamingInkActive == true) {
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 10) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("fireforce:textures/entities/tatto1.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 11) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 20) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("fireforce:textures/entities/tatto3.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
										_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
										_evt.getLight());
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 21) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 30) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("fireforce:textures/entities/tatto4.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
										_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
										_evt.getLight());
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 31) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 40) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("fireforce:textures/entities/tatto5.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
										_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
										_evt.getLight());
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 41) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 50) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("fireforce:textures/entities/tatto7.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
										_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
										_evt.getLight());
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 51) {
				if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing <= 60) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("fireforce:textures/entities/tatto9.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
										_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
										_evt.getLight());
					}
				}
			}
			if ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).tickspassedtattoshowing >= 61) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("fireforce:textures/entities/tatto10.png")).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		}
	}
}
