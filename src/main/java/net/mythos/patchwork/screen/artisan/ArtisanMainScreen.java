package net.mythos.patchwork.screen.artisan;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.GridLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;


public class ArtisanMainScreen extends BaseOwoScreen<GridLayout> {

	private PlayerInventory inventory;

	public ArtisanMainScreen(PlayerInventory inventory) {
		this.inventory = inventory;
	}

	@Override
	protected @NotNull OwoUIAdapter<GridLayout> createAdapter() {
		return OwoUIAdapter.create(this, (size1, size2) -> Containers.grid(size1, size2, 20, 20));
	}

	@Override
	protected void build(GridLayout rootComponent) {

		rootComponent
				.surface(Surface.VANILLA_TRANSLUCENT)
				.horizontalAlignment(HorizontalAlignment.RIGHT)
				.verticalAlignment(VerticalAlignment.TOP);

		rootComponent.child(
			(Component) Components.button(
				Text.literal(" ❌ ").formatted(Formatting.RED, Formatting.BOLD),
				button -> { client.setScreen(null); }
			),
			0,
			19
		);

		rootComponent.child(
			(Component) Components.button(Text.literal(" Cartographer "), button -> { } ),
			1,
			3
		);

		rootComponent.child(
			(Component) Components.button(Text.literal("   Typewriter   "), button -> { } ),
			3,
			3
		);

		rootComponent.child(
			(Component) Components.button(Text.literal("    Architect    "), button -> { } ),
				5,
				3
		);

		rootComponent.child(
				Containers.draggable(
						Sizing.content(),
						Sizing.content(),
						Containers.verticalFlow(Sizing.fixed(240), Sizing.fixed(120))
								.child(
										Components.item(Blocks.GOLD_BLOCK.asItem().getDefaultStack())
								)
								.padding(Insets.of(10))
								.surface(Surface.VANILLA_TRANSLUCENT)
								.verticalAlignment(VerticalAlignment.CENTER)
								.horizontalAlignment(HorizontalAlignment.CENTER)
				).surface(Surface.VANILLA_TRANSLUCENT),
				9,
				9
			);

	}

}
