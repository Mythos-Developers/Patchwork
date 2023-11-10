package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Dominate extends PatchworkEnchantment {

	public Dominate() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(), 6, 1);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		user.startRiding(target, true);
		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "dominate"), new Dominate());
	}

}
