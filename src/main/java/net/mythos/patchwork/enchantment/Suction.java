package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.common.EnchantmentType;

public class Suction extends PatchworkEnchantment {

	public Suction() {
		super(PatchworkRarity.MYTHIC, Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EnchantmentType.hand(), 8, 5);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		Vec3d reversed = target.getVelocity().negate();

		target.setVelocity(reversed);

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registry.ENCHANTMENT, new Identifier(Patchwork.ID, "suction"), new Suction());
	}

}
