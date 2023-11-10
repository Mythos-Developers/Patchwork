package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Sunburn extends PatchworkEnchantment {

	public Sunburn() {
		super(PatchworkRarity.EPIC, Rarity.RARE, EnchantmentTarget.ARMOR, EnchantmentType.armorAll(), 8, 2);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		boolean glowing = target.isGlowing();

		target.setGlowing(true);
		target.damage(DamageSource.ON_FIRE, level * 0.5f);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		target.setGlowing(glowing);

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "sunburn"), new Sunburn());
	}

}
