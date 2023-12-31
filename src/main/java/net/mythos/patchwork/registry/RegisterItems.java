package net.mythos.patchwork.registry;

import io.wispforest.owo.registration.annotations.RegistryNamespace;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterItems implements ItemRegistryContainer {

	// registered as 'mod_id:banana'
	public static final Item BANANA = new Item(new QuiltItemSettings().food(FoodComponents.SWEET_BERRIES));

	@RegistryNamespace("minecraft")
	public static class Inner implements ItemRegistryContainer {

		// registered as 'minecraft:damascus_ingot'
		public static final Item DAMASCUS_INGOT = new Item(new QuiltItemSettings());
	}

}
