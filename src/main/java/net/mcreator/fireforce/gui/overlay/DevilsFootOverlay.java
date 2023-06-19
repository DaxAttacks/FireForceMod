
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

import net.mcreator.fireforce.procedures.ShowDFProcedure;
import net.mcreator.fireforce.procedures.Lock3Procedure;
import net.mcreator.fireforce.procedures.Lock2Procedure;
import net.mcreator.fireforce.procedures.Lock1Procedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class DevilsFootOverlay {
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
			if (ShowDFProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/ability1.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 194, posY + 57, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/ability1.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 171, posY + 57, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/ability1.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 148, posY + 57, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/ability1.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 171, posY + 34, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/rapid.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 171, posY + 34, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/flight.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 148, posY + 57, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/hell_fire.png.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 198, posY + 61, 0, 0, 14, 14, 14, 14);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/devilsfootprint.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 171, posY + 57, 0, 0, 22, 22, 22, 22);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/line.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 165, posY + 64, 0, 0, 8, 8, 8, 8);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/line.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 188, posY + 64, 0, 0, 8, 8, 8, 8);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/line2.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 178, posY + 51, 0, 0, 8, 8, 8, 8);

				if (Lock1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/locked.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 152, posY + 61, 0, 0, 14, 14, 14, 14);
				}
				if (Lock2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/locked.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 175, posY + 38, 0, 0, 14, 14, 14, 14);
				}
				if (Lock3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/locked.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 198, posY + 61, 0, 0, 14, 14, 14, 14);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
