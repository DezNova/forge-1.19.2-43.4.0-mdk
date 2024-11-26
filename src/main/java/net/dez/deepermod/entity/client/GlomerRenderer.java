package net.dez.deepermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.entity.custom.GlomerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GlomerRenderer extends GeoEntityRenderer<GlomerEntity> {


    public GlomerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlomerModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(GlomerEntity instance){
        return new ResourceLocation(DeeperMod.MOD_ID, "textures/entity/glomer_texture.png");
    }

    @Override
    public RenderType getRenderType(GlomerEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn,
                                    ResourceLocation textureLocation) {

        stack.scale(2, 2, 2);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
