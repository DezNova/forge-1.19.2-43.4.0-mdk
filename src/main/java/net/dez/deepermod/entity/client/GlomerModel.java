package net.dez.deepermod.entity.client;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.entity.custom.GlomerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GlomerModel extends AnimatedGeoModel<GlomerEntity> {

    @Override
    public ResourceLocation getModelResource(GlomerEntity glomerEntity) {
        return new ResourceLocation(DeeperMod.MOD_ID, "geo/glomer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GlomerEntity glomerEntity) {
        return new ResourceLocation(DeeperMod.MOD_ID, "textures/entity/glomer_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GlomerEntity glomerEntity) {
        return new ResourceLocation(DeeperMod.MOD_ID, "animations/glomer.animation.json");
    }
}
