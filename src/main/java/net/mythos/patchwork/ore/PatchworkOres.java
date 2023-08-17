package net.mythos.patchwork.ore;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mythos.patchwork.Patchwork;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class PatchworkOres {

	public static final Block ARCADEITE_ORE = new Block(QuiltBlockSettings.create().strength(4.0f));

	public static void registerBlocks() {

		registerBlock("arcadeite_ore", ARCADEITE_ORE);

	}

	private static void registerBlock(String name, Block block) {
		Registry.register(Registries.BLOCK, new Identifier(Patchwork.ID, name), block);
		Registry.register(Registries.ITEM, new Identifier(Patchwork.ID, name), new BlockItem(block, new QuiltItemSettings()));
	}

}
