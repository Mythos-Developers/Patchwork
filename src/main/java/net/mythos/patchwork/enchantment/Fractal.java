package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Fractal extends PatchworkEnchantment {

	public Fractal() {
		super(PatchworkRarity.MYTHIC, Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(),16, 6);
	}

	@Override
	public float getAttackDamage(int level, EntityGroup group) {
		return 12.0f * level;
	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "fractal"), new Fractal());
	}

}
