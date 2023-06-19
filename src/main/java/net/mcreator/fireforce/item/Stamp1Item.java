
package net.mcreator.fireforce.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fireforce.FireforceModElements;

@FireforceModElements.ModElement.Tag
public class Stamp1Item extends FireforceModElements.ModElement {
	@ObjectHolder("fireforce:stamp_1")
	public static final Item block = null;

	public Stamp1Item(FireforceModElements instance) {
		super(instance, 372);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("stamp_1");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
