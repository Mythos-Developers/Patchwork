package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;


public class Frostbite extends PatchworkEnchantment {

	public Frostbite() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(), 6, 2);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity) {
			((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level - 1, true, false));
		}

		target.damage(DamageSource.FREEZE, level * 0.5f);

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "frostbite"), new Frostbite());
	}

}
