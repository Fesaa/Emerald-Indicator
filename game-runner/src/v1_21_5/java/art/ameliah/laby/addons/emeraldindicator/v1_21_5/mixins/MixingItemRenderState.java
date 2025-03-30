package art.ameliah.laby.addons.emeraldindicator.v1_21_5.mixins;

import art.ameliah.laby.addons.emeraldindicator.v1_21_5.ItemExtractor;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemEntityRenderState.class)
public class MixingItemRenderState implements ItemExtractor {

  @Unique
  private ItemStack emeraldindicator$itemStack;

  @Override
  public void setItem(ItemStack item) {
    this.emeraldindicator$itemStack = item;
  }

  @Override
  public ItemStack getItem() {
    return this.emeraldindicator$itemStack;
  }
}
