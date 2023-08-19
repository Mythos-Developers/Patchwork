package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.template.PatchworkEnchantmentType;

public class Dominate extends PatchworkEnchantment {

	public Dominate() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, PatchworkEnchantmentType.eitherHand());
	}

	@Override
	public int getMinPower(int level) {
		return 6 * level;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		user.startRiding(target, true);
		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "dominate"), new Dominate());
	}

}
