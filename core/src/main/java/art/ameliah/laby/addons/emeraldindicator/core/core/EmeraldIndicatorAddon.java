package art.ameliah.laby.addons.emeraldindicator.core.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import javax.inject.Inject;

@AddonMain
public class EmeraldIndicatorAddon extends LabyAddon<EmeraldIndicatorConfiguration> {

  private static EmeraldIndicatorAddon instance;

  public static EmeraldIndicatorAddon get() {
    return instance;
  }

  @Inject
  public EmeraldIndicatorAddon(){
    instance = this;
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<EmeraldIndicatorConfiguration> configurationClass() {
    return EmeraldIndicatorConfiguration.class;
  }
}
