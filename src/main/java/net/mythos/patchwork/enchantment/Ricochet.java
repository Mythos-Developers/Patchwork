package net.mythos.patchwork.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.PatchworkEnchantment;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.template.EnchantmentType;

import java.util.Objects;
import java.util.Random;

public class Ricochet extends PatchworkEnchantment {

	public Ricochet() {
		super(PatchworkRarity.EPIC, Rarity.RARE, EnchantmentTarget.ARMOR, EnchantmentType.armorAll());
	}

	public int getProtectionAmount(int level, DamageSource source) {

		Random random = new Random();

		if(random.nextInt(6) <= level && !(null == source.getAttacker())) {

			if(random.nextInt(7) <= level && source.getAttacker() != null) {

				Objects.requireNonNull(source.getAttacker()).damage(Objects.requireNonNull(source.getSource()).getDamageSources().mobAttack((LivingEntity) source.getAttacker()), level * 2.5f);

			}

			return 2147483647;

		} else {
			return 0;
		}

	}

	@Override
	public int getMinPower(int level) {
		return 5 * level;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	public static void registerEnchantment() {
		Registry.register(Registries.ENCHANTMENT, new Identifier(Patchwork.ID, "ricochet"), new Ricochet());
	}

}
