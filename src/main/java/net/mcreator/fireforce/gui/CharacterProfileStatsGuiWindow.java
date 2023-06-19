
package net.mcreator.fireforce.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.fireforce.procedures.IfadollaProcedure;
import net.mcreator.fireforce.procedures.GenInfernalProcedure;
import net.mcreator.fireforce.procedures.Gen6Procedure;
import net.mcreator.fireforce.procedures.Gen5Procedure;
import net.mcreator.fireforce.procedures.Gen4Procedure;
import net.mcreator.fireforce.procedures.Gen3Procedure;
import net.mcreator.fireforce.procedures.Gen2Procedure;
import net.mcreator.fireforce.FireforceModVariables;
import net.mcreator.fireforce.FireforceMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CharacterProfileStatsGuiWindow extends ContainerScreen<CharacterProfileStatsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CharacterProfileStatsGui.guistate;

	public CharacterProfileStatsGuiWindow(CharacterProfileStatsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 500;
		this.ySize = 500;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fireforce:textures/screens/updatedui2.png"));
		this.blit(ms, this.guiLeft + 103, this.guiTop + 121, 0, 0, 270, 270, 270, 270);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		if (GenInfernalProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Infernal", 223, 168, -16777216);
		if (Gen2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Second Generation", 203, 169, -16777216);
		if (Gen3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Third Generation", 203, 169, -16777216);
		if (Gen4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Fourth Generation", 203, 169, -16777216);
		if (Gen6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Hybrid", 229, 168, -16777216);
		if (Gen5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Demon Infernal", 208, 169, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).PlayerName) + "", 228, 155, -16777216);
		this.font.drawString(ms, "Fire Power: " + ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FirePower) + "", 239, 356, -16777216);
		this.font.drawString(ms, "Speed: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireSpeed) + "", 216, 222, -16777216);
		this.font.drawString(ms, "Oxygen Level: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireOxygen) + "", 215, 247, -16777216);
		this.font.drawString(ms, "Skill Points: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).SP) + "", 197, 183, -16777216);
		this.font.drawString(ms, "", 218, 257, -16777216);
		this.font.drawString(ms, "Health: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireHealth) + "", 215, 198, -16777216);
		if (IfadollaProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Adolla Burst: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FireforceModVariables.PlayerVariables())).adollalburstevel) + "", 217, 320, -16777216);
		this.font.drawString(ms, "Heat Resistance: " + (int) ((entity.getCapability(FireforceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireforceModVariables.PlayerVariables())).FireResistancedefense) + "", 214, 270, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 182, this.guiTop + 193, 30, 20, new StringTextComponent("+"), e -> {
			if (true) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(0, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 182, this.guiTop + 242, 30, 20, new StringTextComponent("+"), e -> {
			if (true) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(1, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 182, this.guiTop + 217, 30, 20, new StringTextComponent("+"), e -> {
			if (true) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(2, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 182, this.guiTop + 266, 30, 20, new StringTextComponent("+"), e -> {
			if (true) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(3, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 183, this.guiTop + 314, 30, 20, new StringTextComponent("+"), e -> {
			if (IfadollaProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(4, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (IfadollaProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 172, this.guiTop + 346, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				FireforceMod.PACKET_HANDLER.sendToServer(new CharacterProfileStatsGui.ButtonPressedMessage(5, x, y, z));
				CharacterProfileStatsGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
