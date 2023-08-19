package net.mythos.patchwork.template;

import net.minecraft.entity.EquipmentSlot;

public class PatchworkEnchantmentType {

	//TODO Implement these methods in PatchworkEnchantment and all classes in the net.mythos.enchantment package.

	public EquipmentSlot[] eitherHand() {
		return new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND};
	}

	public EquipmentSlot[] mainHand() {
		return new EquipmentSlot[] {EquipmentSlot.MAINHAND};
	}

	public EquipmentSlot[] offHand() {
		return new EquipmentSlot[] {EquipmentSlot.OFFHAND};
	}

	public EquipmentSlot[] armorAll() {
		return new EquipmentSlot[] {EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD};
	}

	public EquipmentSlot[] helmet() {
		return new EquipmentSlot[] {EquipmentSlot.HEAD};
	}

	public EquipmentSlot[] chestplate() {
		return new EquipmentSlot[] {EquipmentSlot.CHEST};
	}

	public EquipmentSlot[] leggings() {
		return new EquipmentSlot[] {EquipmentSlot.LEGS};
	}

	public EquipmentSlot[] boots() {
		return new EquipmentSlot[] {EquipmentSlot.FEET};
	}

}
