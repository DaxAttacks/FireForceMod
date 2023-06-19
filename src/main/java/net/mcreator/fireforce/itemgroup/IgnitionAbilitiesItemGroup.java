
package net.mcreator.fireforce.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.fireforce.item.DevilsFootprintItem;
import net.mcreator.fireforce.FireforceModElements;

@FireforceModElements.ModElement.Tag
public class IgnitionAbilitiesItemGroup extends FireforceModElements.ModElement {
	public IgnitionAbilitiesItemGroup(FireforceModElements instance) {
		super(instance, 392);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabignition_abilities") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DevilsFootprintItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
