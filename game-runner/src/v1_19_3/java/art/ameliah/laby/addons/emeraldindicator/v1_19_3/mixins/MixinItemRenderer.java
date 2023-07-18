package art.ameliah.laby.addons.emeraldindicator.v1_19_3.mixins;

import art.ameliah.laby.addons.emeraldindicator.core.core.EmeraldIndicatorAddon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

  @Inject(method = "render", at = @At("HEAD"))
  public void injectRender(ItemStack $$0, ItemTransforms.TransformType $$1, boolean $$2,
      PoseStack $$3, MultiBufferSource $$4, int $$5, int $$6, BakedModel $$7, CallbackInfo ci) {
    if ($$0.is(Items.EMERALD) && $$1 == TransformType.GROUND) {
      Float scale = EmeraldIndicatorAddon.get().configuration().getScale().get();
      $$3.scale(scale, scale, scale);
    }
  }
}
