package art.ameliah.laby.addons.emeraldindicator.v1_21_5;

import net.minecraft.world.item.ItemStack;

public interface ItemExtractor {

  default void setItem(ItemStack item) {}

  default ItemStack getItem() {
    return null;
  }

}
