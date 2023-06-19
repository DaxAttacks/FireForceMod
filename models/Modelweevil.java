// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelweevil extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer l_leg_1;
	private final ModelRenderer l_leg_2;
	private final ModelRenderer l_leg_3;
	private final ModelRenderer r_leg_1;
	private final ModelRenderer r_leg_2;
	private final ModelRenderer r_leg_3;
	private final ModelRenderer main_body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer l_antenna;
	private final ModelRenderer r_antenna;

	public Modelweevil() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 20.0F, -3.0F);

		l_leg_1 = new ModelRenderer(this);
		l_leg_1.setRotationPoint(4.5F, 2.0F, 2.0F);
		body.addChild(l_leg_1);
		l_leg_1.setTextureOffset(29, 5).addBox(0.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		l_leg_2 = new ModelRenderer(this);
		l_leg_2.setRotationPoint(4.5F, 2.0F, 5.0F);
		body.addChild(l_leg_2);
		l_leg_2.setTextureOffset(29, 5).addBox(0.0F, -3.0F, 1.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		l_leg_3 = new ModelRenderer(this);
		l_leg_3.setRotationPoint(4.5F, 2.0F, 8.0F);
		body.addChild(l_leg_3);
		l_leg_3.setTextureOffset(29, 5).addBox(0.0F, -3.0F, 2.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		r_leg_1 = new ModelRenderer(this);
		r_leg_1.setRotationPoint(-4.5F, 2.0F, 2.0F);
		body.addChild(r_leg_1);
		r_leg_1.setTextureOffset(20, 22).addBox(-5.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		r_leg_2 = new ModelRenderer(this);
		r_leg_2.setRotationPoint(-4.5F, 2.0F, 5.0F);
		body.addChild(r_leg_2);
		r_leg_2.setTextureOffset(20, 22).addBox(-5.0F, -3.0F, 1.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		r_leg_3 = new ModelRenderer(this);
		r_leg_3.setRotationPoint(-4.5F, 2.0F, 8.0F);
		body.addChild(r_leg_3);
		r_leg_3.setTextureOffset(20, 22).addBox(-5.0F, -3.0F, 2.0F, 5.0F, 5.0F, 0.0F, 0.0F, false);

		main_body = new ModelRenderer(this);
		main_body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(main_body);
		main_body.setTextureOffset(0, 0).addBox(-4.5F, -1.0F, 0.0F, 9.0F, 4.0F, 11.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 21.0F, -3.0F);
		head.setTextureOffset(0, 18).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 4.0F, 3.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, -1.0F, -3.0F);
		head.addChild(nose);
		nose.setTextureOffset(1, 1).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		l_antenna = new ModelRenderer(this);
		l_antenna.setRotationPoint(2.0F, 1.0F, -3.0F);
		head.addChild(l_antenna);
		setRotationAngle(l_antenna, 0.3604F, -0.2457F, -0.0914F);
		l_antenna.setTextureOffset(15, 17).addBox(-0.5F, 0.0F, -5.0F, 2.0F, 0.0F, 5.0F, 0.0F, false);

		r_antenna = new ModelRenderer(this);
		r_antenna.setRotationPoint(-2.0F, 1.0F, -3.0F);
		head.addChild(r_antenna);
		setRotationAngle(r_antenna, 0.3695F, 0.3272F, 0.1238F);
		r_antenna.setTextureOffset(-1, 6).addBox(-1.5F, 0.0F, -5.0F, 2.0F, 0.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}