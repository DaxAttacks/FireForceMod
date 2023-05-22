
package net.mcreator.fireforce.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.fireforce.procedures.OxygenMaxProcedure;
import net.mcreator.fireforce.procedures.Oxygen80percentProcedure;
import net.mcreator.fireforce.procedures.Oxygen60percentProcedure;
import net.mcreator.fireforce.procedures.Oxygen40percentProcedure;
import net.mcreator.fireforce.procedures.Oxygen20percentProcedure;
import net.mcreator.fireforce.procedures.Oxygen0Procedure;
import net.mcreator.fireforce.procedures.Overheat5Procedure;
import net.mcreator.fireforce.procedures.Overheat4Procedure;
import net.mcreator.fireforce.procedures.Overheat3Procedure;
import net.mcreator.fireforce.procedures.Overheat2Procedure;
import net.mcreator.fireforce.procedures.Overheat1Procedure;
import net.mcreator.fireforce.procedures.Genhigherthan1Procedure;
import net.mcreator.fireforce.FireforceModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class OxygenBarOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (Genhigherthan1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				if (OxygenMaxProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen100percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Oxygen80percentProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen80percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Oxygen60percentProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen60percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Oxygen40percentProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen40percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Oxygen20percentProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen20percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Oxygen0Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/oxygen0.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Overheat1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/overheat20percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Overheat2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/overheat40percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Overheat3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/overheat60percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Overheat4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/overheat80percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				if (Overheat5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager()
							.bindTexture(new ResourceLocation("fireforce:textures/screens/overheat100percent.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -243, posY + 41, 0, 0, 112, 112, 112, 112);
				}
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireforceModVariables.PlayerVariables())).tickspassed) + "",
						posX + 81, posY + -67, -52429);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
