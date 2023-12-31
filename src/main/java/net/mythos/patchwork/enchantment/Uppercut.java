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
import net.minecraft.util.math.Vec3d;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.template.EnchantmentType;
import org.quiltmc.loader.impl.lib.sat4j.core.Vec;

public class Uppercut extends PatchworkEnchantment {

	public Uppercut() {
		super(PatchworkRarity.LEGENDARY, Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentType.eitherHand(), 8, 5);
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		Vec3d vectorUp = target.getVelocity().add(0.0, target.getVelocity().getX() + target.getVelocity().getZ(), 0.0);
		vectorUp.multiply(0.0, 1.0, 0.0);

		target.setVelocity(vectorUp);

		/* if(target instanceof LivingEntity) {
			((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, level * 2, true, false));
		} */

		super.onTargetDamaged(user, target, level);

	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "uppercut"), new Uppercut());
	}

}
