package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Plague extends PatchworkEnchantment {

	public Plague() {
		super(PatchworkRarity.EPIC, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(), 6, 4);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity) {
			((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2 * level, level - 1, true, false));
		}

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "plague"), new Plague());
	}

}
