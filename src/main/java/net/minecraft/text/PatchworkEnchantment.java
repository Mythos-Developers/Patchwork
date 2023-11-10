package net.minecraft.text;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Formatting;

public abstract class PatchworkEnchantment extends Enchantment {

	private final PatchworkRarity rarity;
	private int maxLevel = 0;
	private int minPower = 0;

	protected PatchworkEnchantment(PatchworkRarity rarity, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes, int minPower, int maxLevel) {
		super(weight, type, slotTypes);
		this.rarity = rarity;
		this.minPower = minPower;
		this.maxLevel = maxLevel;
	}

	protected PatchworkEnchantment(PatchworkRarity rarity, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes, int maxLevel) {
		super(weight, type, slotTypes);
		this.rarity = rarity;
		this.maxLevel = maxLevel;
	}

	protected PatchworkEnchantment(PatchworkRarity rarity, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(weight, type, slotTypes);
		this.rarity = rarity;
	}

	@Override
	public int getMaxLevel() {
		return maxLevel;
	}

	@Override
	public int getMinPower(int level) {
		return minPower * level;
	}

	@Override
	public Text getName(int level) {
		MutableText mutableText = Text.translatable(this.getTranslationKey());

		switch(rarity) {
			case COMMON -> { mutableText.setStyle(new Style(TextColor.fromRgb(16777215), false, false, false, false, false, null, null, null, null)); }
			case UNCOMMON -> { mutableText.setStyle(new Style(TextColor.fromRgb(3700253), false, false, false, false, false, null, null, null, null)); }
			case RARE -> { mutableText.setStyle(new Style(TextColor.fromRgb(1136076), false, false, false, false, false, null, null, null, null)); }
			case EPIC -> { mutableText.setStyle(new Style(TextColor.fromRgb(6770343), false, false, false, false, false, null, null, null, null)); }
			case LEGENDARY -> { mutableText.setStyle(new Style(TextColor.fromRgb(15110456), false, false, false, false, false, null, null, null, null)); }
			case MYTHIC -> { mutableText.setStyle(new Style(TextColor.fromRgb(4555150), false, false, false, false, false, null, null, null, null)); }
			case DIVINE -> { mutableText.setStyle(new Style(TextColor.fromRgb(15374745), false, false, false, false, false, null, null, null, null)); }
			case HIDDEN -> { mutableText.formatted(Formatting.OBFUSCATED); }
		}

		if (level != 1 || this.getMaxLevel() != 1) {
			mutableText.append(" ").append(Text.translatable("enchantment.level." + level));
		}

		return mutableText;
	}

	public enum PatchworkRarity {
		COMMON,
		UNCOMMON,
		RARE,
		EPIC,
		LEGENDARY,
		MYTHIC,
		DIVINE,
		HIDDEN
	}

}
