package net.mythos.patchwork.material;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.mythos.patchwork.armor.PrimordiumArmor;

public class PrimordiumArmorMaterial implements ArmorMaterial {

	private static final int[] BASE_DURABILITY = new int[] {18, 20, 21, 16};
	private static final int[] PROTECTION_VALUES = new int[] {9, 12, 14, 9};

	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 40;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 18;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(PrimordiumArmor.PRIMORDIUM_INGOT);
	}

	@Override
	public String getName() {
		return "primordium";
	}

	@Override
	public float getToughness() {
		return 3.0f;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.3f;
	}

}
