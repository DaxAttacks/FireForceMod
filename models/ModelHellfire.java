// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelHellfire extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public ModelHellfire() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-14.9286F, -18.5714F, 13.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3927F);
		cube_r1.setTextureOffset(0, 46).addBox(-12.75F, 22.5F, -15.75F, 21.5F, 0.5F, 21.5F, 0.0F, false);
		cube_r1.setTextureOffset(66, 24).addBox(-12.75F, -1.5F, -15.75F, 21.5F, 0.5F, 21.5F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-12.6786F, -13.0714F, 13.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3927F);
		cube_r2.setTextureOffset(92, 93).addBox(-12.75F, -6.75F, 6.0F, 21.5F, 23.5F, 0.5F, 0.0F, false);
		cube_r2.setTextureOffset(46, 93).addBox(-12.75F, -6.75F, -16.5F, 21.5F, 23.5F, 0.5F, 0.0F, false);
		cube_r2.setTextureOffset(66, 47).addBox(9.0F, -6.75F, -15.75F, 0.5F, 23.5F, 21.5F, 0.0F, false);
		cube_r2.setTextureOffset(66, 15).addBox(2.25F, 8.0F, -7.75F, 5.5F, 0.5F, 5.5F, 0.0F, false);
		cube_r2.setTextureOffset(0, 69).addBox(-13.5F, -6.75F, -15.75F, 0.5F, 23.5F, 21.5F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-13.0F, -7.0F, -16.0F, 22.0F, 24.0F, 22.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-12.3979F, -12.2871F, 12.7F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3927F);
		cube_r3.setTextureOffset(24, 69).addBox(-12.22F, -17.066F, -0.416F, 5.64F, 9.426F, 6.016F, 0.0F, false);
		cube_r3.setTextureOffset(66, 0).addBox(-12.22F, -17.066F, -15.416F, 5.64F, 9.426F, 6.016F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}