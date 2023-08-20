package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.template.EnchantmentType;

public class Leech extends PatchworkEnchantment {

	public Leech() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.eitherHand(), 7, 3);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		user.heal((0.07f * level) * (((SwordItem) user.getStackInHand(user.getActiveHand()).getItem()).getAttackDamage() * 0.5f));
	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "leech"), new Leech());
	}

}
