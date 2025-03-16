package art.ameliah.laby.addons.emeraldindicator.v1_21_4.mixins;

import art.ameliah.laby.addons.emeraldindicator.core.EmeraldIndicatorAddon;
import art.ameliah.laby.addons.emeraldindicator.v1_21_4.ItemExtractor;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntityRenderer.class)
public class MixingEntityRenderer {

  @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/item/ItemEntity;Lnet/minecraft/client/renderer/entity/state/ItemEntityRenderState;F)V", at = @At("HEAD"))
  public void itemStackSetter(ItemEntity $$0, ItemEntityRenderState $$1, float $$2, CallbackInfo ci) {
    try {
      ((ItemExtractor)$$1).setItem($$0.getItem());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Inject(method = "render(Lnet/minecraft/client/renderer/entity/state/ItemEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"))
  public void onRender(ItemEntityRenderState $$0, PoseStack $$1, MultiBufferSource $$2, int $$3,
      CallbackInfo ci) {
    if (!EmeraldIndicatorAddon.get().configuration().enabled().get()) {
      return;
    }

    ItemStack item;
    try {
      item = ((ItemExtractor)$$0).getItem();
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    if (!item.is(Items.EMERALD)) {
      return;
    }

    Float scale = EmeraldIndicatorAddon.get().configuration().getScale().get();
    $$1.scale(scale, scale, scale);
  }
}
