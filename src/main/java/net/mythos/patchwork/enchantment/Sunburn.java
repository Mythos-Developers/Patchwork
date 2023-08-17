package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;

public class Sunburn extends PatchworkEnchantment {

	public Sunburn() {
		super(PatchworkRarity.EPIC, Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
	}

	@Override
	public int getMinPower(int level) {
		return 8 * level;
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		boolean glowing = target.isGlowing();

		target.setGlowing(true);
		target.damage(user.getDamageSources().onFire(), level * 0.5f);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		target.setGlowing(glowing);

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "sunburn"), new Sunburn());
	}

}
