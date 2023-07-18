package art.ameliah.laby.addons.emeraldindicator.core.core;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("settings")
public class EmeraldIndicatorConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SliderSetting(min = 0F, max = 10F, steps = 0.1F)
  private final ConfigProperty<Float> scale = new ConfigProperty<>(5F);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Float> getScale() {
    return scale;
  }
}
