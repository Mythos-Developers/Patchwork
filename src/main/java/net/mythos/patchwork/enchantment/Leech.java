package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Leech extends PatchworkEnchantment {

	public Leech() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(), 7, 3);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		user.heal((0.07f * level) * (((SwordItem) user.getStackInHand(user.getActiveHand()).getItem()).getAttackDamage() * 0.5f));
	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "leech"), new Leech());
	}

}
