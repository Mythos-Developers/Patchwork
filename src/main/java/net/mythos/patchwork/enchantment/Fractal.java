package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;

public class Fractal extends PatchworkEnchantment {

	public Fractal() {
		super(PatchworkRarity.MYTHIC, Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMinPower(int level) {
		return 16 * level;
	}

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	public float getAttackDamage(int level, EntityGroup group) {
		return 12.0f * level;
	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "fractal"), new Fractal());
	}

}
