package net.mythos.patchwork.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import net.mythos.patchwork.material.PrimordiumArmorMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class PrimordiumArmor {

	public static final ArmorMaterial PRIMORDIUM_MATERIAL = new PrimordiumArmorMaterial();
	public static final Item PRIMORDIUM_INGOT = new Item(new QuiltItemSettings());

	public static final Item PRIMORDIUM_HELMET = new ArmorItem(PRIMORDIUM_MATERIAL, EquipmentSlot.HEAD, new QuiltItemSettings());
	public static final Item PRIMORDIUM_CHESTPLATE = new ArmorItem(PRIMORDIUM_MATERIAL, EquipmentSlot.CHEST, new QuiltItemSettings());
	public static final Item PRIMORDIUM_LEGGINGS = new ArmorItem(PRIMORDIUM_MATERIAL, EquipmentSlot.LEGS, new QuiltItemSettings());
	public static final Item PRIMORDIUM_BOOTS = new ArmorItem(PRIMORDIUM_MATERIAL, EquipmentSlot.FEET, new QuiltItemSettings());

	public static void registerItems() {

		registerItem("primordium_ingot", PRIMORDIUM_INGOT);
		registerItem("primordium_helmet", PRIMORDIUM_HELMET);
		registerItem("primordium_chestplate", PRIMORDIUM_CHESTPLATE);
		registerItem("primordium_leggings", PRIMORDIUM_LEGGINGS);
		registerItem("primordium_boots", PRIMORDIUM_BOOTS);

	}

	private static void registerItem(String name, Item item) {
		Registry.register(Registry.ITEM, new Identifier(Patchwork.ID, name), item);
	}

}
