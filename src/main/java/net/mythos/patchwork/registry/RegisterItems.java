package net.mythos.patchwork.registry;

import io.wispforest.owo.registration.annotations.RegistryNamespace;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterItems implements ItemRegistryContainer {

	@RegistryNamespace("minecraft")
	public static class Inner implements ItemRegistryContainer {

		// registered as 'minecraft:damascus_ingot'
		public static final Item DAMASCUS_INGOT = new Item(new QuiltItemSettings());
	}

}
