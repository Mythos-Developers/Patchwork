package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.template.PatchworkEnchantmentType;


public class Frostbite extends PatchworkEnchantment {

	public Frostbite() {
		super(PatchworkRarity.RARE, Rarity.RARE, EnchantmentTarget.WEAPON, PatchworkEnchantmentType.eitherHand());
	}

	@Override
	public int getMinPower(int level) {
		return 6 * level;
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity) {
			((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level - 1, true, false));
		}

		target.damage(user.getDamageSources().freeze(), level * 0.5f);

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "frostbite"), new Frostbite());
	}

}
