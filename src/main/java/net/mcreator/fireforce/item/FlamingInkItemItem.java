
package net.mcreator.fireforce.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.fireforce.procedures.GetFlamingInkProcedure;
import net.mcreator.fireforce.itemgroup.IgnitionAbilitiesItemGroup;
import net.mcreator.fireforce.FireforceModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@FireforceModElements.ModElement.Tag
public class FlamingInkItemItem extends FireforceModElements.ModElement {
	@ObjectHolder("fireforce:flaming_ink_item")
	public static final Item block = null;

	public FlamingInkItemItem(FireforceModElements instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(IgnitionAbilitiesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("flaming_ink_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			GetFlamingInkProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}
	}
}
