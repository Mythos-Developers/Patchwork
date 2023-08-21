package net.mythos.patchwork;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.armor.PrimordiumArmor;
import net.mythos.patchwork.enchantment.*;
import net.mythos.patchwork.registry.RegisterItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Patchwork implements ModInitializer {

	public static final String ID = "patchwork";
	public static final String NAME = "Patchwork";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize(ModContainer mod) {

		PrimordiumArmor.registerItems();

		registerEnchantments();

		FieldRegistrationHandler.register(RegisterItems.class, ID, true);

	}

	public void registerEnchantments() {
		Ricochet.registerEnchantment();
		Fractal.registerEnchantment();
		Leech.registerEnchantment();
		Frostbite.registerEnchantment();
		Plague.registerEnchantment();
		Stasis.registerEnchantment();
		Dominate.registerEnchantment();
		Sunburn.registerEnchantment();
		Uppercut.registerEnchantment();
	}

	public static void registerItem(String name, Item item) {
		Registry.register(Registries.ITEM, new Identifier(Patchwork.ID, name), item);
	}

	public static void registerBlock(String name, Block block) {
		Registry.register(Registries.BLOCK, new Identifier(Patchwork.ID, name), block);
		Registry.register(Registries.ITEM, new Identifier(Patchwork.ID, name), new BlockItem(block, new QuiltItemSettings()));
	}

}
