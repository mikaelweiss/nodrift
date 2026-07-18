package dev.mikael.nodrift;

import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public class NoDriftConfigScreen extends Screen {
	private final Screen parent;

	public NoDriftConfigScreen(Screen parent) {
		super(Component.translatable("nodrift.config.title"));
		this.parent = parent;
	}

	@Override
	protected void init() {
		addRenderableWidget(new StringWidget(width / 2 - font.width(title) / 2, 40, title, font));
		addRenderableWidget(new AbstractSliderButton(width / 2 - 100, height / 2 - 20, 200, 20,
				driftLabel(NoDriftConfig.driftStrength()), NoDriftConfig.driftStrength()) {
			@Override
			protected void updateMessage() {
				setMessage(driftLabel(value));
			}

			@Override
			protected void applyValue() {
				NoDriftConfig.setDriftStrength(value);
			}
		});
		addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, button -> onClose())
				.bounds(width / 2 - 100, height / 2 + 20, 200, 20)
				.build());
	}

	private static Component driftLabel(double value) {
		int percent = (int) Math.round(value * 100.0);
		Component amount;
		if (percent <= 0) {
			amount = Component.translatable("nodrift.config.drift.none");
		} else if (percent >= 100) {
			amount = Component.translatable("nodrift.config.drift.vanilla");
		} else {
			amount = Component.literal(percent + "%");
		}
		return Component.translatable("nodrift.config.drift", amount);
	}

	@Override
	public void onClose() {
		NoDriftConfig.save();
		minecraft.setScreenAndShow(parent);
	}
}
