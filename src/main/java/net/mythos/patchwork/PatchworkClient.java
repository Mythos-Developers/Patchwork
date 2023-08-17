package net.mythos.patchwork;

import com.mojang.blaze3d.platform.InputUtil;
import net.minecraft.client.option.KeyBind;
import net.mythos.patchwork.screen.artisan.ArtisanMainScreen;
import org.lwjgl.glfw.GLFW;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;


public class PatchworkClient implements ClientModInitializer {

	public static final KeyBind OPEN_ARTISAN = KeyBindingHelper.registerKeyBinding(new KeyBind(
			"key.patchwork.open_artisan",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_GRAVE_ACCENT,
			"category.patchwork.patchwork"
	));

	@Override
	public void onInitializeClient(ModContainer mod) {
		ClientTickEvents.END.register(client -> {

			while(OPEN_ARTISAN.wasPressed()) {

				ArtisanMainScreen artisan = new ArtisanMainScreen(client.player.getInventory());

				if(client.currentScreen instanceof ArtisanMainScreen) {

					client.currentScreen.closeScreen();

				} else {

					client.setScreen(artisan);

				}

			}

		});
	}

}
